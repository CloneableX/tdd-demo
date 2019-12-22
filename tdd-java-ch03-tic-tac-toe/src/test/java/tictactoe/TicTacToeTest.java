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

    @Test
    public void should_no_winner_when_play() {
        String result = ticTacToe.play(new Point(1, 1));
        assertEquals("No winner", result);
    }

    @Test
    public void should_winner_X_when_play_given_X_whole_horizon_line() {
        ticTacToe.play(new Point(1, 1)); // X
        ticTacToe.play(new Point(1, 2)); // O
        ticTacToe.play(new Point(2, 1)); // X
        ticTacToe.play(new Point(2, 2)); // O
        String result = ticTacToe.play(new Point(3, 1));// X
        assertEquals("X is winner", result);
    }

    @Test
    public void should_winner_O_when_play_given_O_whole_vertical_line() {
        ticTacToe.play(new Point(2, 1)); // X
        ticTacToe.play(new Point(1, 1)); // O
        ticTacToe.play(new Point(3, 1)); // X
        ticTacToe.play(new Point(1, 2)); // O
        ticTacToe.play(new Point(2, 2)); // X
        String result = ticTacToe.play(new Point(1, 3));// O
        assertEquals("O is winner", result);
    }

    @Test
    public void should_winner_X_when_play_given_X_whole_top_bottom_diagonal_line() {
        ticTacToe.play(new Point(1, 1)); // X
        ticTacToe.play(new Point(1, 2)); // O
        ticTacToe.play(new Point(2, 2)); // X
        ticTacToe.play(new Point(1, 3)); // O
        String result = ticTacToe.play(new Point(3, 3));// X
        assertEquals("X is winner", result);
    }

    @Test
    public void should_winner_X_when_play_given_X_whole_bottom_top_diagonal_line() {
        ticTacToe.play(new Point(1, 3)); // X
        ticTacToe.play(new Point(1, 1)); // O
        ticTacToe.play(new Point(2, 2)); // X
        ticTacToe.play(new Point(1, 2)); // O
        String result = ticTacToe.play(new Point(3, 1));// X
        assertEquals("X is winner", result);
    }

    @Test
    public void should_draw_when_play_given_filled_board_and_no_winner() {
        ticTacToe.play(new Point(1, 1));
        ticTacToe.play(new Point(1, 2));
        ticTacToe.play(new Point(1, 3));
        ticTacToe.play(new Point(2, 1));
        ticTacToe.play(new Point(2, 3));
        ticTacToe.play(new Point(2, 2));
        ticTacToe.play(new Point(3, 1));
        ticTacToe.play(new Point(3, 3));
        String result = ticTacToe.play(new Point(3, 2));
        assertEquals("The result is draw", result);
    }
}
