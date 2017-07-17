import java.util.ArrayList;

/**
 * Created by dude on 7/13/2017.
 */
public class Bomb {
    boolean isAlive;
    int posX=-1;
    int posY=-1;
    Bomb(){
        isAlive=false;
    }
    ArrayList<Integer> xDestroyable=new ArrayList<>();
    ArrayList<Integer> yDestroyable=new ArrayList<>();


    boolean destroyable(int a , int  b , Square[][] squares ){
        if( squares[a][b] instanceof Brick){
            xDestroyable.add(a);
            yDestroyable.add(b);
            return true;

        }
        else
            return false;
    }
    void destroy(int a , int b,Board board,Player player ) {
        for (int i = -1; i < 2; i++) {

            if (destroyable(a + i, b, board.squares)) {
                int p1=board.squares[a+i][b].posx;
                int p2=board.squares[a+i][b].posy;
                board.open_prize(a,b,player);
             //   board.setGreen(a+i,b);
                board.squares[a+i][b].posx=p1;
                board.squares[a+i][b].posy=p2;

            }
            if (destroyable(a, b + i, board.squares)) {
                int p1=board.squares[a][b+i].posx;
                int p2=board.squares[a][b+i].posy;
               // board.setGreen(a,b+i);
                board.squares[a][b+i].posx=p1;
                board.squares[a][b+i].posy=p2;
            }
        }
        for(int k=0;k< xDestroyable.size();k++){
            board.setGreen(xDestroyable.get(k),yDestroyable.get(k));
        }
    }

    void kill(int a , int b , Board board) {
        for (int i = 0; i < board.players.size(); i++) {
            for (int j = -1; j < 2; j++) {
                if (board.players.get(i).posX == board.squares[a + j][b].posx && board.players.get(i).posY == board.squares[a + j][b].posy) {
                    board.players.get(i).health--;
                }
                if (board.players.get(i).posX == board.squares[a][b + j].posx && board.players.get(i).posY == board.squares[a][b + j].posy) {
                    board.players.get(i).health--;
                    if(board.players.get(i).posX==board.squares[a][b].posx && board.players.get(i).posY == board.squares[a][b].posy) {
                        board.players.get(i).health++;
                    }
                }
            }
        }
    }


    void destroykhatti(int a , int b,Board board,Player player ) {
       for(int i=0 ;i<15 ;i++){
           if(destroyable(i,b,board.squares)){
               int p1=board.squares[i][b].posx;
               int p2=board.squares[i][b].posy;
               board.open_prize(i,b,player);
               board.squares[i][b] = new Green();
               board.squares[i][b].posx=p1;
               board.squares[i][b].posy=p2;
           }
       }

        for(int i=0 ;i<15 ;i++){
            if(destroyable(a,b,board.squares)){
                int p1=board.squares[a][i].posx;
                int p2=board.squares[a][i].posy;
                board.open_prize(a,i,player);
                board.squares[a][i] = new Green();
                board.squares[a][i].posx=p1;
                board.squares[a][i].posy=p2;
            }
        }
    }

    void killkhatti(int a , int b , Board board) {
            for (int i=0;i<board.players.size();i++){
                for(int j=0 ;j<15 ;j++){
                if (board.players.get(i).posX == board.squares[j][b].posx && board.players.get(i).posY == board.squares[j][b].posy) {
                board.players.get(i).health--;}
                if (board.players.get(i).posX == board.squares[a][j].posx && board.players.get(i).posY == board.squares[a][j].posy) {
                        board.players.get(i).health--;
                }
                }
            }
    }
}
