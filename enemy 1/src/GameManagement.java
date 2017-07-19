import java.awt.*;

/**
 * Created by dude on 7/13/2017.
 */
public class GameManagement {
    int a, b;
    Board board = new Board();
    String keyboard;

    boolean checkRight(Player player) {
        boolean flag = true;
        for (int i = 0; i < 15 && flag; i++) {
            for (int j = 0; j < 15; j++) {
                if (board.squares[i][j].posy == player.posY && board.squares[i][j].posx == player.posX) {
                    System.out.println("vared shod to right");
                    a = i;
                    b = j;
                    flag = false;
                    break;
                }

            }
        }
        System.out.println("a_right" + a);
        System.out.println("b_right" + b);
        if (board.squares[a][b + 1].type.equals("*")) {
            return true;
        } else
            return false;
    }

    boolean checkLeft(Player player) {
        boolean flag = true;
        for (int i = 1; i < 14 && flag; i++) {
            for (int j = 1; j < 14; j++) {
                if (board.squares[i][j].posy == player.posY && board.squares[i][j].posx == player.posX) {
                    System.out.println("vared shod to left");
                    a = i;
                    b = j;
                    flag = false;
                    break;
                }

            }
        }
        System.out.println("a_left" + a);
        System.out.println("b_left" + b);
        if (board.squares[a][b - 1].type.equals("*")) {
            return true;
        } else
            return false;
    }

    boolean checkUp(Player player) {
        boolean flag = true;
        for (int i = 0; i < 15 && flag; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.println("vared shod to up");
                if (board.squares[i][j].posy == player.posY && board.squares[i][j].posx == player.posX) {
                    a = i;
                    b = j;
                    flag = false;
                    break;
                }

            }
        }
        System.out.println("a_up" + a);
        System.out.println("b_up" + b);


        if (board.squares[a - 1][b].type.equals("*")) {
            return true;
        } else
            return false;
    }

    boolean checkDown(Player player) {
        boolean flag = true;
        for (int i = 0; i < 15 && flag; i++) {
            for (int j = 0; j < 15; j++) {
                if (board.squares[i][j].posy == player.posY && board.squares[i][j].posx == player.posX) {
                    System.out.println("vared shod to down");
                    a = i;
                    b = j;
                    flag = false;
                    break;
                }

            }
        }
        System.out.println("a_down" + a);
        System.out.println("b_down" + b);
        if (board.squares[a + 1][b].type.equals("*")) {
            return true;
        } else
            return false;
    }


    void checkMove(Player player, String keyboard) {
        switch (keyboard) {
            case "6":
                if (checkRight(player))
                    player.move1(+60);
                break;
            case "4":
                if (checkLeft(player))
                    player.move1(-60);
                break;
            case "8":
                if (checkUp(player))
                    player.move2(-60);
                break;
            case "2":
                if (checkDown(player))
                    player.move2(+60);
                break;
        }
    }

    void checkBomb(Player player) {
        boolean flag = true;
        for (int i = 0; i < 15 && flag; i++) {
            for (int j = 0; j < 15; j++) {
                if (board.squares[i][j].posx == player.posX && board.squares[i][j].posy == player.posY) {
                    a = i;
                    b = j;
                    flag = false;
                    break;
                }
            }
        }
        if (player.number_of_bombs < 3)
            player.putBomb(a, b, board, player);


    }

    void checkenemymove(Enemy[] enemies) {
        for (int i = 0; i < enemies.length; i++) {
            if (board.squares[enemies[i].x / 60 + 1][enemies[i].y / 60].type.equals("*")) {
                board.squares[enemies[i].x / 60 + 1][enemies[i].y / 60].type = "e";
                board.squares[enemies[i].x / 60][enemies[i].y / 60].type = "*";
                enemies[i].x+=60;}
                 else if (board.squares[enemies[i].x / 60][enemies[i].y / 60 - 1].type.equals("*")) {
                    board.squares[enemies[i].x / 60][enemies[i].y / 60 - 1].type = "e";
                    board.squares[enemies[i].x / 60][enemies[i].y / 60].type = "*";
                    enemies[i].x-=60;
                }
             else if (board.squares[enemies[i].x / 60 - 1][enemies[i].y / 60].type.equals("*")) {
                board.squares[enemies[i].x / 60 - 1][enemies[i].y / 60].type = "e";
                board.squares[enemies[i].x / 60][enemies[i].y / 60].type = "*";
                enemies[i].x-=60;
            } else if (board.squares[enemies[i].x / 60][enemies[i].y / 60 + 1].type.equals("*")) {
                board.squares[enemies[i].x / 60][enemies[i].y / 60 + 1].type = "e";
                board.squares[enemies[i].x / 60][enemies[i].y / 60].type = "*";
                enemies[i].y+=60;

            }

        }
    }
    void checkenemykill(Enemy[] enemies) {
        for (int i = 0; i < 5; i++) {
            if (enemies[i].x==board.player1.posX&&enemies[i].y==board.player1.posY){
                board.player1.health--;
            }
            if (enemies[i].x==board.player2.posX&&enemies[i].y==board.player2.posY){
                board.player2.health--;
            }
            System.out.println("player 1  " +board.player1.health+"player2 "+board.player2.health );
        }
    }


}
