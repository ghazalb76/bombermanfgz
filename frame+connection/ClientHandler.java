import jdk.nashorn.internal.runtime.ParserException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.net.Socket;
import java.util.Iterator;
import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 * Created by mohammadrezamousavi on 5/27/17.
 */
public class ClientHandler implements Runnable {
    int n;
    long[] score=null;
    String[] scoreString=null;
    long[][] posPresent= new long[2][9];
    String[] presentType=new String[9];
    int[][] posPlayerint=null;
    long[][] posePlayer= null;
    int[][] bombs=null;
    String[][] squares=null;
    InputStream is;
    Thread t;
    Socket socket = null;
    ParseClient parseClient=new ParseClient();
    Graphic gui;
    boolean flag=true;
    String[] time=null;
    public ClientHandler() throws IOException {
        try {
            socket=new Socket("localhost",8081);
            is = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui=new Graphic(/*squares,posPresent,n,parse.score,parse.presentType,parse.posePlayer,parse.bombs,parse.time*/);

        t = new Thread(this);
        t.start();

        send();


        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    Semaphore semaphore= new Semaphore(1);



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
                            System.out.print(squares[i][j]);
                        }
                        System.out.println();
                    }
                String c = (String) jsonObject.get("numbers");
                n = Integer.parseInt(c);
                System.out.println("n"+n);
                String temp;
                posePlayer= new long[2][n];
                for(int i =0 ;i<n;i++){

                    posePlayer[0][i]=(long)jsonObject.get("x_player"+i+"");
                    System.out.println(posePlayer[0][i]);

                    posePlayer[1][i]=(long)jsonObject.get("y_player"+i+"");
                    System.out.println(posePlayer[1][i]);

                }
                posPlayerint=new int[2][n];
                    for(int i =0 ;i<n;i++) {
                        posPlayerint[0][i] = (int) posePlayer[0][i];
                        posPlayerint[1][i] = (int) posePlayer[1][i];
                    }

                for(int j =0 ;j<n;j++){
                    System.out.println(posePlayer[0][0+j]);
                    System.out.println(posePlayer[1][0+j]);
                }
                    JSONArray presentX=(JSONArray) jsonObject.get("presentX") ;
                    JSONArray presentY=(JSONArray) jsonObject.get("presentY") ;

                    Iterator<Long > iteratorX=presentX.iterator();
                    Iterator<Long > iteratorY=presentY.iterator();


                    for(int i =0 ;i<9 ;i++){
                        posPresent[0][i]= iteratorX.next();
                        posPresent[1][i]= iteratorY.next();

                    }
                    for(int j =0 ;j<9;j++){
                        System.out.print(posPresent[0][j]+"\t"+posPresent[1][j]);
                        System.out.println();
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
                    for(int i =0 ;i<n ;i++){
                        System.out.println("++++"+scoreString[i]);
                    }
                    JSONArray timeee=(JSONArray) jsonObject.get("time");
                    Iterator<String > iteratorr=timeee.iterator();
                    time=new String[2];
                    for(int i =0 ;i<2 ;i++){
                        time[i]=iteratorr.next();
                    }
                    for(int i =0 ;i<2 ;i++){
                        System.out.println("++++"+time[i]);
                    }
                    gui.setChanges(squares,posPresent,n,posPlayerint,scoreString,time);
                    do{
                        gui.draaw(gui);
                        flag=false;
                    }while (flag);
                    gui.repaint();

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
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            try {

                String s = (String) cin.readLine();
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("keyBoard",s);
                String STRdata=jsonObject.toString();

                socket.getOutputStream().write(STRdata.getBytes());
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
}