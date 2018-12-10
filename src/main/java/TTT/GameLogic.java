package TTT;

public class GameLogic {
    public static char[][] board = new char[3][3];
    public static char lastMove = 'O';
    public static boolean end = false;
    public static int moves = 0;

    public static char nextPlayer() {
        if (lastMove == 'O') {
            lastMove = 'X';
            return 'X';
        } else {
            lastMove = 'O';
            return 'O';
        }

    }

    public static char currentPlayer() {
        return lastMove;
    }

    public static boolean isOccupied(int x, int y) {
        if (board[x][y] == 'X' || board[x][y] == 'O')
            return true;
        else
            return false;
    }

    public static char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer() && board[i][1] == currentPlayer() && board[i][2] == currentPlayer())
                end = true;
            if (board[0][i] == currentPlayer() && board[1][i] == currentPlayer() && board[2][i] == currentPlayer())
                end = true;
        }
        if (board[0][0] == currentPlayer() && board[1][1] == currentPlayer() && board[2][2] == currentPlayer())
            end = true;
        if (board[2][0] == currentPlayer() && board[1][1] == currentPlayer() && board[0][2] == currentPlayer())
            end = true;
        if (end)
            return currentPlayer();

        return 'N';
    }

    public static char move(int x, int y) {
        if (isOccupied(x, y))
            return 'N';
        board[x][y] = nextPlayer();
        checkWinner();
        moves++;
        return currentPlayer();
    }

    public static void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void restartGame() {
        clearBoard();
        end = false;
        lastMove = 'O';
        moves = 0;
    }
}
