package org.fiveinarow;

import org.fiveinarow.menu.Menu;

/**
 * The {@link TictactoeApplication} class.
 */
public class TictactoeApplication {

    private static final String WELCOME_MESSAGE = "Welcome to the Five In A Row game! Good luck!";

    private static TictactoeApplication instance;

    final private Menu menu;

    /**
     * Returns the only object available. If the object doesn't exist then it will be instantiated first.
     *
     * @return intance of {@link TictactoeApplication}
     */
    public static TictactoeApplication getInstance() {
        if (instance == null) {
            instance = new TictactoeApplication();
        }
        return instance;
    }

    private TictactoeApplication() {
        this.menu = Menu.createMenu();
    }

    /**
     * Runs the application.
     * Prints the welcome message. Hanles the menu.
     */
    public void runApplication() {
        printWelcomeMessage();
        while (true) {
            menu.printMenuItems();
            menu.chooseMenuItem();
        }
    }

    private void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }
}
