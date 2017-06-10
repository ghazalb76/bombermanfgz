import javax.swing.*;
import java.awt.Graphics;

/**
 * Created by ZAHRA on 10/06/2017.
 */
public class GUI {
    JFrame j=new JFrame();
    GUI(){
        j.setSize(960,960);
        j.setVisible(true);
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void paint(Graphics g){
        g.fillRect(0,0,480,480);

    }
}
