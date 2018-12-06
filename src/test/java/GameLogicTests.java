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

    @Test
    public void moveNoMovePossibleTest() {
        GameLogic.board[1][1]='X';
        char expected = 'N';
        char result = GameLogic.move(1,1);
        assertEquals(expected,result);
        GameLogic.board[1][1]=' ';
    }

    @Test
    public void moveNoWinnerTest() {
        char expected = 'X';
        char result = GameLogic.move(1,1);
        assertEquals(expected,result);
        GameLogic.board[1][1]=' ';
    }

    @Test
    public void moveWinnerTest() {
        char expected = 'X';
        GameLogic.move(0,0);
        GameLogic.move(2,0);
        GameLogic.move(0,1);
        GameLogic.move(2,1);
        char result = GameLogic.move(0,2);
        assertEquals(expected,result);
        assertTrue(GameLogic.end);
    }

    @Test
    public void clearBoardTest() {
        GameLogic.board[1][1] = 'X';
        GameLogic.clearBoard();
        assertEquals(' ', GameLogic.board[1][1]);
    }
}
