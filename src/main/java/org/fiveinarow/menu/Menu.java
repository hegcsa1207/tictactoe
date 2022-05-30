package org.fiveinarow.menu;

import org.fiveinarow.menu.menuitem.AbstractMenuItem;
import org.fiveinarow.menu.menuitem.MenuItemLoadGame;
import org.fiveinarow.menu.menuitem.MenuItemNewGame;
import org.fiveinarow.menu.menuitem.MenuItemQuit;
import org.fiveinarow.ui.InputFromConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * The {@link Menu} class. Represents the menu of the application.
 */
public class Menu {

    private final List<AbstractMenuItem> menu;

    /**
     * Static factory method for {@link Menu} class.
     * It returns a new instance of {@link Menu} class.
     * The created menu contains menu items.
     *
     * @return new instance of {@link Menu}
     */
    public static Menu createMenu() {
        return new Menu();
    }

    private Menu() {
        this.menu = new ArrayList<>();
        addMenuItems();
    }

    /**
     * Prints the menu items.
     */
    public void printMenuItems() {
        menu.forEach(this::printMenuItem);
    }

    /**
     * Provides the possibility of choosing a menu item.
     */
    public void chooseMenuItem() {
        System.out.print("Please choose a menu item and press ENTER! ");
        String numberOfMenuItemByUser = InputFromConsole.scanner.nextLine();
        Optional<AbstractMenuItem> chosenMenuItem = menu.stream().filter(menuItem ->
                numberOfMenuItemByUser.equals(menuItem.getNumber())
        ).findFirst();
        chosenMenuItem.ifPresentOrElse(this::executeMenuItem, this::printIncorrectMenuItem);
    }

    private void printMenuItem(AbstractMenuItem menuItem) {
        System.out.println(menuItem.getNumber() + ". " + menuItem.getLabel());
    }

    private void executeMenuItem(AbstractMenuItem menuItem) {
        menuItem.execute();
    }

    private void printIncorrectMenuItem() {
        System.out.println("The menu item, you've chosen, doesn't exist.");
    }

    private void addMenuItems() {
        menu.add(MenuItemNewGame.createWithDefaultNumberLabel());
        menu.add(MenuItemLoadGame.createWithDefaultNumberLabel());
        menu.add(MenuItemQuit.createWithDefaultNumberLabel());
    }
}
