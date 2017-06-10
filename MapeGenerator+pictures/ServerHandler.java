/**
 * Created by dude on 6/6/2017.
 */
public class ServerHandler {
    public static void main(String[] args) {
        MapGenerator mapGenerator = new MapGenerator();
        mapGenerator.make_block();
        mapGenerator.set_id();
        GameManagement gameManagement= new GameManagement();
        gameManagement.board.squares=mapGenerator.squares;
        gameManagement.board.display();
        GUI gui=new GUI(gameManagement.board.squares);
     //   gui.paint(null);
        gui.draaw(gui);
    }
}
