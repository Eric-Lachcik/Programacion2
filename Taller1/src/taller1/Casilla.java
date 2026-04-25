/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package taller1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *  La clase Casilla representa una casilla individual del tablero. 
 *  Cada casilla varia segun su tipo y segun la direccion de la hormiga.
 */
public class Casilla extends JPanel {
    /** Enumerador para el tipo de casilla. */
    public enum TipoCasilla {
        HOJA,
        HORMIGA,
        PROHIBIDA,
        VACIA
    }

    /** Enumerador para la direccion de la hormiga. */
    public enum Direccion {
        NORTE,
        OESTE,
        SUR,
        ESTE
    }

    /** Constante tamaño en píxeles */
    private static final int TAM_PIXELS = 35;


    /** El tipo de casilla. */
    private TipoCasilla tipo;

    /** La direccion de la hormiga. */
    private Direccion rumbo;

    /** Las coordenadas de la casilla en el tablero. */
    private final int fila;
    private final int columna;

    /** Imagenes para cada tipo de casilla. */
    private final Image imgHoja;
    private final Image imgVacia;
    private final Image imgProhibida;
    private final Image imgHormigaN;
    private final Image imgHormigaO;
    private final Image imgHormigaS;
    private final Image imgHormigaE;
    

    /** Constructor de la casilla.
     * @param fila
     * @param columna 
     * */
    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.tipo = TipoCasilla.HOJA; // La casilla inicia como una hoja
        this.rumbo = Direccion.NORTE; // La direccion inicial de la hormiga es norte

        imgHoja     = cargar("/imagenes/hoja.png");
        imgVacia    = cargar("/imagenes/nada.png");
        imgProhibida= cargar("/imagenes/direccionProhibida.png");
        imgHormigaN = cargar("/imagenes/hormiga_n.png");
        imgHormigaO = cargar("/imagenes/hormiga_o.png");
        imgHormigaS = cargar("/imagenes/hormiga_s.png");
        imgHormigaE = cargar("/imagenes/hormiga_e.png");
        

        setPreferredSize(new Dimension(TAM_PIXELS, TAM_PIXELS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /**
     * Carga una imagen desde una ruta relativa.
     * @param ruta La ruta de la imagen.
     * @return La imagen cargada o null si no se encuentra.
     */
    private Image cargar(String ruta) {
        var url = getClass().getResource(ruta);
        return url == null ? null : new ImageIcon(url).getImage();
    }

    /** Método para actualizar el tipo de casilla. */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Image imagenActual = null;

        // Seleccionamos la imagen a dibujar segun la casilla
        switch (tipo) {
            case HOJA:
                imagenActual = imgHoja;
                break;

            case PROHIBIDA:
                imagenActual = imgProhibida;
                break;

            case VACIA:
                imagenActual = imgVacia;
                break;

            case HORMIGA:
                // Segun el rumbo seleccionamos la imagen de la hormiga correspondiente
                switch (rumbo) {
                    case NORTE: 
                        imagenActual = imgHormigaN; 
                        break;
                    case OESTE: 
                        imagenActual = imgHormigaO; 
                        break;
                    case SUR:   
                        imagenActual = imgHormigaS; 
                        break;
                    case ESTE:  
                        imagenActual = imgHormigaE; 
                        break;
                    
                }
                break;
        }

        // Dibujamos la imagen seleccionada
        if (imagenActual != null) {
            g2.drawImage(imagenActual, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /** Getter para el tipo de casilla. */
    public TipoCasilla getTipo() {
        return tipo;
    }

    /** Setter para el tipo de casilla. */
    public void setTipo(TipoCasilla t) {
        tipo = t;
        repaint();
    }

    /** Getter para la direccion de la hormiga. */
    public Direccion getRumbo() {
        return rumbo;
    }

    /** Setter para la direccion de la hormiga. */
    public void setRumbo(Direccion d) {
        rumbo = d;
        repaint();
    }

    /* Getter para el tamaño en pixeles. */
    public static int getTamPixeles() {
        return TAM_PIXELS;
    }
}
