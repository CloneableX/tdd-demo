package tictactoe;

import java.util.SimpleTimeZone;

public class TicTacToe {
    private final int SIZE;
    private Character[][] board;
    private char latestPlayer;

    public TicTacToe() {
        board = new Character[][]{{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
        SIZE = 3;
    }

    private void storePoint(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Point is occupied");
        }

        latestPlayer = nextPlayer();
        board[x - 1][y - 1] = latestPlayer;
    }

    public String play(Point point) {
        point.checkXAxis();
        point.checkYAxis();
        storePoint(point.getX(), point.getY());

        if (isWin()) {
            return latestPlayer + " is winner";
        } else if (isDraw()) {
            return "The result is draw";
        }

        return "No winner";
    }

    private boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin() {
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] + board[1][i] +board[2][i] == (latestPlayer * SIZE)) {
                return true;
            }

            if (board[i][0] + board[i][1] +board[i][2] == (latestPlayer * SIZE)) {
                return true;
            }

        }

        if (board[0][0] + board[1][1] + board[2][2] == (latestPlayer * SIZE)) {
            return true;
        }

        if (board[2][0] + board[1][1] + board[0][2] == (latestPlayer * SIZE)) {
            return true;
        }

        return false;
    }

    public char nextPlayer() {
        if (latestPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}
