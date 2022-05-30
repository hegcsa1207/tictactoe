package org.fiveinarow.menu.menuitem;

import org.fiveinarow.logic.Game;

/**
 * The {@link MenuItemNewGame} class. Extension of {@link AbstractMenuItem}.
 */
public class MenuItemNewGame extends AbstractMenuItem {

    private static final String DEFAULT_NUMBER = "1";
    private static final String DEFAULT_LABEL = "New Game";

    /**
     * Static factory method for {@link MenuItemNewGame} class.
     * It returns a new instance of {@link MenuItemNewGame} class.
     *
     * @return new instance of {@link MenuItemNewGame}
     */
    public static MenuItemNewGame createWithDefaultNumberLabel() {
        return new MenuItemNewGame(DEFAULT_NUMBER, DEFAULT_LABEL);
    }

    private MenuItemNewGame(String number, String label) {
        super(number, label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        Game game = Game.createDefaultGameWithPlayerXAndO();
        game.play();
    }
}
