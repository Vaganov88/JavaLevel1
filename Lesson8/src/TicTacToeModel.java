import java.util.Random;

public class TicTacToeModel
{
    private char      playerToMove;
    private boolean   computerIsOpponent;
    private boolean   computerIsDifficult;
    private char[][]  gameBoard = new char[3][3];
    private int       moveCount;
    private boolean   gameIsComplete;
    private char      gameWinner;
    private WinPath   winPath = new WinPath();


    public class WinPath
    {
        private int startRow;
        private int startCol;
        private int endRow;
        private int endCol;

        public int getStartRow() { return startRow; }
        public int getStartCol() { return startCol; }
        public int getEndRow()   { return endRow; }
        public int getEndCol()   { return endCol; }
        public void setPath( int startRow, int startCol, int endRow, int endCol )
        {
            this.startRow = startRow;
            this.startCol = startCol;
            this.endRow = endRow;
            this.endCol = endCol;
        }
    }

    public char[][] getGameBoard()        { return gameBoard; }
    public boolean  computerIsOpponent()  { return computerIsOpponent; }
    public boolean  computerIsDifficult() { return computerIsDifficult; }
    public char     getPlayerToMove()     { return playerToMove; }
    public boolean  gameIsComplete()      { return gameIsComplete; }
    public char     getGameWinner()       { return gameWinner; }
    public WinPath  getWinPath()          { return winPath; }

    public void setComputerIsOpponent ( boolean trueForComputerMode )
    {
        computerIsOpponent = trueForComputerMode;
    }

    public void setComputerIsDifficult ( boolean trueForDifficult )
    {
        computerIsDifficult = trueForDifficult;
    }

    public TicTacToeModel()
    {
        startNewGame( false );
    }


    public void startNewGame()
    {
        playerToMove = 'x';
        moveCount = 0;
        gameWinner = ' ';
        gameIsComplete = false;
        resetGameBoard();
    }


    public void startNewGame( boolean trueForComputerMode )
    {
        computerIsOpponent = trueForComputerMode;
        startNewGame();
    }


    private void resetGameBoard()
    {
        for ( int i = 0; i < 3; i++ ) {
            for ( int j = 0; j < 3; j++ ) {
                gameBoard[i][j] = ' ';
            }
        }
    }


    public boolean squareHasBeenPlayed( int row, int col )
    {
        return gameBoard[row][col] != 'x' && gameBoard[row][col] != 'o' ? false : true;
    }


    public void makeMoveInSquare( int row, int col )
    {
        gameBoard[row][col] = playerToMove;

        if ( playerToMove == 'x' )
            playerToMove = 'o';
        else if ( playerToMove == 'o' )
            playerToMove = 'x';

        performWinCheck();
        ++moveCount;
        if ( moveCount == 9 ) gameIsComplete = true;
    }


    public void performWinCheck()
    {
        if ( rowWins() || colWins() || diagWins() ) gameIsComplete = true;
    }

    private boolean rowWins()
    {
        for ( int i = 0; i < 3; i++ ) {
            int xCount = 0, oCount = 0;
            for ( int j = 0; j < 3; j++ ) {
                if ( gameBoard[i][j] == 'x' ) ++xCount;
                if ( gameBoard[i][j] == 'o' ) ++oCount;
            }
            if ( xCount == 3 || oCount == 3 ) {
                if ( xCount == 3 ) gameWinner = 'x';
                if ( oCount == 3 ) gameWinner = 'o';
                winPath.setPath( i, 0, i, 2);
                return true;
            }
        }
        return false;
    }
    private boolean colWins()
    {
        for ( int i = 0; i < 3; i++ ) {
            int xCount = 0, oCount = 0;
            for ( int j = 0; j < 3; j++ ) {
                if ( gameBoard[j][i] == 'x' ) ++xCount;
                if ( gameBoard[j][i] == 'o' ) ++oCount;
            }
            if ( xCount == 3 || oCount == 3 ) {
                if ( xCount == 3 ) gameWinner = 'x';
                if ( oCount == 3 ) gameWinner = 'o';
                winPath.setPath( 0, i, 2, i);
                return true;
            }
        }
        return false;
    }
    private boolean diagWins()
    {
        if ( gameBoard[0][0] == 'x' && gameBoard[1][1] == 'x' && gameBoard[2][2] == 'x' ) {
            gameWinner = 'x';
            winPath.setPath( 0, 0, 2, 2 );
            return true;
        } else if  ( gameBoard[2][0] == 'x' && gameBoard[1][1] == 'x' && gameBoard[0][2] == 'x' ) {
            gameWinner = 'x';
            winPath.setPath( 0, 2, 2, 0 );
            return true;
        } else if  ( gameBoard[0][0] == 'o' && gameBoard[1][1] == 'o' && gameBoard[2][2] == 'o' ) {
            gameWinner = 'o';
            winPath.setPath( 0, 0, 2, 2 );
            return true;
        } else if  ( gameBoard[2][0] == 'o' && gameBoard[1][1] == 'o' && gameBoard[0][2] == 'o' ) {
            gameWinner = 'o';
            winPath.setPath( 0, 2, 2, 0 );
            return true;
        } else {
            return false;
        }
    }
    public void computerMove()
    {
        Random rgen = new Random();
        if ( playWin() ) return;
        if ( computerIsDifficult() ) {
            if ( blockWin() ) return;
        }
        if ( !computerIsDifficult() && rgen.nextBoolean() ) {
            if ( blockWin() ) return;
        }
        if ( computerIsDifficult() ) {
            if ( preventForkScenarios() ) return;
        }
        if ( !computerIsDifficult() && rgen.nextBoolean() ) {
            if ( preventForkScenarios() ) return;
        }
        if ( playCenter() ) return;
        if ( playOppositeCorner() ) return;
        if ( playEmptyCorner() ) return;
        playEmptySide();
    }

