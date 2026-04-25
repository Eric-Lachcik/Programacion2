/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller1;
import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * La clase principal del programa, que crea la ventana y anade el tablero de juego.
 * 
 */
public class Taller1 extends JFrame {

    /** Constructor de la ventana principal. */
    public Taller1() {
        super("Juego de la Hormiga");
        // Configurar la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Configurar el layout y anadir el tablero
        setLayout(new BorderLayout());
        // Crear el tablero y anadirlo al centro de la ventana
        add(new Tablero(), BorderLayout.CENTER);
        // Ajustar el tamaño de la ventana al contenido y centrarla
        pack();
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
        // Evitar que el usuario cambie el tamaño de la ventana
        setResizable(false);
        // Mostrar la ventana
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Taller1();
    }
    
}
