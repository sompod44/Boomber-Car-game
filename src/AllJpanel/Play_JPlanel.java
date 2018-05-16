
/*
    Bismillahir Rahmanir Rahim
 */


package AllJpanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Sompod_Programmer
 */
public class Play_JPlanel extends JPanel { // This class for print game first user enterface  

    BufferedImage backgroundimage;

    public Play_JPlanel() throws IOException {
        backgroundimage = ImageIO.read(getClass().getClassLoader().getResource("background.png"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        g.drawImage(backgroundimage, 0, 0, 850, 600, this);
    }

}
