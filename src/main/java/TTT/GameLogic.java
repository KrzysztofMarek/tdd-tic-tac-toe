package TTT;

public class GameLogic {
    public static char[][] board = new char[3][3];
    private static char lastMove = 'O';

    public static char nextPlayer() {
        if(lastMove == 'O')
        {
            lastMove = 'O';
            return 'X';
        } else
        {
            lastMove = 'X';
            return 'O';
        }

    }

    public static char currentPlayer(){
        return lastMove;
    }

    public static boolean isOccupied(int x, int y) {
        if(board[x][y] == 'X' || board[x][y] == 'O')
            return true;
        else
            return false;
    }

    public static char checkWinner() {
        for(int i=0; i<3; i++)
        {
            if(board[i][0] == currentPlayer() && board[i][1] == currentPlayer() && board[i][2] == currentPlayer())
                return currentPlayer();
            if(board[0][i] == currentPlayer() && board[i][1] == currentPlayer() && board[i][2] == currentPlayer())
                return currentPlayer();
        }
        if(board[0][0] == currentPlayer() && board[1][1] == currentPlayer() && board[2][2] == currentPlayer())
            return currentPlayer();
        if(board[2][0] == currentPlayer() && board[1][1] == currentPlayer() && board[0][2] == currentPlayer())
            return currentPlayer();
        return 'N';
    }

}
