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
    int number_of_players=4;

    public ServerHandler() {
        gameManagement= new GameManagement(number_of_players);
        mapGenerator=new MapGenerator(gameManagement.board,number_of_players);
        gameManagement.board.addplayer(number_of_players);
        mapGenerator.setSquares();
        mapGenerator.setPlayer();
        mapGenerator.setPresents();
        gameManagement.board.setId();
        gameManagement.board.setPos_Square();
        gameManagement.board.setDirection(gameManagement.board.player1,"2");
        gameManagement.board.setDirection(gameManagement.board.player2,"2");
        if(number_of_players==3)
            gameManagement.board.setDirection(gameManagement.board.player3,"2");
        else if(number_of_players==4) {
            gameManagement.board.setDirection(gameManagement.board.player3,"2");
            gameManagement.board.setDirection(gameManagement.board.player4, "2");
        }
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
                        if(data.keyBoard.equals("4") || data.keyBoard.equals("6") || data.keyBoard.equals("8") || data.keyBoard.equals("2") || data.keyBoard.equals("5")) {
                            logic(countConnection, data);
                        }
                        if(data != null)
                            sendToAll(/*data*/);
                    }
                    countConnection++;
                }
                Thread.sleep(10);
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
            if(data.keyBoard.equals("5")) {
                gameManagement.checkBomb(gameManagement.board.player1);
            }
            else {
                gameManagement.board.setDirection(gameManagement.board.player1, data.keyBoard);
                gameManagement.checkMove(gameManagement.board.player1, data.keyBoard);
            }
        }
        else if(countConnection==2){
            if(data.keyBoard.equals("5"))
                gameManagement.checkBomb(gameManagement.board.player2);
            else {
                gameManagement.board.setDirection(gameManagement.board.player2, data.keyBoard);
                gameManagement.checkMove(gameManagement.board.player2, data.keyBoard);
            }
        }
        else if(countConnection==3){
            if(data.keyBoard.equals("5"))
                gameManagement.checkBomb(gameManagement.board.player3);
            else {
                gameManagement.board.setDirection(gameManagement.board.player3, data.keyBoard);
                gameManagement.checkMove(gameManagement.board.player3, data.keyBoard);
            }
        }
        else if(countConnection==4){
            if(data.keyBoard.equals("5"))
                gameManagement.checkBomb(gameManagement.board.player4);
            else {
                gameManagement.board.setDirection(gameManagement.board.player4, data.keyBoard);
                gameManagement.checkMove(gameManagement.board.player4, data.keyBoard);
            }
        }
    }


    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(connections.size()+"were connected");

                Server connection = new Server(socket, connections.size() + 1,mapGenerator,number_of_players);
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