import java.awt.*;

/**
 * Created by dude on 7/13/2017.
 */
public class GameManagement {
    Board board = new Board();
    GameManagement(){
        board.player1.iSquare=1;
        board.player1.jSquare=1;
        board.player2.iSquare=13;
        board.player2.jSquare=13;
    }
    boolean checkRight(Player player){
        System.out.println("i: "+player.iSquare+" j: "+player.jSquare+" right");
        if (board.squares[player.iSquare][player.jSquare+1].type.equals("*")){
            player.jSquare++;
            return true;}
        else
            return false;
    }

    boolean checkLeft(Player player){
        System.out.println("i: "+player.iSquare+" j: "+player.jSquare+" left");
        if (board.squares[player.iSquare][player.jSquare-1].type.equals("*")){
            player.jSquare--;
            return true;}
        else
            return false;
    }

    boolean checkUp(Player player){
        System.out.println("i: "+player.iSquare+" j: "+player.jSquare+" up");
        if (board.squares[player.iSquare-1][player.jSquare].type.equals("*")){
            player.iSquare--;
            return true;}
        else
            return false;
    }

    boolean checkDown(Player player){
        System.out.println("i: "+player.iSquare+" j: "+player.jSquare+" down");
        if (board.squares[player.iSquare+1][player.jSquare].type.equals("*")){
            player.iSquare++;
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
        if(player.number_of_bombs<3)
            player.putBomb(board,player);


    }

}

