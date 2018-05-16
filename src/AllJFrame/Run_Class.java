
/*
    Bismillahir Rahmanir Rahim
 */

package AllJFrame;

import AllJpanel.Intropanel;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author Sompod_Programmer
 */
public class Run_Class extends JFrame { // This class show main game panel

    Run_Class() {
        setTitle("2D Boomber Car Developed By Sompod");
        setBounds(500, 100, 365, 600);
        Container containpain = getContentPane();
        containpain.add(new Intropanel());
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
