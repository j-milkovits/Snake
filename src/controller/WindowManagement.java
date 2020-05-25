package controller;

import javax.swing.*;
import java.awt.Color;

public class WindowManagement {


    private static view.StartScreen startScreen;
    private static view.GameScreen gameScreen;
    private static view.GamePlayScreen gamePlayScreen;
    private static view.GameControlScreen gameControlScreen;
    private static view.GameOverScreen gameOverScreen;
    private static view.SettingsScreen settingsScreen;
    private static int delay = 100;

    // variables for settingsScreen (saving the settings here)

    private static boolean isDarkModeOn = false;
    private static int snakeColorRed = 128;
    private static int snakeColorGreen = 255;
    private static int snakeColorBlue = 0;


    /**
     * Opens a new StartScreen, called by main method
     */
    public static void openStartScreen(){
        WindowManagement.startScreen = new view.StartScreen(300,300);
    }

    /**
     * Closes the start screen and opens the gamescreen, also creates a timeManager-Object
     * This method gets called by the startButton in view.StartScreen
     * @param startScreen
     */
    public static void startScreenToGameScreen(){
        WindowManagement.startScreen.setVisible(false);
        if (WindowManagement.settingsScreen != null){
            WindowManagement.settingsScreen.setVisible(false); // Disables settingsScreen when ingame
        }
        

        WindowManagement.gamePlayScreen = new view.GamePlayScreen(800, 800, 32, 32);
        WindowManagement.gameControlScreen = new view.GameControlScreen();
        WindowManagement.gameScreen = new view.GameScreen(800, 900, gamePlayScreen, gameControlScreen);

        new Thread(new TimeFlow(delay)).start(); // Starts the TimeFlow Thread
    }

    /**
     * Closes the game screen and opens a new start screen
     * This method gets called by the menuButton in GameControlScreen
     * @param gameScreen
     */
    public static void gameScreenToStartScreen(){
        WindowManagement.gameScreen.setVisible(false);

        WindowManagement.startScreen = new view.StartScreen(300,300);

        TimeFlow.stopThread(); // Stops the TimeFlow Thread
    }


    /**
     * Gets called when a game over happens
     * Stops the thread and opens a GameOverScreen
     * @param score
     */
    public static void gameOverScreen(int score){
        gameOverScreen = new view.GameOverScreen(500, 75, score);
        controller.TimeFlow.stopThread();
    }

    /**
     * Disables GameScreen and GameOverScreen and opens new StartScreen
     */
    public static void gameScreenAndGameOverScreenToStartScreen(){
        gameOverScreen.setVisible(false);
        gameScreen.setVisible(false);

        WindowManagement.startScreen = new view.StartScreen(300,300);
    }


    /**
     * Disable GameOverScreen and start new Game
     */
    public static void gameOverScreenToStartNewGame(){
        gameOverScreen.setVisible(false);
        gameScreen.setVisible(false);

        WindowManagement.gamePlayScreen = new view.GamePlayScreen(800, 800, 32, 32);
        WindowManagement.gameControlScreen = new view.GameControlScreen();
        WindowManagement.gameScreen = new view.GameScreen(800, 900, gamePlayScreen, gameControlScreen);

        new Thread(new TimeFlow(delay)).start(); // Starts the TimeFlow Thread
    }

    public static void settingsScreen(){
        WindowManagement.settingsScreen = new view.SettingsScreen(400,250);

    }

    /**
     * Returns the startScreen
     * @return
     */
    public static view.StartScreen getStartScreen(){
        return WindowManagement.startScreen;
    }

    /**
     * Returns the GameScreen
     * @return
     */
    public static view.GameScreen getGameScreen() {
        return WindowManagement.gameScreen;
    }

    /**
     * Returns the GamePlayScreen
     * @return
     */
    public static view.GamePlayScreen getGamePlayScreen(){
        return WindowManagement.gamePlayScreen;
    }

    /**
     * Returns the GameControlScreen
     */
    public static view.GameControlScreen getGameControlScreen(){
        return WindowManagement.gameControlScreen;
    }

    /**
     * Sets the score label, gets called by move() in Snake
     * @param score
     */
    public static void setScoreLabel(int score) {
        gameControlScreen.setScoreLabel(score);
    }

    public static boolean isDarkModeOn() {
        return isDarkModeOn;
    }

    public static void setDarkModeOn(boolean isDarkModeOn) {
        WindowManagement.isDarkModeOn = isDarkModeOn;
    }

    public static int getSnakeColorRed() {
        return snakeColorRed;
    }

    public static void setSnakeColorRed(int snakeColorRed) {
        WindowManagement.snakeColorRed = snakeColorRed;
    }

    public static int getSnakeColorGreen() {
        return snakeColorGreen;
    }

    public static void setSnakeColorGreen(int snakeColorGreen) {
        WindowManagement.snakeColorGreen = snakeColorGreen;
    }

    public static int getSnakeColorBlue() {
        return snakeColorBlue;
    }

    public static void setSnakeColorBlue(int snakeColorBlue) {
        WindowManagement.snakeColorBlue = snakeColorBlue;
    }

    public static int getDelay() {
        return delay;
    }

    public static void setDelay(int delay) {
        WindowManagement.delay = delay;
    }

   

    
}