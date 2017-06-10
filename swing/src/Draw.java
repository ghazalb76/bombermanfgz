import javax.swing.*;
import java.awt.*;

/**
 * Created by asus on 6/10/2017.
 */
public class Draw extends JPanel {

    // JFrame j= new JFrame();
    public void draaw(Draw panel) {


        // create a basic JFrame
        //  JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("JFrame Color Example");
        frame.setSize(900, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add panel to main frame
        frame.add(panel);

        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        int x = 0, y = 0;
     /* for(int i=0;i<5; i++){
          x+=10;
          y+=10;

          g.setColor(Color.red);
          g.fillRect(x,y,5,5);
      }*/
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                //  if(squares[i][j] instanceof Brick)
                if (i % 2 == 0 && j % 2 == 0)
                    g.setColor(new Color(0xD61B23));
                else
                    g.setColor(new Color(0x20B41E));

                x += 60;

                if (j % 14 == 0) {
                    y += 60;
                    x = 0;
                }
                g.fillRect(x,y,20,20);
            }

        }
    }
}






