package fr.raphNerval.model.enemy;

import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.Entity;

public class Zombie extends Entity{

    //*****ATTRIBUTS*****//
    private RealCoordinates pos;
    private boolean freeze=false;
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

    protected int speed;
    public boolean isSpawned() {
        return spawned;
    }

    public void setSpawned(boolean spawned) {
        this.spawned = spawned;
    }

    private boolean spawned=false;
    private boolean a_spawned=false;
    public boolean isA_spawned() {
        return a_spawned;
    }

    public void setA_spawned(boolean a_spawned) {
        this.a_spawned = a_spawned;
    }

    private int id_enemy;

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    private int reward;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    private int strength;

    private static int nb_enemy;



    // Le nombre de pixels à déplacer à chaque itération


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

    //*****METHODES******//

   /* public void attack(Box box){
        if(!box.isEmpty() && box.getEntity() instanceof Plant){
        }
    }*/

    public void receivedDamage(int damage){
        if(this.health-damage>=0){
            this.health-=damage;
        }
    }

    public boolean is_death() {
        return this.health<=0;
    }
}

