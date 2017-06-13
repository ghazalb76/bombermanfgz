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
        squares[1][1]="*";
        squares[1][2]="*";
        squares[2][1]="*";
        squares[13][1]="*";
        squares[13][2]="*";
        squares[12][1]="*";
        squares[1][13]="*";
        squares[2][13]="*";
        squares[1][12]="*";
        squares[13][13]="*";
        squares[13][12]="*";
        squares[12][13]="*";
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
        try(FileWriter file=new FileWriter("C:\\Users\\dude\\Desktop\\a.txt")){
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

            try(FileWriter file=new FileWriter("C:\\Users\\dude\\Desktop\\a.txt")){
                file.write(jsonObject1.toString());
                file.flush();
            }catch(IOException e){
                e.printStackTrace();}
        }
    }
    void setPresent(){
        String[][] posPresent=new String[3][9];
        JSONObject jsonObject=new JSONObject();
        JSONArray posX=new JSONArray();
        JSONArray posY=new JSONArray();
        JSONArray type=new JSONArray();
        int a,b;
        for(int i=0;i<9;i++){
            do{
                a=rand.nextInt(15);
                b=rand.nextInt(15);
            }while(!isBrick(a,b) || repetetive(posPresent,i,a,b)==true);
            posPresent[1][i]=Integer.toString(a);
            posPresent[2][i]=Integer.toString(b);
            if(i==0 || i==1 || i==2)
                posPresent[0][i]="bomb";
            else if(i==3 || i==4 || i==5)
                posPresent[0][i]="health";
            else
                posPresent[0][i]="velocity";


        }
        for(int i=0;i<9;i++){
            posX.add(i,posPresent[1][i]);
            posY.add(i,posPresent[2][i]);
            type.add(i,posPresent[0][i]);
        }
        jsonObject.put("presentType",type);
        jsonObject.put("presentX",posX);
        jsonObject.put("presentY",posY);
        try(FileWriter file=new FileWriter("C:\\Users\\dude\\Desktop\\a.txt")){
            file.write(jsonObject.toString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();}
    }
    boolean repetetive(String[][] posPresent,int i,int a,int b){
        String k= String.valueOf(a);
        String n=String.valueOf(b);
        for(int j=0;j<i;j++){
            if(posPresent[1][j].equals(k) && posPresent[2][j].equals(n)) {
                System.out.println("aaaaaaaaaa");
                return true;
            }
        }
        return false;
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
        try(FileWriter file=new FileWriter("C:\\Users\\dude\\Desktop\\a.txt")){
            file.write(jsonObject.toString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();}
    }}
