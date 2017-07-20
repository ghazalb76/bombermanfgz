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
    JSONArray scores=new JSONArray();
    JSONArray time=new JSONArray();
    void parseNumberOfPlayers(int number_of_players){
        obj.put("numberOfPlayers",number_of_players);
    }
    void parseSquares(Board board){
        JSONArray arrayy=new JSONArray();
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                arrayy.add(board.squares[i][j].type);
            }
        }
        obj.put("squares",arrayy);
    }
    void parsePlayers(int numberOfPlayers, ArrayList<Player> players){
        obj.put("numbers",numberOfPlayers);
        for (int i =0;i<numberOfPlayers ; i++){
            obj.put("x_player"+i+"",players.get(i).posX);
            obj.put("y_player"+i+"",players.get(i).posY);
            System.out.println(players.get(i).direction);
            obj.put("direction"+i+"",players.get(i).direction);

        }
    }

    void parsePresents(Board board){
        JSONArray posX=new JSONArray();
        JSONArray posY=new JSONArray();
        JSONArray type=new JSONArray();
        for(int i=0;i<board.packPresents.size();i++) {
                        posX.add(board.packPresents.get(i).posX);
                        posY.add(board.packPresents.get(i).posY);
                        type.add(board.packPresents.get(i).type);
                    }
        obj.put("numberOfPresents",board.packPresents.size());
        obj.put("presentX",posX);
        obj.put("presentY",posY);
        obj.put("presentType",type);
    }
    String parse(){
        return obj.toString();
    }
    void parseScores(Board board,int numberOfPlayers){
        scores.add(board.player1.score);
        scores.add(board.player2.score);
        if(numberOfPlayers==3)
        scores.add(board.player3.score);
        else if(numberOfPlayers==4) {
            scores.add(board.player3.score);
            scores.add(board.player4.score);
        }
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
    void parseBombs3(Player player){
        JSONArray bomb_x3=new JSONArray();
        JSONArray bomb_y3=new JSONArray();
        for(int i=0;i<3;i++){
            bomb_x3.add(player.bomb[i].posX);
            bomb_y3.add(player.bomb[i].posY);
        }
        obj.put("bomb_x3",bomb_x3);
        obj.put("bomb_y3",bomb_y3);
    }
    void parseBombs4(Player player){
        JSONArray bomb_x4=new JSONArray();
        JSONArray bomb_y4=new JSONArray();
        for(int i=0;i<3;i++){
            bomb_x4.add(player.bomb[i].posX);
            bomb_y4.add(player.bomb[i].posY);
        }
        obj.put("bomb_x4",bomb_x4);
        obj.put("bomb_y4",bomb_y4);
    }
    void parseTime(){
        String[] timee={"00","00"};
        for(int i=0;i<2;i++){
            time.add(timee[0]);
        }
        obj.put("time",time);
    }
    void parsee(){
        try(FileWriter file=new FileWriter("C:\\Users\\dude\\Desktop\\r.txt")){
            file.write(obj.toString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();}
    }
}
