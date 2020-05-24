package controller;

import java.util.Random;

public class DirectionManagement {

    public enum Direction {UP, RIGHT, DOWN, LEFT};

    private static Random rand = new Random();
    private static Direction dir = Direction.values()[rand.nextInt(4)];
    
    /**
     * Sets the direction
     * @param dir
     */
    public static void setDirection(Direction dir){
        // Distance = 2 between two enums means that they are opposite directions
        // If they are opposite directions we don't want to change the direction
        // That's why we only change it if the distance is not 2
        if (!(Math.abs(DirectionManagement.dir.ordinal() - dir.ordinal()) == 2)){
            DirectionManagement.dir = dir;
        }
        
    }

    /**
     * Returns the direction
     * @return
     */
    public static Direction getDirection(){
        return dir;
    }
}