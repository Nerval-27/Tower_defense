package fr.raphNerval.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fr.raphNerval.model.enemy.EnemiesCount;
import fr.raphNerval.model.tower.TowersCount;

public class MenuPanel extends JPanel {

    //*****CONSTRUCTEUR*****//
    public MenuPanel() {
        setSize(1000,752);
        setLayout(null);

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("/images/menu.png"));
        JLabel backgroundLabel = new JLabel(backgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 752);
        add(backgroundLabel);

        JButton startGame = new JButton("JOUER");
        JButton chooseLevel = new JButton("LEVEL");
        JButton button3 = new JButton("SAUVEGARDE");

        startGame.setBounds(100, 600, 200, 70);
        chooseLevel.setBounds(400, 600, 200, 70);
        button3.setBounds(700, 600, 200, 70);

        // Actions des boutons
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        chooseLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               selectLevel();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {loadSavedGame();}
        });

        // Ajout des boutons
        backgroundLabel.setOpaque(false);
        backgroundLabel.add(startGame);
        backgroundLabel.add(chooseLevel);
        backgroundLabel.add(button3);

       setVisible(true);
    }

    //*****METHODES******//
    private void startGame() {
        EnemiesCount enemiesCount = new EnemiesCount(true,true,true);
        TowersCount towersCount = new TowersCount(true,true,true,true);

        GamePanel gamePanel = new GamePanel(towersCount,enemiesCount);
        if (GameWindow.gameWindow != null) {
            GameWindow.gameWindow.switchPanel(gamePanel);
        }
    }

    private void selectLevel(){
       LevelPanel levelPanel = new LevelPanel();
        if (GameWindow.gameWindow != null) {
            GameWindow.gameWindow.switchPanel(levelPanel);
        }
    }

    private void loadSavedGame(){
        SavedPanel savedPanel = new SavedPanel();
        if(GameWindow.gameWindow != null){
            GameWindow.gameWindow.switchPanel(savedPanel);
        }
    }

}
