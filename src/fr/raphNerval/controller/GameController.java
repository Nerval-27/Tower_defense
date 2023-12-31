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
    private int x,y;

    //*****CONSTRUCTEUR*****//
    public GameController(GamePanel gp,int x,int y){
        this.gamePanel = gp;
        this.x = x;
        this.y = y;
    }

    //*****METHODES******//


    @Override
    public void actionPerformed(ActionEvent e) {
        if (gamePanel.getPlantType() == GameWindow.PlantType.Sunflower) {
            gamePanel.getTray()[x + y * 10].addEntity(new SunFlower(gamePanel, x, y));
        } else if (gamePanel.getPlantType() == GameWindow.PlantType.Peashooter) {
            gamePanel.getTray()[x + y * 10].addEntity(new Peashooter(gamePanel, x, y));
        } else if (gamePanel.getPlantType() == GameWindow.PlantType.FreezePeashooter) {
            gamePanel.getTray()[x + y * 10].addEntity(new FreezePeashooter(gamePanel, x, y));
        }
        gamePanel.setPlantType(GameWindow.PlantType.None);
    }

}
