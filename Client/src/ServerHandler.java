/**
 * Created by ZAHRA on 21/07/2017.
 */
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerHandler implements  Runnable {

    Thread listenThread;
    Thread t;
    LinkedList<Server> connections;
    GameManagement gameManagement=null;
    MapGenerator mapGenerator=null;
    int number_of_players=3;
    OutputStream os = null;
    Send sendServer = new Send();
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
        gameManagement.board.player1.start();
        gameManagement.board.player2.start();

        if(number_of_players==3)
            gameManagement.board.setDirection(gameManagement.board.player3,"2");
        else if(number_of_players==4) {
            gameManagement.board.setDirection(gameManagement.board.player3,"2");
            gameManagement.board.setDirection(gameManagement.board.player4, "2");
        }
        for(int i=0;i<15;i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(gameManagement.board.squares[i][j].present.type+"\t");
            }
            System.out.println();
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
                    os=connection.os;
                    if (connection.haveNewData()) {

                        Data data = connection.getData();
                        if(data.keyBoard.equals("4") || data.keyBoard.equals("6") || data.keyBoard.equals("8") || data.keyBoard.equals("2") || data.keyBoard.equals("5")) {
                            logic(countConnection, data);
                        }
                        if(data != null)
                            sendServer.sendToAll(connections,gameManagement,os);
                    }
                    countConnection++;
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        for(int i=0;i<15;i++) {
            for (int j = 0; j < 15; j++) {
                if(!gameManagement.board.squares[i][j].present.type.equals("empty") )
                    System.out.println(gameManagement.board.squares[i][j].present.isOpen);
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
      /*  Timee timer= new Timee();
        timer.start();*/
        ServerHandler serverhandler = new ServerHandler();


        // System.out.println("timeee"+timer.secondPassed);
        while (true){

        }

    }}