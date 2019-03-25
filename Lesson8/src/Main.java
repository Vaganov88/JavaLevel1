public class Main {


    public static void main( String[] args )
    {
        TicTacToeView view = new TicTacToeView();
        TicTacToeModel model = new TicTacToeModel();
        @SuppressWarnings("unused")
        TicTacToeController controller = new TicTacToeController( view, model );
        view.setVisible( true );
    }

}
