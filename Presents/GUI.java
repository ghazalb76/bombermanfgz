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

    GUI(String[][] squares,int[][] presents){
        this.squares=squares;
        this.presents=presents;
    }
    public void draaw(GUI panel) {

        JFrame frame = new JFrame("JFrame Color Example");
        frame.setSize(918, 947+100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        int x = 0, y =100;
        int a=0;

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
                else if(squares[i][j].equals("+")){
                    try {
                        BufferedImage bufferedImage=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\brick60.png"));
                        g.drawImage(bufferedImage,x,y,null);
                        for(int k=0;k<9;k++){
                            if(presents[0][k]==i && presents[1][k]==j){
                                BufferedImage bufferedImage1=ImageIO.read(new File("C:\\Users\\dude\\Desktop\\Picture1.png"));
                                g.drawImage(bufferedImage1,x,y,null);
                            }
                        }
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
                x += 60;
            }
            y += 60;
            x = 0;
        }
    }
}
