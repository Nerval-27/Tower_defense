package fr.raphNerval.controller;

import fr.raphNerval.model.field.Box;
import fr.raphNerval.model.tower.FreezePeashooter;
import fr.raphNerval.model.tower.Peashooter;
import fr.raphNerval.model.tower.SunFlower;
import fr.raphNerval.model.tower.Walnut;
import fr.raphNerval.player.Player;
import fr.raphNerval.view.GamePanel;
import fr.raphNerval.view.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    //*****ATTRIBUTS*****//
    private GamePanel gamePanel;
    private int x,y;
    private Player player;

    //*****CONSTRUCTEUR*****//
    public GameController(GamePanel gp,int x,int y, Player player){
        this.player = player;
        this.gamePanel = gp;
        this.x = x;
        this.y = y;
    }

    //*****METHODES******//
    @Override
    public void actionPerformed(ActionEvent e) {
        Box clickedBox = (Box) e.getSource();

        if (gamePanel.getPlantType() == GameWindow.PlantType.Sunflower) {
            if (player.placePlant(50)) {
                clickedBox.addEntity(new SunFlower(gamePanel, clickedBox.getX(), clickedBox.getY()));
            }
        } else if (gamePanel.getPlantType() == GameWindow.PlantType.Peashooter) {
            if (player.placePlant(100)) {
                clickedBox.addEntity(new Peashooter(gamePanel, clickedBox.getX(), clickedBox.getY()));
            }
        } else if (gamePanel.getPlantType() == GameWindow.PlantType.FreezePeashooter) {
            if (player.placePlant(175)) {
                clickedBox.addEntity(new FreezePeashooter(gamePanel, clickedBox.getX(), clickedBox.getY()));
            }
        } else if (gamePanel.getPlantType() == GameWindow.PlantType.Walnut) {
            if (player.placePlant(50)) {
                clickedBox.addEntity(new Walnut(gamePanel, clickedBox.getX(), clickedBox.getY()));
            }
        } else if (gamePanel.getPlantType() == GameWindow.PlantType.Shovel) {
            clickedBox.removeEntity(clickedBox.getPlant());
        }

        gamePanel.setPlantType(GameWindow.PlantType.None);
    }
}