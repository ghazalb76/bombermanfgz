import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dude on 7/13/2017.
 */
public class GameManagement {
    Board board = new Board();
    GameManagement(int number_of_players){
        board.player1.iSquare=1;
        board.player1.jSquare=1;
        board.player2.iSquare=13;
        board.player2.jSquare=13;
        if(number_of_players==3){
            board.player3.iSquare=1;
            board.player3.jSquare=13;
        }
        else if(number_of_players==4){
            board.player3.iSquare=1;
            board.player3.jSquare=13;
            board.player4.iSquare=13;
            board.player4.jSquare=1;
        }
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
        System.out.println("mooooove");
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
        try {
            explode(player);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void checkBomb(Player player){

            player.putBomb(board,player);


    }
    void explode(Player player){
        player.checkexplode(board,player);
    }





}

