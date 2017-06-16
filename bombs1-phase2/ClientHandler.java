
public class ClientHandler {
    public static void main(String[] args) {
        JsonWriter jsonWrite=new JsonWriter();
        Parser jsonRead=new Parser();
        jsonWrite.setBlock();
        jsonWrite.setPlayer();
        jsonWrite.setPresent();
        //
        jsonWrite.set_bomb();
        jsonWrite.parse();
        jsonRead.parsePresent();
        jsonRead.parseBlock();
        jsonRead.parsePlayer();
        jsonWrite.set_score();
        jsonRead.parseScore();
         jsonRead.parse_bomb();
       GUI gui=new GUI(jsonRead.squares,jsonRead.posPresent,jsonWrite.n,jsonRead.score,jsonRead.presentType,jsonRead.posePlayer,jsonRead.bombs);
       gui.draaw(gui);
    }
}
