import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicTests {
    @Test
    public void isOccupiedPositiveTest() {
        GameLogic.board[1][1]='X';
        boolean result = GameLogic.isOccupied(1,1);
        assertTrue(result);
        GameLogic.board[1][1]=' ';
    }

    @Test
    public void isOccupiedNegativeTest() {
        boolean result = GameLogic.isOccupied(2,2);
        assertFalse(result);
    }

    @Test
    public void checkWinnerNegativeTest() {
        char winner = 'N';
        char result = GameLogic.checkWinner();
        assertEquals(winner, result);
    }

    @Test
    public void checkWinnerPositiveTest() {
        char winner = 'A';
        GameLogic.board[0][0]='X';
        GameLogic.board[1][1]='X';
        GameLogic.board[2][2]='X';
        char result = GameLogic.checkWinner();
        assertEquals(winner, result);
    }


}
