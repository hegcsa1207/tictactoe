/*
 * Copyright (c) 2022 Csaba Hegedus.
 *
 * This project is developed to demonstrate java developer skills on a job interview.
 * Tic-tac-toe game is implemented in this project.
 */
package org.fiveinarow;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The {@link Tictactoe} class. The main method is implemented in this class.
 *
 * @author Csaba Hegedus
 */
public class Tictactoe {

    private static final String PROPERTIES_FILE_NAME = "tictactoe.properties";

    public static Properties properties;

    /**
     * The main method where the execution starts.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Tictactoe tictactoe = new Tictactoe();
        properties = new Properties();
        tictactoe.loadProperties();
        TictactoeApplication tictactoeApplication = TictactoeApplication.getInstance();
        tictactoeApplication.runApplication();
    }

    private void loadProperties() {
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME)) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
