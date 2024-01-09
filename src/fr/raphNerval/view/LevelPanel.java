package fr.raphNerval.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelPanel extends JPanel {

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

            }
        });

        level2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        level3.addActionListener(new ActionListener() {
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
