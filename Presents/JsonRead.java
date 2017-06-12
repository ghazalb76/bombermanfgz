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
public class JsonRead {
    String[][] squares=null;
    JSONArray jsonArray=null;
    int[][] posPresent= new int[2][9];
    void parsePlayer(){
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("C:\\Users\\dude\\Desktop\\a.txt"));
            JSONObject js = (JSONObject) obj;
            int n =2;
            String[][] pose= new String[2][n];
            for(int i =0 ;i<n;i++){
                pose[0][i]=(String)js.get("x_player"+i+1);
                pose[1][i]=(String)js.get("y_player"+i+1);
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

    void parseBlock() {
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
    void parsePresent(){
        try{
            String temp;
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("C:\\Users\\dude\\Desktop\\a.txt"));
            JSONObject js = (JSONObject) obj;
            for(int i =0 ;i<9;i++){
                temp=(String)js.get("presentX"+i);
                posPresent[0][i]= Integer.parseInt(String.valueOf(temp));
                temp=(String)js.get("presentY"+i);
                posPresent[1][i]= Integer.parseInt(String.valueOf(temp));;
            }

            for(int j =0 ;j<9;j++){
                System.out.print(posPresent[0][0+j]+"\t"+posPresent[1][0+j]);
                System.out.println();
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (ParserException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}

    }

}
