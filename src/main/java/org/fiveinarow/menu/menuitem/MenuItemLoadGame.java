package org.fiveinarow.menu.menuitem;

import org.fiveinarow.file.Save;
import org.fiveinarow.logic.Board;
import org.fiveinarow.logic.Game;
import org.jetbrains.annotations.NotNull;

/**
 * The {@link MenuItemLoadGame} class. Extension of {@link AbstractMenuItem}.
 */
public class MenuItemLoadGame extends AbstractMenuItem {

    private static final String DEFAULT_NUMBER = "2";
    private static final String DEFAULT_LABEL = "Load Game";

    /**
     * Static factory method for {@link MenuItemLoadGame} class.
     * It returns a new instance of {@link MenuItemLoadGame} class.
     *
     * @return new instance of {@link MenuItemLoadGame}
     */
    public static MenuItemLoadGame createWithDefaultNumberLabel() {
        return new MenuItemLoadGame(DEFAULT_NUMBER, DEFAULT_LABEL);
    }

    private MenuItemLoadGame(String number, String label) {
        super(number, label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        char[][] board = loadBoard();
        Game game = Game.createGameWithPlayerXAndOAndGivenBoard(Board.createBoard(board));
        game.play();
    }

    private char[][] loadBoard() {
        Save save = Save.createSaveWithDefaultSettings();
        String loadGame = save.loadGame();
        loadGame = loadGame.substring(1, loadGame.length() - 1);
        String[] rows = loadGame.split("],");
        int rowNumber = rows.length;
        char[][] board = new char[rowNumber][];
        int counter = 0;
        for (String row : rows) {
            row = row.replace("[", "");
            row = row.replace("]", "");
            String[] columns = row.split(",");
            char[] columnsChar = new char[columns.length];
            for (int i = 0; i < columns.length; i++) {
                columnsChar[i] = columns[i].charAt(0);
            }
            board[counter++] = columnsChar;
        }
        return board;
    }
}
