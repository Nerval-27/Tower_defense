package fr.raphNerval.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game_over extends JPanel {

    //*****CONSTRUCTEUR*****//
    public Game_over() {
        super();
        setSize(1000, 752);
        setLayout(null);
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("/images/gameover.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 752);
        add(backgroundLabel);

        JButton goBack = new JButton("GO BACK");
        goBack.setBounds(10, 650, 100, 60);

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPanel menuPanel = new MenuPanel();
                if (GameWindow.gameWindow != null) {
                    GameWindow.gameWindow.switchPanel(menuPanel);
                }
            }
        });
        backgroundLabel.setOpaque(false);
        backgroundLabel.add(goBack);
        setVisible(true);
    }
}