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
}


