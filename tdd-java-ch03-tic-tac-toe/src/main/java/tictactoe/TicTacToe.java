package tictactoe;

public class TicTacToe {
    private Character[][] board;
    private char latestPlayer;

    public TicTacToe() {
        board = new Character[][]{{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    }

    private void storePoint(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Point is occupied");
        }

        latestPlayer = nextPlayer();
        board[x - 1][y - 1] = latestPlayer;
    }

    public void play(Point point) {
        point.checkXAxis();
        point.checkYAxis();
        storePoint(point.getX(), point.getY());
    }

    public char nextPlayer() {
        if (latestPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}
