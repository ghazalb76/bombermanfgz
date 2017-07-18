import java.util.ArrayList;

/**
 * Created by dude on 7/13/2017.
 */
public class Player {
    int posX;
    int posY;
    int health=3 ;
    int score;
    int velocity=10;
    Bomb bomb;
    int number_of_bombs=0;
    int number_of_khatti_bombs=0;
    void move1(int dist){
        posX+=dist;
    }
    void move2(int dist){
        posY+=dist;
    }

    void putBomb(int a , int b,Board board,Player player) {
        bomb= new Bomb();
        bomb.posX=a;
        bomb.posY=b;
       player.number_of_bombs++;

        if(number_of_khatti_bombs==0){
        bomb.destroy(a, b, board,player);
        bomb.kill(a,b,board);
    }
        player.number_of_bombs--;
        if(number_of_khatti_bombs>0){
            bomb.destroykhatti(a, b, board,player);
            bomb.killkhatti(a,b,board);
        }

    }}