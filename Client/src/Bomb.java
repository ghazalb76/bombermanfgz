/**
 * Created by ZAHRA on 21/07/2017.
 */

import java.util.ArrayList;

public class Bomb {
    boolean isAlive;
    boolean khatti;
    int posX=-1;
    int posY=-1;
    int timepass=0;
    Bomb(){
        isAlive=false;
    }
    ArrayList<Integer> xDestroyable=new ArrayList<>();
    ArrayList<Integer> yDestroyable=new ArrayList<>();


    void destroyable(int a , int  b , Square[][] squares ){
        if( squares[a][b] instanceof Brick){
            xDestroyable.add(a);
            yDestroyable.add(b);

        }
    }
    void destroy(int a,Board board,Player player ) {
        destroyable(player.bomb[a].posX-1, player.bomb[a].posY, board.squares);
        destroyable(player.bomb[a].posX+1, player.bomb[a].posY, board.squares);
        destroyable(player.bomb[a].posX, player.bomb[a].posY-1 , board.squares);
        destroyable(player.bomb[a].posX, player.bomb[a].posY+1 , board.squares);
        System.out.println("destroy shod");
        for(int k=0;k< xDestroyable.size();k++){
            int p1=board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posx;
            int p2=board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posx;
            board.open_prize(player.bomb[a].posX-1,player.bomb[a].posY,player);
            board.open_prize(player.bomb[a].posX+1,player.bomb[a].posY,player);
            board.open_prize(player.bomb[a].posX,player.bomb[a].posY-1,player);
            board.open_prize(player.bomb[a].posX,player.bomb[a].posY+1,player);
            board.setGreen(xDestroyable.get(k),yDestroyable.get(k));
            board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posx=p1;
            board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posy=p2;
        }
    }

    void kill(Player player , Board board) {
        for (int i = 0; i < board.players.size(); i++) {
            for (int j = -1; j < 2; j++) {
                if (board.players.get(i).posX == board.squares[player.iSquare + j][player.jSquare].posx && board.players.get(i).posY == board.squares[player.iSquare + j][player.jSquare].posy) {
                    board.players.get(i).health--;
                }
                if (board.players.get(i).posX == board.squares[player.iSquare][player.jSquare + j].posx && board.players.get(i).posY == board.squares[player.iSquare][player.jSquare + j].posy) {
                    board.players.get(i).health--;
                    if(board.players.get(i).posX==board.squares[player.iSquare][player.jSquare].posx && board.players.get(i).posY == board.squares[player.iSquare][player.jSquare].posy) {
                        board.players.get(i).health++;
                    }
                }
            }
        }
        System.out.println("health"+player.health);
    }


    void destroykhatti(int a,Board board,Player player ) {
        for (int i = 0; i < 15; i++) {
            destroyable(i, player.bomb[a].posY, board.squares);
            for (int k = 0; k < xDestroyable.size(); k++) {
                int p1 = board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posx;
                int p2 = board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posx;
                board.open_prize(i, player.bomb[a].posY, player);
                board.setGreen(xDestroyable.get(k), yDestroyable.get(k));
                board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posx = p1;
                board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posy = p2;
            }
        }

        for (int i = 0; i < 15; i++) {
            destroyable(player.bomb[a].posX, i, board.squares);
            for (int k = 0; k < xDestroyable.size(); k++) {
                int p1 = board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posx;
                int p2 = board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posx;
                board.open_prize(player.bomb[a].posX, i, player);
                board.setGreen(xDestroyable.get(k), yDestroyable.get(k));
                board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posx = p1;
                board.squares[xDestroyable.get(k)][yDestroyable.get(k)].posy = p2;
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

