package tictactoe;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void checkXAxis() {
        if (x > 3 || x < 1) {
            throw new RuntimeException("X is outside board");
        }
    }

    public void checkYAxis() {
        if (y > 3 || y < 1) {
            throw new RuntimeException("Y is outside board");
        }
    }
}
