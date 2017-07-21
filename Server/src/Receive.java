/**
 * Created by ZAHRA on 21/07/2017.
 */
import jdk.internal.util.xml.impl.Input;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;


public class Receive {
    InputStream is = null;
    Semaphore semaphore=null;
    LinkedList q =null;
    ParseServer parseServer= new ParseServer();
    public void Receive(InputStream is , LinkedList q){
        this.q=q;
        this.is=is;
        semaphore = new Semaphore(1);
        try {
            if(is.available() != 0) {
                byte[] b = new byte[is.available()];
                is.read(b);

                parseServer.parse_keyboard(q,b);
                //   data.number_of_players= (int) jsonObject.get("number_of_players");

            }
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
