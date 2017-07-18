import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

/**
 * Created by asus on 7/16/2017.
 */
public class Keyboard extends JPanel implements KeyListener,ActionListener {
    KeyEvent key;
    boolean keyflag = false;
    Timer t = new Timer(3, this);

    public Keyboard() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
     //char m = e.getKeyChar();
     //   System.out.println(m+"inside keyboard");


    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyflag = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        keyflag = true;
    }



}