/**
 * Created by dude on 6/11/2017.
 */
public class Main {
    public static void main(String[] args) {
        JsonWrite jsonWrite=new JsonWrite();
        JsonRead jsonRead=new JsonRead();
        jsonWrite.setBlock();
        jsonRead.parseBlock();
        jsonWrite.setPlayer();
        jsonRead.parsePlayer();
        jsonWrite.setPresent();
        jsonRead.parsePresent();
        GUI gui=new GUI(jsonRead.squares,jsonRead.posPresent);
        gui.draaw(gui);
    }
}
