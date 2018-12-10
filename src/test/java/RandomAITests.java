import org.junit.Test;
import TTT.RandomAI;
import TTT.GameLogic;

import static org.junit.Assert.*;

public class RandomAITests {
    @Test
    public void generateRandomTest() {
        int result = RandomAI.generateRandom();
        assertTrue(result >= 0 && result <= 8);
    }

    @Test
    public void isOccupiedPositiveTest() {
        GameLogic.board[1][1] = 'X';
        assertTrue(RandomAI.isOccupied(4));
        GameLogic.board[1][1] = ' ';
    }

    @Test
    public void isOccupiedNegativeTest() {
        GameLogic.restartGame();
        assertFalse(RandomAI.isOccupied(4));
    }

    @Test
    public void randomMoveNoWinnerTest() {
        GameLogic.restartGame();
        GameLogic.move(1, 1);

        assertEquals('O', (char) RandomAI.randomMove()[0]);
        assertFalse(GameLogic.end);
        GameLogic.clearBoard();
    }

    @Test
    public void randomMoveWinnerTest() {
        GameLogic.restartGame();
        GameLogic.move(0, 0);
        GameLogic.board[0][1] = 'X';
        GameLogic.board[0][2] = 'O';
        GameLogic.board[1][0] = 'O';
        GameLogic.board[1][1] = 'O';
        GameLogic.board[2][1] = 'X';
        GameLogic.board[2][0] = 'X';
        GameLogic.board[2][2] = 'O';
        assertEquals('O', (char) RandomAI.randomMove()[0]);
        assertTrue(GameLogic.end);
        GameLogic.restartGame();
    }
}


