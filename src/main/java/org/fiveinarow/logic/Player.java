package org.fiveinarow.logic;

/**
 * The {@link Player} class. Represents the player.
 */
public class Player {

    /**
     * SYMBOLX
     */
    private static char SYMBOLX = 'X';

    /**
     * SYMBOLO
     */
    private static char SYMBOLO = 'O';

    /**
     * Counter of winnings.
     */
    public static int winCounter = 0;

    private char symbol;

    /**
     * Static factory method for {@link Player} class.
     * It returns a new instance of {@link Player} class.
     * Player has symbol X.
     *
     * @return new instance of {@link Player}
     */
    public static Player createPlayerWithSymbolX() {
        return new Player(SYMBOLX);
    }

    /**
     * Static factory method for {@link Player} class.
     * It returns a new instance of {@link Player} class.
     * Player has symbol O.
     *
     * @return new instance of {@link Player}
     */
    public static Player createPlayerWithSymbolO() {
        return new Player(SYMBOLO);
    }

    private Player(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol.
     *
     * @return symbol of player
     */
    public char getSymbol() {
        return symbol;
    }
}
