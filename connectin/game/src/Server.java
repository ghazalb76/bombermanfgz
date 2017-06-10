import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by asus on 6/1/2017.
 */
public class Server {
    int port=3333;
    ServerSocket serverSocket=null;
    int clientnum=2;
    public void server(){

        try {
            serverSocket = new ServerSocket(port);
        }catch (IOException e){
            System.out.println( e.getMessage());
        }
        while (clientnum!=0){
            try {
                Socket clientsocket=serverSocket.accept();
                new Thread(new MultiThread(clientsocket)).start();
                //make new thread
                clientnum--;
            }catch (IOException e){
                System.out.println( e.getMessage());
            }
        }
    }

}
