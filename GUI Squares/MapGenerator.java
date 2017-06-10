import java.util.Random;

/**
 * Created by dude on 6/6/2017.
 */
public class MapGenerator {

    GameManagement gm = new GameManagement();
    Square[][] squares =new Square[15][15];
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
            squares[a][b]=new Brick();
        }
        for(int i=0;i<15;i++) {
            for (int j = 0; j < 15; j++) {
                if(i==0 || i==14 || j==0 || j==14){
                    squares[i][j]=new Block();
                }
                else if(i%2==0 && j%2==0){
                    squares[i][j]=new Block();
                }
                else if(is_null(i,j)){
                    squares[i][j]=new Green_Square();
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
    void set_id(){
        int counter=1;
        for (int i =0 ;i< 15;i++){
            for(int j =0 ; j<15 ;j++){
                squares[i][j].id=counter;
                counter++;
            }
        }
    }
}