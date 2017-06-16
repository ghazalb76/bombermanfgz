import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by dude on 6/15/2017.
 */
public class ParserS {
    JSONArray arrayy=new JSONArray();
    JSONObject obj = new JSONObject();
    JSONArray posX=new JSONArray();
    JSONArray posY=new JSONArray();
    JSONArray type=new JSONArray();
    JSONArray bomb_x=new JSONArray();
    JSONArray bomb_y=new JSONArray();
    void parseSquares(String[][] squares){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                arrayy.add(squares[i][j]);
            }
        }
        obj.put("squares",arrayy);
    }
    void parsePlayers(String  c,String[][]posePlayers){
        obj.put("numbers",c);
        int n= Integer.parseInt(c);
        for (int i =0;i<n ; i++){
            obj.put("x_player"+i+1,posePlayers[0][i]);
            obj.put("y_player"+i+1,posePlayers[1][i]);

        }
    }
    void parsePresents(String[][] posPresent){
        for(int i=0;i<9;i++){
            posX.add(i,posPresent[1][i]);
            posY.add(i,posPresent[2][i]);
            type.add(i,posPresent[0][i]);
        }
        obj.put("presentType",type);
        obj.put("presentX",posX);
        obj.put("presentY",posY);
    }
    void parse(){
        try(FileWriter file=new FileWriter("C:\\Users\\dude\\Desktop\\r.txt")){
            file.write(obj.toString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();}

    }
    void parseScores(String c,String[] score){
        int n= Integer.parseInt(c);
        for(int i =0 ;i<n;i++){
            obj.put("score",score[i]);

        }
    }
    void parseBombs(String[] bombX,String[] bombY){
        for(int i=0;i<6;i++){
            bomb_x.add(i,bombX[i]);
            bomb_y.add(i,bombY[i]);
        }
        obj.put("bombs_x",bomb_x);
        obj.put("bombs_y",bomb_y);
    }
}
