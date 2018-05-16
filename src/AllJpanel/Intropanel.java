
/*
    Bismillahir Rahmanir Rahim
 */
package AllJpanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/**
 *
 * @author Sompod_Programmer
 */
public class Intropanel extends JPanel implements ActionListener, KeyListener {

    private final Integer timelapes = 150;
    private BufferedImage[] background = new BufferedImage[3];
    private BufferedImage[] car = new BufferedImage[7];
    private BufferedImage rocket;
    int check = 0;
    int playercarX = 80;
    int playercarY = 480;
    int forboomprint = 0;
    int getplayercarX = 0;
    int getplayercarY = 0;
    boolean boomrun = true;
    boolean againboomrun = true;
    int boomcrosslimit = 0;
    boolean[] carCrashOrNot = new boolean[3];
    int LeftSideRoad = 80;
    int RightSideRoad = 230;
    int[] increasingY = new int[6];
    Random RandomNumber = new Random();
    boolean[] carrun = new boolean[3];
    int[] checkcarside = new int[3];
    int[] primaryvalue = new int[6];
    JLabel jlabel;
    int scoure = 0, best_scoure = 0;
    int[] changeTrack = new int[6];
    int play = 0;

    public Intropanel() {
        Timer timer = new Timer(timelapes, this);
        timer.start();
        jlabel = new JLabel();
        jlabel.setBounds(100, 200, 100, 20);

        jlabel.setForeground(Color.RED);
        add(jlabel);

        try {
            // Now input background images
            background[0] = ImageIO.read(getClass().getClassLoader().getResource("road1.png"));
            background[1] = ImageIO.read(getClass().getClassLoader().getResource("road2.png"));
            background[2] = ImageIO.read(getClass().getClassLoader().getResource("road3.png"));

            // Now input car images
            car[0] = ImageIO.read(getClass().getClassLoader().getResource("car1.png"));
            car[1] = ImageIO.read(getClass().getClassLoader().getResource("car2.png"));
            car[2] = ImageIO.read(getClass().getClassLoader().getResource("car3.png"));
            car[3] = ImageIO.read(getClass().getClassLoader().getResource("car4.png"));
            car[4] = ImageIO.read(getClass().getClassLoader().getResource("car5.png"));
            car[5] = ImageIO.read(getClass().getClassLoader().getResource("car6.png"));
            car[6] = ImageIO.read(getClass().getClassLoader().getResource("playercar.png"));

            // Now input car images
            rocket = ImageIO.read(getClass().getClassLoader().getResource("rocket.png"));

        } catch (Exception ex) {
            System.out.println(ex);
        }

        for (int i = 0; i < 6; i++) { // This loop for initialize changetrack variables 
            changeTrack[i] = 0;

        }

        // Those variable are primary positon of cars 
        primaryvalue[0] = -500;
        primaryvalue[1] = -800;
        primaryvalue[2] = -1100;
        primaryvalue[3] = -1400;
        primaryvalue[4] = -1700;
        primaryvalue[5] = -2000;

        System.arraycopy(primaryvalue, 0, increasingY, 0, 6); // Here primaryvalue array copy into increasingY array

        //This 3 method are very importance for Key listener
        addKeyListener(this); // this is for key listener 
        setFocusable(true); // This method need for key listener
        setFocusTraversalKeysEnabled(false); // This method need for key listener

    }

