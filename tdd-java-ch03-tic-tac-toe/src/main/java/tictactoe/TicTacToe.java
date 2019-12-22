package tictactoe;

public class TicTacToe {
    private Character[][] board;

    public TicTacToe() {
        board = new Character[][]{{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    }

    public void play(int x, int y) {
        checkAxis(x, "X is outside board");
        checkAxis(y, "Y is outside board");
        storePoint(x, y);
    }

    private void checkAxis(int axis, String errorMsg) {
        if (axis > 3 || axis < 1) {
            throw new RuntimeException(errorMsg);
        }
    }

    private void storePoint(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Point is same");
        }

        board[x - 1][y - 1] = 'X';
    }
}
