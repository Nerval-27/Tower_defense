package fr.raphNerval.model;

import java.awt.Graphics;

import javax.swing.*;

public abstract class Entity extends JPanel {

    //*****ATTRIBUTS*****//
    protected int health;
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    protected int speed;

    //*****CONSTRUCTEUR*****//
    public Entity(int health, int speed) {
        this.health = health;
        this.speed = speed;
    }

    //*****ACCESSEURS*****//

    //*****METHODES******//
    public int getHealth() {
        return health;
    }

    public void draw(Graphics g, int entityX, int entityY) {
    }

}
