package org.fiveinarow.logic;

import org.fiveinarow.Tictactoe;

/**
 * The {@link Board} class. Represents the table where players play on.
 */
public class Board {

    private char[][] board;

    private int rowNumber;

    private int columnNumber;

    /**
     * Static factory method for {@link Board} class.
     * It returns a new instance of {@link Board} class.
     *
     * @return new instance of {@link Board}
     */
    public static Board createDefaultBoard() {
        return new Board();
    }

    public static Board createBoard(char[][] board) {
        return new Board(board);
    }

    private Board() {
        this.rowNumber = Integer.valueOf(Tictactoe.properties.getProperty("table.rowNumber"));
        this.columnNumber = Integer.valueOf(Tictactoe.properties.getProperty("table.columnNumber"));
        this.board = new char[rowNumber][columnNumber];
    }

    private Board(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }

    /**
     * Marks a field with symbol on the board.
     *
     * @param row    row number of the field
     * @param column column number of the field
     */
    public void markFieldOnBoard(int row, int column, char symbol) {
        board[row][column] = symbol;
    }
}
