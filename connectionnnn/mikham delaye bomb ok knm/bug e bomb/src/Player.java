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
    ArrayList<String> haveKhatti=new ArrayList<>();
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
        if(player.number_of_bombs==3){
            player.setBombs();
        }
        System.out.println(player.haveKhatti.size()+ "    ah aha ha a ah");
        if(player.haveKhatti.size()!=0){
            if(player.haveKhatti.size()==1) {
                System.out.println(" vvvvvvvvvvvvvvvvvvvvvvvay");
                player.bomb[0].khatti = true;
            }
            else if(player.haveKhatti.size()==2){
                player.bomb[0].khatti = true;
                player.bomb[1].khatti = true;
            }
            else if(player.haveKhatti.size()==3){
                player.bomb[0].khatti = true;
                player.bomb[1].khatti = true;
                player.bomb[2].khatti = true;
            }
        }
        if(player.number_of_bombs==0){

            player.bomb[0].isAlive=true;
            player.bomb[0].posX=player.iSquare;
            player.bomb[0].posY=player.jSquare;
            player.number_of_bombs++;
            if(player.bomb[0].khatti==true){
                player.bomb[0].destroykhatti(0, board, player);
               // player.bomb[0].killkhatti(player,board);
            }
            else {
                player.bomb[0].destroy(0, board, player);
                player.bomb[0].kill(player, board);
            }

        }
        else if(player.number_of_bombs==1){
            player.bomb[1].isAlive=true;
            player.bomb[1].posX=player.iSquare;
            player.bomb[1].posY=player.jSquare;
            player.number_of_bombs++;
            if(player.bomb[1].khatti==true){
                player.bomb[1].destroykhatti(1, board, player);
                // player.bomb[0].killkhatti(player,board);
            }
            else {
                player.bomb[1].destroy(1, board, player);
                player.bomb[1].kill(player, board);
            }


        }
        else if(player.number_of_bombs==2){
            player.bomb[2].isAlive=true;
            player.bomb[2].posX=player.iSquare;
            player.bomb[2].posY=player.jSquare;
            player.number_of_bombs++;
            if(player.bomb[2].khatti==true){
                System.out.println("kahtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttti");
                player.bomb[2].destroykhatti(2, board, player);
                // player.bomb[0].killkhatti(player,board);
            }
            else {
                player.bomb[2].destroy(2, board, player);
                player.bomb[2].kill(player, board);
            }

        }
    }}