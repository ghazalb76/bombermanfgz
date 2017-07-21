/**
 * Created by dude on 7/13/2017.
 */
import java.io.*;
import java.io.IOException;
import java.net.Socket;

public class Receive {
    Socket socket;
    InputStream is;
    Receive(InputStream is,Socket socket){
        this.is=is;
        this.socket=socket;
    }
    Parse parse=new Parse(socket);
    public void receive() {
        try {
            if (is.available() != 0) {
                byte[] b = new byte[is.available()];
                is.read(b);
                parse.parse(b);
                parse.numberOfPlayers();
                parse.squares();
                parse.players();
                parse.present();
                parse.scores();
                parse.time();
                parse.bomb();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}

