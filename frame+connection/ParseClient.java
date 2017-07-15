import jdk.nashorn.internal.runtime.ParserException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by dude on 6/11/2017.
 */
public class ParseClient {
    int n;
    String[] score=null;
    String[][] squares=null;
    JSONArray jsonArray=null;
    int[][] posPresent= new int[2][9];
    String[] presentType=new String[9];
    int[][] posePlayer= null;
    int[][] bombs=null;



    void parsePlayer(InputStream is) {
        try{
            byte[] b = new byte[is.available()];
            is.read(b);
            JSONParser jsonParser = new JSONParser();
            JSONObject js = (JSONObject) jsonParser.parse(new String(b));
           // JSONObject js1=(JSONObject)jsonParser.parse(new String )
            String c = (String) js.get("numbers");
            n= Integer.parseInt(c);
            System.out.println("n = "+n);
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
            Object obj = parser.parse(new FileReader("C:\\Users\\ZAHRA\\Desktop\\a.txt"));
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
            Object obj = parser.parse(new FileReader("C:\\Users\\ZAHRA\\Desktop\\a.txt"));
            JSONObject js = (JSONObject) obj;

            JSONArray presentX=(JSONArray) js.get("presentX") ;
            JSONArray presentY=(JSONArray) js.get("presentY") ;

            Iterator<String > iteratorX=presentX.iterator();
            Iterator<String > iteratorY=presentY.iterator();


            for(int i =0 ;i<9 ;i++){
                posPresent[0][i]= Integer.parseInt(iteratorX.next());
                posPresent[1][i]= Integer.parseInt(iteratorY.next());

            }
            for(int j =0 ;j<9;j++){
                System.out.print(posPresent[0][j]+"\t"+posPresent[0][j]);
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
            Object obj = parser.parse(new FileReader("C:\\Users\\dude\\Desktop\\a.txt"));
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
    void parse_bomb(){
        try{

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("C:\\Users\\ZAHRA\\Desktop\\a.txt"));
            JSONObject js = (JSONObject) obj;
            bombs=new int[2][6];
            JSONArray b_x;
            JSONArray b_y;
            b_x=(JSONArray)js.get("bombs_x");
            b_y=(JSONArray)js.get("bombs_y");
            Iterator<String> ite=b_x.iterator();
            Iterator<String> itey=b_y.iterator();
            for (int i=0;i<6;i++){
                bombs[0][i]=Integer.parseInt(ite.next());
                bombs[1][i]=Integer.parseInt(itey.next());
            }
            for (int i=0;i<6;i++){
                System.out.print(bombs[0][i]+"\t"+bombs[1][i]);
                System.out.println();
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (ParserException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}

    }

}