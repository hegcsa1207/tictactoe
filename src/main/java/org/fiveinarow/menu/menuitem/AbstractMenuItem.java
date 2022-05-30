package org.fiveinarow.menu.menuitem;

/**
 * Abstract class for menu items.
 */
public abstract class AbstractMenuItem {

    final private String number;
    final private String label;

    protected AbstractMenuItem(String number, String label) {
        this.number = number;
        this.label = label;
    }

    /**
     * Returns the number.
     *
     * @return the number of the menu item
     */
    public String getNumber() {
        return number;
    }

    /**
     * Returns the label.
     *
     * @return the label of the menu item
     */
    public String getLabel() {
        return label;
    }

    /**
     * Implementation of the function of the menu item.
     */
    public abstract void execute();
}
