/**
 * Created by dude on 6/15/2017.
 */
public class ServerHandler {
    public static void main(String[] args) {
        MapGenerator mapGenerator = new MapGenerator();
        mapGenerator.setSquares();
        mapGenerator.setPlayers();
        mapGenerator.setPresents();
        mapGenerator.setScores();
        mapGenerator.setBombs();
        ParserS parse = new ParserS();
        parse.parseSquares(mapGenerator.squares);
        parse.parsePlayers(mapGenerator.n,mapGenerator.posePlayers);
        parse.parsePresents(mapGenerator.posPresent);
        parse.parseScores(mapGenerator.n,mapGenerator.score);
        parse.parseBombs(mapGenerator.bombX,mapGenerator.bombY);
        parse.parse();
    }
}
