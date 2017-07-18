import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Server implements Runnable{
    int client_id;
    Socket socket;
    InputStream is;
    OutputStream os;
    Queue<Data> q;
    Thread thread;
    Semaphore semaphore;
    MapGenerator mapGenerator=null;

    public Server(Socket socket, int client_id, MapGenerator mapGenerator)
    {
        this.mapGenerator=mapGenerator;
        this.socket = socket;
        this.client_id = client_id;

        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        semaphore = new Semaphore(1);
        thread = new Thread(this);
        thread.start();
        q = new LinkedList<>();

    }

    @Override
    public void run() {
        while (socket.isConnected()) {

            try {
                if(is.available() != 0) {
                    byte[] b = new byte[is.available()];
                    is.read(b);

                    JSONParser jsonParser = new JSONParser();
                    JSONObject jsonObject = (JSONObject) jsonParser.parse(new String(b));
                    Data data = new Data();
                    data.keyBoard= (String) jsonObject.get("keyBoard");
                    data.message.add((String) jsonObject.get("message"));
                    semaphore.acquire();
                    q.add(data);

                    semaphore.release();
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean haveNewData() {
        boolean res = false;
        try {
            semaphore.acquire();
            res = q.size() != 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return res;
    }

    public Data getData() {
        Data data = null;
        try {
            semaphore.acquire();
            data = q.remove();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return data;
    }
ParseServer parseServer=new ParseServer();
    String number_of_clients="2";
    public void sendData(/*Data data*/Board board) {
        parseServer.parseSquares(board);
        parseServer.parsePlayers(number_of_clients,board.players );
        parseServer.parsePresents(mapGenerator.x,mapGenerator.y);
        parseServer.parseScores(board);
        parseServer.parseTime();
        parseServer.parseBombs(board.player1);
        parseServer.parseBombs1(board.player2);
        parseServer.parsee();
        String dataSTR=parseServer.parse();

        try {
            os.write(dataSTR.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
