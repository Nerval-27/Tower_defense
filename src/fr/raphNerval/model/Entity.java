package fr.raphNerval.model;

import javax.swing.*;

public abstract class Entity extends JPanel {

    //*****ATTRIBUTS*****//
    protected int health;
    protected int speed;

    //*****CONSTRUCTEUR*****//
    public Entity(int health, int speed) {
        this.health = health;
        this.speed = speed;
    }

    //*****ACCESSEURS*****//
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getHealth() {
        return health;
    }
    protected void setHealth(int health){this.health = health;}



}
