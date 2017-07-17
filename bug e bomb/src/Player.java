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
    String direction;
    Bomb[] bomb=new Bomb[3];
    void setBombs(){
        bomb[0]=new Bomb();
        bomb[1]=new Bomb();
        bomb[2]=new Bomb();
    }
    int number_of_bombs=0;
    int number_of_khatti_bombs=0;
    void move1(int dist){
        posX+=dist;
    }
    void move2(int dist){
        posY+=dist;
    }


    void putBomb(int a , int b,Board board,Player player) {
        if(number_of_bombs==0){
            player.bomb[0].isAlive=true;
            player.bomb[0].posX=a;
            player.bomb[0].posY=b;
            player.number_of_bombs++;
            player.bomb[0].destroy(a,b,board,player);
         //   player.bomb[0].kill(a,b,board);

        }
        else if(number_of_bombs==1){
            //player.bomb[0]=new Bomb();
            player.bomb[1].isAlive=true;
            player.bomb[1].posX=a;
            player.bomb[1].posY=b;
            player.number_of_bombs++;
            player.bomb[1].destroy(a,b,board,player);
           // player.bomb[1].kill(a,b,board);

        }
        else if(number_of_bombs==2){
           // player.bomb[1]=new Bomb();
            player.bomb[2].isAlive=true;
            player.bomb[2].posX=a;
            player.bomb[2].posY=b;
            player.number_of_bombs++;
            player.bomb[2].destroy(a,b,board,player);
          //  player.bomb[2].kill(a,b,board);

        }
       /* else{
            player.bomb[1]=new Bomb();
            player.number_of_bombs++;
        }*/
    }}