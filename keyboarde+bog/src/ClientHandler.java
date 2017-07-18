import jdk.nashorn.internal.runtime.ParserException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import java.util.concurrent.Semaphore;


public class ClientHandler  {



    InputStream is;
    Thread t;
    Socket socket = null;
    ParseClient parseClient = new ParseClient();



    public static void main(String[] args)throws IOException {


        Graphic gui;
        gui = new Graphic(/*squares,posPresent,n,parse.score,parse.presentType,parse.posePlayer,parse.bombs,parse.time*/);
    Client client=new Client(gui);
    }
}
     /*   t = new Thread(this);
        t.start();

        send();


        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        while(true) {
            receive();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void receive() {
        try {
            if (is.available() != 0) {
                byte[] b = new byte[is.available()];
                is.read(b);
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new String(b));
                JSONArray jsonArray = (JSONArray) jsonObject.get("squares");

                Iterator<String> iterator = jsonArray.iterator();
                squares = new String[15][15];

                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 15; j++) {
                        squares[i][j] = iterator.next();
                    }
                }
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 15; j++) {
                        System.out.print(squares[i][j]+"\t");
                    }
                    System.out.println();
                }

                String c = (String) jsonObject.get("numbers");
                n = Integer.parseInt(c);
                String temp;
                posePlayer= new long[2][n];
                direction=new String[n];
                // directionInt=new int[n];
                for(int i =0 ;i<n;i++){

                    posePlayer[0][i]=(long)jsonObject.get("x_player"+i+"");

                    posePlayer[1][i]=(long)jsonObject.get("y_player"+i+"");

                    direction[i]=(String)jsonObject.get("direction"+i+"");
                }
                posPlayerint=new int[2][n];
                for(int i =0 ;i<n;i++) {
                    posPlayerint[0][i] = (int) posePlayer[0][i];
                    posPlayerint[1][i] = (int) posePlayer[1][i];
                    // directionInt[i] = (int) direction[i];
                }

                JSONArray presentX=(JSONArray) jsonObject.get("presentX") ;
                JSONArray presentY=(JSONArray) jsonObject.get("presentY") ;

                Iterator<Long > iteratorX=presentX.iterator();
                Iterator<Long > iteratorY=presentY.iterator();


                for(int i =0 ;i<9 ;i++){
                    posPresent[0][i]= iteratorX.next();
                    posPresent[1][i]= iteratorY.next();

                }
                JSONArray scooores=(JSONArray) jsonObject.get("score");
                Iterator <Long> iteratorS=scooores.iterator();
                score=new long[2];
                for(int i =0 ;i<2 ;i++){
                    score[i]=iteratorS.next();
                }
                scoreString=new String[2];
                for(int i =0 ;i<2 ;i++){
                    scoreString[i]= String.valueOf(score[i]);
                }

                JSONArray timeee=(JSONArray) jsonObject.get("time");
                Iterator<String > iteratorr=timeee.iterator();
                time=new String[2];
                for(int i =0 ;i<2 ;i++){
                    time[i]=iteratorr.next();
                }
                thebomb_xy1=new long[2][3];
                JSONArray bomb_x1=(JSONArray) jsonObject.get("bomb_x1");
                Iterator<Long > iteratorbomb_x1=bomb_x1.iterator();
                for(int i =0 ;i<3 ;i++){
                    thebomb_xy1[0][i]=iteratorbomb_x1.next();
                }
                JSONArray bomb_y1=(JSONArray) jsonObject.get("bomb_y1");
                Iterator<Long > iteratorbomb_y1=bomb_y1.iterator();
                for(int i =0 ;i<3 ;i++){
                    thebomb_xy1[1][i]=iteratorbomb_y1.next();
                }
                thebomb_xy2=new long[2][3];
                JSONArray bomb_x2=(JSONArray) jsonObject.get("bomb_x2");
                Iterator<Long > iteratorbomb_x2=bomb_x2.iterator();
                for(int i =0 ;i<3 ;i++){
                    thebomb_xy2[0][i]=iteratorbomb_x2.next();
                }
                JSONArray bomb_y2=(JSONArray) jsonObject.get("bomb_y2");
                Iterator<Long > iteratorbomb_y2=bomb_y2.iterator();
                for(int i =0 ;i<3 ;i++){
                    thebomb_xy2[1][i]=iteratorbomb_y2.next();
                }
                thebombInt_xy1=new int[2][3];
                thebombInt_xy2=new int[2][3];
                for(int i=0;i<3;i++){
                    thebombInt_xy1[0][i]=(int) thebomb_xy1[0][i];
                    thebombInt_xy1[1][i]=(int) thebomb_xy1[1][i];
                    thebombInt_xy2[0][i]=(int) thebomb_xy2[0][i];
                    thebombInt_xy2[1][i]=(int) thebomb_xy2[1][i];

                }
                for(int i=0;i<3;i++){
                    System.out.print(thebombInt_xy1[0][i]+"\t");
                    System.out.println(thebombInt_xy1[1][i]);
                    System.out.print(thebombInt_xy2[0][i]+"\t");
                    System.out.println(thebombInt_xy2[1][i]);

                }
                thebomb_xy1=new long[2][3];
                thebomb_xy2=new long[2][3];
                gui.setChanges(squares,posPresent,n,posPlayerint,scoreString,time,direction,thebombInt_xy1,thebombInt_xy2);
                do{
                    gui.draaw(gui);
                    flag=false;
                }while (flag);
                gui.repaint();
                squares = new String[15][15];

            }

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ParserException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void send() {
        while(true) {
            System.out.println("hiiiiiiiiiiiii");
            if (flag) {
                BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));


                try {
                    key= java.lang.String.valueOf(cin.readLine());
                    flag = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else{
                gui.frame.addKeyListener(new Keyboard());
            }
            try {


                JSONObject jsonObject=new JSONObject();
                jsonObject.put("keyBoard",key);
                String STRdata=jsonObject.toString();

                socket.getOutputStream().write(STRdata.getBytes());
                key="0";
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        ClientHandler clientHandler = new ClientHandler();

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


}*/