/**
 * Created by dude on 6/11/2017.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GUI extends JPanel {
    String[][] squares= null;
    int[][] presents=null;
    int number_of_players;
    String[] presentTypes=null;

    GUI(String[][] squares,int[][] presents,int n ,String[] Score,String[] presentType){
        this.squares=squares;
        this.presents=presents;
        number_of_players=n;
        this.presents=presents;
        this.presentTypes=presentType;
    }

    public void draaw(GUI panel) {

        JFrame frame = new JFrame("JFrame Color Example");
        frame.setSize(918, 947 + 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        System.out.println();
        for (int j = 0; j < 9; j++) {
            {
                System.out.print(presentTypes[j] + "\t");
                System.out.println();
                System.out.print(presents[0][j]+"\t"+presents[1][j]);
                System.out.println();
            }
        }
    }

    public void paint(Graphics g) {
        int x = 0, y =100;
        int a=0;
        int xPer=0;
        int Yper=0;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                int k = 0;
                if(i==0 || i==14 || j==0 || j==14){
                    try {
                        BufferedImage bufferedImage=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\block602.jpg"));
                        g.drawImage(bufferedImage,x,y,null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else if(squares[i][j].equals("+")){
                    try {
                        BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\brick60.png"));
                        g.drawImage(bufferedImage, x, y, null);

                      /*  if (presentTypes[k].equals("bomb")) {
                            System.out.print("b");
                            BufferedImage bufferedImage1 = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\picture150.png"));
                            g.drawImage(bufferedImage1, x, y, null);
                        } else if (presentTypes[k].equals("health")) {
                            System.out.print("h");
                            BufferedImage bufferedImage1 = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\picture350.png"));
                            g.drawImage(bufferedImage1, x, y, null);
                        } else if (presentTypes[k].equals("velocity")){
                            System.out.print("v");
                            BufferedImage bufferedImage1 = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\picture250.png"));
                            g.drawImage(bufferedImage1, x, y, null);
                        }*/
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else if (squares[i][j].equals("-")){
                    try {
                        BufferedImage bufferedImage=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\block60.png"));
                        g.drawImage(bufferedImage,x,y,null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\green60.png"));
                        g.drawImage(bufferedImage, x, y, null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                for (; k < 9; k++) {
                    xPer=presents[1][k]*60;
                  Yper=presents[0][k]*60+100;
                    if (presentTypes[k].equals("bomb")) {
                        BufferedImage bufferedImage1 = null;
                        try {
                            bufferedImage1 = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\picture150.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        g.drawImage(bufferedImage1, xPer, Yper, null);
                        } else if (presentTypes[k].equals("health")) {

                        BufferedImage bufferedImage1 = null;
                        try {
                            bufferedImage1 = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\picture350.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        g.drawImage(bufferedImage1, xPer, Yper, null);
                        } else if (presentTypes[k].equals("velocity")){
                        BufferedImage bufferedImage1 = null;
                        try {
                            bufferedImage1 = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\picture250.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        g.drawImage(bufferedImage1, xPer, Yper, null);
                        }
                }
                x += 60;
            }
            y += 60;
            x = 0;
        }
        try {
            BufferedImage clock=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\clock.png"));
            BufferedImage time=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\time.png"));
            g.drawImage(clock,430,5,null);
            g.drawImage(time,410,65,null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(number_of_players==2){
            try {
                BufferedImage bufferedImage1=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_white.png"));
                BufferedImage bufferedImage2=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_black.png"));
                BufferedImage bufferedImage3=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\health.png"));
                g.drawImage(bufferedImage1,20,5,null);
                g.drawImage(bufferedImage2,750,5,null);
                for(int i=0;i<3;i++){
                    g.drawImage(bufferedImage3,762+35*i,65,null);
                    g.drawImage(bufferedImage3,30+35*i,65,null);


                }} catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(number_of_players==3){
            try {
                BufferedImage bufferedImage1=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_white.png"));
                BufferedImage bufferedImage2=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_black.png"));
                BufferedImage bufferedImage3=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_blue.png"));
                BufferedImage health=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\health.png"));
                g.drawImage(bufferedImage1,20,5,null);
                g.drawImage(bufferedImage2,250,5,null);
                g.drawImage(bufferedImage3,750,5,null);
                for(int i=0;i<3;i++){
                    g.drawImage(health,30+35*i,65,null);
                    g.drawImage(health,260+35*i,65,null);
                    g.drawImage(health,762+35*i,65,null);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (number_of_players==4){
            try {
                BufferedImage bufferedImage1=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_white.png"));
                BufferedImage bufferedImage2=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_black.png"));
                BufferedImage bufferedImage3=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_blue.png"));
                BufferedImage bufferedImage4=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_red.png"));
                BufferedImage health=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\health.png"));
                g.drawImage(bufferedImage1,20,5,null);
                g.drawImage(bufferedImage2,250,5,null);
                g.drawImage(bufferedImage3,550,5,null);
                g.drawImage(bufferedImage4,750,5,null);

                for(int i=0;i<3;i++){
                    g.drawImage(health,30+35*i,65,null);
                    g.drawImage(health,260+35*i,65,null);
                    g.drawImage(health,560+35*i,65,null);
                    g.drawImage(health,762+35*i,65,null);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
