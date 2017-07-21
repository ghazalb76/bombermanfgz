/**
 * Created by ZAHRA on 21/07/2017.
 */
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
    int number_of_players;


    public void Data() {
        String keyBoard;
        int number_of_players;

    }



    public Server(Socket socket, int client_id, MapGenerator mapGenerator,int number_of_players)
    {
        this.number_of_players=number_of_players;
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

            Receive receiveServer = new Receive();
            receiveServer.Receive(is, (LinkedList) q);
        }}

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
    }}
