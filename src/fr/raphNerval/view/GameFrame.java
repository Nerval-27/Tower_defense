package fr.raphNerval.view;

import javax.swing.*;

public class GameFrame extends JFrame {

    //*****ATTRIBUTS*****//
    private GamePanel gamePanel;

    //*****CONSTRUCTEUR*****//
    public GameFrame(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel();
        add(gamePanel);

        setSize(1000, 752);
        setLocationRelativeTo(null);
    }

    //*****ACCESSEURS*****//

    public GamePanel getGamePanel() {return gamePanel;}
}