    @Override
    protected void paintComponent(Graphics g) { // This method for print object into jpanel.
        super.paintComponent(g);
        jlabel.setText("Best scoure : " + best_scoure + " Your scoure : " + scoure); // This print scoure at first.
        switch (check) { // This switch condition use for paint background images
            case 0:
                g.drawImage(background[0], 0, 0, this);
                check = 1;
                break;
            case 1:
                g.drawImage(background[1], 0, 0, this);
                check = 2;
                break;
            case 2:
                g.drawImage(background[2], 0, 0, this);
                check = 0;
                break;
        }

        g.drawImage(car[6], playercarX, playercarY, 50, 80, this); // Here paint playercar

        if (forboomprint == 1) {// If user press F key then Here print boom.
            if (boomrun == true) { //This variable use for print boom but first time 
                g.drawImage(rocket, playercarX + 5, playercarY - 20, 50, 80, this); // here print boom
                getplayercarX = playercarX + 5; // this variable use for get boom X - Axis
                getplayercarY = playercarY - 20; // This variable use for get boom Y - Axis
                againboomrun = false; // without crush boom user can't press F key
                boomrun = false; // then boom can't print again same place
            } else { // Here boom go 
               getplayercarY -= 80;
               if(getplayercarY < -1){ // if boom are cross the screen 
                   forboomprint =0;
                   againboomrun = true;
               }
                g.drawImage(rocket, getplayercarX, getplayercarY, 50, 80, this);

            }
        }

        for (int i = 0; i < 6; i++) { // This loop for cars print

            switch (i) {
                case 0:
                    if (changeTrack[i] == 0) { // if car crush in leftside road then here car again post in rigth side
                        g.drawImage(car[i], LeftSideRoad, increasingY[i], 50, 80, this);
                    } else {
                        g.drawImage(car[i], RightSideRoad, increasingY[i], 50, 80, this);
                    }

                    break;
                case 1:
                    if (changeTrack[i] == 0) { // if car crush in leftside road then here car again post in rigth side
                        g.drawImage(car[i], LeftSideRoad, increasingY[i], 50, 80, this);
                    } else {
                        g.drawImage(car[i], RightSideRoad, increasingY[i], 50, 80, this);
                    }
                    break;
                case 2:
                    if (changeTrack[i] == 0) {// if car crush in leftside road then here car again post in rigth side
                        g.drawImage(car[i], LeftSideRoad, increasingY[i], 50, 80, this);
                    } else {
                        g.drawImage(car[i], RightSideRoad, increasingY[i], 50, 80, this);
                    }
                    break;
                case 3:
                    if (changeTrack[i] == 0) {// if car crush in leftside road then here car again post in rigth side
                        g.drawImage(car[i], LeftSideRoad, increasingY[i], 50, 80, this);
                    } else {
                        g.drawImage(car[i], RightSideRoad, increasingY[i], 50, 80, this);
                    }
                    break;
                case 4:
                    if (changeTrack[i] == 0) {// if car crush in leftside road then here car again post in rigth side
                        g.drawImage(car[i], LeftSideRoad, increasingY[i], 50, 80, this);
                    } else {
                        g.drawImage(car[i], RightSideRoad, increasingY[i], 50, 80, this);
                    }
                    break;
                case 5:
                    if (changeTrack[i] == 0) {// if car crush in leftside road then here car again post in rigth side
                        g.drawImage(car[i], LeftSideRoad, increasingY[i], 50, 80, this);
                    } else {
                        g.drawImage(car[i], RightSideRoad, increasingY[i], 50, 80, this);
                    }
                    break;
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) { // Timer call this method specific 	
        // Those variable use for collect distance and radius
        double boom_and_car_distance;
        double playercar_and_car_distance;
        double boom_and_car_radius;
        double playercar_and_car_radius;
        double boomx1, boomy1, playercarx1, playercary1, carx2, cary2;

        for (int i = 0; i < 6; i++) { // this loop use for increacing deffarent car speed 

            switch (i) {
                case 0:
                    increasingY[i] += 50;
                    break;
                case 1:
                    increasingY[i] += 40;
                    break;
                case 2:
                    increasingY[i] += 35;
                    break;

                case 3:
                    increasingY[i] += 45;
                    break;
                case 4:
                    increasingY[i] += 25;
                    break;
                case 5:
                    increasingY[i] += 20;
                    break;
            }
        }

        for (int i = 0; i < 6; i++) { // If cars are cross this limit then cars are again print there primary position
            if (increasingY[i] >= 550) {
                increasingY[i] = primaryvalue[i];
            }
        }
        
        

        

        for (int i = 0; i < 6; i++) { // This loop check player car and other care hit each other or not 
            playercarx1 = playercarX + 50 / 2; // here get playercar center value of X - Axis
            playercary1 = playercarY + 80 / 2; // here get playercar center value of Y - Axis
            switch (i) {
                case 0:
                    if (changeTrack[i] == 0) { // If car roadside is diffarant then car X - Axis value also have diffarent so here we check cars are which road.
                        carx2 = LeftSideRoad + 50 / 2;
                    } else {
                        carx2 = RightSideRoad + 50 / 2;
                    }

                    break;
                case 1:
                    if (changeTrack[i] == 0) { // If car roadside is diffarant then car X - Axis value also have diffarent so here we check cars are which road.
                        carx2 = LeftSideRoad + 50 / 2;
                    } else {
                        carx2 = RightSideRoad + 50 / 2;
                    }
                    break;
                case 2:
                    if (changeTrack[i] == 0) { // If car roadside is diffarant then car X - Axis value also have diffarent so here we check cars are which road.
                        carx2 = LeftSideRoad + 50 / 2;
                    } else {
                        carx2 = RightSideRoad + 50 / 2;
                    }
                    break;
                case 3:
                    if (changeTrack[i] == 0) { // If car roadside is diffarant then car X - Axis value also have diffarent so here we check cars are which road.
                        carx2 = LeftSideRoad + 50 / 2;
                    } else {
                        carx2 = RightSideRoad + 50 / 2;
                    }
                    break;
                case 4:
                    if (changeTrack[i] == 0) { // If car roadside is diffarant then car X - Axis value also have diffarent so here we check cars are which road.
                        carx2 = LeftSideRoad + 50 / 2;
                    } else {
                        carx2 = RightSideRoad + 50 / 2;
                    }
                    break;
                default:
                    if (changeTrack[i] == 0) { // If car roadside is diffarant then car X - Axis value also have diffarent so here we check cars are which road.
                        carx2 = LeftSideRoad + 50 / 2;
                    } else {
                        carx2 = RightSideRoad + 50 / 2;
                    }
                    break;
            }

            cary2 = increasingY[i] + 80 / 2; // Here we get car center value of Y-Axis . Here 80 is width of car.

            playercar_and_car_radius = 60;  // Here this is playercar and car radius . Like player car radius is 30 and car radius is 30.

            playercar_and_car_distance = Math.sqrt(Math.pow((playercarx1 - carx2), 2) + Math.pow((playercary1 - cary2), 2)); // Here applied formula of two circle distance from center cordinate

            if (playercar_and_car_distance <= playercar_and_car_radius) {
                increasingY[i] = primaryvalue[i];
                Crushmusic();
                JOptionPane.showMessageDialog(this, " Game Over!!!");

                if (best_scoure <= scoure) {
                    best_scoure = scoure;
                }

                scoure = 0;

            }
        }

        for (int i = 0; i < 6; i++) { // This loop use for check boom and car hit each other or not !!!
            if (forboomprint == 1) {  // If boom are not crush 

                boomx1 = getplayercarX + 50 / 2;
                boomy1 = getplayercarY + 80 / 2;
                switch (i) {
                    case 0:
                        if (changeTrack[i] == 0) {
                            carx2 = LeftSideRoad + 50 / 2;
                        } else {
                            carx2 = RightSideRoad + 50 / 2;
                        }
                        break;
                    case 1:
                        if (changeTrack[i] == 0) {
                            carx2 = LeftSideRoad + 50 / 2;
                        } else {
                            carx2 = RightSideRoad + 50 / 2;
                        }
                        break;
                    case 2:
                        if (changeTrack[i] == 0) {
                            carx2 = LeftSideRoad + 50 / 2;
                        } else {
                            carx2 = RightSideRoad + 50 / 2;
                        }
                        break;
                    case 3:
                        if (changeTrack[i] == 0) {
                            carx2 = LeftSideRoad + 50 / 2;
                        } else {
                            carx2 = RightSideRoad + 50 / 2;
                        }
                        break;
                    case 4:
                        if (changeTrack[i] == 0) {
                            carx2 = LeftSideRoad + 50 / 2;
                        } else {
                            carx2 = RightSideRoad + 50 / 2;
                        }
                        break;
                    default:
                        if (changeTrack[i] == 0) {
                            carx2 = LeftSideRoad + 50 / 2;
                        } else {
                            carx2 = RightSideRoad + 50 / 2;
                        }
                        break;
                }
                cary2 = increasingY[i] + 80 / 2;

                boom_and_car_radius = 80;

                boom_and_car_distance = Math.sqrt(Math.pow((boomx1 - carx2), 2) + Math.pow((boomy1 - cary2), 2)); // Here applied formula of two circle distance from center cordinate

                if (boom_and_car_distance <= boom_and_car_radius) {
                    Explosionmusic();

                    if (changeTrack[i] == 0) {
                        changeTrack[i] = 1;
                    } else {
                        changeTrack[i] = 0;
                    }

                    increasingY[i] = -1000 - RandomNumber.nextInt(500);
                    ++scoure;
                    forboomprint = 0;
                    againboomrun = true;
                    boomcrosslimit = 0;
                }

            }

        }



        repaint(); // Thia method called this method paintComponent(Graphics g) thats why objecct are always print

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) { // When we press key from key board then this method called
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            if (playercarX < 230) {
                playercarX += 150;

            }

        }
        if (key == KeyEvent.VK_LEFT) {
            if (playercarX > 80) {
                playercarX -= 150;

            }

        }

        if (key == KeyEvent.VK_F) { // when we press F key from keyboard.
            if (againboomrun == true) {
                forboomprint = 1;
                boomrun = true;
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    void Explosionmusic() { // This method for play music when boom hit the car
        InputStream inputStream;
        AudioPlayer audioPlayer = AudioPlayer.player; // this is need for play music
        AudioStream audio; // this is need for play music

        try {
            inputStream = getClass().getClassLoader().getResourceAsStream("explosionfinal.wav");
            audio = new AudioStream(inputStream);

            audioPlayer.start(audio);

        } catch (Exception ex) {

            System.out.println(ex);
        }

    }

    void Crushmusic() { // This method for play music when car hit the player car
        InputStream inputStream;
        AudioPlayer audioPlayer = AudioPlayer.player; // this is need for play music
        AudioStream audio; // this is need for play music

        try {
            inputStream = getClass().getClassLoader().getResourceAsStream("splat.wav");
            audio = new AudioStream(inputStream);

            audioPlayer.start(audio);

        } catch (Exception ex) {

            System.out.println(ex);
        }

    }
}
