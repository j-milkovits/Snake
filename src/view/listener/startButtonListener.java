package view.listener;

import javax.swing.*;

import controller.WindowManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startButtonListener implements ActionListener{

    /**
     * Gets called if the button startButton gets pressed
     * Calls the method in window management that closes the given screen and opens a new GameScreen
     */
    public void actionPerformed (ActionEvent event){
        WindowManagement.closeStartScreenOpenGameScreen();
    }
    
}