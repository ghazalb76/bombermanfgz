/**
 * Created by ZAHRA on 21/07/2017.
 */
import java.util.ArrayList;
import java.util.Random;

public class MapGenerator {
    Random rand=new Random();
    Board board=null;
    int number_of_players=2;
    ArrayList<Integer> x=null;
    ArrayList<Integer> y=null;
    public MapGenerator(Board board,int number_of_players){
        this.board=board;
        this.number_of_players=number_of_players;
    }

    void setPresents(){
        int a ;
        x=new ArrayList();
        y=new ArrayList();
        for (int i =0;i<15;i++) {
            for (int j = 0; j < 15; j++) {
                if (board.squares[i][j].type == "+") {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            a = rand.nextInt(x.size());
            if(k>=0&& k<3) {
                board.squares[x.get(a)][y.get(a)].present.type = "health";
            }
            if(k>=3&& k<6)
                board.squares[x.get(a)][y.get(a)].present.type="bomb";
            if(k>=6&& k<9)
                board.squares[x.get(a)][y.get(a)].present.type="velocity";
            x.remove(a);
            y.remove(a);
        }

    }

    void setSquares(){
        board.setGreen(1,1);
        board.setGreen(1,2);
        board.setGreen(2,1);
        board.setGreen(13,1);
        board.setGreen(13,2);
        board.setGreen(12,1);
        board.setGreen(1,13);
        board.setGreen(2,13);
        board.setGreen(1,12);
        board.setGreen(13,13);
        board.setGreen(13,12);
        board.setGreen(12,13);
        //   System.out.println(board.squares[1][1]);
        int a,b;
        for(int i=0;i<60;i++){
            do{
                do{
                    a=rand.nextInt(13)+1;
                    b=rand.nextInt(13)+1;
                }while(a%2==0 && b%2==0);
            }while(is_null(a,b)==false);
            board.setBrick(a,b);
        }
        for(int i=0;i<15;i++) {
            for (int j = 0; j < 15; j++) {
                if(i==0 || i==14 || j==0 || j==14){
                    board.setBlock(i,j);
                }
                else if(i%2==0 && j%2==0){
                    board.setBlock(i,j);
                }
                else if(is_null(i,j)){
                    board.setGreen(i,j);
                }
            }
        }
    }
    void setPlayer(){
        board.set2Players(60,160,780,880);
        if(number_of_players==3)
            board.set3Players(780,160);
        else if(number_of_players==4)
            board.set4Players(780,160,60,880);
    }

    boolean is_null(int a,int b){
        if(board.squares[a][b]==null)
            return true;
        else
            return false;
    }
    void setScores(){
        board.setScores(0,0);
    }
}

