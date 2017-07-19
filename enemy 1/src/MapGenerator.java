import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dude on 7/13/2017.
 */
public class MapGenerator {
    Random rand = new Random();
    Board board = null;
    int number_of_players = 2;
    ArrayList<Integer> x = null;
    ArrayList<Integer> y = null;
    ArrayList<Integer> enemy_x = null;
    ArrayList<Integer> enemy_y = null;


    public MapGenerator(Board board, int number_of_players) {

        this.board = board;
        this.number_of_players = number_of_players;
    }

    void setPresents() {
        int a;
        x = new ArrayList();
        y = new ArrayList();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (board.squares[i][j].type == "+") {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            a = rand.nextInt(x.size());
            if (k >= 0 && k < 3)
                board.squares[x.get(a)][y.get(a)].type = "1";
            if (k >= 3 && k < 6)
                board.squares[x.get(a)][y.get(a)].type = "2";
            if (k >= 6 && k < 9)
                board.squares[x.get(a)][y.get(a)].type = "3";
            x.remove(a);
            y.remove(a);
        }

    }

    void setSquares() {
        board.setGreen(1, 1);
        board.setGreen(1, 2);
        board.setGreen(2, 1);
        board.setGreen(13, 1);
        board.setGreen(13, 2);
        board.setGreen(12, 1);
        board.setGreen(1, 13);
        board.setGreen(2, 13);
        board.setGreen(1, 12);
        board.setGreen(13, 13);
        board.setGreen(13, 12);
        board.setGreen(12, 13);
        //   System.out.println(board.squares[1][1]);
        int a, b;
        for (int i = 0; i < 60; i++) {
            do {
                do {
                    a = rand.nextInt(13) + 1;
                    b = rand.nextInt(13) + 1;
                } while (a % 2 == 0 && b % 2 == 0);
            } while (is_null(a, b) == false);
            board.setBrick(a, b);
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i == 0 || i == 14 || j == 0 || j == 14) {
                    board.setBlock(i, j);
                } else if (i % 2 == 0 && j % 2 == 0) {
                    board.setBlock(i, j);
                } else if (is_null(i, j)) {
                    board.setGreen(i, j);
                }
            }
        }
    }

    void setPlayer() {
        board.setPlayers(60, 160, 780, 880);
    }

    boolean is_null(int a, int b) {
        if (board.squares[a][b] == null)
            return true;
        else
            return false;
    }

    void setScores() {
        board.setScores(0, 0);
    }

    public void setenemy() {
        enemy_x = new ArrayList<>();
        enemy_y = new ArrayList<>();

      /*  int x= (rand.nextInt(12)+2)*60;
        int y=(rand.nextInt(12)+2)*60;
        int xm=x/60;
        int ym=y/60;
        System.out.println(ym);
        enemy_x.add(x);
        enemy_y.add(y);*/
        int x = 0, y = 0, xm = 0, ym = 0;
        for (int i = 0; i < 5; i++) {
            while (repeated(x, y, enemy_x, enemy_y) || !board.squares[xm][ym].type.equals("*") || board.squares[xm][ym].type.equals(null) || i == 0) {
                x = (rand.nextInt(10) + 4) * 60;
                y = (rand.nextInt(10) + 4) * 60;
                xm = x / 60;
                ym = y / 60;
                if (i == 0 && board.squares[ym][xm].type.equals("*"))
                    break;

            }
            if (board.squares[xm][ym].type.equals("*")) {

                enemy_x.add(x);
                enemy_y.add(y);
                board.squares[xm][ym].type="e";
                System.out.println(board.squares[xm][ym].type);
            } else i--;

        }

    }

    boolean repeated(int x, int y, ArrayList<Integer> enemy_x, ArrayList<Integer> enemy_y) {
        for (int i = 0; i < enemy_x.size(); i++) {
            if (x == enemy_x.get(i) && y == enemy_y.get(i)) {
                return true;
            }
        }
        return false;
    }


    }


