package fr.raphNerval.model.enemy;

import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.Entity;

public class Zombie extends Entity{

    //*****ATTRIBUTS*****//
    private RealCoordinates pos;
    private boolean freeze=false;
    protected int speed;
    private boolean spawned=false;
    private boolean a_spawned=false;
    private int id_enemy;
    private int reward;
    private int strength;
    private static int nb_enemy;

    //*****CONSTRUCTEUR*****//
    public Zombie(int health,int speed, int reward,int strength){
        super(health,speed);
        id_enemy=nb_enemy;
        this.reward=reward;
        this.strength=strength;
        nb_enemy++;
    }

    //*****ACCESSEURS*****//
    public int getId_enemy() {
        return id_enemy;
    }
    public boolean isFreeze() {
        return freeze;
    }
    public void setFreeze(boolean freeze) {
        this.freeze = freeze;
    }
    public RealCoordinates getPos() {
        return pos;
    }
    public void setPos(RealCoordinates pos) {
        this.pos = pos;
    }
    public boolean isSpawned() {
        return spawned;
    }
    public void setSpawned(boolean spawned) {
        this.spawned = spawned;
    }
    public int getStrength() {
        return strength;
    }
    public int getReward() {
        return reward;
    }

    //*****METHODES******//
    public void receivedDamage(int damage){
        if(this.health-damage>=0){
            this.health-=damage;
        }
    }

    public boolean is_death() {
        return this.health<=0;
    }
}

