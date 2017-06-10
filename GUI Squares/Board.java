/**
 * Created by dude on 6/6/2017.
 */
public class Board {
    Square[][] squares= new Square[15][15];
    Player player= new Player();
    void display(){
        System.out.println("aaa");
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                System.out.print(squares[i][j].type+"\t");
            }
            System.out.println();
        }
    }

    void update(){


    }
    void add_velocity(){

    }
    void add_health(){

    }
    void convert_b(){

    }
}
