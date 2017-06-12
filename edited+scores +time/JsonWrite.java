import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 * Created by dude on 6/11/2017.
 */
public class JsonWrite {
int n ;
    JSONArray arrayy=new JSONArray();
    String[][] squares =new String [15][15];
    Random rand=new Random();

    void setBlock(){
        int a,b;
        for(int i=0;i<60;i++){
            do{
                do{
                    a=rand.nextInt(13)+1;
                    b=rand.nextInt(13)+1;
                }while(a%2==0 && b%2==0);
            }while(is_null(a,b)==false);
            squares[a][b]="+";
        }
        for(int i=0;i<15;i++) {
            for (int j = 0; j < 15; j++) {
                if(i==0 || i==14 || j==0 || j==14){
                    squares[i][j]="-";
                }
                else if(i%2==0 && j%2==0){
                    squares[i][j]="-";
                }
                else if(is_null(i,j)){
                    squares[i][j]="*";
                }
            }
        }
        JSONObject obj = new JSONObject();
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                arrayy.add(squares[i][j]);
            }
        }
        obj.put("squares",arrayy);
        try(FileWriter file=new FileWriter("C:\\Users\\ZAHRA\\Desktop\\a.txt")){
            file.write(obj.toString());
            file.flush();
        }catch(IOException e){

        }
    }

    boolean is_null(int a,int b){
        if(squares[a][b]==null)
            return true;
        else
            return false;
    }

    void setPlayer(){
        JSONObject jsonObject1 = new JSONObject();
        String c="4";
        jsonObject1.put("numbers",c);
         n = Integer.parseInt(c);
        //jsonObject1.put("n",n);
        String[][] poses={{"0","900","900","0"},{"0","900","0","900"}};

        for (int i =0;i<n ; i++){
            jsonObject1.put("x_player"+i+1,poses[0][i]);
            jsonObject1.put("y_player"+i+1,poses[1][i]);

            try(FileWriter file=new FileWriter("C:\\Users\\ZAHRA\\Desktop\\a.txt")){
                file.write(jsonObject1.toString());
                file.flush();
            }catch(IOException e){
                e.printStackTrace();}
        }
    }
    void setPresent(){
        String[][] posPresent=new String[2][9];
        JSONObject jsonObject=new JSONObject();
        int a,b;
        for(int i=0;i<9;i++){
            do{
                a=rand.nextInt(15);
                b=rand.nextInt(15);
            }while(!isBrick(a,b));
            posPresent[0][i]=Integer.toString(a);
            posPresent[1][i]=Integer.toString(b);

        }
        for(int i=0;i<9;i++){
            jsonObject.put("presentX"+i,posPresent[0][i]);
            jsonObject.put("presentY"+i,posPresent[1][i]);
        }
        try(FileWriter file=new FileWriter("C:\\Users\\ZAHRA\\Desktop\\a.txt")){
            file.write(jsonObject.toString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();}
    }
    boolean isBrick(int a,int b){
        if(squares[a][b].equals("+"))
            return true;
        else
            return false;
    }
    void set_score(){
        String[] score = {"0","0","0","0"};
        JSONObject jsonObject= new JSONObject();
        for(int i =0 ;i<n;i++){
        jsonObject.put("score",score[i]);

    }
        try(FileWriter file=new FileWriter("C:\\Users\\ZAHRA\\Desktop\\a.txt")){
            file.write(jsonObject.toString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();}
}}
