package model;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Fruit {

    private int widthPosition;
    private int heightPosition;
    private Random rand = new Random();
    private ArrayList<Position> snakePositions;
    private view.GamePlayScreen gamePlayScreen;
    private ArrayList<Position> allAvailablePositions;
    private JPanel[][] panelMatrix;
    private Position fruitPosition;


    /**
     * Constructor for fruit with random coordinates
     */
    public Fruit(ArrayList<Position> snakePositions, view.GamePlayScreen gamePlayScreen){
        this.snakePositions = snakePositions;
        this.gamePlayScreen = gamePlayScreen;
        this.panelMatrix = gamePlayScreen.getPanelMatrix();
        this.allAvailablePositions = new ArrayList<Position>();

        for (int u = 0; u < snakePositions.size(); u++){ 
            for (int i = 0; i < gamePlayScreen.getPanelMatrixHeight(); i++){
                for (int j = 0; j < gamePlayScreen.getPanelMatrixWidth(); j++){
                    if (!(snakePositions.get(u).getHeight() == i && snakePositions.get(u).getWidth() == j)){  // This checks if current snakePos matches current panel in the matrix, negated statement, if it's true the panel will get added to allAvailablePositions
                        allAvailablePositions.add(new Position(i, j));
                    }
                }
            }
        }

        int randomInt = rand.nextInt(allAvailablePositions.size());
        fruitPosition = allAvailablePositions.get(randomInt);
        
        this.widthPosition = fruitPosition.getWidth();
        this.heightPosition = fruitPosition.getHeight();
    }


    /**
     * Return fruitPosition
     * @return
     */
    public Position getFruitPosition() {
        return fruitPosition;
    }


    
}