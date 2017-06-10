import org.omg.CORBA_2_3.portable.*;
import org.omg.CORBA_2_3.portable.InputStream;

import java.io.*;
import java.net.Socket;

/**
 * Created by asus on 6/1/2017.
 */
public class MultiThread extends Thread{
    Socket client=null;
    Game m;
    public MultiThread(Socket client){
        this.client=client;
    }
    public void run(){
        try {
            InputStreamReader a=new InputStreamReader(client.getInputStream());
            BufferedReader in =new BufferedReader(a);
            PrintWriter out=new PrintWriter(client.getOutputStream(),true);
           String s=in.readLine();
           System.out.println(s);
           m=new Game(s);
            String b=m.make();
            out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

