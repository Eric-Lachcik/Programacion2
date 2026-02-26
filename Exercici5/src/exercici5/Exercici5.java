/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici5;

/**
 *
 * @author blu20
 */

import java.awt.*;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Exercici5 extends JFrame implements ActionListener {
        
    private JTextField t; //display de la calculadora
    char op = ' '; //operador
    String nump = "", num = ""; //nump significa nombre precedent
    //num:  numero actual
    //nump: numero anterior/precedent
    double mem = 0;
    
    public Exercici5() {
        setTitle("Calculadora Bàsica");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Exercici5.EXIT_ON_CLOSE);
        initContents();
    }
    
    private void initContents() {
        //Es definiexen dos panells un pels botons i l'altre per la pantalla
        JPanel jpTeclat = new JPanel();
        jpTeclat.setLayout(new GridLayout(5, 4));
//        jpTeclat.setLayout(new FlowLayout());
        String jlbBotons[] = {"M+", "M-", "MR", "C", "7", "8", "9", "/", "4", "5", "6", "*", "1",
            "2", "3", "-", "0", ".", "=", "+"};
         //Crear els botons segons el String
        for (int i = 0; i < jlbBotons.length; i++) {
            JButton boto = new JButton(jlbBotons[i]);
            boto.addActionListener(this);
            boto.setFont(new Font("arial", PLAIN, 50));
            jpTeclat.add(boto);
        }
        //Definim un area de text     
        t = new JTextField();
        //Alineada a la dreta        
        t.setHorizontalAlignment(JTextField.RIGHT);
        t.setEditable(false); //No es pot escriure directament s'han d'usar
        //els botons
        t.setFont(new Font("arial", PLAIN, 25));

        JPanel jpPantalla = (JPanel) getContentPane();

        jpPantalla.setLayout(new BorderLayout());
        jpPantalla.add(t, BorderLayout.NORTH);
        jpPantalla.add(jpTeclat, BorderLayout.CENTER);
        //pack(); // Manté proporcions        
    }

    //Quan es clicki un botó, s'ejecutará el métode
    @Override
    public void actionPerformed(ActionEvent evt) {
        char c = ((JButton) evt.getSource()).getText().charAt(0);
        //getSource retorna un objecte, es fa el casting a botó
        //del botó s'agafa l'string que l'identifica
        //de l'string n'extreu el caràcter

        //Construeix el numero
        if (c >= '0' && c <= '9') {
            if (num.equals("")) {
                t.setText(num);
            }
            //Afegir caracters a un numero                  
            num = num + c;
            t.setText(num);
            //afegeix el punt decimal
        } else if (c == '.') {
            if (num.equals("")) {
                num = "0.";
                t.setText(num);
            } else if (!num.contains(".")) {
                num = num + ".";
                t.setText(num);
            }
            //esborra
        } else if (c == 'C') {
            nump = "";
            num = "";
            op = ' ';
            t.setText(num);
            //realitza els càlculs
        } else if (c == '=') {
            calc();
            //nombres negatius
        } else if (c == '-' && (op == ' ') && num.equals("")) {
            num = num + c;
            t.setText(num);
            //operadors
            
        } else if (c == 'M') {
            char c1 = ((JButton) evt.getSource()).getText().charAt(1);
            double valor;
            switch (c1) {
                case '+':
                    valor = Double.parseDouble(num);
                    mem = mem + valor;
                    break;
                case '-':
                    valor = Double.parseDouble(num);
                    mem = mem - valor;
                    break;
                default:
                    String s = String.format("%.2f", mem);
                    num = s;
                    t.setText(num);
                    break;
            }
            
        } else {
            if (op == ' ') {
                    op = c;
                    nump = num;
                    num = "";
            } else {
                calc();
                op = c;
            }
        }
    }
    //Métode per calcular
    private void calc() {
        if (!num.equals("") && !nump.equals("")) {
            float a = Float.parseFloat(nump);
            float b = Float.parseFloat(num);
            float r = 0;
            switch (op) {
                case '+':
                    r = a + b;
                    break;
                case '-':
                    r = a - b;
                    break;
                case '*':
                    r = a * b;
                    break;
                case '/':
                    // r = a / (b != 0 ? b : 1);
                    r = a / b;
                    break;
            }
            //Passam el resultat a String                      
            nump = Float.toString(r);
            //El posam al display            
            t.setText(nump);
        }
        num = "";
    }
    
    
    public static void main(String[] args) {
        new Exercici5().setVisible(true);
    }
    
}
