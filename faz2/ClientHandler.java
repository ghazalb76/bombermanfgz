
public class ClientHandler {
    public static void main(String[] args) {
        ParseC parse =new ParseC();
        parse.parsePresent();
        parse.parseBlock();
        parse.parsePlayer();
        parse.parseScore();
        parse.parse_bomb();
        parse.parseTime();
        Graphic gui=new Graphic(parse.squares,parse.posPresent,parse.n,parse.score,parse.presentType,parse.posePlayer,parse.bombs,parse.time);
        gui.draaw(gui);

    }
}
