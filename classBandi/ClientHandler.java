
import java.io.IOException;

public class ClientHandler  {
    Client client;
    Graphic gui;
    public ClientHandler() {
        gui=new Graphic();
        client=new Client(gui);
    }

    public static void main(String[] args) throws IOException {

        ClientHandler clientHandler = new ClientHandler();

    }
}