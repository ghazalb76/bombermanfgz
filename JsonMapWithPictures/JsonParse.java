import jdk.nashorn.internal.runtime.ParserException;

import java.io.FileNotFoundException;
import java.io.IOException;
import jdk.nashorn.internal.runtime.ParserException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by dude on 6/11/2017.
 */
public class JsonParse {
    String[][] squares=null;
    JSONArray jsonArray=null;
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
