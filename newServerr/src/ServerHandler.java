
public class ServerHandler {
    public static void main(String[] args) {
        int number_of_players=2;

        GameManagement gameManagement= new GameManagement();
        MapGenerator mapGenerator=new MapGenerator(gameManagement.board,number_of_players);
        gameManagement.board.addplayer();
        mapGenerator.setSquares();
        mapGenerator.setPlayer();

        mapGenerator.setPresents();
        gameManagement.board.setId();
        gameManagement.board.setPos_Square();
        String keyboard1="6";
        String keyboard2="6";
//ina byad too while true bashe
//in doroste player 1 va 2 jodas checkesh ??
        gameManagement.checkMove(gameManagement.board.player1,keyboard1);
        gameManagement.checkMove(gameManagement.board.player2,keyboard2);
        keyboard1="5";
        if(keyboard1=="5")
        gameManagement.checkBomb(gameManagement.board.player1);
      /* if (keyboard2=="5")
        gameManagement.checkBomb(gameManagement.board.player2);*/
        System.out.println(gameManagement.board.player1.health);
}}

