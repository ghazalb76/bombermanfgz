import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by asus on 7/16/2017.
 */
public class SendServer extends Thread {

    ParseServer parseServer=new ParseServer();
    String number_of_clients="2";
    MapGenerator mapGenerator;
    OutputStream os;
    /*Data data*/Board board=mapGenerator.board;
    SendServer(MapGenerator mapGenerator, OutputStream os){
        this.mapGenerator=mapGenerator;
        this.os=os;
    }
    @Override
    public void run() {
        parseServer.parseSquares(board);
        parseServer.parsePlayers(number_of_clients,board.players );
        parseServer.parsePresents(mapGenerator.x,mapGenerator.y);
        parseServer.parseScores(board);
        parseServer.parseTime();
        System.out.println("parsed");
        String dataSTR=parseServer.parse();

        try {
            os.write(dataSTR.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
