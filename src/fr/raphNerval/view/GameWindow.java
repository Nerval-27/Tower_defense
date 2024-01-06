package fr.raphNerval.view;

import javax.swing.*;

public class GameWindow extends JFrame {

    public enum PlantType{
        None,
        Sunflower,
        Peashooter,
        FreezePeashooter
    }

    //*****ATTRIBUTS*****//
    private GamePanel gamePanel;
    public static GameWindow GAMEWINDOW;

    //*****CONSTRUCTEUR*****//
    public GameWindow() {
        setSize(1012,785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        gamePanel = new GamePanel();
        gamePanel.setLocation(0,0);
        getLayeredPane().add(gamePanel);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        GAMEWINDOW = new GameWindow();
    }

}

