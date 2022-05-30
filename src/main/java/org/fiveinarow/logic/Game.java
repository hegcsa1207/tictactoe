package org.fiveinarow.logic;

import org.fiveinarow.Tictactoe;
import org.fiveinarow.file.Save;
import org.fiveinarow.ui.BoardUIComponent;

import java.util.Arrays;

public class Game {

    private static char currentSymbol;

    final private Board board;

    final private BoardUIComponent boardUIComponent;

    final private Player playerX;

    final private Player playerO;

    /**
     * Static factory method for {@link Game} class.
     * It returns a new instance of {@link Game} class.
     *
     * @return new instance of {@link Game}
     */
    public static Game createDefaultGameWithPlayerXAndO() {
        return new Game(Board.createDefaultBoard());
    }

    /**
     * Static factory method for {@link Game} class.
     * It returns a new instance of {@link Game} class.
     *
     * @param board board
     * @return new instance of {@link Game}
     */
    public static Game createGameWithPlayerXAndOAndGivenBoard(Board board) {
        return new Game(board);
    }

    private Game(Board board) {
        this.board = board;
        this.boardUIComponent = new BoardUIComponent(board);
        playerX = Player.createPlayerWithSymbolX();
        playerO = Player.createPlayerWithSymbolO();
        currentSymbol = playerX.getSymbol();
    }

    public void play() {
        char winner = Character.MIN_VALUE;
        while (winner == Character.MIN_VALUE) {
            boardUIComponent.drawBoard();
            String nextStepRowFromConsole = boardUIComponent.requestRow(currentSymbol);
            if (save(nextStepRowFromConsole)) {
                continue;
            }
            String nextStepColumnFromConsole = boardUIComponent.requestColumn(currentSymbol);
            if (save(nextStepColumnFromConsole)) {
                continue;
            }
            int nextStepRow = Integer.parseInt(nextStepRowFromConsole);
            int nextStepColumn = Integer.parseInt(nextStepColumnFromConsole);
            board.markFieldOnBoard(nextStepRow - 1, nextStepColumn - 1, currentSymbol);
            switchCurrentSymbol();
            winner = checkWinner();
        }
        boardUIComponent.displayCongratulationMessage(winner);
    }

    private boolean save(String command) {
        boolean result = false;
        if (command.equals(Tictactoe.properties.getProperty("game.saveCommand"))) {
            String boardAsString = Arrays.deepToString(board.getBoard());
            Save save = Save.createSaveWithDefaultSettings();
            save.saveGame(boardAsString);
            result = true;
        }
        return result;
    }


    private char checkWinner() {
        char winner = Character.MIN_VALUE;
        char symbol = playerX.getSymbol();
        int counter = 0;
        char[][] board = this.board.getBoard();
        int tableWin = Integer.parseInt(Tictactoe.properties.getProperty("table.win"));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (symbol != Character.MIN_VALUE) {
                    if (board[i][j] == symbol) {
                        counter++;
                        if (counter == tableWin) {
                            winner = symbol;
                            break;
                        }
                    } else {
                        symbol = board[i][j];
                        counter = 0;
                    }
                }
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (symbol != Character.MIN_VALUE) {
                    if (board[i][j] == symbol) {
                        counter++;
                        if (counter == tableWin) {
                            winner = symbol;
                            break;
                        }
                    } else {
                        symbol = board[i][j];
                        counter = 0;
                    }
                }
            }
        }

        return winner;
    }

    private void switchCurrentSymbol() {
        currentSymbol = currentSymbol == playerX.getSymbol() ? playerO.getSymbol() : playerX.getSymbol();
    }
}
