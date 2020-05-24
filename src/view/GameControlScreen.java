package view;

import javax.swing.*;
import java.awt.*;

public class GameControlScreen extends JPanel{

    private JButton buttonDown;
    private JButton buttonUp;
    private JButton buttonRight;
    private JButton buttonLeft;
    private JButton menuButton;
    private JLabel scoreLabel;
    
    /**
     * Constructor to create an object of type GameControlScreen
     */
    public GameControlScreen(){

        // Settings for Frame
        setLayout(new GridBagLayout());

        // Initializing components
        buttonUp = new JButton("⬆");
        buttonDown = new JButton("⬇");
        buttonRight = new JButton("➡");
        buttonLeft = new JButton("⬅");
        menuButton = new JButton("Go back to menu");
        scoreLabel = new JLabel("Score: 0");

        buttonUp.setEnabled(false);
        buttonDown.setEnabled(false);
        buttonLeft.setEnabled(false);
        buttonRight.setEnabled(false);
        buttonUp.setName("UP");
        buttonDown.setName("DOWN");
        buttonRight.setName("RIGHT");
        buttonLeft.setName("LEFT");

        // Add Listeners to buttons
        buttonUp.addMouseListener(new view.listener.buttonDirectionListener(buttonUp));
        buttonDown.addMouseListener(new view.listener.buttonDirectionListener(buttonDown));
        buttonLeft.addMouseListener(new view.listener.buttonDirectionListener(buttonLeft));
        buttonRight.addMouseListener(new view.listener.buttonDirectionListener(buttonRight));
        menuButton.addActionListener(new view.listener.menuButtonListener());


        // GridBagLayout Stuff

        // MenuButton
        GridBagConstraints cMenu = new GridBagConstraints();
        cMenu.fill = GridBagConstraints.BOTH;
        cMenu.gridx = 0;
        cMenu.gridy = 0;
        cMenu.weightx = 0;
        cMenu.weighty = 0;
        add(menuButton, cMenu);

        // Blank expanding spaces
        GridBagConstraints cBlank = new GridBagConstraints();
        cBlank.fill = GridBagConstraints.BOTH;
        cBlank.gridx = 1;
        cBlank.gridy = 0;
        cBlank.weightx = 0.5;
        cBlank.weighty = 0.5;
        add(new JPanel(), cBlank);
        cBlank.gridx = 5;
        cBlank.gridy = 0;
        add(new JPanel(), cBlank);
        cBlank.gridx = 1;
        cBlank.gridy = 1;
        add(new JPanel(), cBlank);
        cBlank.gridx = 5;
        cBlank.gridy = 1;
        add(new JPanel(), cBlank);
        
        // ButtonUp
        GridBagConstraints cButtonUp = new GridBagConstraints();
        cButtonUp.fill = GridBagConstraints.BOTH;
        cButtonUp.ipadx = 20;
        cButtonUp.ipady = 20;
        cButtonUp.gridx = 3;
        cButtonUp.gridy = 0;
        cButtonUp.weightx = 0;
        cButtonUp.weighty = 0;
        add(buttonUp, cButtonUp);

        // ButtonDown
        GridBagConstraints cButtonDown = new GridBagConstraints();
        cButtonDown.fill = GridBagConstraints.BOTH;
        cButtonDown.ipadx = 20;
        cButtonDown.ipady = 20;
        cButtonDown.gridx = 3;
        cButtonDown.gridy = 1;
        cButtonDown.weightx = 0;
        cButtonDown.weighty = 0;
        add(buttonDown, cButtonDown);

        // ButtonLeft
        GridBagConstraints cButtonLeft = new GridBagConstraints();
        cButtonLeft.fill = GridBagConstraints.BOTH;
        cButtonLeft.ipadx = 20;
        cButtonLeft.ipady = 20;
        cButtonLeft.gridx = 2;
        cButtonLeft.gridy = 1;
        cButtonLeft.weightx = 0;
        cButtonLeft.weighty = 0;
        add(buttonLeft, cButtonLeft);

        // ButtonRight
        GridBagConstraints cButtonRight = new GridBagConstraints();
        cButtonRight.fill = GridBagConstraints.BOTH;
        cButtonRight.ipadx = 20;
        cButtonRight.ipady = 20;
        cButtonRight.gridx = 4;
        cButtonRight.gridy = 1;
        cButtonRight.weightx = 0;
        cButtonRight.weighty = 0;
        add(buttonRight, cButtonRight);

        // ScoreLabel
        GridBagConstraints cScoreLabel = new GridBagConstraints();
        cScoreLabel.fill = GridBagConstraints.BOTH;
        cScoreLabel.ipadx = 20;
        cScoreLabel.ipady = 20;
        cScoreLabel.gridx = 6;
        cScoreLabel.gridy = 0;
        cScoreLabel.weightx = 0;
        cScoreLabel.weighty = 0;
        add(scoreLabel, cScoreLabel);
    }


    /**
     * Used to set the score label
     * Gets called by WindowManagement
     * @param score
     */
    public void setScoreLabel(int score) {
        scoreLabel.setText("Score: " + score);
    }
}