import java.awt.event.KeyEvent;
import java.net.Socket;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;


public class Client {
    InputStream is = null;
    Socket socket = null;
    char key;
    Keyboard k;
KeyEvent e;
    public Client(Graphic gui) {
        try {
            socket = new Socket("localhost", 8081);
            is = socket.getInputStream();
            this.key=key;
            this.k=k;
            this.e=e;
        } catch (IOException m) {
            m.printStackTrace();
        }

        //   t = new Thread(this);
        //   t.start();

        Receive t2 = new Receive(is, gui);
        t2.start();
        Runnable t4=new Send(socket,gui);
        Thread t3=new Thread(t4);
     //  Send t3 = new Send(socket,gui);
        t3.start();


        try {
            t2.join();
        } catch (InterruptedException m) {
            m.printStackTrace();
        }

    }
}