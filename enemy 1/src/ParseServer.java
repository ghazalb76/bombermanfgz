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
    JSONObject obj = new JSONObject();
    JSONArray posX=new JSONArray();
    JSONArray posY=new JSONArray();
    JSONArray type=new JSONArray();
    JSONArray scores=new JSONArray();
    JSONArray time=new JSONArray();
    void parseSquares(Board board){
        JSONArray arrayy=new JSONArray();
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
            System.out.println(players.get(i).direction);
            obj.put("direction"+i+"",players.get(i).direction);

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
    void parseBombs(Player player){
        JSONArray bomb_x1=new JSONArray();
        JSONArray bomb_y1=new JSONArray();
       for(int i=0;i<3;i++){
           bomb_x1.add(player.bomb[i].posX);
           bomb_y1.add(player.bomb[i].posY);
       }
       obj.put("bomb_x1",bomb_x1);
        obj.put("bomb_y1",bomb_y1);

    }
    void parseBombs1(Player player){
        JSONArray bomb_x2=new JSONArray();
        JSONArray bomb_y2=new JSONArray();
        for(int i=0;i<3;i++){
            bomb_x2.add(player.bomb[i].posX);
            bomb_y2.add(player.bomb[i].posY);
        }
        obj.put("bomb_x2",bomb_x2);
        obj.put("bomb_y2",bomb_y2);


    }
    void parseTime(){
        String[] timee={"00","00"};
        for(int i=0;i<2;i++){
            time.add(timee[0]);
        }
        obj.put("time",time);
    }
    void parseEnemy(ArrayList<Integer>enemy_x,ArrayList<Integer>enemy_y){
        JSONArray enemyx=new JSONArray();
        JSONArray enemyy=new JSONArray();
        for (int i=0;i<enemy_x.size();i++){
            enemyx.add(i, enemy_x.get(i));
            enemyy.add(i, enemy_y.get(i));
            System.out.println(enemy_x.get(0));
        }
        for (int i=0;i<enemy_x.size();i++){
            obj.put("enemy_x",enemyx);
            obj.put("enemy_y",enemyy);
            System.out.println(" x enemy "+enemy_x.get(i)+" "+"   y enemy "+ enemy_y.get(i));
        }
    }
    void parsee(){
        try(FileWriter file=new FileWriter("C:\\Users\\asus\\Desktop\\r.txt")){
            file.write(obj.toString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();}

    }

}
