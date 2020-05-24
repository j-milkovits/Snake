package view;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

public class GamePlayScreen extends JPanel{
    
    private int width;
    private int height;
    private int gridWidth;
    private int gridHeight;
    private int panelMatrixWidth;
    private int panelMatrixHeight;
    private JPanel[][] panelMatrix;

    /**
     * Constructor to create an object ob type GamePlayScreen with specific width, height, gridWidth, and gridHeight
     * @param width
     * @param height
     * @param gridWidth
     * @param gridHeight
     */
    public GamePlayScreen(int width, int height, int gridWidth, int gridHeight){
        this.width = width;
        this.height = height;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.panelMatrixWidth = this.gridWidth;
        this.panelMatrixHeight = this.gridHeight;
        

        // Settings for JPanel
        setSize(this.width, this.height);
        setLayout(new GridLayout(gridHeight, gridWidth));

        // first value is the height, second is the width
        panelMatrix = new JPanel[panelMatrixHeight][panelMatrixWidth];

        // Filling the panelMatrix with JPanels
        for (int i = 0; i < panelMatrixHeight; i++){
            for (int j = 0; j < panelMatrixWidth; j++){
                panelMatrix[i][j] = new JPanel();
                panelMatrix[i][j].setBackground(new Color(255, 255, 255));
            }
        }

        // Adding the matrix to the GridLayout
        // GridLayout always fills from left -> right, top -> bottom
        for (int i = 0; i < panelMatrixHeight; i++){
            for (int j = 0; j < panelMatrixWidth; j++){
                add(panelMatrix[i][j]);
            }
        }

    }


    /**
     * Paints the panels green that are at the same position as the elements in the ArrayList of the current snake
     * @param snakePositions
     */
    public void paintSnake(ArrayList<model.Position> snakePositions) {
        for (int i = 0; i < snakePositions.size(); i++) {
            panelMatrix[snakePositions.get(i).getHeight()][snakePositions.get(i).getWidth()].setBackground(new Color(128,255,0));
        }
    }

    /**
     * Paints the fruit
     * @param fruit
     */
    public void paintFruit(model.Fruit fruit){
        model.Position fruitPos = fruit.getFruitPosition();

        panelMatrix[fruitPos.getHeight()][fruitPos.getWidth()].setBackground(new Color(255,0,0));
    }

    /**
     * Paints the panel that just got removed from the snake white again
     * @param position
     */
    public void paintLastSnakePartWhite(model.Position position){
        panelMatrix[position.getHeight()][position.getWidth()].setBackground(new Color(255,255,255));
    }

    /**
     * Paints the panel where the fruit was (before being eaten) green (might not be needed, not sure yet)
     * @param position
     */
    public void paintEatenFruitGreen(model.Position position){
        panelMatrix[position.getHeight()][position.getWidth()].setBackground(new Color(128,255,0));
    }

    /**
     * Return panelMatrix
     */
    public JPanel[][] getPanelMatrix(){
        return panelMatrix;
    }

    /**
     * Return panelMatrixWidth
     * @return
     */
    public int getPanelMatrixWidth() {
        return gridWidth;
    }

    /** 
     * return panelMatrixHeight
     */
    public int getPanelMatrixHeight() {
        return gridHeight;
    }

}