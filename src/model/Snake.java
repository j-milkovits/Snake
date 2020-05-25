package model;

import java.util.Random;
import java.util.ArrayList;
import controller.DirectionManagement;
import controller.TimeFlow;
import controller.WindowManagement;
import controller.DirectionManagement.Direction;

public class Snake {

    private int startHeight;
    private int startWidth;
    private Random rand = new Random();
    private ArrayList<Position> snakePositions = new ArrayList<Position>();
    private Position lastPositionInArrayList;
    private Direction dir = DirectionManagement.getDirection();
    int score;

    /**
     * Constructor that creates a snake with random a starting point and adds it to the ArrayList
     */
    public Snake(){
        startHeight = rand.nextInt(32);
        startWidth = rand.nextInt(32);
        score = 0;

        snakePositions.add(new Position(startHeight, startWidth));
    }

    /**
     * returns the length of the snakePositions-ArrayList
     * @return
     */
    public int getLength(){
        return this.snakePositions.size();
    }

    /**
     * Returns the ArrayList of snake positions
     * @return
     */
    public ArrayList<Position> getSnakePositions(){
        return this.snakePositions;
    }
    /**
     * Sets the variable lastPositionInArrayist to the last position in the ArrayList
     */
    public void refreshLastPosition(){
        this.lastPositionInArrayList = snakePositions.get(getLength() - 1);
    }


    /**
     * Adds a new point to the ArrayList (the snake moved) and deletes the first one
     * First one, shouldn't be deleted if the new position to add had a fruit on it
     */
    public void move(Fruit givenFruit, view.GamePlayScreen givenGamePlayScreen) {
        refreshLastPosition();
        int lastHeight = lastPositionInArrayList.getHeight();
        int lastWidth = lastPositionInArrayList.getWidth();
        Position positionToAdd = new Position(0,0); // Had to initialize cuz I didn't want to do else down here

        Direction newDir = DirectionManagement.getDirection();

        if (!(Math.abs(dir.ordinal() - newDir.ordinal()) == 2)){
            dir = newDir;
        }
        

        Fruit fruit = givenFruit;
        boolean ateFruit = false;
        view.GamePlayScreen gamePlayScreen = givenGamePlayScreen;

        if (dir == Direction.UP) {
            if (lastHeight - 1 > -1) {
                positionToAdd = new Position(lastHeight - 1, lastWidth);
            }
            else {
                positionToAdd = new Position(31, lastWidth);
            }
        }

        if (dir == Direction.DOWN) {
            if (lastHeight + 1 < 32 ) {
                positionToAdd = new Position(lastHeight + 1, lastWidth);
            }
            else {
                positionToAdd = new Position(0, lastWidth);
            }
        }

        if (dir == Direction.LEFT) {
            if (lastWidth - 1 > -1) {
                positionToAdd = new Position(lastHeight, lastWidth - 1);
            }
            else {
                positionToAdd = new Position(lastHeight, 31);
            }
        }

        if (dir == Direction.RIGHT) {
            if (lastWidth + 1 < 32) {
                positionToAdd = new Position(lastHeight, lastWidth + 1);
            }
            else {
                positionToAdd = new Position(lastHeight, 0);
            }
        }

        // Checks if the positionToAdd is already "in the snake", if yes GameOverScreen
        if (isPositionInSnakePositions(positionToAdd) == true){
            WindowManagement.gameOverScreen(score);
            snakePositions.add(positionToAdd);
        }
        else{
            snakePositions.add(positionToAdd);
        }

        

        if (positionToAdd.getHeight() == fruit.getFruitPosition().getHeight() && positionToAdd.getWidth() == fruit.getFruitPosition().getWidth()) {
            ateFruit = true;
            gamePlayScreen.paintEatenFruitGreen(fruit.getFruitPosition());
        }

        if (ateFruit == true){
            ateFruit = !ateFruit;
            TimeFlow.setAteFruit(true);
        }
        else {
            gamePlayScreen.paintLastSnakePartWhite(snakePositions.get(0));
            snakePositions.remove(0);
        }

        // Refreshes the score (size - 1, because I want it to start at zero)
        score = snakePositions.size() - 1;
        WindowManagement.setScoreLabel(score);
        

    }


    /**
     * Returns true, if given position is already "in the snake"
     * @param positionToAdd
     * @return
     */
    private boolean isPositionInSnakePositions(Position positionToAdd){
        for (int i = 0; i < snakePositions.size(); i++){
            if (snakePositions.get(i).getHeight() == positionToAdd.getHeight() && snakePositions.get(i).getWidth() == positionToAdd.getWidth()){
                return true;
            }
        }

        return false;
    }

    
}