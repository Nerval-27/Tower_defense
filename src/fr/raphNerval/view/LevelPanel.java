package fr.raphNerval.view;

import fr.raphNerval.model.enemy.EnemiesCount;
import fr.raphNerval.model.enemy.Wave;
import fr.raphNerval.model.tower.TowersCount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelPanel extends JPanel {

    //*****CONSTRUCTEUR*****//
    public LevelPanel(){
        super();
        setSize(1000,752);
        setLayout(null);

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("/images/levelmenu.png"));
        JLabel backgroundLabel = new JLabel(backgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 752);
        add(backgroundLabel);

        JButton level1 = new JButton(new ImageIcon(getClass().getResource("/images/buttons/L1.png")));
        JButton level2 = new JButton(new ImageIcon(getClass().getResource("/images/buttons/L2.png")));
        JButton level3 = new JButton(new ImageIcon(getClass().getResource("/images/buttons/L3.png")));
        JButton goBack = new JButton("GO BACK");

        JCheckBox nightMode = new JCheckBox("Mode Nuit");

        level1.setBounds(100, 250, 174, 192);
        level2.setBounds(400, 250, 174, 192);
        level3.setBounds(700, 250, 174, 192);
        goBack.setBounds(10,650,100,60);

        nightMode.setBounds(800,600,150,150);
        // Actions des boutons
        level1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnemiesCount enemiesCount = new EnemiesCount(true,false,false);
                TowersCount towersCount = new TowersCount(true,true,false,false);

                Wave.nbEnemies = 20;
                GamePanel gamePanel = new GamePanel(towersCount,enemiesCount);
                if (GameWindow.gameWindow != null) {
                    GameWindow.gameWindow.switchPanel(gamePanel);
                }
            }
        });

        level2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnemiesCount enemiesCount = new EnemiesCount(true,true,false);
                TowersCount towersCount = new TowersCount(true,true,true,false);
                Wave.nbEnemies = 30;
                GamePanel gamePanel = new GamePanel(towersCount,enemiesCount);
                if (GameWindow.gameWindow != null) {
                    GameWindow.gameWindow.switchPanel(gamePanel);
                }
            }
        });

        level3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnemiesCount enemiesCount = new EnemiesCount(true,true,true);
                TowersCount towersCount = new TowersCount(true,true,true,true);
                Wave.nbEnemies = 40;
                GamePanel gamePanel = new GamePanel(towersCount,enemiesCount);
                if (GameWindow.gameWindow != null) {
                    GameWindow.gameWindow.switchPanel(gamePanel);
                }
            }
        });

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPanel menuPanel = new MenuPanel();
                if (GameWindow.gameWindow != null) {
                    GameWindow.gameWindow.switchPanel(menuPanel);
                }
            }
        });

        nightMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nightMode.isSelected()){
                   GamePanel.pathBG = "/images/BG-Night.png";
                }else{
                    GamePanel.pathBG = "/images/BG.png";
                }
            }
        });

        // Ajout des boutons
        backgroundLabel.setOpaque(false);
        backgroundLabel.add(level1);
        backgroundLabel.add(level2);
        backgroundLabel.add(level3);
        backgroundLabel.add(goBack);
        backgroundLabel.add(nightMode);

        setVisible(true);
    }
}
