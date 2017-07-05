import javax.swing.*;
import java.awt.*;

/**
 * Created by dude on 7/5/2017.
 */
public class Graphic extends JPanel{
    int x=0;
    int y=0;
    JFrame frame = new JFrame("JFrame Color Example");
    public void draaw(Graphic panel) {
        frame.setSize(918, 947 + 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x,y,60,60);
        x++;
        y++;
    }

}
