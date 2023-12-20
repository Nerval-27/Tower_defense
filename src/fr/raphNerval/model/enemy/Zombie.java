package fr.raphNerval.model.enemy;

import fr.raphNerval.model.Entity;
import java.awt.*;

public class Zombie extends Entity {

    //*****ATTRIBUTS*****//
    private int damage;


    //*****CONSTRUCTEUR*****//
    public Zombie() {
        super( 1000, 2);
        this.damage = 10;
    }

    //*****ACCESSEURS*****//

    //*****METHODES******//
    @Override
    public void move() {

    }

    @Override
    public void draw(Graphics g,int x,int y) {
    }



}

