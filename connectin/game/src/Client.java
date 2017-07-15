import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by asus on 6/1/2017.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket client;
        String id ="localhost" ;
        int port=3333;
        client=new Socket(id,port);

        PrintWriter out=new PrintWriter(client.getOutputStream(),true);
        InputStreamReader ir=new InputStreamReader(client.getInputStream());
        BufferedReader in=new BufferedReader(ir);
        BufferedReader input= new BufferedReader(new InputStreamReader ( System.in));

        out.println(input.readLine());//sends input to server
        System.out.println(in.readLine());
    }
}
