package view.listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gameOverNewGameButtonListener implements ActionListener{
    
    /**
     * Closes the GameOverScreen and starts a new game when retryButton is pressed
     */
    public void actionPerformed(ActionEvent event){
        controller.WindowManagement.gameOverScreenToStartNewGame();
    }

}