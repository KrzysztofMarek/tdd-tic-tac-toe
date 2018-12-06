import TTT.GameLogic;
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
        char winner = 'O';
        GameLogic.board[0][0]='O';
        GameLogic.board[1][1]='O';
        GameLogic.board[2][2]='O';
        char result = GameLogic.checkWinner();
        assertEquals(winner, result);
        GameLogic.board[0][0]=' ';
        GameLogic.board[1][1]=' ';
        GameLogic.board[2][2]=' ';
    }


}
