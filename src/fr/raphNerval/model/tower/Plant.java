package fr.raphNerval.model.tower;

import fr.raphNerval.model.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Plant extends  Entity {

    //*****ATTRIBUTS*****//
    private Image imgPlant;
    private int damage;


    //*****CONSTRUCTEUR*****//
    public Plant(){

        super(200, 0);
        this.damage = 0;
        //  this.imgPlant = new ImageIcon(getClass().getResource("/images/sunflower.gif")).getImage();
        try {
            this.imgPlant = ImageIO.read(getClass().getResource("/images/peashooter.gif"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //*****ACCESSEURS*****//
    public int getDamage() {return damage;}
    public Image getImgPlant() {return imgPlant;}

    //*****METHODES******//
    @Override
    public void move() {}

    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawImage(this.imgPlant, x, y, null);

    }



}
