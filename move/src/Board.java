import java.util.ArrayList;

/**
 * Created by dude on 7/13/2017.
 */
public class Board {
    Square[][] squares=new Square[15][15];
    Player player1= new Player();
    Player player2= new Player();
    ArrayList<Player> players= new ArrayList<Player>();

    void addplayer(){
        players.add(player1);
        players.add(player2);
    }

    void setBlock(int i, int j){squares[i][j]=new Block();}

    void setGreen(int i , int j ){squares[i][j]=new Green();}

    void setBrick(int i , int j ){
        squares[i][j]=new Brick();
    }

    void setId(){
        int counter=1;
        for(int i =0;i<15;i++){
            for(int j =0;j<15;j++){
                squares[i][j].id=counter;
                counter++;
            }
        }
    }

    void setPos_Square(){
        for (int i=0;i<15;i++){
            for (int j=0;j<15;j++){
                squares[i][j].posx=60*(j);
                squares[i][j].posy =100+60*(i);
            }
        }
    }

    void setPlayers(int x1,int y1,int x2,int y2){
        player1.posX=x1;
        player1.posY=y1;
        player2.posX=x2;
        player2.posY=y2;

    }

    void open_prize(int a , int b ,Player player){
        if(squares[a][b] instanceof Brick){
            if(squares[a][b].type=="1"){
                player.health++;
                System.out.println("prize1");
            }
            else if(squares[a][b].type=="2"){
                player.number_of_khatti_bombs++;
                System.out.println("prize2");

            }
            else if(squares[a][b].type=="3"){
                player.velocity+=10;
                System.out.println("prize 3");
            }
        }
    }

    void setScores(int score1,int score2){
        player1.score=0;
        player2.score=0;
    }
    void setDirection(Player player,String keyBoard){
        switch (keyBoard){
            case "4":
                player.direction="4";
                break;
            case "6":
                player.direction="6";
                break;
            case "8":
                player.direction="8";
                break;
            case "2":
                player.direction="2";
                break;
            default:
                player.direction="2";
                break;
        }

    }
}




