package TTT;

import java.util.Random;

public class RandomAI {
    public static char randomMove(){
        int random = generateRandom();
        return GameLogic.move(random/3, random%3);
    }
    public static boolean isOccupied(int x) {
        if(GameLogic.board[x/3][x%3] == 'X' || GameLogic.board[x/3][x%3] == 'O'  )
            return true;
        return false;

    }
    public static int generateRandom() {
        Random random = new Random();
        int i;
        do {
            i = random.nextInt(9);
        }while (isOccupied(i));
        return i;
    }
}
