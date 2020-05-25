package view.listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class settingsButtonListener implements ActionListener{

    public void actionPerformed(ActionEvent event){
        controller.WindowManagement.settingsScreen();
    }
    
}