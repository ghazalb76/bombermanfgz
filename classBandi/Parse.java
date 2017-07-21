import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by dude on 7/21/2017.
 */
public class Parse {
    Socket socket;
    JSONParser jsonParser;
    JSONObject jsonObject;
    JSONArray jsonArray;
    Iterator<String> iteratorString;
    long[][] thebomb_xy1 = null;
    long[][] thebomb_xy2 = null;
    long[][] thebomb_xy3 = null;
    long[][] thebomb_xy4 = null;
    long number;
    boolean kk=true;
    int[][] posPresent;
    long[] score = null;
    String[] scoreString = null;
    String[] direction = null;
    int[][] thebombInt_xy2 = null;
    int[][] thebombInt_xy1 = null;
    int[][] thebombInt_xy3 = null;
    int[][] thebombInt_xy4 = null;
    int[][] posPlayerint = null;
    long[][] posePlayer = null;
    long[] healthPlayer = null;
    int[] healthPlayerInt = null;
    String[][] squares=new String[15][15];;
    String[] time = null;
    ArrayList<Integer> posXplayerForBomb = new ArrayList<>();
    ArrayList<Integer> posYplayerForBomb = new ArrayList<>();
    int numberOfPlayers = 0;
    long numberOfPresents;
    String[] presentTypes;
    int numberOfPresentsInt;
    Parse(Socket socket){
        this.socket=socket;
    }
    void parse(byte[] b) {
        jsonParser = new JSONParser();
        try {
            jsonObject = (JSONObject) jsonParser.parse(new String(b));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void numberOfPlayers() {
        number = (long) jsonObject.get("numberOfPlayers");
        numberOfPlayers = (int) number;
    }
    void squares(){
        jsonArray = (JSONArray) jsonObject.get("squares");
        iteratorString = jsonArray.iterator();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                squares[i][j] = iteratorString.next();
            }
        }
    }
    void players() {
        posePlayer= new long[2][numberOfPlayers];
        direction=new String[numberOfPlayers];
        healthPlayer=new long[numberOfPlayers];
        for(int i =0 ;i<numberOfPlayers;i++){

            posePlayer[0][i]=(long)jsonObject.get("x_player"+i+"");

            posePlayer[1][i]=(long)jsonObject.get("y_player"+i+"");

            healthPlayer[i]=(long)jsonObject.get("health_player"+i+"");

            direction[i]=(String)jsonObject.get("direction"+i+"");
        }
        posPlayerint=new int[2][numberOfPlayers];
        healthPlayerInt=new int[numberOfPlayers];
        for(int i =0 ;i<numberOfPlayers;i++) {
            posPlayerint[0][i] = (int) posePlayer[0][i];
            posPlayerint[1][i] = (int) posePlayer[1][i];
            healthPlayerInt[i] = (int) healthPlayer[i];
            posXplayerForBomb.add(posPlayerint[0][i]);
            posYplayerForBomb.add(posPlayerint[1][i]);
        }
    }
    void present() {
        numberOfPresents = (long) jsonObject.get("numberOfPresents");
        numberOfPresentsInt = (int) numberOfPresents;

        JSONArray presentX=(JSONArray) jsonObject.get("presentX") ;
        JSONArray presentY=(JSONArray) jsonObject.get("presentY") ;
        JSONArray presentType=(JSONArray) jsonObject.get("presentType") ;

        Iterator<Long > iteratorX=presentX.iterator();
        Iterator<Long > iteratorY=presentY.iterator();
        Iterator<Long > iteratorTypee=presentType.iterator();

        posPresent= new int[2][numberOfPresentsInt];
        presentTypes= new String[numberOfPresentsInt];
        for(int i =0 ;i<numberOfPresentsInt ;i++){
            posPresent[0][i]= Math.toIntExact(iteratorX.next());
            posPresent[1][i]= Math.toIntExact(iteratorY.next());
            presentTypes[i]= String.valueOf(iteratorTypee.next());

        }
    }
    void scores() {
        JSONArray scooores=(JSONArray) jsonObject.get("score");
        Iterator <Long> iteratorS=scooores.iterator();
        score=new long[numberOfPlayers];
        for(int i =0 ;i<numberOfPlayers ;i++){
            score[i]=iteratorS.next();
        }
        scoreString=new String[numberOfPlayers];
        for(int i =0 ;i<numberOfPlayers ;i++){
            scoreString[i]= String.valueOf(score[i]);
        }

    }
    void time(){
        JSONArray timeee=(JSONArray) jsonObject.get("time");
        Iterator<String > iteratorr=timeee.iterator();
        time=new String[2];
        for(int i =0 ;i<2 ;i++){
            time[i]=iteratorr.next();
        }
    }
    void bomb(){
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
        if(numberOfPlayers==3){
            thebomb_xy3=new long[2][3];
            JSONArray bomb_x3=(JSONArray) jsonObject.get("bomb_x3");
            Iterator<Long > iteratorbomb_x3=bomb_x3.iterator();
            for(int i =0 ;i<3 ;i++){
                thebomb_xy3[0][i]=iteratorbomb_x3.next();
            }
            JSONArray bomb_y3=(JSONArray) jsonObject.get("bomb_y3");
            Iterator<Long > iteratorbomb_y3=bomb_y3.iterator();
            for(int i =0 ;i<3 ;i++){
                thebomb_xy3[1][i]=iteratorbomb_y3.next();
            }
        }
        else if(numberOfPlayers==4){
            thebomb_xy3=new long[2][3];
            JSONArray bomb_x3=(JSONArray) jsonObject.get("bomb_x3");
            Iterator<Long > iteratorbomb_x3=bomb_x3.iterator();
            for(int i =0 ;i<3 ;i++){
                thebomb_xy3[0][i]=iteratorbomb_x3.next();
            }
            JSONArray bomb_y3=(JSONArray) jsonObject.get("bomb_y3");
            Iterator<Long > iteratorbomb_y3=bomb_y3.iterator();
            for(int i =0 ;i<3 ;i++){
                thebomb_xy3[1][i]=iteratorbomb_y3.next();
            }
            thebomb_xy4=new long[2][3];
            JSONArray bomb_x4=(JSONArray) jsonObject.get("bomb_x4");
            Iterator<Long > iteratorbomb_x4=bomb_x4.iterator();
            for(int i =0 ;i<3 ;i++){
                thebomb_xy4[0][i]=iteratorbomb_x4.next();
            }
            JSONArray bomb_y4=(JSONArray) jsonObject.get("bomb_y4");
            Iterator<Long > iteratorbomb_y4=bomb_y4.iterator();
            for(int i =0 ;i<3 ;i++){
                thebomb_xy4[1][i]=iteratorbomb_y4.next();
            }
        }
        thebombInt_xy1=new int[2][3];
        thebombInt_xy2=new int[2][3];
        thebombInt_xy3=new int[2][3];
        thebombInt_xy4=new int[2][3];
        for(int i=0;i<3;i++){
            thebombInt_xy1[0][i]=(int) thebomb_xy1[0][i];
            thebombInt_xy1[1][i]=(int) thebomb_xy1[1][i];
            thebombInt_xy2[0][i]=(int) thebomb_xy2[0][i];
            thebombInt_xy2[1][i]=(int) thebomb_xy2[1][i];
            if(numberOfPlayers==3){
                thebombInt_xy3[0][i]=(int) thebomb_xy3[0][i];
                thebombInt_xy3[1][i]=(int) thebomb_xy3[1][i];
            }
            else if(numberOfPlayers==4){
                thebombInt_xy3[0][i]=(int) thebomb_xy3[0][i];
                thebombInt_xy3[1][i]=(int) thebomb_xy3[1][i];
                thebombInt_xy4[0][i]=(int) thebomb_xy4[0][i];
                thebombInt_xy4[1][i]=(int) thebomb_xy4[1][i];
            }

        }
        thebomb_xy1=new long[2][3];
        thebomb_xy2=new long[2][3];
        thebomb_xy3=new long[2][3];
        thebomb_xy4=new long[2][3];

    }
    void keyBoard(String key){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("keyBoard", key);
        String STRdata = jsonObject.toString();
        try {
            socket.getOutputStream().write(STRdata.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
