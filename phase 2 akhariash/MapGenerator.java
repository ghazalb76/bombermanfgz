import org.json.simple.JSONArray;

import java.util.Random;

/**
 * Created by dude on 6/15/2017.
 */
public class MapGenerator {
    String[][] squares =new String [15][15];
    String[][] posPresent=new String[3][9];
    String[][] posePlayers=null;
    String[] score=null;
    Random rand=new Random();
    String n;
    void setSquares(){
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
    }

    boolean is_null(int a,int b){
        if(squares[a][b]==null)
            return true;
        else
            return false;
    }

    void setPlayers(){
        n="4";
        posePlayers= new String[][]{{"60", "780", "780", "60"}, {"160", "880", "160", "880"}};
    }
    void setPresents(){
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
    void setScores(){
        score = new String[]{"0", "0", "0", "0"};
        // JSONObject jsonObject= new JSONObject();
    }
}
