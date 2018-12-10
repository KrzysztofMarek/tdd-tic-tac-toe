package TTT;

public class SmartAI {
    public static int[] findWinningMove() {
        int checker = 0;
        int x = -1;
        int y = -1;
        for(int i=0; i<3; i++)
        {
            checker = 0;
            for(int j=0; j<3; j++)
            {
                if(GameLogic.board[i][j]=='O')
                    checker++;
                if(GameLogic.board[i][j]=='X')
                    checker--;
                if(GameLogic.board[i][j]==' '){
                    x=i;
                    y=j;
                }
            }
            if(checker == 2)
                return new int[] {x,y};

        }
        for(int i=0; i<3; i++)
        {
            checker = 0;
            for(int j=0; j<3; j++)
            {
                if(GameLogic.board[j][i]=='O')
                    checker++;
                if(GameLogic.board[j][i]=='X')
                    checker--;
                if(GameLogic.board[j][i]==' '){
                    x=j;
                    y=i;
                }
            }
            if(checker == 2)
                return new int[] {x,y};

        }
        checker=0;
        for(int i=0; i<3; i++)
        {
            if(GameLogic.board[i][i]=='O')
                checker++;
            if(GameLogic.board[i][i]=='X')
                checker--;
            if(GameLogic.board[i][i]==' '){
                x=i;
                y=i;
            }
        }
        if(checker == 2)
            return new int[] {x,y};
        checker=0;
        for(int i=0; i<3; i++)
        {
            if(GameLogic.board[i][2-i]=='O')
                checker++;
            if(GameLogic.board[i][2-i]=='X')
                checker--;
            if(GameLogic.board[i][2-i]==' '){
                x=i;
                y=2-i;
            }
        }
        if(checker == 2)
            return new int[] {x,y};

        return new int[] {-1, -1};
    }
    public static int[] findPreventingMove() {
        int checker = 0;
        int x = -1;
        int y = -1;
        for(int i=0; i<3; i++)
        {
            checker = 0;
            for(int j=0; j<3; j++)
            {
                if(GameLogic.board[i][j]=='O')
                    checker--;
                if(GameLogic.board[i][j]=='X')
                    checker++;
                if(GameLogic.board[i][j]==' '){
                    x=i;
                    y=j;
                }
            }
            if(checker == 2)
                return new int[] {x,y};

        }
        for(int i=0; i<3; i++)
        {
            checker = 0;
            for(int j=0; j<3; j++)
            {
                if(GameLogic.board[j][i]=='O')
                    checker--;
                if(GameLogic.board[j][i]=='X')
                    checker++;
                if(GameLogic.board[j][i]==' '){
                    x=j;
                    y=i;
                }
            }
            if(checker == 2)
                return new int[] {x,y};

        }
        checker=0;
        for(int i=0; i<3; i++)
        {
            if(GameLogic.board[i][i]=='O')
                checker--;
            if(GameLogic.board[i][i]=='X')
                checker++;
            if(GameLogic.board[i][i]==' '){
                x=i;
                y=i;
            }
        }
        if(checker == 2)
            return new int[] {x,y};
        checker=0;
        for(int i=0; i<3; i++)
        {
            if(GameLogic.board[i][2-i]=='O')
                checker--;
            if(GameLogic.board[i][2-i]=='X')
                checker++;
            if(GameLogic.board[i][2-i]==' '){
                x=i;
                y=2-i;
            }
        }
        if(checker == 2)
            return new int[] {x,y};

        return new int[] {-1, -1};
    }
    public static int[] findGoodMove() {
        int[] x = {1,0,0,2,2,0,1,1,2};
        int[] y = {1,0,2,0,2,1,0,2,1};
        for(int i=0; i<9; i++)
        {
            if(!GameLogic.isOccupied(x[i],y[i]))
                return new int[] {x[i],y[i]};
        }
        return new int[] {-10, -10};
    }
}
