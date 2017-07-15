import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dude on 6/15/2017.
 */
public class ParseServer {
    JSONArray arrayy=new JSONArray();
    JSONObject obj = new JSONObject();
    JSONArray posX=new JSONArray();
    JSONArray posY=new JSONArray();
    JSONArray type=new JSONArray();
    JSONArray bomb_x=new JSONArray();
    JSONArray bomb_y=new JSONArray();
    JSONArray scores=new JSONArray();
    JSONArray time=new JSONArray();
    void parseSquares(Board board){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                arrayy.add(board.squares[i][j].type); /* inja mikham fqt type ha roo add konam be arrayyam */
            }
        }
        obj.put("squares",arrayy);
    }
    void parsePlayers(String  c, ArrayList<Player> players){
        obj.put("numbers",c);
        int n= Integer.parseInt(c);
        for (int i =0;i<n ; i++){
            obj.put("x_player"+i+"",players.get(i).posX);
            obj.put("y_player"+i+"",players.get(i).posY);

        }
    }

    void parsePresents(ArrayList<Integer> x , ArrayList<Integer> y){
        for(int i=0;i<9;i++){
            posX.add(i,x.get(i));
            posY.add(i,y.get(i));
        }
        //obj.put("presentType",type);
        obj.put("presentX",posX);
        obj.put("presentY",posY);
    }
    String parse(){
        return obj.toString();
    }
    void parseScores(Board board){
        scores.add(board.player1.score);
        scores.add(board.player2.score);

        obj.put("score",scores);
    }
    void parseBombs(String[] bombX,String[] bombY){
        for(int i=0;i<6;i++){
            bomb_x.add(i,bombX[i]);
            bomb_y.add(i,bombY[i]);
        }
        obj.put("bombs_x",bomb_x);
        obj.put("bombs_y",bomb_y);
    }
    void parseTime(){
        String[] timee={"00","00"};
        for(int i=0;i<2;i++){
            time.add(timee[0]);
        }
        obj.put("time",time);
    }

}
