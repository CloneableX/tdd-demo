package tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void should_X_when_next_player_given_first_turn() {
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void should_O_when_next_player_given_next_turn_after_X() {
        ticTacToe.play(new Point(1, 1));
        assertEquals('O', ticTacToe.nextPlayer());
    }
}
