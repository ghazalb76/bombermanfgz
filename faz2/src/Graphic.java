/**
 * Created by dude on 6/11/2017.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Graphic extends JPanel {
    int keyboard1=5;
    int keyboard2=5;
    int keyboard3=5;
    int keyboard4=5;

    String[][] squares= null;
    int[][] presents=null;
    int number_of_players;
    String[] presentTypes=null;
    int[][] posePlayer=null;
    int[][] bombs;
    String[] score=null;
    JLabel jLabel = new JLabel();
    JFrame frame = new JFrame("JFrame Color Example");
    JTextPane jTextPane=new JTextPane();
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

        frame.setSize(918, 947 + 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        frame.setVisible(true);
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
        jLabel.setBounds(50,50, 100,30);
        jLabel.setText("qazaleeeeeeeeeeeeeeee");
        frame.add(jLabel);
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
        BufferedImage player_right=null;
        BufferedImage player_left=null;
        BufferedImage player_up=null;
        BufferedImage player_down=null;
        BufferedImage red_right=null;
        BufferedImage blue_right=null;
        BufferedImage black_right=null;
        BufferedImage white_right=null;
        BufferedImage red_left=null;
        BufferedImage blue_left=null;
        BufferedImage black_left=null;
        BufferedImage white_left=null;


        try {
            green = ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\green60.png"));
            brick= ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\brick60.png"));
            block=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\block60.png"));
            block1=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\block602.jpg"));
            p1 = ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\picture150.png"));
            p2 = ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\picture250.png"));
            p3 = ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\picture350.png"));
            clock=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\clock.png"));
            time=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\time.png"));
            score_white=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\score_white.png"));
            score_black=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\score_black.png"));
            health=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\health.png"));
            score_blue=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\score_blue.png"));
            score_red=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\score_red.png"));
            player_red=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\p1.png"));
            player_blue=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\p1.png"));
            player_black=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\p1.png"));
            red_right=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\redright.png"));
            blue_right=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\blueright.png"));
            black_right=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\blackright.png"));
            white_right=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\whiteright.png"));
            red_left=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\redleft.png"));
            blue_left=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\blueleft.png"));
            black_left=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\blackleft.png"));
            white_left=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\whiteleft.png"));
            bomb=ImageIO.read(new File("C:\\Users\\ZAHRA\\Desktop\\bomb3.png"));

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
            if(keyboard1==5) {
                g.drawImage(player_red, posePlayer[0][0], posePlayer[1][0], null);
            }
            else if (keyboard1==6){
                g.drawImage(red_right,posePlayer[0][1],posePlayer[1][1],null);

            }
            else if (keyboard1==4){
                g.drawImage(red_left,posePlayer[0][1],posePlayer[1][1],null);

            }
            if(keyboard2==5) {
                g.drawImage(player_blue,posePlayer[0][1],posePlayer[1][1],null);
            }
            else if (keyboard2==6){
                g.drawImage(blue_right,posePlayer[0][1],posePlayer[1][1],null);
            }
            else if (keyboard2==4){
                g.drawImage(blue_left,posePlayer[0][1],posePlayer[1][1],null);
            }
            for (int i = 0; i < 3; i++) {
                g.drawImage(health, 762 + 35 * i, 65, null);
                g.drawImage(health, 30 + 35 * i, 65, null);
            }

        }
        else if(number_of_players==3){
            g.drawImage(score_white,20,5,null);
            g.drawImage(score_black,250,5,null);
            g.drawImage(score_blue,750,5,null);
            if(keyboard1==5) {
                g.drawImage(player_red, posePlayer[0][0], posePlayer[1][0], null);
            }
            else if (keyboard1==6){
                g.drawImage(red_right,posePlayer[0][1],posePlayer[1][1],null);

            }
            else if (keyboard1==4){
                g.drawImage(red_left,posePlayer[0][1],posePlayer[1][1],null);

            }
            if(keyboard2==5) {
                g.drawImage(player_blue,posePlayer[0][1],posePlayer[1][1],null);
            }
            else if (keyboard2==6){
                g.drawImage(blue_right,posePlayer[0][1],posePlayer[1][1],null);
            }
            else if (keyboard2==4){
                g.drawImage(blue_left,posePlayer[0][1],posePlayer[1][1],null);
            }
            if(keyboard3==5) {
                g.drawImage(player_black,posePlayer[0][2],posePlayer[1][2],null);
            }
            else if (keyboard3==6){
                g.drawImage(black_right,posePlayer[0][2],posePlayer[1][2],null);
            }
            else if (keyboard3==4){
                g.drawImage(black_left,posePlayer[0][2],posePlayer[1][2],null);
            }


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
            if(keyboard1==5) {
                g.drawImage(player_red, posePlayer[0][0], posePlayer[1][0], null);
            }
            else if (keyboard1==6){
                g.drawImage(red_right,posePlayer[0][1],posePlayer[1][1],null);

            }
            else if (keyboard1==4){
                g.drawImage(red_left,posePlayer[0][1],posePlayer[1][1],null);

            }
            if(keyboard2==5) {
                g.drawImage(player_blue,posePlayer[0][1],posePlayer[1][1],null);
            }
            else if (keyboard2==6){
                g.drawImage(blue_right,posePlayer[0][1],posePlayer[1][1],null);
            }
            else if (keyboard2==4){
                g.drawImage(blue_left,posePlayer[0][1],posePlayer[1][1],null);
            }
            if(keyboard3==5) {
                g.drawImage(player_black,posePlayer[0][2],posePlayer[1][2],null);
            }
            else if (keyboard3==6){
                g.drawImage(black_right,posePlayer[0][2],posePlayer[1][2],null);
            }
            else if (keyboard3==4){
                g.drawImage(black_left,posePlayer[0][2],posePlayer[1][2],null);
            }
            if(keyboard4==5) {
                g.drawImage(player_black,posePlayer[0][3],posePlayer[1][3],null);
            }
            else if (keyboard4==6){
                g.drawImage(white_right,posePlayer[0][3],posePlayer[1][3],null);
            }
            else if (keyboard4==4){
                g.drawImage(white_left,posePlayer[0][3],posePlayer[1][3],null);
            }



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
        jTextPane.setText("8799999999999999999999999999");
        frame.add(jTextPane);
    }

}