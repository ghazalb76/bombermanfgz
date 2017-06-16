import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class JsonWriter {
    int n ;
    JSONArray arrayy=new JSONArray();
    String[][] squares =new String [15][15];
    Random rand=new Random();
    JSONObject obj = new JSONObject();
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

        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                arrayy.add(squares[i][j]);
            }
        }
        obj.put("squares",arrayy);
    }

    boolean is_null(int a,int b){
        if(squares[a][b]==null)
            return true;
        else
            return false;
    }

    void setPlayer(){
        //   JSONObject jsonObject1 = new JSONObject();
        String c="4";
        obj.put("numbers",c);
        n = Integer.parseInt(c);
        //jsonObject1.put("n",n);
        String[][] poses={{"60","780","780","60"},{"160","880","160","880"}};

        for (int i =0;i<n ; i++){
            obj.put("x_player"+i+1,poses[0][i]);
            obj.put("y_player"+i+1,poses[1][i]);

        }
    }
    void setPresent(){
        String[][] posPresent=new String[3][9];

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
        obj.put("presentType",type);
        obj.put("presentX",posX);
        obj.put("presentY",posY);
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
        // JSONObject jsonObject= new JSONObject();
        for(int i =0 ;i<n;i++){
            obj.put("score",score[i]);

        }

    }
    void parse(){
        try(FileWriter file=new FileWriter("C:\\Users\\asus\\Desktop\\info.txt")){
            file.write(obj.toString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();}

    }
    void set_bomb() {
       // String [][] bomb=new String[2][6];
        int x,y;
        JSONArray bomb_x=new JSONArray();
        JSONArray bomb_y=new JSONArray();
        for(int i=0;i<6;i++){
            do {
                x = rand.nextInt(15);
                y = rand.nextInt(15);
            }while (!isgreen(x,y) || isBrick(x,y) /* rep_bomb(x,y,i,bomb_x,bomb_y)*/|| isplayer(x,y) );
       //    bomb[0][i]= (Integer.toString(x));
         //   bomb[1][i]= (Integer.toString(y));
           bomb_x.add(i,(Integer.toString(x)));
            bomb_y.add(i,Integer.toString(y));
        }

        obj.put("bombs_x",bomb_x);
        obj.put("bombs_y",bomb_y);
        System.out.println("bombs done");

    }
   /* boolean rep_bomb(int x1, int y1, int i, JSONArray bx , JSONArray by) {
        String x=String.valueOf(x1);
        String y=String.valueOf(y1);
        int m = 0;
        for (; m < i; m++) {
            if (x==bx.get(m) && y==by.get(m)){
                return true;
            }
            else     if(m==i-1) {
              return false;
            }
            }
        return false;
    }*/



    boolean isgreen(int x,int y){
        if (squares[x][y].equals("*"))
            return true;
        else
            return false;
    }
    boolean isplayer(int x,int y){
        if(x==60 && y==160|| x==780&& y==880 || x==780 && y==160|| x==60 && y==880){
         return  true;
        }
        else
            return false;
    }
}