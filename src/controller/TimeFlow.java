package controller;

import java.lang.Runnable;
import javax.swing.*;
import model.Snake;
import view.GamePlayScreen;
import model.Fruit;

public class TimeFlow implements Runnable{

    private Snake snake;
    private int delay;
    private static boolean keepRunning;
    private static boolean ateFruit;
    private static Fruit fruit;

    /**
     * Constructor
     */
    public TimeFlow(int delay){
        this.snake = new Snake();
        TimeFlow.fruit = new Fruit(snake.getSnakePositions(), WindowManagement.getGamePlayScreen());
        this.delay = delay;
        TimeFlow.keepRunning = true;
    }

    public void run(){
        while(keepRunning){

            if (ateFruit == true){
                TimeFlow.fruit = new Fruit(snake.getSnakePositions(), WindowManagement.getGamePlayScreen());
                TimeFlow.ateFruit = !ateFruit;
            }

            snake.move(fruit, WindowManagement.getGamePlayScreen());
            WindowManagement.getGamePlayScreen().paintFruit(fruit);
            WindowManagement.getGamePlayScreen().paintSnake(snake.getSnakePositions());

            try{
                Thread.sleep(delay);
            }
            catch (Exception exc){
                System.out.println(exc.getMessage());
            }

        }
    }

    /**
     * Method to stop the thread
     */
    public static void stopThread(){
        TimeFlow.keepRunning = false;
    }

    /**
     * Set the variable ateFruit
     * @param b
     */
    public static void setAteFruit(boolean b){
        ateFruit = b;
    }

    /**
     * Get the variable ateFruit
     * @return
     */
    public static boolean getAteFruit(){
        return ateFruit;
    }
    
    
    /**
     * Get the variable ateFruit
     * @return
     */
    public static Fruit getFruit(){
        return TimeFlow.fruit;
    }
}