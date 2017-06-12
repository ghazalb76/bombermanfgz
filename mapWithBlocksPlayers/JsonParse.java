import jdk.nashorn.internal.runtime.ParserException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;

/**
 * Created by dude on 6/11/2017.
 */
public class JsonParse {
    String[][] squares=null;
    JSONArray jsonArray=null;
    void info_parse(){
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("C:\\Users\\dude\\Desktop\\a.txt"));
            JSONObject js = (JSONObject) obj;
            int n =2;
            String[][] pose= new String[2][n];
            String [] presents=new String[9];
            for(int i =0 ;i<n;i++){
                pose[0][0+i]=(String)js.get("x_player"+i+1);
                pose[1][0+i]=(String)js.get("y_player"+i+1);
            }

            for(int j =0 ;j<n;j++){
            System.out.println(pose[0][0+j]);
            System.out.println(pose[1][0+j]);
            }
        }
     catch (FileNotFoundException e) {e.printStackTrace();}
     catch (IOException e) {e.printStackTrace();}
     catch (ParserException e) {e.printStackTrace();}
     catch (Exception e) {e.printStackTrace();}
    }

    void parsee() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\dude\\Desktop\\a.txt"));
            JSONObject jsonObject = (JSONObject) obj;
            jsonArray=(JSONArray) jsonObject.get("squares");

            Iterator<String > iterator=jsonArray.iterator();
            squares=new String[15][15];

            for(int i =0 ;i<15 ;i++){
                for (int j=0;j<15;j++){
                    squares[i][j]=iterator.next();
                }
            }
            for(int i =0 ;i<15;i++){
                for (int j=0;j<15 ;j++){
                    System.out.print(squares[i][j]);
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
