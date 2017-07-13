
public class ServerHandler {
    public static void main(String[] args) {
        int number_of_players=2;
        GameManagement gameManagement= new GameManagement();
        MapGenerator mapGenerator=new MapGenerator(gameManagement.board,number_of_players);
        mapGenerator.setSquares();
        mapGenerator.setPlayer();
        mapGenerator.setPresents();
        gameManagement.board.setId();
        gameManagement.board.setPos_Square();

        for (int i=1; i<14 ;i++){
            for(int j=1 ;j<14;j++){
               // System.out.print(gameManagement.board.squares[i][j].type);
                System.out.print(gameManagement.board.squares[i][j].posx);
                System.out.print("\t");
                System.out.println(gameManagement.board.squares[i][j].poy);


            }
            System.out.println();
        }
       // System.out.println(gameManagement.board.squares[1][1].type);
    }
}

