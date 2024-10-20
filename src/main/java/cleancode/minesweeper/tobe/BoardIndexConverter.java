package cleancode.minesweeper.tobe;

public class BoardIndexConverter {

    private final char BASE_CHAR_FOR_COL = 'a';

    public int getSelectedColIndex(String cellInput, int colSize) {
        char cellInputCol = cellInput.charAt(0);
        return convertColumFrom(cellInputCol, colSize);
    }

    public int getSelectedRowIndex(String cellInput, int rowSize) {
        String cellInputRow = cellInput.substring(1);
        return convertRowFrom(cellInputRow, rowSize);
    }

    private int convertRowFrom(String cellInputRow, int rowSize) {
        int rowIndex = Integer.parseInt(cellInputRow) - 1;
        if (rowIndex < 0 || rowIndex >= rowSize) {
            throw new GameException("입력된 행 값이 유효하지 않습니다.");
        }

        return rowIndex;
    }

    private int convertColumFrom(char cellInputCol, int colSize) {
        int colIndex = cellInputCol - BASE_CHAR_FOR_COL;
        if (colIndex < 0 || colIndex >= colSize) {
            throw new GameException("입력된 열 값이 유효하지 않습니다.");
        }

        return colIndex;
    }
}
