package fr.raphNerval.model;

import javax.swing.*;
import java.awt.*;

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


    public abstract void draw(Graphics g,int x,int y);


}
