import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by ZAHRA on 11/06/2017.
 */

public class Write {
    JSONObject[][] array= new JSONObject[15][15];
    Random rand= new Random();
    boolean is_null(int a,int b){
        if(array[a][b]==null)
            return true;
        else
            return false;
    }
    void make_square(){
      //  JSONObject[][] array= new JSONObject[15][15];
        int a,b;
        for(int i=0;i<60;i++){
            do{
                do{
                    a=rand.nextInt(13)+1;
                    b=rand.nextInt(13)+1;
                }while(a%2==0 && b%2==0);
            }while(is_null(a,b)==false);
            array[a][b].add
        }
        for(int i=0;i<15;i++) {
            for (int j = 0; j < 15; j++) {
                if(i==0 || i==14 || j==0 || j==14){
                    array[i][j].put("block","-");
                }
                else if(i%2==0 && j%2==0){
                    array[i][j].put("block","-");
                }
                else if(is_null(i,j)){
                    array[i][j].put("block","-");
                }
            }
        }

    }

    public static void main(String[] args) {
        JSONObject obj=new JSONObject();
        obj.put("x1","100");
        obj.put("x2","200");
        obj.put("height","50");
        obj.put("width","50");
        try(FileWriter fileWriter = new FileWriter("C:\\Users\\ZAHRA\\Desktop\\info.txt")){
            fileWriter.write(obj.toString());
            fileWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(obj);
}

}
