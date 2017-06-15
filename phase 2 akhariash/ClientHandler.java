/**
 * Created by dude on 6/15/2017.
 */
public class ClientHandler {
    public static void main(String[] args) {
        ParseC parse =new ParseC();
        parse.parsePresent();
        parse.parseBlock();
        parse.parsePlayer();
        parse.parseScore();
        Graphic gui=new Graphic(parse.squares,parse.posPresent,parse.n,parse.score,parse.presentType,parse.posePlayer);
        gui.draaw(gui);
    }
}
