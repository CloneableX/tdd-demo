package tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void should_play_exception_when_play_given_point_over_x() {
        expectedException.expect(RuntimeException.class);

        ticTacToe.play(new Point(4, 1));
    }

    @Test
    public void should_play_exception_when_play_given_point_over_y() {
        expectedException.expect(RuntimeException.class);

        ticTacToe.play(new Point(1, 4));
    }

    @Test
    public void should_play_exception_when_play_given_same_point() {
        Point point = new Point(1, 1);

        ticTacToe.play(point);

        expectedException.expect(RuntimeException.class);

        ticTacToe.play(point);
    }
}
