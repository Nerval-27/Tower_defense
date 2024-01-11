package fr.raphNerval.model.enemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class NormalZombie extends Zombie{

    //*****ATTRIBUTS*****//
    public Image getModel() {
        return model;
    }
    private Image model;

    //*****CONSTRUCTEUR*****//
    public NormalZombie(int reward, int strength) {

        super(1000, 3, reward, strength);
        try {
            this.model = ImageIO.read(getClass().getResource("/images/zombies/zombie1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

