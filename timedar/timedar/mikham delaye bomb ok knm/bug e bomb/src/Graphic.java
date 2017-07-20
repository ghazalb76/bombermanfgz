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
    int[][] posePlayer=null;
    String[] score=null;
    String[] timee=null;
    String[] direction=null;
    JFrame frame = new JFrame("JFrame Color Example");
    int[][] theBomb_xy1=null;
    int[][] theBomb_xy2=null;
    int[][] theBomb_xy3=null;
    int[][] theBomb_xy4=null;
    String[] presentType=null;
    int numberOfPresentsInt;
    int[][] posPresents=new int[2][9];
    void setChanges(int numberOfPlayers,String[][] squares,int numberOfPresentsInt,int[][] presents,String[] presentType,int n,int[][] posePlayer,String[] score,String[] timee,String[] direction,int[][] theBomb_xy1,int [][]theBomb_xy2){
        this.squares=squares;
        this.numberOfPresentsInt=numberOfPresentsInt;
        this.presentType=presentType;
        this.number_of_players=numberOfPlayers;
        this.presents=presents;
        number_of_players=n;
        this.presents=presents;
        this.score=score;
        this.posePlayer=posePlayer;
        this.timee=timee;
        this.direction=direction;
        this.theBomb_xy1=theBomb_xy1;
        this.theBomb_xy2=theBomb_xy2;
    }
    void  setOtherChanges(int[][] theBomb_xy3){
        this.theBomb_xy3=theBomb_xy3;
    }
    void setNewChanges(int[][] theBomb_xy3,int[][] theBomb_xy4){
        this.theBomb_xy3=theBomb_xy3;
        this.theBomb_xy4=theBomb_xy4;
    }

    public void draaw(Graphic panel) {
        frame.setSize(918, 947 + 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
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
        BufferedImage black_front=null;
        BufferedImage white_front=null;
        BufferedImage red_front=null;
        BufferedImage blue_front=null;
        BufferedImage black_back=null;
        BufferedImage white_back=null;
        BufferedImage red_back=null;
        BufferedImage blue_back=null;
        BufferedImage black_right=null;
        BufferedImage blue_right=null;
        BufferedImage red_right=null;
        BufferedImage white_right=null;
        BufferedImage red_left=null;
        BufferedImage blue_left=null;
        BufferedImage black_left=null;
        BufferedImage white_left=null;
        try {

            green = ImageIO.read(new File("C:\\Users\\asus\\Desktop\\green60.png"));
            brick= ImageIO.read(new File("C:\\Users\\asus\\Desktop\\brick60.png"));
            block=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\block60.png"));
            block1=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\block602.jpg"));
            p1 = ImageIO.read(new File("C:\\Users\\asus\\Desktop\\picture150.png"));
            p2 = ImageIO.read(new File("C:\\Users\\asus\\Desktop\\picture250.png"));
            p3 = ImageIO.read(new File("C:\\Users\\asus\\Desktop\\picture350.png"));
            clock=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\clock.png"));
            time=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\time.png"));
            score_white=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\score_white.png"));
            score_black=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\score_black.png"));
            health=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\health.png"));
            score_blue=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\score_blue.png"));
            score_red=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\score_red.png"));
            player_red=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\redfront.png"));
            player_blue=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\bluefront.png"));
            player_black=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\blackfront.png"));
            bomb=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\bomb3.png"));
            red_right=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\redright.png"));
            blue_right=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\blueright.png"));
            black_right=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\blackright.png"));
            white_right=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\whiteright.png"));
            red_left=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\redleft.png"));
            blue_left=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\blueleft.png"));
            black_left=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\blackleft.png"));
            white_left=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\whiteleft.png"));
            white_back=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\whiteback.png"));
            red_back=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\redback.png"));
            black_back=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\blackback.png"));
            blue_back=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\blueback.png"));
            red_front=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\redfront.png"));
            blue_front=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\bluefront.png"));
            black_front=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\blackfront.png"));
            white_front=ImageIO.read(new File("C:\\Users\\asus\\Desktop\\whitefront.png"));



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
                else if(squares[i][j].equals("+") || squares[i][j].equals("1") || squares[i][j].equals("2") || squares[i][j].equals("3") ){
                    g.drawImage(brick, x, y, null);
                }
                else if (squares[i][j].equals("-")){
                    g.drawImage(block,x,y,null);
                }
                else {
                    g.drawImage(green, x, y, null);
                }
                for (; k < numberOfPresentsInt; k++) {
                    xPer = presents[1][k] * 60;
                    Yper = presents[0][k] * 60 + 100;
                    if (presentType[k].equals("bomb")) {
                        g.drawImage(p1, xPer, Yper, null);
                    } else if (presentType[k].equals("health")) {
                        g.drawImage(p2, xPer, Yper, null);
                    } else if (presentType[k].equals("velocity")) {
                        g.drawImage(p3, xPer, Yper, null);
                    }
                }
                x += 60;
                }
            y += 60;
            x = 0;
            }
            for(int i=0;i<3;i++) {
                if (theBomb_xy1[0][i]!=-1){
                    g.drawImage(bomb,theBomb_xy1[1][i]*60,theBomb_xy1[0][i]*60+100,null);
                }
                if (theBomb_xy2[0][i]!=-1){
                    g.drawImage(bomb,theBomb_xy2[1][i]*60,theBomb_xy2[0][i]*60+100,null);
                }
                if(number_of_players==3){
                    if (theBomb_xy3[0][i]!=-1){
                        g.drawImage(bomb,theBomb_xy3[1][i]*60,theBomb_xy3[0][i]*60+100,null);
                    }
                }
                else if(number_of_players==4){
                    if (theBomb_xy3[0][i]!=-1){
                        g.drawImage(bomb,theBomb_xy3[1][i]*60,theBomb_xy3[0][i]*60+100,null);
                    }
                    if (theBomb_xy4[0][i]!=-1){
                        g.drawImage(bomb,theBomb_xy4[1][i]*60,theBomb_xy4[0][i]*60+100,null);
                    }
                }
            }
        Font f = new Font("Comic Sans MS", Font.BOLD, 25);
        g.setFont(f);
        g.setColor(Color.white);
        g.drawImage(clock,430,5,null);
        g.drawImage(time,410,65,null);
        g.drawString(timee[0],420,88);
        g.drawString(timee[1],467,88);
        f = new Font("Comic Sans MS", Font.BOLD, 40);
        g.setFont(f);
        g.setColor(Color.black);
        if(number_of_players==2) {
            g.drawImage(score_white, 20, 5, null);
            g.drawImage(score_black, 750, 5, null);
            g.drawString(score[0], 105, 50);
            g.drawString(score[1], 835, 50);
            for (int i = 0; i < 3; i++) {
                g.drawImage(health, 762 + 35 * i, 65, null);
                g.drawImage(health, 30 + 35 * i, 65, null);
            }
        }
        else if(number_of_players==3){
            g.drawImage(score_white,20,5,null);
            g.drawImage(score_black,250,5,null);
            g.drawImage(score_blue,750,5,null);
            g.drawString(score[0],105,50);
            g.drawString(score[1],335,50);
            g.drawString(score[2],835,50);
            for(int i=0;i<3;i++) {
                g.drawImage(health, 30 + 35 * i, 65, null);
                g.drawImage(health, 260 + 35 * i, 65, null);
                g.drawImage(health, 762 + 35 * i, 65, null);
            }
        }
        else if (number_of_players==4) {
            g.drawImage(score_white, 20, 5, null);
            g.drawImage(score_black, 250, 5, null);
            g.drawImage(score_blue, 550, 5, null);
            g.drawImage(score_red, 750, 5, null);
            g.drawString(score[0], 105, 50);
            g.drawString(score[1], 335, 50);
            g.drawString(score[2], 635, 50);
            g.drawString(score[3], 835, 50);
            for(int i=0;i<3;i++){
                g.drawImage(health,30+35*i,65,null);
                g.drawImage(health,260+35*i,65,null);
                g.drawImage(health,560+35*i,65,null);
                g.drawImage(health,762+35*i,65,null);
            }
        }
            switch (direction[0]){
                case "2":g.drawImage(red_front, posePlayer[0][0], posePlayer[1][0], null);
                    break;
                case "6":g.drawImage(red_right,posePlayer[0][0],posePlayer[1][0],null);
                    break;
                case "4":g.drawImage(red_left,posePlayer[0][0],posePlayer[1][0],null);
                    break;
                case "8":g.drawImage(red_back,posePlayer[0][0],posePlayer[1][0],null);
                    break;
            }switch (direction[1]){
                case "2":g.drawImage(blue_front,posePlayer[0][1],posePlayer[1][1],null);
                    break;
                case "6":g.drawImage(blue_right,posePlayer[0][1],posePlayer[1][1],null);
                    break;
                case "4":g.drawImage(blue_left,posePlayer[0][1],posePlayer[1][1],null);
                    break;
                case "8":g.drawImage(blue_back,posePlayer[0][1],posePlayer[1][1],null);
                    break;
            }

         if(number_of_players==3){
            switch (direction[2]){
                case "2":g.drawImage(black_front,posePlayer[0][2],posePlayer[1][2],null);
                    break;
                case "6":g.drawImage(black_right,posePlayer[0][2],posePlayer[1][2],null);
                    break;
                case "4":g.drawImage(black_left,posePlayer[0][2],posePlayer[1][2],null);
                    break;
                case "8":g.drawImage(black_back,posePlayer[0][2],posePlayer[1][2],null);
                    break;
            }
        }
        else if(number_of_players==4){
             switch (direction[2]){
                 case "2":g.drawImage(black_front,posePlayer[0][2],posePlayer[1][2],null);
                     break;
                 case "6":g.drawImage(black_right,posePlayer[0][2],posePlayer[1][2],null);
                     break;
                 case "4":g.drawImage(black_left,posePlayer[0][2],posePlayer[1][2],null);
                     break;
                 case "8":g.drawImage(black_back,posePlayer[0][2],posePlayer[1][2],null);
                     break;
             }
            switch (direction[3]){
                case "2":g.drawImage(white_front,posePlayer[0][3],posePlayer[1][3],null);
                    break;
                case "6":g.drawImage(white_right,posePlayer[0][3],posePlayer[1][3],null);
                    break;
                case "4":g.drawImage(white_left,posePlayer[0][3],posePlayer[1][3],null);
                    break;
                case "8":g.drawImage(white_back,posePlayer[0][3],posePlayer[1][3],null);
                    break;
            }
        }
    }
}