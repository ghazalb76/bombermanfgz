import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
   Created by asus on 6/10/2017.**/


     public class GUI extends JPanel {
         Square[][] squares=new Square[15][15];
         GUI(Square[][] squares){
             this.squares=squares;
         }
        public void draaw(GUI panel) {

            JFrame frame = new JFrame("JFrame Color Example");
            frame.setSize(918, 947+100);
           // frame.setUndecorated(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            frame.setVisible(true);
        }

        public void paint(Graphics g) {
            int x = 0, y =100;

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    if(i==0 || i==14 || j==0 || j==14){
                        try {
                            BufferedImage bufferedImage=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\block602.jpg"));
                            g.drawImage(bufferedImage,x,y,null);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                      else if(squares[i][j] instanceof Brick){
                          try {
                              BufferedImage bufferedImage=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\brick60.png"));
                              g.drawImage(bufferedImage,x,y,null);
                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                      }

                    else if (squares[i][j] instanceof  Block){
                          try {
                              BufferedImage bufferedImage=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\block60.png"));
                              g.drawImage(bufferedImage,x,y,null);
                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                      }
                       // g.setColor(new Color(0x69BCFF));
                    else {
                          try {
                              BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\dude\\Desktop\\green60.png"));
                              g.drawImage(bufferedImage, x, y, null);
                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                      }
                   // g.fillRect(x,y,60,60);
                    x += 60;
                }
                y += 60;
                x = 0;
            }
        }
    }