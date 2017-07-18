import com.sun.org.apache.xpath.internal.operations.String;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Send implements Runnable {
 java.lang.String key;
    Socket socket;
    Graphic gui;
    Keyboard k;
    KeyEvent e;
    boolean keyflag;



    Send(Socket socket, Graphic gui) {
        this.socket = socket;
        // this.key = String.valueOf(key);
        this.gui = gui;
        this.k = k;


    }

    boolean flag = true;

    @Override
    public void run() {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));


        try {
            key= java.lang.String.valueOf(cin.readLine());
            flag = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui.frame.addKeyListener(new Keyboard());

        while (true) {
            //  Keyboard k2 = new Keyboard();
            //gui.frame.add(k2);



         if(key!=null){
              //  key = String.value(key).toString();
             key= java.lang.String.valueOf(key).toString();
                System.out.println("true "+key);
            }
            //    System.out.println(k2.key);

            System.out.println("hiiiiiiiiiiiii");

            try {


                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("keyBoard", key);
                    System.out.println(key + " keyyyyyyyy");
                    java.lang.String STRdata = jsonObject.toString();

                    socket.getOutputStream().write(STRdata.getBytes());
                    key="0";

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch(IOException e){
                    e.printStackTrace();
                }



        }
    }

  public void key(KeyEvent e) {

        System.out.println(e.getKeyChar());
      //key = String.valueOf(e.getKeyChar());
      key= java.lang.String.valueOf(e.getKeyChar());
        System.out.println("key method" + key);


    }


    public class Keyboard extends JPanel implements KeyListener,ActionListener {

        boolean keyflag = false;
        Timer t = new Timer(5, this);

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
            key = java.lang.String.valueOf(e.getKeyChar());
         //   System.out.println(key);

            keyflag = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (keyflag == false) {
                key = "0";
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {

        }



    }


}






