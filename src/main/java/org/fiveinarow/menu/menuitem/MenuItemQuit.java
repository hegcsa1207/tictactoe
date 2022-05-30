package org.fiveinarow.menu.menuitem;

/**
 * The {@link MenuItemQuit} class. Extension of {@link AbstractMenuItem}.
 */
public class MenuItemQuit extends AbstractMenuItem {

    private static final String DEFAULT_NUMBER = "3";
    private static final String DEFAULT_LABEL = "Quit";

    /**
     * Static factory method for {@link MenuItemQuit} class.
     * It returns a new instance of {@link MenuItemQuit} class.
     *
     * @return new instance of {@link MenuItemQuit}
     */
    public static MenuItemQuit createWithDefaultNumberLabel() {
        return new MenuItemQuit(DEFAULT_NUMBER, DEFAULT_LABEL);
    }

    private MenuItemQuit(String number, String label) {
        super(number, label);
    }

    /**
     * {@inheritDoc}
     * Prints a thank you message and exits.
     */
    @Override
    public void execute() {
        System.out.println("Thank you for playing with us. We hope you enjoyed the game.");
        System.exit(0);
    }
}
