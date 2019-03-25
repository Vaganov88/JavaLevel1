import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class TicTacToeController
{


    private final String  STATUS_START        = "X moves to start the game";
    private final String  STATUS_CATS         = "Cat's game";
    private final String  STATUS_X_WINS       = "X wins the game!";
    private final String  STATUS_O_WINS       = "O wins the game!";
    private final String  STATUS_X_MOVES      = "X to move";
    private final String  STATUS_O_MOVES      = "O to move";
    private final String  STATUS_CP_MOVES     = "Computer is thinking...";
    private final String  OPPONENT_MODE_2P    = "2 player";
    private final String  OPPONENT_MODE_EASY  = "Computer Easy";
    private final String  OPPONENT_MODE_HARD  = "Computer Hard";



    private TicTacToeView  view;
    private TicTacToeModel model;


    public TicTacToeController( TicTacToeView view, TicTacToeModel model )
    {
        this.view = view;
        this.model = model;

        this.view.addGameBoardSquareButtonListener( new SquareListener() );
        this.view.addGameBoardSquareButtonHoverListener( new SquareHoverListener() );
        this.view.addNewGameButtonListener( new NewGameListener() );
        this.view.addOpponentModeButtonListener( new OpponentModeListener() );
    }


    private class SquareListener implements ActionListener
    {

        private boolean blockMove = false;

        @Override
        public void actionPerformed( ActionEvent e )
        {
            if ( !blockMove ) {
                String gameStatus;
                JButton square = (JButton) e.getSource();
                int row = (int) square.getClientProperty("row");
                int col = (int) square.getClientProperty("col");


                if ( model.gameIsComplete() ) return;
                if ( model.squareHasBeenPlayed( row, col )) return;


                model.makeMoveInSquare( row, col );


                if ( model.computerIsOpponent() ) {
                    gameStatus = STATUS_CP_MOVES;
                } else if ( model.getPlayerToMove() == 'x' ) {
                    gameStatus = STATUS_X_MOVES;
                } else {
                    gameStatus = STATUS_O_MOVES;
                }


                if ( model.gameIsComplete() ) {
                    if ( model.getGameWinner() == ' ' ) gameStatus = STATUS_CATS;
                    if ( model.getGameWinner() == 'x' ) gameStatus = STATUS_X_WINS;
                    if ( model.getGameWinner() == 'o' ) gameStatus = STATUS_O_WINS;
                }


                view.updateGameStatusLabelText( gameStatus );
                view.updateGameBoardUI( model.getGameBoard() );
                performWinLineUpdates();


                if ( !model.gameIsComplete() && model.getPlayerToMove() == 'o' && model.computerIsOpponent())
                    computerMove();

            }
        }
        private void computerMove()
        {
            blockMove = true;
            model.computerMove();


            java.util.Timer timer = new java.util.Timer();
            timer.schedule( new java.util.TimerTask() {
                @Override
                public void run() {
                    String gameStatus;
                    gameStatus = STATUS_X_MOVES;
                    if ( model.gameIsComplete() ) {
                        if ( model.getGameWinner() == ' ' ) gameStatus = STATUS_CATS;
                        if ( model.getGameWinner() == 'o' ) gameStatus = STATUS_O_WINS;
                    }
                    view.updateGameStatusLabelText( gameStatus );
                    view.updateGameBoardUI( model.getGameBoard() );
                    performWinLineUpdates();
                    blockMove = false;
                }
            }, 750 );

        }
        private void performWinLineUpdates()
        {
            if ( model.gameIsComplete() && model.getGameWinner() != ' ' ) {
                int row1 = model.getWinPath().getStartRow();
                int col1 = model.getWinPath().getStartCol();
                int row2 = model.getWinPath().getEndRow();
                int col2 = model.getWinPath().getEndCol();
                view.updateWinnerLine( row1, col1, row2, col2 );
            }
        }

    }
    private class SquareHoverListener extends MouseAdapter {

        @Override
        public void mouseEntered( MouseEvent e ) {
            JButton square = (JButton) e.getSource();
            int row = (int) square.getClientProperty("row");
            int col = (int) square.getClientProperty("col");
            if ( !model.gameIsComplete() && !model.squareHasBeenPlayed(row, col) ) {
                view.updateSquareUIForHoverState( row, col );
            }
        }

        @Override
        public void mouseExited( MouseEvent e ) {
            JButton square = (JButton) e.getSource();
            int row = (int) square.getClientProperty("row");
            int col = (int) square.getClientProperty("col");
            view.updateSquareUIForNormalState( row, col );
        }

    }


    class NewGameListener implements ActionListener
    {
        @Override
        public void actionPerformed( ActionEvent e )
        {
            model.startNewGame();
            view.resetWinnerLine();
            view.updateGameBoardUI( model.getGameBoard() );
            view.updateGameStatusLabelText( STATUS_START );
        }

    }
    class OpponentModeListener implements ActionListener
    {
        @Override
        public void actionPerformed( ActionEvent e )
        {

            if ( !model.computerIsOpponent() ) {
                model.setComputerIsOpponent( true );
                model.setComputerIsDifficult( false );
                view.updateOpponentModeLabelText( OPPONENT_MODE_EASY );
            }

            else if ( model.computerIsOpponent() && !model.computerIsDifficult() ) {
                model.setComputerIsDifficult( true );
                view.updateOpponentModeLabelText( OPPONENT_MODE_HARD );
            }

            else
            {
                model.setComputerIsOpponent( false );
                view.updateOpponentModeLabelText( OPPONENT_MODE_2P );
            }

            model.startNewGame();
            view.resetWinnerLine();
            view.updateGameBoardUI( model.getGameBoard() );
            view.updateGameStatusLabelText( STATUS_START );
        }

    }

}