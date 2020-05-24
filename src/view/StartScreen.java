package view;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;

public class StartScreen extends JFrame{

    int width;
    int height;

    JButton startButton;
    JButton controlsButton;
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
        controlsButton = new JButton("Controls");

        ImageIcon snakeImage = new ImageIcon("C:\\Users\\Jonas\\Google Drive\\Sync\\Coding Projects\\Java\\Snake\\res\\snake.png");
        snakeIcon = new JLabel(snakeImage);

        startButton.addActionListener(new view.listener.startButtonListener());

        // Adding components to StartScreen
        add(snakeIcon);
        add(startButton);
        add(controlsButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}