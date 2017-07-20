import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Player {

    int secondPassed = 0;
    Timer mytimer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondPassed++;
            System.out.println(secondPassed);
        }
    };

    public void start() {
        mytimer.scheduleAtFixedRate(task, 1000, 1000);
    }


    int posX;
    int posY;
    int health = 3;
    int iSquare;
    int jSquare;
    int score = 0;
    int velocity = 10;
    String direction;
    Bomb[] bomb = new Bomb[3];
    ArrayList<String> haveKhatti = new ArrayList<>();

    void setBombs() {
        number_of_bombs = 0;
        bomb[0] = new Bomb();
        bomb[1] = new Bomb();
        bomb[2] = new Bomb();
    }

    int number_of_bombs = 100;
    int number_of_khatti_bombs = 0;

    void move1(int dist) {
        posX += dist;
    }

    void move2(int dist) {
        posY += dist;
    }

    void setTimeBomb(int i) {
        bomb[i].timepass = secondPassed;
    }

    void putBomb(Board board, Player player) {
        int counter = 0;
        counter++;
        if (player.number_of_bombs == 3) {
            player.setBombs();

        }

        System.out.println(player.haveKhatti.size() + "    ah aha ha a ah");
        if (player.haveKhatti.size() != 0) {
            if (player.haveKhatti.size() == 1) {
                System.out.println(" vvvvvvvvvvvvvvvvvvvvvvvay");
                player.bomb[0].khatti = true;
                setTimeBomb(0);
            } else if (player.haveKhatti.size() == 2) {
                player.bomb[0].khatti = true;
                player.bomb[1].khatti = true;
                setTimeBomb(0);
                setTimeBomb(1);
            } else if (player.haveKhatti.size() == 3) {
                player.bomb[0].khatti = true;
                player.bomb[1].khatti = true;
                player.bomb[2].khatti = true;
                setTimeBomb(0);
                setTimeBomb(1);
                setTimeBomb(2);

            }
        }
        if (player.number_of_bombs == 0) {

            player.bomb[0].isAlive = true;
            setTimeBomb(0);
            System.out.println("creatioon"+bomb[0].timepass);
            player.bomb[0].posX = player.iSquare;
            player.bomb[0].posY = player.jSquare;
            player.number_of_bombs++;
            System.out.println(bomb[0].timepass + "timeeeee bobm");


        } else if (player.number_of_bombs == 1) {
            player.bomb[1].isAlive = true;
            setTimeBomb(1);
            player.bomb[1].posX = player.iSquare;
            player.bomb[1].posY = player.jSquare;
            player.number_of_bombs++;

                // player.bomb[0].killkhatti(player,board);


        } else if (player.number_of_bombs == 2) {
            player.bomb[2].isAlive = true;
            setTimeBomb(2);
            player.bomb[2].posX = player.iSquare;
            player.bomb[2].posY = player.jSquare;
            player.number_of_bombs++;


        }

    }

    void checkexplode (Board board, Player player) {
        System.out.println(" this time "+secondPassed);
        System.out.print("passes");
        System.out.println(secondPassed - bomb[0].timepass );
        if (player.number_of_bombs == 0 || secondPassed - bomb[0].timepass >=3) {
            if (player.bomb[0].khatti == true) {
                player.bomb[0].destroykhatti(1, board, player);
            } else {
                System.out.println("going tto");
                player.bomb[0].destroy(0, board, player);
                player.bomb[0].kill(player, board);
            }


        }
        if (player.number_of_bombs == 1|| secondPassed - bomb[1].timepass >=3) {
            if (player.bomb[1].khatti == true) {
                player.bomb[1].destroykhatti(1, board, player);
            } else {
                System.out.println("going tto");
                player.bomb[1].destroy(1, board, player);
                player.bomb[1].kill(player, board);
            }


        }
        if (player.number_of_bombs == 2 || secondPassed - bomb[2].timepass >=3) {
            if (player.bomb[2].khatti == true) {
                player.bomb[2].destroykhatti(1, board, player);
            } else {
                System.out.println("going tto");
                player.bomb[2].destroy(2, board, player);
                player.bomb[2].kill(player, board);
            }


        }

    }
}