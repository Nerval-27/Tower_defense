package fr.raphNerval.model.tower;

import fr.raphNerval.view.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Walnut extends Plant {

    //*****ATTRIBUTS*****//
    private Image img;

    //*****CONSTRUCTEUR*****//
    public Walnut(GamePanel gamePanel, int x, int y) {
        super(gamePanel,x,y);
        this.setHealth(2000);
        try {
            this.img = ImageIO.read(getClass().getResource("/images/plants/walnut.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Walnut crée(" + this.x + ", " + this.y + ")");
    }

    //*****ACCESSEURS*****//
    public Image getImg() {
        return img;
    }
}
