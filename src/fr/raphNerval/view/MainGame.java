package fr.raphNerval.view;

import javax.swing.*;

public class MainGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame gameFrame = new GameFrame("Zombie vs Plant");
            gameFrame.setVisible(true);

        });
    }
}
