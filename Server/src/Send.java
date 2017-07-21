/**
 * Created by ZAHRA on 21/07/2017.
 */
import javax.print.attribute.standard.Severity;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;

/**
 * Created by ZAHRA on 21/07/2017.
 */
public class Send {
    OutputStream os = null;

    ParseServer parseServer=new ParseServer();
    public void sendData(Board board,GameManagement gameManagement,OutputStream os) {
        /*for(int i=0;i<15;i++) {
            for (int j = 0; j < 15; j++) {
                if(board.squares[i][j].present.type.equals("health"))
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        }*/
        this.os=os;
        parseServer.parseNumberOfPlayers(gameManagement.number_of_players);
        parseServer.parseSquares(board);
        parseServer.parsePlayers(gameManagement.number_of_players,board.players );
        parseServer.parsePresents(board);
        parseServer.parseScores(board,gameManagement.number_of_players);
        parseServer.parseTime();
        parseServer.parseBombs(board.player1);
        parseServer.parseBombs1(board.player2);
        if(gameManagement.number_of_players==3)
            parseServer.parseBombs3(board.player3);
        else if(gameManagement.number_of_players==4) {
            parseServer.parseBombs3(board.player3);
            parseServer.parseBombs4(board.player4);
        }
        parseServer.parsee();
        String dataSTR=parseServer.parse();

        try {
            os.write(dataSTR.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToAll(LinkedList connections, GameManagement gameManagement, OutputStream os) {
        this.os=os;
        for (Object connection: connections) {
            sendData(gameManagement.board,gameManagement,os);
        }
    }
}

