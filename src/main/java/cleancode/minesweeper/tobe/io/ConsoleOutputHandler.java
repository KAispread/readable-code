package cleancode.minesweeper.tobe.io;

import cleancode.minesweeper.tobe.GameBoard;
import cleancode.minesweeper.tobe.GameException;
import cleancode.minesweeper.tobe.position.CellPosition;
import java.util.List;
import java.util.stream.IntStream;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void showGameStartComments() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("지뢰찾기 게임 시작!");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void showBoard(final GameBoard gameBoard) {
        String joiningAlphabets = generateAlphabets(gameBoard);

        System.out.println("    " + joiningAlphabets);
        for (int row = 0; row < gameBoard.getRowSize(); row++) {
            System.out.printf("%2d  ", row + 1);
            for (int col = 0; col < gameBoard.getColSize(); col++) {
                System.out.print(gameBoard.getSign(CellPosition.of(row, col)) + " ");
            }
            System.out.println();
        }
    }

    private String generateAlphabets(GameBoard gameBoard) {
        List<String> alphabets = IntStream.range(0, gameBoard.getColSize())
            .mapToObj(index -> (char) ('a' + index))
            .map(Object::toString)
            .toList();
        return String.join(" ", alphabets);
    }

    @Override
    public void showGameWinningComments() {
        System.out.println("지뢰를 모두 찾았습니다. GAME CLEAR!");
    }

    @Override
    public void showGameLosingComments() {
        System.out.println("지뢰를 밟았습니다. GAME OVER!");
    }

    @Override
    public void showCommentsForSelectingCell() {
        System.out.println();
        System.out.println("선택할 좌표를 입력하세요. (예: a1)");
    }

    @Override
    public void showCommentsForUserAction() {
        System.out.println("선택한 셀에 대한 행위를 선택하세요. (1: 오픈, 2: 깃발 꽂기)");
    }

    @Override
    public void showExceptionMessage(GameException exception) {
        System.out.println(exception.getMessage());
    }

    @Override
    public void showSimpleMessage(String message) {
        System.out.println(message);
    }
}
