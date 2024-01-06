package fr.raphNerval.controller;

import fr.raphNerval.model.tower.FreezePeashooter;
import fr.raphNerval.model.tower.Peashooter;
import fr.raphNerval.model.tower.SunFlower;
import fr.raphNerval.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    //*****ATTRIBUTS*****//
    private GamePanel gamePanel;
    private int x, y;

    //*****CONSTRUCTEUR*****//
    public GameController(GamePanel gp, int x, int y) {
        this.gamePanel = gp;
        this.x = x;
        this.y = y;
    }

    //*****METHODES******//

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gamePanel.getPlantType() == GameWindow.PlantType.Sunflower) {
            if(gamePanel.getPlayer().getMoney()>=50){
                   gamePanel.getTray()[y][x].addEntity(new SunFlower(gamePanel, x, y));
                    gamePanel.getPlayer().setMoney(-50);
            }
        } else if (gamePanel.getPlantType() == GameWindow.PlantType.Peashooter) {
              if(gamePanel.getPlayer().getMoney()>=100){
            gamePanel.getTray()[y][x].addEntity(new Peashooter(gamePanel, x, y));
             gamePanel.getPlayer().setMoney(-100);
              }
        } else if (gamePanel.getPlantType() == GameWindow.PlantType.FreezePeashooter) {
              if(gamePanel.getPlayer().getMoney()>=175){
            gamePanel.getTray()[y][x].addEntity(new FreezePeashooter(gamePanel, x, y));
            gamePanel.getPlayer().setMoney(-175);

        }
        gamePanel.setPlantType(GameWindow.PlantType.None);
    }
}
}