import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Created by asus on 7/16/2017.
 */
public class ReceiveServer extends Thread {
  Semaphore semaphore = new Semaphore(1);
    Queue<Data> q = new LinkedList<>();
    Socket socket;
    InputStream is;
    ReceiveServer( Socket socket, InputStream is){
       this.socket=socket;
        this.is=is;
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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }




}
