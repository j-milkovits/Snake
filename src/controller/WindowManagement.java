package controller;

import javax.swing.*;

public class WindowManagement {


    private static view.StartScreen startScreen;
    private static view.GameScreen gameScreen;
    private static view.GamePlayScreen gamePlayScreen;
    private static view.GameControlScreen gameControlScreen;
    private static view.GameOverScreen gameOverScreen;
    private static int delay = 200;


    /**
     * Opens a new StartScreen, called by main method
     */
    public static void openStartScreen(){
        startScreen = new view.StartScreen(300,300);
    }

    /**
     * Closes the start screen and opens the gamescreen, also creates a timeManager-Object
     * This method gets called by the startButton in view.StartScreen
     * @param startScreen
     */
    public static void closeStartScreenOpenGameScreen(){
        WindowManagement.startScreen.setVisible(false);

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
    public static void closeGameScreenOpenStartScreen(){
        WindowManagement.gameScreen.setVisible(false);

        WindowManagement.startScreen = new view.StartScreen(300,300);

        TimeFlow.stopThread(); // Stops the TimeFlow Thread
    }


    /**
     * Gets called when a game over happens
     * Stops the thread and opens a GameOverScreen
     * @param score
     */
    public static void openGameOverScreen(int score){
        gameOverScreen = new view.GameOverScreen(500, 75, score);
        controller.TimeFlow.stopThread();
    }

    /**
     * Disables GameScreen and GameOverScreen and opens new StartScreen
     */
    public static void closeGameAndGameOverScreenOpenStartScreen(){
        gameOverScreen.setVisible(false);
        gameScreen.setVisible(false);

        WindowManagement.startScreen = new view.StartScreen(300,300);
    }


    /**
     * Disable GameOverScreen and start new Game
     */
    public static void closeGameOverAndStartNewGame(){
        gameOverScreen.setVisible(false);
        gameScreen.setVisible(false);

        WindowManagement.gamePlayScreen = new view.GamePlayScreen(800, 800, 32, 32);
        WindowManagement.gameControlScreen = new view.GameControlScreen();
        WindowManagement.gameScreen = new view.GameScreen(800, 900, gamePlayScreen, gameControlScreen);

        new Thread(new TimeFlow(delay)).start(); // Starts the TimeFlow Thread
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

    
}