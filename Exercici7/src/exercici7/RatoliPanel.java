/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author ericp
 */
public class RatoliPanel extends JPanel implements MouseListener, MouseMotionListener {

    private URL fitxerImatge = getClass().getResource("/imatges/UIB_200.JPG");
    private BufferedImage img;

    private int x = 100;
    private int y = 100;

    private boolean arrossegant = false;
    private int offsetX;
    private int offsetY;

    public RatoliPanel() {
        try {
            img = ImageIO.read(getClass().getResource("/imatges/UIB_200.JPG"));
        } catch (IOException e) {
            System.out.println("Error carregant la imatge: " + fitxerImatge);
        }

        this.setBackground(Color.WHITE);

        addMouseListener((MouseListener) this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if (img != null) {
            g2d.drawImage(img, x, y, null);
        } else {
            g2d.drawString("No s'ha pogut carregar la imatge", 20, 20);
        }
    }

    private boolean dinsImatge(int mx, int my) {
        if (img == null) {
            return false;
        }

        return mx >= x && mx <= x + img.getWidth()
            && my >= y && my <= y + img.getHeight();
    }

    public void mousePressed(MouseEvent e) {
        if (dinsImatge(e.getX(), e.getY())) {
            arrossegant = true;
            offsetX = e.getX() - x;
            offsetY = e.getY() - y;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (arrossegant) {
            x = e.getX() - offsetX;
            y = e.getY() - offsetY;
            repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {
        arrossegant = false;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
