package view.listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gameOverMenuButtonListener implements ActionListener{
    
    /**
     * Closes the GameScreen and GameOverScreen and opens the StartScreen when menu button is being pressed
     */
    public void actionPerformed(ActionEvent event){
        controller.WindowManagement.closeGameAndGameOverScreenOpenStartScreen();
    }

}