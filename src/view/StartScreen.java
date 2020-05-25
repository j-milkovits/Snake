package view;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;

public class StartScreen extends JFrame{

    int width;
    int height;

    JButton startButton;
    JButton settingsButton;
    JLabel snakeIcon;

    /**
     * Constructor
     */
    public StartScreen(int width, int height){
        super("StartScreen");
        this.width = width; 
        this.height = height;

        // Setting window settings
        setSize(this.width, this.height);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1));

        startButton = new JButton("Start");
        settingsButton = new JButton("Settings");

        ImageIcon snakeImage = new ImageIcon(".\\res\\snake.png");
        snakeIcon = new JLabel(snakeImage);

        startButton.addActionListener(new view.listener.startButtonListener());
        settingsButton.addActionListener(new view.listener.settingsButtonListener());

        // Adding components to StartScreen
        add(snakeIcon);
        add(startButton);
        add(settingsButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}