    private boolean playWin()
    {
        return playThirdInSequenceOfTwo('o') ? true : false;
    }

    private boolean blockWin()
    {
        return playThirdInSequenceOfTwo('x') ? true : false;
    }


    private boolean playThirdInSequenceOfTwo( char playedBy )
    {
        if ( moveCount < 3 ) return false;
        for ( int i = 0; i < 3; i++ ) {
            int count = 0, emptyCount = 0;
            for ( int j = 0; j < 3; j++ ) {
                if ( gameBoard[i][j] == playedBy ) ++count;
                if ( gameBoard[i][j] == ' ' ) ++emptyCount;
            }
            if ( count == 2 && emptyCount == 1 ) {
                for ( int j = 0; j < 3; j++ ) {
                    if ( gameBoard[i][j] == ' ' ) makeMoveInSquare( i, j );
                }
                return true;
            }
        }
        for ( int i = 0; i < 3; i++ ) {
            int count = 0, emptyCount = 0;
            for ( int j = 0; j < 3; j++ ) {
                if ( gameBoard[j][i] == playedBy ) ++count;
                if ( gameBoard[j][i] == ' ' ) ++emptyCount;
            }
            if ( count == 2 && emptyCount == 1 ) {
                for ( int j = 0; j < 3; j++ ) {
                    if ( gameBoard[j][i] == ' ' ) makeMoveInSquare( j, i );
                }
                return true;
            }
        }
        int count = 0, emptyCount = 0;
        for ( int i = 0, j = 0; i < 3; ++i, ++j )
        {
            if ( gameBoard[i][j] == playedBy ) ++count;
            if ( gameBoard[i][j] == ' ' ) ++emptyCount;
            if ( count == 2 && emptyCount == 1 ) {
                if ( gameBoard[0][0] == ' ' ) makeMoveInSquare( 0, 0 );
                if ( gameBoard[1][1] == ' ' ) makeMoveInSquare( 1, 1 );
                if ( gameBoard[2][2] == ' ' ) makeMoveInSquare( 2, 2 );
                return true;
            }
        }
        count = 0; emptyCount = 0;
        for ( int i = 0, j = 2; i < 3; i++, j-- )
        {
            if ( gameBoard[i][j] == playedBy ) ++count;
            if ( gameBoard[i][j] == ' ' ) ++emptyCount;
            if ( count == 2 && emptyCount == 1 ) {
                if ( gameBoard[2][0] == ' ' ) makeMoveInSquare( 2, 0 );
                if ( gameBoard[1][1] == ' ' ) makeMoveInSquare( 1, 1 );
                if ( gameBoard[0][2] == ' ' ) makeMoveInSquare( 0, 2 );
                return true;
            }
        }

        return false;
    }
    private boolean preventForkScenarios()
    {
        if ( moveCount == 3 ) {
            if ( gameBoard[0][0] == 'x' && gameBoard[1][1] == 'o' && gameBoard[2][2] == 'x' ) {
                playEmptySide();
                return true;
            }
            if ( gameBoard[2][0] == 'x' && gameBoard[1][1] == 'o' && gameBoard[0][2] == 'x' ) {
                playEmptySide();
                return true;
            }
            if ( gameBoard[2][1] == 'x' && gameBoard[1][2] == 'x' ) {
                makeMoveInSquare( 2, 2 );
                return true;
            }
        }
        return false;
    }


    private boolean playCenter()
    {
        if ( gameBoard[1][1] == ' ' ) {
            makeMoveInSquare( 1, 1 );
            return true;
        }
        return false;
    }


    private boolean playOppositeCorner()
    {
        if ( gameBoard[0][0] == 'x' && gameBoard[2][2] == ' ' ) {
            makeMoveInSquare( 2, 2 );
            return true;
        } else if ( gameBoard[2][2] == 'x' && gameBoard[0][0] == ' ' ) {
            makeMoveInSquare( 0, 0 );
            return true;
        } else if ( gameBoard[0][2] == 'x' && gameBoard[2][0] == ' ' ) {
            makeMoveInSquare( 2, 0 );
            return true;
        } else if ( gameBoard[2][0] == 'x' && gameBoard[0][2] == ' ' ) {
            makeMoveInSquare( 0, 2 );
            return true;
        }
        return false;
    }


    private boolean playEmptyCorner()
    {
        if ( gameBoard[0][0] == ' ' ) {
            makeMoveInSquare( 0, 0 );
            return true;
        } else if ( gameBoard[0][2] == ' ' ) {
            makeMoveInSquare( 0, 2 );
            return true;
        } else if ( gameBoard[2][0] == ' ' ) {
            makeMoveInSquare( 2, 0 );
            return true;
        } else if ( gameBoard[2][2] == ' ' ) {
            makeMoveInSquare( 2, 2 );
            return true;
        }
        return false;
    }


    private void playEmptySide()
    {
        if ( gameBoard[0][1] == ' ' ) {
            makeMoveInSquare( 0, 1 );
        } else if ( gameBoard[1][0] == ' ' ) {
            makeMoveInSquare( 1, 0 );
        } else if ( gameBoard[1][2] == ' ' ) {
            makeMoveInSquare( 1, 2 );
        } else if ( gameBoard[2][1] == ' ' ) {
            makeMoveInSquare( 2, 1 );
        }
    }

} 