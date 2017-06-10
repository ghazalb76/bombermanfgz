import javax.swing.*;
import java.awt.*;

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
                      if(squares[i][j] instanceof Brick)
                        g.setColor(new Color(0xBDD21B));
                    else if (squares[i][j] instanceof  Block)
                        g.setColor(new Color(0x69BCFF));
                    else
                          g.setColor(new Color(0x1EB43E));
                    g.fillRect(x,y,60,60);
                    x += 60;
                }
                y += 60;
                x = 0;
            }
        }
    }