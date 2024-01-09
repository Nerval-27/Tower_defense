package fr.raphNerval.model.tower;

import fr.raphNerval.view.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class FreezePeashooter extends Plant {

    //*****ATTRIBUTS*****//
    private Image img;

    //*****CONSTRUCTEUR*****//
    public FreezePeashooter(GamePanel gamePanel, int x, int y) {
        super(gamePanel,x,y);
        try {
            this.img = ImageIO.read(getClass().getResource("/images/plants/freezepeashooter.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("FreezePeaShooter crée(" + this.x + ", " + this.y + ")");
    }

    //*****ACCESSEURS*****//
    public Image getImg() {
        return img;
    }
}