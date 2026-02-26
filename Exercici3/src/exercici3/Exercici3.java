/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici3;

/**
 *
 * @author blu20
 */

import java.awt.event.*;
import javax.swing.*;

public class Exercici3 extends JFrame {
    private JLabel MainTitulo;
    private JLabel Valor1label;
    private JTextField Valor1tf;
    private JLabel Valor2label;
    private JTextField Valor2tf;
    private JLabel Resultadolabel;
    private JTextField Resultadotf;
    private JButton SumarB;
    private JButton RestarB;
    private JButton MultiplicarB;
    private JButton DividirB;
    
    
    public Exercici3() {
        setSize(600, 400);
        setTitle("Calculadora basica");
        initComponents();
    }
    
    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }
    
    private void initComponents() {
        MainTitulo = new JLabel();
        Valor1label = new JLabel();
        Valor1tf = new JTextField();
        Valor2label = new JLabel();
        Valor2tf = new JTextField();
        Resultadolabel = new JLabel();
        Resultadotf = new JTextField();
        SumarB = new JButton();
        RestarB = new JButton();
        MultiplicarB = new JButton();
        DividirB = new JButton();
        
        
        getContentPane().setLayout(null);
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });
        
        
        // Main Label
        MainTitulo.setText("Calculadora Basica");
        getContentPane().add(MainTitulo);
        MainTitulo.setBounds(190, 100, 131, 10);
        
        // Valores y Resultado
        Valor1label.setText("Valor 1: ");
        getContentPane().add(Valor1label);
        Valor1label.setBounds(100, 140, 116, 20);
        Valor1tf.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(Valor1tf);
        Valor1tf.setBounds(220, 140, 184, 24);
        Valor2label.setText("Valor 2: ");
        getContentPane().add(Valor2label);
        Valor2label.setBounds(100, 180, 116, 20);
        Valor2tf.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(Valor2tf);
        Valor2tf.setBounds(220, 180, 184, 24);
        Resultadolabel.setText("Resultado: ");
        getContentPane().add(Resultadolabel);
        Resultadolabel.setBounds(100, 220, 116, 20);
        Resultadotf.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(Resultadotf);
        Resultadotf.setBounds(220, 220, 184, 24);
        
        //Botones
        SumarB.setText("+");
        getContentPane().add(SumarB);
        SumarB.setBounds(160, 280, 45, 45);
        RestarB.setText("-");
        getContentPane().add(RestarB);
        RestarB.setBounds(205, 280, 45, 45);
        MultiplicarB.setText("*");
        getContentPane().add(MultiplicarB);
        MultiplicarB.setBounds(250, 280, 45, 45);
        DividirB.setText("/");
        getContentPane().add(DividirB);
        DividirB.setBounds(295, 280, 45, 45);
        
        // Control del Botones
        SumarB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sumaOperacion(evt);
            }
        });
        
        RestarB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                restaOperacion(evt);
            }
        });
        
        MultiplicarB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Bombo clat3");
            }
        });
        
        DividirB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Bombo clat4");
            }
        });
        
    }
    
    private void sumaOperacion(ActionEvent evt) {
        try {
            double valor1;
            double valor2;
            double resultado;
            
            valor1 = Double.parseDouble(Valor1tf.getText());
            valor2 = Double.parseDouble(Valor2tf.getText());
            
            resultado = valor1 + valor2;
            String s = String.format("%.2f", resultado);
            Resultadotf.setText(s);
            
        } catch(NumberFormatException e){
            Resultadotf.setText("Conchetumadre pon numeros");
        }
    }
    
    private void restaOperacion(ActionEvent evt) {
        try {
            double valor1;
            double valor2;
            double resultado;
            
            valor1 = Double.parseDouble(Valor1tf.getText());
            valor2 = Double.parseDouble(Valor2tf.getText());
            
            resultado = valor1 - valor2;
            String s = String.format("%.2f", resultado);
            Resultadotf.setText(s);
            
        } catch(NumberFormatException e){
            Resultadotf.setText("Conchetumadre pon numeros");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try { //Control de l'aspecte
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("No s'ha establert el look desitjat: " + e);
        }
        new Exercici3().setVisible(true);
    }
    
}
