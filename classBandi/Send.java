import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by dude on 7/13/2017.
 */
public class Send {
    Socket socket;
    Parse parse;
    Send(Graphic gui,Socket socket){
        this.socket=socket;
        gui.frame.addKeyListener(new Keyboard());
        parse=new Parse(socket);
    }
    public void send()  {

        key="5452";
        while(true) {
            if(!key.equals("0")) {
                parse.keyBoard(key);
            }
            key="0";
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    String key;
    public class Keyboard extends JPanel implements KeyListener,ActionListener {

        public Keyboard() {
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);

        }


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            key = java.lang.String.valueOf(e.getKeyChar());
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }


    }
}
