package fr.raphNerval.model.enemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class MastifZombie extends Zombie {

    //*****ATTRIBUTS*****//
    public Image getModel() {
        return model;
    }
    private Image model;

    //*****CONSTRUCTEUR*****//
    public MastifZombie(int reward, int strength) {

        super(5000, 2, reward, strength);
        try {
            this.model = ImageIO.read(getClass().getResource("/images/zombies/maastifZombie.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
