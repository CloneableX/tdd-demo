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

        ticTacToe.play(4, 1);
    }

    @Test
    public void should_play_exception_when_play_given_point_over_y() {
        expectedException.expect(RuntimeException.class);

        ticTacToe.play(1, 4);
    }

    @Test
    public void should_play_exception_when_play_given_same_point() {
        ticTacToe.play(1, 1);

        expectedException.expect(RuntimeException.class);

        ticTacToe.play(1, 1);
    }
}
