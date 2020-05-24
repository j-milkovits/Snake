package model;

public class Position {
    
    private int height;
    private int width;

    /**
     * Constructor
     */
    public Position (int height, int width){
        this.height = height;
        this.width = width;
    }

    /**
     * Returns height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns width
     */
    public int getWidth() {
        return width;
    }

}