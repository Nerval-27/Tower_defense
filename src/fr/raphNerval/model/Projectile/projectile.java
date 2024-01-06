package fr.raphNerval.model.Projectile;

import javax.swing.*;

import java.awt.Image.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.*;

import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.enemy.Zombie;


public class  projectile  extends JPanel{
    protected int health;
    protected int speed;


     private RealCoordinates pos=null;
    public RealCoordinates getPos() {
        return pos;
    }


    public void setPos(RealCoordinates pos) {
        this.pos = pos;
       
    }
    public Zombie getTarget() {
        return target;
    }
    public void setTarget(Zombie target) {
        this.target = target;
    }
    private Zombie target;

 public void receivedDamage(int damage){
        if(this.health-damage>0){
        this.health-=damage;
    }
}

}