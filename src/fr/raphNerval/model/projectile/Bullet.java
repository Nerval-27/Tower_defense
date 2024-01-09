package fr.raphNerval.model.projectile;

import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.enemy.Zombie;

import javax.swing.*;


public class Bullet extends JPanel{
    protected int health;
    protected int speed;
    private Zombie target;
    private RealCoordinates pos=null;



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
    public void receivedDamage(int damage){
        if(this.health-damage>0){
            this.health-=damage;
        }
    }

}
