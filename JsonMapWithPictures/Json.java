import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by dude on 6/11/2017.
 */
public class Json {
        JSONArray arrayy=new JSONArray();
        String[][] squares =new String [15][15];
        Random rand=new Random();
        void make_block(){
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

    }

    boolean is_null(int a,int b){
        if(squares[a][b]==null)
            return true;
        else
            return false;
    }
    void parse() {
        JSONObject obj = new JSONObject();
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                arrayy.add(squares[i][j]);
            }
        }
        obj.put("squares",arrayy);
        try(FileWriter file=new FileWriter("C:\\Users\\dude\\Desktop\\a.txt")){
            file.write(obj.toString());
            file.flush();
        }catch(IOException e){

        }

       // System.out.println(obj);
    }

}
