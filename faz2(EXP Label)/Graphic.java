/**
 * Created by dude on 6/11/2017.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Graphic extends JPanel {
    String[][] squares= null;
    int[][] presents=null;
    int number_of_players;
    String[] presentTypes=null;
    int[][] posePlayer=null;
    int[][] bombs;
    String[] score=null;
    Graphic(String[][] squares,int[][] presents,int n ,String[] Score,String[] presentType,int[][] posePlayer,int[][] bombs){
        this.squares=squares;
        this.presents=presents;
        number_of_players=n;
        this.presents=presents;
        this.presentTypes=presentType;
        this.score=score;
        this.posePlayer=posePlayer;
        this.bombs=bombs;
    }

    public void draaw(Graphic panel) {
        System.out.println("++++++++++++++++"+number_of_players);
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
        BufferedImage green = null;
        BufferedImage brick=null;
        BufferedImage block=null;
        BufferedImage block1=null;
        BufferedImage p1 = null;
        BufferedImage p2 = null;
        BufferedImage p3 = null;
        BufferedImage clock = null;
        BufferedImage time = null;
        BufferedImage score_white = null;
        BufferedImage score_black = null;
        BufferedImage health = null;
        BufferedImage score_blue = null;
        BufferedImage score_red = null;
        BufferedImage player_red = null;
        BufferedImage player_blue = null;
        BufferedImage player_black = null;
        BufferedImage bomb = null;
        try {
            green = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\green60.png"));
            brick= ImageIO.read(new File("C:\\Users\\dude\\Desktop\\brick60.png"));
            block=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\block60.png"));
            block1=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\block602.jpg"));
            p1 = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\picture150.png"));
            p2 = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\picture250.png"));
            p3 = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\picture350.png"));
            clock=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\clock.png"));
            time=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\time.png"));
            score_white=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_white.png"));
            score_black=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_black.png"));
            health=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\health.png"));
            score_blue=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_blue.png"));
            score_red=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\score_red.png"));
            player_red=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\star140.png"));
            player_blue=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\star240.png"));
            player_black=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\star340.png"));
            bomb=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\bomb3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        int x = 0, y =100;
        int a=0;
        int xPer=0;
        int Yper=0;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                int k = 0;
                if(i==0 || i==14 || j==0 || j==14){
                    g.drawImage(block1,x,y,null);
                }
                else if(squares[i][j].equals("+")){
                    g.drawImage(brick, x, y, null);
                }
                else if (squares[i][j].equals("-")){
                    g.drawImage(block,x,y,null);
                }
                else {
                    g.drawImage(green, x, y, null);
                }
                for (; k < 9; k++) {
                    xPer=presents[1][k]*60;
                    Yper=presents[0][k]*60+100;
                    if (presentTypes[k].equals("bomb")) {
                        g.drawImage(p1, xPer, Yper, null);
                    }
                    else if (presentTypes[k].equals("health")) {
                        g.drawImage(p2, xPer, Yper, null);
                    }
                    else if (presentTypes[k].equals("velocity")){
                        g.drawImage(p3, xPer, Yper, null);
                    }
                }
                x += 60;
            }
            y += 60;
            x = 0;
        }
        g.drawImage(clock,430,5,null);
        g.drawImage(time,410,65,null);
        if(number_of_players==2) {
            g.drawImage(score_white, 20, 5, null);
            g.drawImage(score_black, 750, 5, null);
            g.drawImage(player_red,posePlayer[0][0],posePlayer[1][0],null);
            g.drawImage(player_blue,posePlayer[0][1],posePlayer[1][1],null);
            for (int i = 0; i < 3; i++) {
                g.drawImage(health, 762 + 35 * i, 65, null);
                g.drawImage(health, 30 + 35 * i, 65, null);
            }
        }
        else if(number_of_players==3){
            g.drawImage(score_white,20,5,null);
            g.drawImage(score_black,250,5,null);
            g.drawImage(score_blue,750,5,null);
            g.drawImage(player_red,posePlayer[0][0],posePlayer[1][0],null);
            g.drawImage(player_blue,posePlayer[0][1],posePlayer[1][1],null);
            g.drawImage(player_black,posePlayer[0][2],posePlayer[1][2],null);
            for(int i=0;i<3;i++) {
                g.drawImage(health, 30 + 35 * i, 65, null);
                g.drawImage(health, 260 + 35 * i, 65, null);
                g.drawImage(health, 762 + 35 * i, 65, null);
            }
        }
        else if (number_of_players==4){
            g.drawImage(score_white,20,5,null);
            g.drawImage(score_black,250,5,null);
            g.drawImage(score_blue,550,5,null);
            g.drawImage(score_red,750,5,null);
            g.drawImage(player_red,posePlayer[0][0],posePlayer[1][0],null);
            g.drawImage(player_blue,posePlayer[0][1],posePlayer[1][1],null);
            g.drawImage(player_black,posePlayer[0][2],posePlayer[1][2],null);
            g.drawImage(player_black,posePlayer[0][3],posePlayer[1][3],null);

            for(int i=0;i<3;i++){
                g.drawImage(health,30+35*i,65,null);
                g.drawImage(health,260+35*i,65,null);
                g.drawImage(health,560+35*i,65,null);
                g.drawImage(health,762+35*i,65,null);
            }
        }
        for(int m=0 ;m<6;m++){
            int xBomb=bombs[1][m]*60;
            int yBomb=bombs[0][m]*60+100;
            g.drawImage(bomb,xBomb,yBomb,null);
        }
    }
}