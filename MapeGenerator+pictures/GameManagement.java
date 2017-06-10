/**
 * Created by dude on 6/7/2017.
 */
public class GameManagement {

    Board board = new Board();
    Square find_i_j(int id){
        Square found=null;
        for(int i=0 ;i<15;i++){
            for(int j =0 ;j<15;j++){
                if(board.squares[i][j].id==id){
                    found=board.squares[i][j];
                    break;
                }
            }

        }
        return found;

    }
    boolean check_if_valid(int id){
        if(find_i_j(id) instanceof  Green_Square){
            return true;
        }
        else {
            return false;
        }

    }
    void check_keyboard(int a , int id){
        boolean is_valid;
        switch (a){
            case 6:is_valid=check_if_valid(id+1);
            case 8:is_valid=check_if_valid(id-15);
            case 4:is_valid=check_if_valid(id-1);
            case 2:is_valid=check_if_valid(id+15);
        }

    }
}
