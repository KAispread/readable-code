package cleancode.minesweeper.tobe.io;

import cleancode.minesweeper.tobe.GameBoard;
import cleancode.minesweeper.tobe.GameException;

public interface OutputHandler {

    void showGameStartComments();

    void showBoard(final GameBoard gameBoard);

    void showGameWinningComments();

    void showGameLosingComments();

    void showCommentsForSelectingCell();

    void showCommentsForUserAction();

    void showExceptionMessage(GameException exception);

    void showSimpleMessage(String message);
}
