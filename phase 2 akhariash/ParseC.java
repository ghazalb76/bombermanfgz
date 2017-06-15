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
public class ParseC {
    int n;
    String[] score=null;
    String[][] squares=null;
    JSONArray jsonArray=null;
    int[][] posPresent= new int[2][9];
    String[] presentType=new String[9];
    int[][] posePlayer= null;

    void parsePlayer(){
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("C:\\Users\\dude\\Desktop\\r.txt"));
            JSONObject js = (JSONObject) obj;
            String c = (String) js.get("numbers");
            n = Integer.parseInt(c);
            System.out.println("n"+n);
            // int n =2;
            String temp;
            posePlayer= new int[2][n];
            for(int i =0 ;i<n;i++){
                temp=(String)js.get("x_player"+i+1);
                posePlayer[0][i]= Integer.parseInt(temp);
                temp=(String)js.get("y_player"+i+1);
                posePlayer[1][i]= Integer.parseInt(temp);
            }

            for(int j =0 ;j<n;j++){
                System.out.println(posePlayer[0][0+j]);
                System.out.println(posePlayer[1][0+j]);
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
            Object obj = parser.parse(new FileReader("C:\\Users\\dude\\Desktop\\r.txt"));
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
            /*String temp;*/
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("C:\\Users\\dude\\Desktop\\r.txt"));
            JSONObject js = (JSONObject) obj;
            JSONArray types=(JSONArray) js.get("presentType");
            JSONArray presentX=(JSONArray) js.get("presentX") ;
            JSONArray presentY=(JSONArray) js.get("presentY") ;
           /* for(int i =0 ;i<9;i++){
                temp=(String)js.get("presentX"+i);
                posPresent[0][i]= Integer.parseInt(String.valueOf(temp));
                temp=(String)js.get("presentY"+i);
                posPresent[1][i]= Integer.parseInt(String.valueOf(temp));
                typePresent[i]=(String) js.get("presentType"+i);
            }*/

            Iterator<String > iterator=types.iterator();
            Iterator<String > iteratorX=presentX.iterator();
            Iterator<String > iteratorY=presentY.iterator();


            for(int i =0 ;i<9 ;i++){
                presentType[i]=iterator.next();
                posPresent[0][i]= Integer.parseInt(iteratorX.next());
                posPresent[1][i]= Integer.parseInt(iteratorY.next());

            }
            for(int j =0 ;j<9;j++){
                System.out.print(presentType[j]+"\t"+posPresent[0][j]+"\t"+posPresent[0][j]);
                System.out.println("**");
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (ParserException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}

    }


    void parseScore(){
        try{

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("C:\\Users\\dude\\Desktop\\r.txt"));
            JSONObject js = (JSONObject) obj;
            score=new String[4];
            for(int i =0 ;i<n ;i++){
                score[i]=(String)js.get("score") ;
                System.out.println("++++"+score[i]);
            }


        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (ParserException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}
    }

}