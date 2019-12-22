package tictactoe;

public class TicTacToe {
    private Character[][] board;

    public TicTacToe() {
        board = new Character[][]{{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    }

    private void storePoint(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Point is occupied");
        }

        board[x - 1][y - 1] = 'X';
    }

    public void play(Point point) {
        point.checkXAxis();
        point.checkYAxis();
        storePoint(point.getX(), point.getY());
    }
}
