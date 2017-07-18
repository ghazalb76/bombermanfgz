import java.util.ArrayList;

/**
 * Created by dude on 7/13/2017.
 */
public class Player {
    int posX;
    int posY;
    int health=3 ;
    int iSquare;
    int jSquare;
    int score=0;
    int velocity=10;
    String direction;
    Bomb[] bomb=new Bomb[3];
    void setBombs(){
        number_of_bombs=0;
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


    void putBomb(Board board,Player player) {
        int counter=0;
        counter++;
        if(player.number_of_bombs==0){

            player.bomb[0].isAlive=true;
            player.bomb[0].posX=player.iSquare;
            player.bomb[0].posY=player.jSquare;
            player.number_of_bombs++;
            player.bomb[0].destroy(0,board,player);

            player.bomb[0].kill(player,board);

        }
        else if(player.number_of_bombs==1){

            //player.bomb[0]=new Bomb();
            player.bomb[1].isAlive=true;
            player.bomb[1].posX=player.iSquare;
            player.bomb[1].posY=player.jSquare;
            player.number_of_bombs++;
            player.bomb[1].destroy(1,board,player);
            player.bomb[1].kill(player,board);

        }
        else if(player.number_of_bombs==2){
           // player.bomb[1]=new Bomb();

            player.bomb[2].isAlive=true;
            player.bomb[2].posX=player.iSquare;
            player.bomb[2].posY=player.jSquare;
            player.number_of_bombs++;
            player.bomb[2].destroy(2,board,player);


            player.bomb[2].kill(player,board);

        }
        else{
            player.setBombs();
        }
    }}