

/*
    Bismillahir Rahmanir Rahim
 */

package AllJFrame;

// This is main class 
import AllJpanel.Play_JPlanel;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Sompod_Programmer
 */
public class Play_Jframe extends JFrame implements KeyListener {

    public Play_Jframe() throws IOException {
        Container containpain = getContentPane();
        containpain.add(new Play_JPlanel());
        setTitle("2D Boomber Car Developed By Sompod");
        setBounds(300, 100, 850, 620);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addKeyListener(this); // this is for key listener 
        setFocusable(true); // This method need for key listener
        setFocusTraversalKeysEnabled(false); // This method need for key listener
    }

    public static void main(String[] args) throws IOException {
        new Play_Jframe();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) { // When press key from keyboard 

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) { // If user press enter button
            new Run_Class();
            this.setVisible(false);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
