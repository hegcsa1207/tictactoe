package org.fiveinarow.file;

import org.fiveinarow.Tictactoe;
import org.fiveinarow.menu.menuitem.MenuItemNewGame;

import java.io.*;
import java.nio.file.Paths;

public class Save {

    public static final String SEPARATOR = "\\";
    private String dir;

    private String fileName;

    public static Save createSaveWithDefaultSettings() {
        return new Save();
    }

    private Save() {
        this.dir = Paths.get("").toAbsolutePath().toString() + SEPARATOR +
                Tictactoe.properties.getProperty("save.dirName") + SEPARATOR;
        this.fileName = Tictactoe.properties.getProperty("save.fileName");
    }

    public void saveGame(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.dir + this.fileName))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadGame() {
        String game = "";
        String file = this.dir + this.fileName;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            game = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return game;
    }
}
