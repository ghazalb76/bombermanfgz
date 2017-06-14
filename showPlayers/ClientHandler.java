
/**
 * Created by dude on 6/11/2017.
 */
public class ClientHandler {
    public static void main(String[] args) {
        JsonWrite jsonWrite=new JsonWrite();
        Parse jsonRead=new Parse();
        jsonWrite.setBlock();
        jsonRead.parseBlock();
        jsonWrite.setPlayer();
        jsonRead.parsePlayer();
        jsonWrite.setPresent();
        jsonRead.parsePresent();
        // jsonWrite.set_score();
        //jsonRead.parseScore();
        Graphic gui=new Graphic(jsonRead.squares,jsonRead.posPresent,jsonWrite.n,jsonRead.score,jsonRead.presentType,jsonRead.posePlayer);
        gui.draaw(gui);
    }
}