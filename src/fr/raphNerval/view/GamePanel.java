package fr.raphNerval.view;

import fr.raphNerval.controller.PlantCard;
import fr.raphNerval.model.tower.Plant;
import fr.raphNerval.model.field.Box;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    //*****ATTRIBUTS*****//
    private Image backgroundImage;
    private Box[] boxs;

    //*****CONSTRUCTEUR*****//
    public GamePanel() {
        setSize(1000, 752);
        setLayout(null);

        backgroundImage = new ImageIcon(getClass().getResource("/images/BG.png")).getImage();

        boxs = new Box[50];
        for(int i = 0;i<50;i++){
            Box box = new Box();
            box.setLocation(44 + (i % 10) * 100, 109 + (i / 10) * 120);
            boxs[i] = box;
            add(box);
        }

        //affiche les card
        PlantCard cardSunFlower = new PlantCard("/images/card_sunflower.png");
        cardSunFlower.setLocation(100,8);
        add(cardSunFlower);

        PlantCard cardFreezePeaShooter = new PlantCard("/images/card_freezepeashooter.png");
        cardFreezePeaShooter.setLocation(230,8);
        add(cardFreezePeaShooter);

        PlantCard cardPeaShooter = new PlantCard("/images/card_peashooter.png");
        cardPeaShooter.setLocation(165,8);
        add(cardPeaShooter);

        //ajoute entity
        Plant plant1 = new Plant();
        boxs[0].addEntity(plant1);
        boxs[11].addEntity(plant1);

    }
    //*****ACCESSEURS*****//

    //*****METHODES******//
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);

        //Dessine chaque case
        for(Box box : boxs){
            box.draw(g);
        }

    }


}
