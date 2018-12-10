import TTT.GameLogic;
import TTT.SmartAI;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmartAITests {
    @Test
    public void findWinningMovePositiveTest() {
        GameLogic.restartGame();
        GameLogic.move(0, 0);
        GameLogic.move(2, 0);
        GameLogic.move(0, 1);
        GameLogic.move(2, 1);
        GameLogic.move(1, 0);
        int[] result = SmartAI.findWinningMove();
        int[] expected = {2, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void findWinningMoveNegativeTest() {
        GameLogic.restartGame();
        GameLogic.move(0, 0);
        int[] result = SmartAI.findWinningMove();
        int[] expected = {-1, -1};
        assertArrayEquals(expected, result);
    }

    @Test
    public void findPreventingMovePositiveTest() {
        GameLogic.restartGame();
        GameLogic.move(0, 0);
        GameLogic.move(2, 0);
        GameLogic.move(0, 1);
        int[] result = SmartAI.findPreventingMove();
        int[] expected = {0, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void findPreventingMoveNegativeTest() {
        GameLogic.restartGame();
        GameLogic.move(0, 0);
        int[] result = SmartAI.findPreventingMove();
        int[] expected = {-1, -1};
        assertArrayEquals(expected, result);
    }

    @Test
    public void findGoodMoveMiddleTest() {
        GameLogic.restartGame();
        GameLogic.move(0, 0);
        int[] result = SmartAI.findGoodMove();
        int[] expected = {1, 1};
        assertArrayEquals(expected, result);
    }

    @Test
    public void findGoodMoveCornerTest() {
        GameLogic.restartGame();
        GameLogic.move(1, 1);
        GameLogic.move(0, 0);
        GameLogic.move(2, 2);
        int[] result = SmartAI.findGoodMove();
        int[] expected = {0, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void findGoodMoveBorderTest() {
        GameLogic.restartGame();
        GameLogic.move(1, 1);
        GameLogic.move(0, 0);
        GameLogic.move(2, 2);
        GameLogic.move(2, 0);
        GameLogic.move(1, 0);
        GameLogic.move(1, 2);
        GameLogic.move(0, 2);

        int[] result = SmartAI.findGoodMove();
        int[] expected = {0, 1};
        assertArrayEquals(expected, result);
    }

    @Test
    public void smartMoveWinningTest() {
        GameLogic.restartGame();
        GameLogic.move(0, 0);
        GameLogic.move(2, 0);
        GameLogic.move(0, 1);
        GameLogic.move(2, 1);
        GameLogic.move(1, 0);
        char result = (char) SmartAI.smartMove()[0];
        char expected = 'O';
        assertEquals(expected, result);
        assertTrue(GameLogic.end);
    }

    @Test
    public void smartMovePreventingTest() {
        GameLogic.restartGame();
        GameLogic.move(0, 0);
        GameLogic.move(2, 0);
        GameLogic.move(0, 1);
        char result = (char) SmartAI.smartMove()[0];
        char expected = 'O';
        assertEquals(expected, result);
        assertFalse(GameLogic.end);
    }

    @Test
    public void smartMoveMiddleTest() {
        GameLogic.restartGame();
        GameLogic.move(0, 0);
        char result = (char) SmartAI.smartMove()[0];
        char expected = 'O';
        assertEquals(expected, result);
        assertEquals('O', GameLogic.board[1][1]);
        assertFalse(GameLogic.end);
    }

    @Test
    public void smartMoveCornerTest() {
        GameLogic.restartGame();
        GameLogic.move(1, 1);
        GameLogic.move(0, 0);
        GameLogic.move(2, 2);
        char result = (char) SmartAI.smartMove()[0];
        char expected = 'O';
        assertEquals(expected, result);
        assertEquals('O', GameLogic.board[0][2]);
        assertFalse(GameLogic.end);
    }

    @Test
    public void smartMoveBorderTest() {
        GameLogic.restartGame();
        GameLogic.move(1, 1);
        GameLogic.move(0, 0);
        GameLogic.move(2, 2);
        GameLogic.move(2, 0);
        GameLogic.move(1, 0);
        GameLogic.move(1, 2);
        GameLogic.move(0, 2);
        char result = (char) SmartAI.smartMove()[0];
        char expected = 'O';
        assertEquals(expected, result);
        assertEquals('O', GameLogic.board[0][1]);
        assertFalse(GameLogic.end);
    }
}
