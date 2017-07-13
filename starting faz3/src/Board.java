/**
 * Created by dude on 7/13/2017.
 */
public class Board {
    Square[][] squares=new Square[15][15];
    Player player1= new Player();
    Player player2= new Player();
    void setBlock(int i, int j){
        squares[i][j]=new Block();

    }
    void setGreen(int i , int j ){
        squares[i][j]=new Green();

    }
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

        for (int i=1;i<14;i++){
            for (int j=1;j<14;j++){
                squares[i][j].posx=60+60*(j-1);
                squares[i][j].poy=160+60*(i-1);
            }
        }
    }
    void setPlayers(int x1,int y1,int x2,int y2){
        player1.posX=x1;
        player1.posX=y1;
        player2.posX=x2;
        player2.posY=y2;

    }
}
