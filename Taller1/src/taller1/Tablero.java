/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package taller1;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * La clase Tablero representa el tablero de juego con una cuadricula 20x20 de casillas.
 * 
 */
public class Tablero extends JPanel {
    
    private static final int PROHIBIDAS = 5;
    private static final int DIMENSION = 20;
    
    private final Casilla[][] casillas;
    private final Random random;
    private int filaHormiga;
    private int colHormiga;
    private Casilla.Direccion rumbo;
    private int hojasComidas;
    private final int totalHojas;

    public Tablero() {
        random = new Random();
        casillas = new Casilla[DIMENSION][DIMENSION];
        setLayout(new GridLayout(DIMENSION, DIMENSION));

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                casillas[i][j] = new Casilla(i, j);
                add(casillas[i][j]);
            }
        }
        
        // Inicializar tablero
        prepararTablero();
        setFocusable(true);
        addKeyListener(new Teclado());

        // 20*20 - PROHIBIDAS - hormiga = total de hojas
        totalHojas = (DIMENSION * DIMENSION) - PROHIBIDAS - 1;
    }

    /**
     * Metodo para configurar el tablero al inicio del juego.
     */
    private void prepararTablero() {
        // Todas las casillas empiezan con una hoja
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                casillas[i][j].setTipo(Casilla.TipoCasilla.HOJA);
            }
        }
        // Colocar casillas prohibidas al azar
        int colocadas = 0;
        while (colocadas < PROHIBIDAS) {
            int f = random.nextInt(DIMENSION);
            int c = random.nextInt(DIMENSION);
            if (casillas[f][c].getTipo() == Casilla.TipoCasilla.HOJA) {
                casillas[f][c].setTipo(Casilla.TipoCasilla.PROHIBIDA);
                colocadas++;
            }
        }

        // Colocar la hormiga en una Casilla que no sea prohibida
        while (true) {
            filaHormiga = random.nextInt(DIMENSION);
            colHormiga  = random.nextInt(DIMENSION);
            
            // Si la casilla generada no es una prohibida, rompemos el bucle
            if (casillas[filaHormiga][colHormiga].getTipo() != Casilla.TipoCasilla.PROHIBIDA) {
                break; 
            }
        }
        
        // Configurar el estado inicial de la hormiga
        casillas[filaHormiga][colHormiga].setTipo(Casilla.TipoCasilla.HORMIGA);
        casillas[filaHormiga][colHormiga].setRumbo(Casilla.Direccion.NORTE);
        rumbo = Casilla.Direccion.NORTE;
        hojasComidas = 0;
        
        repaint();
    }

    /**
     * Metodo para reproducir un sonido dado su nombre (archivo WAV dentro de la carpeta "sonidos/").
     * @param nombreAudio El nombre del archivo de sonido a reproducir (ej: "comer.wav")
     */
    private void reproducirSonido(String nombreAudio) {
        try {
            var url = getClass().getResource("/sonidos/" + nombreAudio);
            if (url == null) {
                System.err.println("No se encontro el sonido: " + nombreAudio);
                return;
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
            System.err.println("No se pudo reproducir " + nombreAudio + ": " + e.getMessage());
        }
    }

    /**
     * Metodo para comprobar si el jugador ha ganado.
     */
    private void comprobarVictoria() {
        if (hojasComidas == totalHojas) {
            reproducirSonido("victoria.wav");
            JOptionPane.showMessageDialog(this,
                "¡Enhorabuena!\n\nLa hormiga se ha comido todas las hojas.",
                "Juego finalizado",
                JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    private void avanzarHormiga() {
        // Calcular nueva posicion segun la direccion actual
        int nuevaFila = filaHormiga;
        int nuevaCol  = colHormiga;
        switch (rumbo) {
            case NORTE -> nuevaFila = (filaHormiga - 1 + DIMENSION) % DIMENSION;
            case SUR   -> nuevaFila = (filaHormiga + 1) % DIMENSION;
            case ESTE  -> nuevaCol  = (colHormiga + 1) % DIMENSION;
            case OESTE -> nuevaCol  = (colHormiga - 1 + DIMENSION) % DIMENSION;
        }

        Casilla destino = casillas[nuevaFila][nuevaCol];
        // Si es casilla prohibida, no se mueve y se reproduce un sonido de error
        if (destino.getTipo() == Casilla.TipoCasilla.PROHIBIDA) {
            reproducirSonido("prohibida.wav");
            return;
        }
        // Si es hoja, se come y se reproduce un sonido de comer
        if (destino.getTipo() == Casilla.TipoCasilla.HOJA) {
            hojasComidas++;
            reproducirSonido("comer.wav");
        }
        // Desplazar hormiga
        casillas[filaHormiga][colHormiga].setTipo(Casilla.TipoCasilla.VACIA);
        filaHormiga = nuevaFila;
        colHormiga  = nuevaCol;
        destino.setTipo(Casilla.TipoCasilla.HORMIGA);
        destino.setRumbo(rumbo);
        repaint();
        // Comprobar victoria
        comprobarVictoria();
    }

    /** Escucha el teclado para cambiar dirección y avanzar. */
    private class Teclado extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> rumbo = Casilla.Direccion.NORTE;
                case KeyEvent.VK_DOWN -> rumbo = Casilla.Direccion.SUR;
                case KeyEvent.VK_RIGHT -> rumbo = Casilla.Direccion.ESTE;
                case KeyEvent.VK_LEFT -> rumbo = Casilla.Direccion.OESTE;
                case KeyEvent.VK_SPACE -> avanzarHormiga();
            }
            // Actualiza la imagen de la hormiga en su celda actual
            casillas[filaHormiga][colHormiga].setRumbo(rumbo);
        }
    }
}
