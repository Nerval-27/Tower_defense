package fr.raphNerval.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavedPanel extends JPanel {

    public SavedPanel(){
        super();
        setSize(1000,752);
        setLayout(null);

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("/images/savedmenu.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 752);
        add(backgroundLabel);

        JButton saveGame1 = new JButton("SAVEGAME 1");
        JButton saveGame2 = new JButton("SAVEGAME 2");
        JButton saveGame3 = new JButton("SAVEGAME 3");
        JButton saveGame4 = new JButton("SAVEGAME 4");
        JButton goBack = new JButton("GO BACK");

        saveGame1.setBounds(250, 250, 200, 80);
        saveGame2.setBounds(250, 400, 200, 80);
        saveGame3.setBounds(600, 250, 200, 80);
        saveGame4.setBounds(600, 400, 200, 80);
        goBack.setBounds(10,650,100,60);

        // Actions des boutons
        saveGame1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        saveGame2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        saveGame3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        saveGame4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

        // Ajout des boutons
        backgroundLabel.setOpaque(false);
        backgroundLabel.add(saveGame1);
        backgroundLabel.add(saveGame2);
        backgroundLabel.add(saveGame3);
        backgroundLabel.add(saveGame4);
        backgroundLabel.add(goBack);

        setVisible(true);
    }
}
