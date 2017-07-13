/**
 * Created by dude on 7/13/2017.
 */
public class GameManagement {
    Board board = new Board();
    void checkRight(int x){
        if(board.squares)
    }
    void checkMove(Player player,String keyboard){
        switch(keyboard){
            case "6":if(checkRight(player.posX))
                player.move1(+60);
            break;
            case "4":if(checkLeft(player.posX))
                player.move1(-60);
            break;
            case "8": if (checkUp(player.posY))
                player.move2(+60);
            break;
            case "2" : if (checkDown(player.posY))
                player.move2(-60);
            break;
        }
    }


}
