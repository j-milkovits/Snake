package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import controller.WindowManagement;

public class SettingsScreen extends JFrame {

    int width;
    int height;
    JCheckBox darkMode;
    JLabel delayLabel;
    JScrollBar delayBar;
    JLabel snakeColorLabel;
    JPanel colorPanel;
    JScrollBar colorRed;
    JScrollBar colorGreen;
    JScrollBar colorBlue;
    JLabel amountRed;
    JLabel amountGreen;
    JLabel amountBlue;
    JLabel amountDelay;


    public SettingsScreen (int width, int height){
        super("SettingsScreen");
        this.width = width;
        this.height = height;

        // Creating components
        this.darkMode = new JCheckBox("DarkMode");
        this.delayLabel = new JLabel("Set delay here (ms)");
        this.delayBar = new JScrollBar(JScrollBar.HORIZONTAL, WindowManagement.getDelay(), 0 , 5 , 500);
        this.snakeColorLabel = new JLabel("SnakeColor");
        this.colorPanel = new JPanel();
        this.colorRed = new JScrollBar(JScrollBar.HORIZONTAL, WindowManagement.getSnakeColorRed(), 0, 0, 255);
        this.colorGreen = new JScrollBar(JScrollBar.HORIZONTAL, WindowManagement.getSnakeColorGreen(), 0, 0, 255);
        this.colorBlue = new JScrollBar(JScrollBar.HORIZONTAL, WindowManagement.getSnakeColorBlue(), 0, 0, 255);
        this.amountRed = new JLabel("R: " + WindowManagement.getSnakeColorRed());
        this.amountGreen = new JLabel("G: " + WindowManagement.getSnakeColorGreen());
        this.amountBlue = new JLabel("B: " + WindowManagement.getSnakeColorBlue());
        this.amountDelay = new JLabel(WindowManagement.getDelay() + "");

        colorPanel.setBackground(new Color(colorRed.getValue(), colorGreen.getValue(), colorBlue.getValue())); 
        darkMode.setSelected(WindowManagement.isDarkModeOn());

        // Adding listeners
        // testing some inclass definitions
        colorRed.addAdjustmentListener(new AdjustmentListener(){
            public void adjustmentValueChanged(AdjustmentEvent event){
                WindowManagement.setSnakeColorRed(event.getValue());
                refreshPanelColor();
                refreshRed();
            }
        });

        colorGreen.addAdjustmentListener(new AdjustmentListener(){
            public void adjustmentValueChanged(AdjustmentEvent event){
                WindowManagement.setSnakeColorGreen(event.getValue());
                refreshPanelColor();
                refreshGreen();
            }
        });

        colorBlue.addAdjustmentListener(new AdjustmentListener(){
            public void adjustmentValueChanged(AdjustmentEvent event){
                WindowManagement.setSnakeColorBlue(event.getValue());
                refreshPanelColor();
                refreshBlue();
            }
        });

        delayBar.addAdjustmentListener(new AdjustmentListener(){
            public void adjustmentValueChanged(AdjustmentEvent event){
                WindowManagement.setDelay(event.getValue());
                refreshDelay();
            }
        });

        darkMode.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent event){
                if (darkMode.isSelected()){
                    WindowManagement.setDarkModeOn(true);
                }
                else {
                    WindowManagement.setDarkModeOn(false);
                }
            }
        });



        // TODO Get a boolean for checkbox

        // Setting window settings
        setSize(this.width, this.height);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints cDarkMode = new GridBagConstraints();
        cDarkMode.gridx = 1;
        cDarkMode.gridy = 0;
        cDarkMode.fill = GridBagConstraints.BOTH;
        cDarkMode.weightx = 0.5;
        cDarkMode.weighty = 0.5;
        add(darkMode, cDarkMode);

        GridBagConstraints cDelayText = new GridBagConstraints();
        cDelayText.gridx = 0;
        cDelayText.gridy = 1;
        cDelayText.weightx = 0.5;
        cDelayText.weighty = 0.5;
        cDelayText.anchor = GridBagConstraints.CENTER;
        add(delayLabel, cDelayText);

        GridBagConstraints cDelayBar = new GridBagConstraints();
        cDelayBar.gridx = 1;
        cDelayBar.gridy = 1;
        cDelayBar.gridwidth = 1;
        cDelayBar.fill = GridBagConstraints.HORIZONTAL;
        cDelayBar.weightx = 0.5;
        cDelayBar.weighty = 0.5;
        add(delayBar, cDelayBar);

        GridBagConstraints cColorPanel = new GridBagConstraints();
        cColorPanel.gridx = 1;
        cColorPanel.gridy = 2;
        cColorPanel.fill = GridBagConstraints.BOTH;
        //cColorPanel.insets = new Insets(50,50,50,50);
        cColorPanel.weightx = 0.5;
        cColorPanel.weighty = 0.5;
        cColorPanel.anchor = GridBagConstraints.CENTER;
        add(colorPanel, cColorPanel);

        GridBagConstraints cSnakeColorLabel = new GridBagConstraints();
        cSnakeColorLabel.gridx = 0;
        cSnakeColorLabel.gridy = 2;
        cSnakeColorLabel.weightx = 0.5;
        cSnakeColorLabel.weighty = 0.5;
        cSnakeColorLabel.anchor = GridBagConstraints.CENTER;
        add(snakeColorLabel, cSnakeColorLabel);

        GridBagConstraints cColorRed = new GridBagConstraints();
        cColorRed.gridx = 0;
        cColorRed.gridy = 3;
        cColorRed.gridwidth = 2;
        cColorRed.fill = GridBagConstraints.HORIZONTAL;
        cColorRed.weightx = 0.5;
        cColorRed.weighty = 0.5;
        add(colorRed, cColorRed);

        GridBagConstraints cColorGreen = new GridBagConstraints();
        cColorGreen.gridx = 0;
        cColorGreen.gridy = 4;
        cColorGreen.gridwidth = 2;
        cColorGreen.fill = GridBagConstraints.HORIZONTAL;
        cColorGreen.weightx = 0.5;
        cColorGreen.weighty = 0.5;
        add(colorGreen, cColorGreen);

        GridBagConstraints cColorBlue = new GridBagConstraints();
        cColorBlue.gridx = 0;
        cColorBlue.gridy = 5;
        cColorBlue.gridwidth = 2;
        cColorBlue.fill = GridBagConstraints.HORIZONTAL;
        cColorBlue.weightx = 0.5;
        cColorBlue.weighty = 0.5;
        add(colorBlue, cColorBlue);

        GridBagConstraints cAmountRed = new GridBagConstraints();
        cAmountRed.gridx = 2;
        cAmountRed.gridy = 3;
        cAmountRed.gridwidth = 1;
        cAmountRed.anchor = GridBagConstraints.CENTER;
        cAmountRed.weightx = 0.25;
        cAmountRed.weighty = 0.25;
        add(amountRed, cAmountRed);

        GridBagConstraints cAmountGreen = new GridBagConstraints();
        cAmountGreen.gridx = 2;
        cAmountGreen.gridy = 4;
        cAmountGreen.gridwidth = 1;
        cAmountGreen.anchor = GridBagConstraints.CENTER;
        cAmountGreen.weightx = 0.25;
        cAmountGreen.weighty = 0.25;
        add(amountGreen, cAmountGreen);

        GridBagConstraints cAmountBlue = new GridBagConstraints();
        cAmountBlue.gridx = 2;
        cAmountBlue.gridy = 5;
        cAmountBlue.gridwidth = 1;
        cAmountBlue.anchor = GridBagConstraints.CENTER;
        cAmountBlue.weightx = 0.25;
        cAmountBlue.weighty = 0.25;
        add(amountBlue, cAmountBlue);

        GridBagConstraints cAmountDelay = new GridBagConstraints();
        cAmountDelay.gridx = 2;
        cAmountDelay.gridy = 1;
        cAmountDelay.gridwidth = 1;
        cAmountDelay.anchor = GridBagConstraints.CENTER;
        cAmountDelay.weightx = 0.25;
        cAmountDelay.weighty = 0.25;
        add(amountDelay, cAmountDelay);









        setVisible(true);
    }

    
    /**
     * Refreshes the color of the JPanel, gets called by listeners
     */
    public void refreshPanelColor(){
        colorPanel.setBackground(new Color(colorRed.getValue(), colorGreen.getValue(), colorBlue.getValue()));
    }

    /**
     * Refreshes the amount in amountRed, gets called by Listeners
     */
    public void refreshRed(){
        amountRed.setText("R: " + WindowManagement.getSnakeColorRed());
    }

    /**
     * Refreshes the amount in amountGreen, gets called by Listeners
     */
    public void refreshGreen(){
        amountGreen.setText("G: " + WindowManagement.getSnakeColorGreen());
    }


    /**
     * Refreshes the amount in amountBlue, gets called by Listeners
     */
    public void refreshBlue(){
        amountBlue.setText("B: " + WindowManagement.getSnakeColorBlue());
    }

    /**
     * Refreshes the delay in amountDelay, gets called by listeners
     */
    public void refreshDelay(){
        amountDelay.setText(WindowManagement.getDelay() + "");
    }
}