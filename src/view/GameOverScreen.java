package view;

import javax.swing.*;
import java.awt.GridLayout;

public class GameOverScreen extends JFrame{
    
    private int width;
    private int height;
    private JButton retryButton;
    private JButton mainMenuButton;
    private JButton scoreLabel;

    public GameOverScreen(int width, int height, int score){
        super("GameOver");
        this.width = width;
        this.height = height;

        // Settings for JFrame
        setSize(this.width, this.height);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,3));

        retryButton = new JButton("Try again");
        mainMenuButton = new JButton("Menu");
        scoreLabel = new JButton("Your score was " + score + ".");
        scoreLabel.setEnabled(false);

        // Add Listeners
        mainMenuButton.addActionListener(new view.listener.gameOverMenuButtonListener());
        retryButton.addActionListener(new view.listener.gameOverNewGameButtonListener());

        add(retryButton);
        add(scoreLabel);
        add(mainMenuButton);
        


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}