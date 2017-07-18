import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerHandler implements  Runnable {

    Thread listenThread;
    Thread t;
    LinkedList<Server> connections;
    GameManagement gameManagement=null;
    MapGenerator mapGenerator=null;
    int number_of_players=2;

    public ServerHandler() {
        gameManagement= new GameManagement();
        mapGenerator=new MapGenerator(gameManagement.board,number_of_players);
        gameManagement.board.addplayer();
        mapGenerator.setSquares();
        mapGenerator.setPlayer();
        mapGenerator.setPresents();
        gameManagement.board.setId();
        gameManagement.board.setPos_Square();

        connections = new LinkedList<>();
        listenThread = new Thread(this);
        listenThread.start();
        t = new Thread();
        t.start();
        search();
    }

    public void search() {
        while (true) {
            try {
                int countConnection=1;
                for (Server connection : connections) {

                    if (connection.haveNewData()) {

                        Data data = connection.getData();
                        System.out.println(data.keyBoard);
                        System.out.println(data.keyBoard);
                        if(data.keyBoard.equals("4") || data.keyBoard.equals("6") || data.keyBoard.equals("8") || data.keyBoard.equals("2")) {
                            logic(countConnection, data);
                        }
                        if(data != null)
                            sendToAll(/*data*/);
                    }
                    countConnection++;
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void sendToAll(/*Data data*/) {
        for (Server connection : connections) {
            connection.sendData(/*data*/gameManagement.board);
        }
    }

    void logic(int countConnection,Data data){

        if(countConnection==1){

            gameManagement.checkMove(gameManagement.board.player1,data.keyBoard);
        }
        else{
            gameManagement.checkMove(gameManagement.board.player2,data.keyBoard);
        }
       /* keyboard1="5";
        if(keyboard1=="5")
            gameManagement.checkBomb(gameManagement.board.player1);
        if (keyboard2=="5")
            gameManagement.checkBomb(gameManagement.board.player2);
        System.out.println(gameManagement.board.player1.health);
        System.out.println(gameManagement.board.player2.health);*/
    }


    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(connections.size()+"were connected");

                Server connection = new Server(socket, connections.size() + 1,mapGenerator);
                connections.add(connection);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ServerHandler serverhandler = new ServerHandler();
        while (true){

        }

    }}