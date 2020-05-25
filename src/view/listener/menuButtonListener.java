package view.listener;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class menuButtonListener implements ActionListener {

    /**
     * Close the GameScreen and open the StartScreen when menu button is being pressed
     */
    public void actionPerformed(ActionEvent event){
        controller.WindowManagement.gameScreenToStartScreen();
    }

}