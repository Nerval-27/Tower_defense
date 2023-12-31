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

    //*****METHODES******//
    public abstract void move();



}
