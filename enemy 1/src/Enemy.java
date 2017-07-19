
public class Enemy {
    int v;
    int id;
    int x;
    int y;
    boolean alive=true;
    Enemy(int id){
        id=this.id;
    }
    public void move(){
        x=x+v;
        y=y+v;
    }
    public void kill(){

    }
}
