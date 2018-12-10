import org.junit.Test;
import TTT.RandomAI;
import TTT.GameLogic;

import static org.junit.Assert.*;

public class RandomAITests {
    @Test
    public void generateRandomTest(){
        int result = RandomAI.generateRandom();
        assertTrue(result>=0 && result <=8);
    }

    @Test
    public void isOccupiedPositiveTest(){
        GameLogic.board[1][1]='X';
        assertTrue(RandomAI.isOccupied(4));
        GameLogic.board[1][1]=' ';
    }

    @Test
    public void isOccupiedNegativeTest(){
        GameLogic.clearBoard();
        assertFalse(RandomAI.isOccupied(4));
    }

    @Test
    public void randomMoveNoWinnerTest() {
        GameLogic.clearBoard();
        GameLogic.move(1,1);

        assertEquals('O',RandomAI.randomMove());
        assertFalse(GameLogic.end);
        GameLogic.clearBoard();
    }

    @Test
    public void randomMoveWinnerTest() {
        GameLogic.clearBoard();
        GameLogic.move(0,0);
        GameLogic.board[0][1]='X';
        GameLogic.board[0][2]='O';
        GameLogic.board[1][0]='O';
        GameLogic.board[1][1]='O';
        GameLogic.board[2][1]='X';
        GameLogic.board[2][0]='X';
        GameLogic.board[2][2]='O';
        assertEquals('O',RandomAI.randomMove());
        assertTrue(GameLogic.end);
        GameLogic.clearBoard();
    }
}


