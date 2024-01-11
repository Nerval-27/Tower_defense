package fr.raphNerval.model.enemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class ConeZombie extends Zombie{

    //*****ATTRIBUTS*****//
    public Image getModel() {
        return model;
    }
    private Image model;

    //*****CONSTRUCTEUR*****//
    public ConeZombie(int reward, int strength) {

        super(3000, 5, reward, strength);
        try {
            this.model = ImageIO.read(getClass().getResource("/images/zombies/zombie2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

