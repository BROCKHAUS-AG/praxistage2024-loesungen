import de.brockhausag.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {

    private TicTacToeGame game;

    @BeforeEach
    void setUp() {
        game = new TicTacToeGame();
    }

    @Test
    void testInitialState() {
        assertArrayEquals(new FieldState[]{FieldState.NONE, FieldState.NONE, FieldState.NONE,
                FieldState.NONE, FieldState.NONE, FieldState.NONE,
                FieldState.NONE, FieldState.NONE, FieldState.NONE}, game.getFieldStates());
    }

    @Test
    void testMakeMove() {
        game.makeMove(0);
        assertArrayEquals(new FieldState[]{FieldState.X, FieldState.NONE, FieldState.NONE,
                FieldState.NONE, FieldState.NONE, FieldState.NONE,
                FieldState.NONE, FieldState.NONE, FieldState.NONE}, game.getFieldStates());

        game.makeMove(4);
        assertArrayEquals(new FieldState[]{FieldState.X, FieldState.NONE, FieldState.NONE,
                FieldState.NONE, FieldState.O, FieldState.NONE,
                FieldState.NONE, FieldState.NONE, FieldState.NONE}, game.getFieldStates());
    }

    @Test
    void testGetWinner() {
        // Test row win
        game.makeMove(0);
        game.makeMove(4);
        game.makeMove(1);
        game.makeMove(3);
        game.makeMove(2);
        assertEquals(FieldState.X, game.getWinner());

        // Reset game
        game.resetGame();

        // Test column win
        game.makeMove(0);
        game.makeMove(1);
        game.makeMove(3);
        game.makeMove(4);
        game.makeMove(6);
        assertEquals(FieldState.X, game.getWinner());

        // Reset game
        game.resetGame();

        // Test diagonal win
        game.makeMove(0);
        game.makeMove(1);
        game.makeMove(4);
        game.makeMove(3);
        game.makeMove(8);
        assertEquals(FieldState.X, game.getWinner());

        // Reset game
        game.resetGame();

        // Test tie
        game.makeMove(0);
        game.makeMove(1);
        game.makeMove(2);
        game.makeMove(3);
        game.makeMove(4);
        game.makeMove(6);
        game.makeMove(5);
        game.makeMove(8);
        game.makeMove(7);
        assertEquals(FieldState.NONE, game.getWinner());
    }

    @Test
    void testResetGame() {
        game.makeMove(0);
        game.makeMove(4);
        game.resetGame();
        assertArrayEquals(new FieldState[]{FieldState.NONE, FieldState.NONE, FieldState.NONE,
                FieldState.NONE, FieldState.NONE, FieldState.NONE,
                FieldState.NONE, FieldState.NONE, FieldState.NONE}, game.getFieldStates());
    }
}