package org.fiveinarow.ui;

import org.fiveinarow.logic.Board;

/**
 * The {@link BoardUIComponent} class. To display board on console.
 */
public class BoardUIComponent {

    private Board board;

    /**
     * Constructor of {@link BoardUIComponent}.
     *
     * @param board
     */
    public BoardUIComponent(Board board) {
        this.board = board;
    }

    /**
     * Draws the board on the console.
     */
    public void drawBoard() {
        char[][] board = this.board.getBoard();
        int columnNumber = board[0].length;
        drawTopRow(columnNumber);
        for (int i = 1; i <= board.length; i++) {
            BoardRowPicture boardRowPicture = new BoardRowPicture(board[i - 1], i);
            System.out.println(boardRowPicture.getLine());
        }
        drawBottomMargin(columnNumber);
    }

    /**
     * Requests the number of row for the following step.
     *
     * @return number of row
     */
    public String requestRow(char symbol) {
        System.out.print("Player " + symbol + ": Please give the number of row for the following step: ");
        return InputFromConsole.scanner.nextLine();
    }

    /**
     * Requests the number of column for the following step.
     *
     * @return number of column
     */
    public String requestColumn(char symbol) {
        System.out.print("Player " + symbol + ": Please give the number of column for the following step: ");
        return InputFromConsole.scanner.nextLine();
    }

    public void displayCongratulationMessage(char winner) {
        System.out.println("Congratulation to Player " + winner + ". You won the game.");
    }

    private void drawTopRow(int columnNumber) {
        StringBuilder result = new StringBuilder("|   |");
        for (int i = 1; i <= columnNumber; i++) {
            String columnNumberText = i < 10 ? " " + i + ".|" : i + ".|";
            result.append(columnNumberText);
        }
        System.out.println(result.toString());
    }

    private void drawBottomMargin(int columnNumber) {
        StringBuilder result = new StringBuilder("+---");
        for (int i = 1; i <= columnNumber; i++) {
            result.append("+---");
        }
        result.append("+");
        System.out.println(result.toString());
    }

    private class BoardRowPicture {

        private static final String SYMBOL_VERTICAL = "+---";

        private static final String SYMBOL_HORIZONTAL = "|   ";

        private StringBuilder lineWithSymbolVertical;

        private StringBuilder lineWithSymbolHorizontal;

        public BoardRowPicture(char[] row, int rowNumber) {
            this.lineWithSymbolVertical = new StringBuilder(SYMBOL_VERTICAL);
            String columnNumberText = rowNumber < 10 ? "| " + rowNumber + "." : "|" + rowNumber + ".";
            this.lineWithSymbolHorizontal = new StringBuilder(columnNumberText);
            initLines(row);
        }

        /**
         * Returns a row. It is created from lineWithSymbolVertical and lineWithSymbolHorizontal.
         *
         * @return row
         */
        public String getLine() {
            return lineWithSymbolVertical.toString() + "\n" + lineWithSymbolHorizontal.toString();
        }

        private void initLines(char[] row) {
            for (char item : row) {
                lineWithSymbolVertical.append(SYMBOL_VERTICAL);
                String text = Character.MIN_VALUE == item ? SYMBOL_HORIZONTAL : "| " + item + " ";
                lineWithSymbolHorizontal.append(text);
            }
            lineWithSymbolVertical.append("+");
            lineWithSymbolHorizontal.append("|");
        }
    }
}
