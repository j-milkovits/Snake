package view.listener;

import javax.swing.*;
import java.awt.event.*;
import controller.DirectionManagement;
import controller.DirectionManagement.Direction;


public class buttonDirectionListener extends MouseAdapter{

    JButton button;

    /**
     * Constructor
     * @param button
     */
    public buttonDirectionListener(JButton button){
        this.button = button;
    }

    /**
     * Method to set the direction on mouseover depending which button was pressed
     */
    public void mouseEntered(MouseEvent event){
        if (button.getName() == "UP"){
            DirectionManagement.setDirection(Direction.UP);
        }
        if (button.getName() == "DOWN"){
            DirectionManagement.setDirection(Direction.DOWN);
        }
        if (button.getName() == "RIGHT"){
            DirectionManagement.setDirection(Direction.RIGHT);
        }
        if (button.getName() == "LEFT"){
            DirectionManagement.setDirection(Direction.LEFT);
        }
    }


    
}