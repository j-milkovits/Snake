package view.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import controller.DirectionManagement;

public class keyboardDirectionListener extends KeyAdapter{

    public void keyPressed(KeyEvent event){
        switch(event.getKeyCode()){
            case KeyEvent.VK_W:
                DirectionManagement.setDirection(DirectionManagement.Direction.UP);
                break;
            case KeyEvent.VK_A:
                DirectionManagement.setDirection(DirectionManagement.Direction.LEFT);
                break;
            case KeyEvent.VK_S:
                DirectionManagement.setDirection(DirectionManagement.Direction.DOWN);
                break;
            case KeyEvent.VK_D:
                DirectionManagement.setDirection(DirectionManagement.Direction.RIGHT);
                break;
            case KeyEvent.VK_UP:
                DirectionManagement.setDirection(DirectionManagement.Direction.UP);
                break;
            case KeyEvent.VK_LEFT:
                DirectionManagement.setDirection(DirectionManagement.Direction.LEFT);
                break;
            case KeyEvent.VK_DOWN:
                DirectionManagement.setDirection(DirectionManagement.Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                DirectionManagement.setDirection(DirectionManagement.Direction.RIGHT);
                break;
        }
    }
}