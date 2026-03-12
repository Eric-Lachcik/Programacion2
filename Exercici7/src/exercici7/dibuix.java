


package exercici7;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class dibuix extends JPanel {

    private String fitxerImatge = "imatges/riu.jpg";
    private BufferedImage img;

    public dibuix() {
        try {
            img = ImageIO.read(new File(fitxerImatge));
        } catch (IOException e) {
        }
    }

    @Override
    public void paintComponent(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.drawImage(img, null, 0, 0);
        
        g.drawImage(img, 0, 0, null);
//         g.drawImage(img, 450, 150, 50, 50,this);
//        g.drawImage(img, 100, 100, 300, 300, 0, 0, img.getWidth(null), img.getHeight(null), null);
    }

    @Override
    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }
}