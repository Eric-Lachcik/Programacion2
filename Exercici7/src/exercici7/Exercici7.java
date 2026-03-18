/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici7;

/**
 *
 * @author blu20
 */

import javax.swing.*;


public class Exercici7 extends JFrame {

    private RatoliPanel paper;

    public Exercici7() {
        this.setTitle("Exercici 7 - Moviment interactiu amb ratolí");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        paper = new RatoliPanel();
        this.getContentPane().add(paper);
        paper.setBounds(0, 0, 900, 700);
    }

    public static void main(String[] args) {
        new Exercici7().setVisible(true);
    }
}
