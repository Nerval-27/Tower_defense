package fr.raphNerval.model.projectile;

import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.enemy.Zombie;

import javax.swing.*;


public class Bullet extends JPanel{

    //*****ATTRIBUTS*****//
    protected int health;
    private Zombie target;
    private RealCoordinates pos=null;

    //*****ACCESSEURS*****//
    public RealCoordinates getPos() {
        return pos;
    }
    public void setPos(RealCoordinates pos) {this.pos = pos;}
    public Zombie getTarget() {
        return target;
    }
    public void setTarget(Zombie target) {
        this.target = target;
    }



}
