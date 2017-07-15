import java.awt.*;

/**
 * Created by dude on 7/13/2017.
 */
public class GameManagement {
    Board board = new Board();
    String keyboard;
    boolean checkRight(Player player){
        int a=0 , b=0 ;
        boolean flag=true;
        for(int i =0;i<15 && flag;i++){
            for (int j =0; j<15 ; j++){
                if(board.squares[i][j].posy==player.posY && board.squares[i][j].posx==player.posX){
                    a=i;
                    b=j;
                    flag=false;
                    break;
                }

            }
        }
        if (board.squares[a][b+1] instanceof Green){
            return true;}
        else
            return false;
    }

    boolean checkLeft(Player player){
        int a=0 , b=0 ;
        boolean flag= true;
        for(int i =1;i<14 && flag;i++){
            for (int j =1; j<14 ; j++){
                if(board.squares[i][j].posy==player.posY && board.squares[i][j].posx==player.posX){
                    a=i;
                    b=j;
                    flag=false;
                    break;
                }

            }
        }
        if (board.squares[a][b-1] instanceof Green){
            return true;}
        else
            return false;
    }

    boolean checkUp(Player player){
        int a=1 , b=1 ;
        boolean flag= true;
        for(int i =0;i<15 && flag;i++){
            for (int j =0; j<15 ; j++){
                if(board.squares[i][j].posy==player.posY && board.squares[i][j].posx==player.posX){
                    a=i;
                    b=j;
                    flag=false;
                    break;
                }

            }
        }
        System.out.println(a );
        System.out.println(b);

        if (board.squares[a-1][b] instanceof Green){
            return true;}
        else
            return false;
    }

    boolean checkDown(Player player){
        int a=1 , b=1 ;
        boolean flag= true;
        for(int i =0;i<15&& flag;i++){
            for (int j =0; j<15 ; j++){
                if(board.squares[i][j].posy==player.posY && board.squares[i][j].posx==player.posX){
                    a=i;
                    b=j;
                    flag=false;
                    break;
                }

            }
        }
        if (board.squares[a+1][b] instanceof Green){
            return true;}
        else
            return false;
    }


    void checkMove(Player player,String keyboard){
        switch(keyboard){
            case "6":if(checkRight(player))
                player.move1(+60);
                break;
            case "4":if(checkLeft(player))
                player.move1(-60);
                break;
            case "8": if (checkUp(player))
                player.move2(-60);
                break;
            case "2" : if (checkDown(player))
                player.move2(+60);
                break;
        }
    }

    void checkBomb(Player player){
        int a =1,b=1;
        boolean flag=true;
        for(int i =0;i<15 && flag;i++){
            for(int j =0 ;j<15 ;j++){
                if(board.squares[i][j].posx==player.posX && board.squares[i][j].posy==player.posY  ){
                    a=i;
                    b=j;
                    flag=false;
                    break;
                }
            }
        }
        if(player.number_of_bombs<3)
            player.putBomb(a,b,board,player);


    }

}

