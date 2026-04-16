/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex10;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.MouseListener;

/**
 *
 * @author blu20
 */
public class EX10 extends JFrame implements MouseListener {

    Tauler tauler;
    int numReines = 0;

    public EX10() {
        super("Joc de les reines");
        tauler = new Tauler();
        tauler.addMouseListener(this);
        this.getContentPane().add(tauler);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        EX10 esc = new EX10();
        esc.setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int i, j = 0;
        if (e.getButton() == MouseEvent.BUTTON1 && numReines < 8) {
 
//         Obtindre casella clicada (observar que i,j son enters)
            i = e.getY() / Tauler.COSTAT; // Fila 
            j = e.getX() / Tauler.COSTAT; // Columna
            
            System.out.println("Click a: " + i + ", " + j);
            if (!tauler.isOcupat(i, j)) {
                if (tauler.posicioValida(i, j)) {
                    tauler.Posa(Pesa.REINAN, i, j);
                    numReines++;
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            } else {
                tauler.buida(i, j);
                numReines--;
            }
            tauler.repaint();
//            tauler.paintImmediately(tauler.getRectangle(i, j));
            if (numReines == 8) {
                Toolkit.getDefaultToolkit().beep();
                ImageIcon icon = new ImageIcon("peces/cavallN.png");
                JOptionPane.showMessageDialog(null, "8 Reines al tauler!",
                        "Victoria!", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
