/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici7;

/**
 *
 * @author blu20
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Exercici7 extends JFrame implements MouseMotionListener, MouseListener  {
    
    public static JLabel label1, label2, label3, label4, label5;
 
    
    Exercici7() {
       
    }
    
    
//    public static void initContents() {
//        // create a frame
//        JFrame f = new JFrame("MouseListener and MouseMotionListener");
//
//        // set the size of the frame
//        f.setSize(900, 300);
//
//        // close the frame when close button is pressed
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // create new panel
//        JPanel p = new JPanel();
//        JPanel p1 = new JPanel();
//
//        // set the layout of the frame
//        f.setLayout(new FlowLayout());
//
//        JLabel l1, l2;
//        
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File("strawberry.jpg"));
//        } catch (IOException e) {
//        }
//        
//        
//        l1 = new JLabel("MouseMotionListener events  :");
//
//        l2 = new JLabel("MouseLIstener events  :");
//
//        // initialize the labels
//        label1 = new JLabel("no event  ");
//
//        label2 = new JLabel("no event  ");
//
//        label3 = new JLabel("no event  ");
//
//        label4 = new JLabel("no event  ");
//
//        label5 = new JLabel("no event  ");
//
//        
//        Exercici7 m = new Exercici7();
//
//        // add mouseListener and MouseMotionListenerto the frame
//        f.addMouseMotionListener(m);
//        f.addMouseListener(m);
//
//        // add labels to the panel
//        p.add(l1);
//        p.add(label1);
//        p.add(label2);
//        p1.add(l2);
//        p1.add(label3);
//        p1.add(label4);
//        p1.add(label5);
//
//        // add panel to the frame
//        f.add(p);
//        f.add(p1);
//
//        f.show();
//        
//    }
    public static void main(String[] args) {
        // create a frame
        JFrame f = new JFrame("MouseListener and MouseMotionListener");

        // set the size of the frame
        f.setSize(900, 300);

        // close the frame when close button is pressed
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create new panel
        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        
        dibuix paper = new dibuix();
        
        // set the layout of the frame
        f.setLayout(new FlowLayout());

        JLabel l1, l2;
        
        l1 = new JLabel("MouseMotionListener events  :");

        l2 = new JLabel("MouseLIstener events  :");

        // initialize the labels
        label1 = new JLabel("no event  ");

        label2 = new JLabel("no event  ");

        label3 = new JLabel("no event  ");

        label4 = new JLabel("no event  ");

        label5 = new JLabel("no event  ");

        
        Exercici7 m = new Exercici7();

        // add mouseListener and MouseMotionListenerto the frame
        f.addMouseMotionListener(m);
        f.addMouseListener(m);

        // add labels to the panel
        p.add(l1);
        p.add(label1);
        p.add(label2);
        p1.add(l2);
        p1.add(label3);
        p1.add(label4);
        p1.add(label5);
        p2.add(paper);

        // add panel to the frame
        f.add(p);
        f.add(p1);
        f.add(p2);
        f.show();
    }
    
    public void mouseDragged(MouseEvent e)
    {
        // update the label to show the point
        // through which point mouse is dragged
        label1.setText("mouse is dragged through point "
                       + e.getX() + " " + e.getY());
    }

    // invoked when the cursor is moved from
    // one point to another within the component
    public void mouseMoved(MouseEvent e)
    {
        // update the label to show the point to which the cursor moved
        label2.setText("mouse is moved to point "
                       + e.getX() + " " + e.getY());
    }

    // MouseListener events

    // this function is invoked when the mouse is pressed
    public void mousePressed(MouseEvent e)
    {

        // show the point where the user pressed the mouse
        label3.setText("mouse pressed at point:"
                       + e.getX() + " " + e.getY());
    }

    // this function is invoked when the mouse is released
    public void mouseReleased(MouseEvent e)
    {

        // show the point where the user released the mouse click
        label3.setText("mouse released at point:"
                       + e.getX() + " " + e.getY());
    }

    // this function is invoked when the mouse exits the component
    public void mouseExited(MouseEvent e)
    {

        // show the point through which the mouse exited the frame
        label4.setText("mouse exited through point:"
                       + e.getX() + " " + e.getY());
    }

    // this function is invoked when the mouse enters the component
    public void mouseEntered(MouseEvent e)
    {

        // show the point through which the mouse entered the frame
        label4.setText("mouse entered at point:"
                       + e.getX() + " " + e.getY());
    }

    // this function is invoked when the mouse is pressed or released
    public void mouseClicked(MouseEvent e)
    {

        // getClickCount gives the number of quick,
        // consecutive clicks made by the user
        // show the point where the mouse is i.e
        // the x and y coordinates
        label5.setText("mouse clicked at point:"
                       + e.getX() + " "
                       + e.getY() + "mouse clicked :" + e.getClickCount());
    }
    
    
}
