package view;

import javax.swing.*;
import java.awt.BorderLayout;

public class GameScreen extends JFrame{
    
    private int width;
    private int height;

    /**
     * Constructor to create the playing screen
     * @param width
     * @param height
     */
    public GameScreen(int width, int height, GamePlayScreen gamePlayScreen, GameControlScreen gameControlScreen){
        super("GameScreen");
        this.width = width;
        this.height = height;
   
        // Settings for Frame
        setSize(this.width, this.height);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the JPanels to the JFrame
        add(gamePlayScreen, BorderLayout.CENTER);
        add(gameControlScreen, BorderLayout.PAGE_END);

        setVisible(true);
    }


}