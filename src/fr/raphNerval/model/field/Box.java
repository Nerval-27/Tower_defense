package fr.raphNerval.model.field;

import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.Entity;
import fr.raphNerval.model.enemy.Wave;
import fr.raphNerval.model.enemy.Zombie;
import fr.raphNerval.model.tower.FreezePeashooter;
import fr.raphNerval.model.tower.Peashooter;
import fr.raphNerval.model.tower.Plant;
import fr.raphNerval.model.tower.SunFlower;
import fr.raphNerval.player.Player;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Box extends JPanel implements MouseListener {

    //*****ATTRIBUTS*****//
    private static int nb_InZone=0;
    private List<Entity> entities;
    private boolean isEmpty;
    private ActionListener actionListener;

    //*****CONSTRUCTEUR*****//
    public Box() {
        //setBorder(new LineBorder(Color.GREEN));
        setOpaque(false);
        addMouseListener(this);
        //setBackground(Color.green);
        setSize(100, 120);

        this.entities = new ArrayList<>();
        this.isEmpty = true;
       
    }

    //*****ACCESSEURS*****//

    public void setActionListener(ActionListener actionListener){this.actionListener = actionListener;}
    public static int getNb_InZone() {
        return nb_InZone;
    }
    public static void setNb_InZone(int nb_InZone) {
        Box.nb_InZone = nb_InZone;
    }
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
    public List<Entity> getEntities() {
        return entities;
    }
    public boolean isEmpty() {return entities.isEmpty();}

    //*****METHODES*****//
    public void addEntity(Entity p){
        if((p instanceof Plant && !this.contain_Plant())|| !(p instanceof Plant)){
            if(!entities.contains(p)){
                entities.add(p);
                this.isEmpty = isEmpty();
                this.repaint();
            }else{
                this.repaint();
            }}
    }
    public void removeEntity(Entity e) {
        if(entities.contains(e)){
            entities.remove(e);  // Supprimez l'entité spécifique de la liste
            this.repaint();
        }
    }

    public List<Entity> getZombies(){
        List<Entity> zombies=new ArrayList<>();
        for (Entity e:this.entities){
            if(e instanceof Zombie){
                zombies.add(e);
            }
        }
        return zombies;
    }

    public boolean contain_Plant(){
        for (Entity e : this.entities) {
            if(e instanceof Plant){
                return true;
            }

        }
        return false;
    }

    public Plant getPlant(){
        if(this.contain_Plant()){
            for (Entity e : this.entities) {
                if(e instanceof Plant){
                    return (Plant)e;
                }
            }
        }
        return null;
    }

    public void spawn(Wave wave){
        for (int cle : wave.wave.keySet()) {
            if(!wave.wave.get(cle).isSpawned()){
                Zombie valeur = wave.wave.get(cle);
                int entityX =getX();
                int entityY = getY();
                valeur.setPos(new RealCoordinates(entityX, entityY));
                valeur.setSpawned(true);
                addEntity(valeur);
                break;
            }
        }
    }

    public static void all_Plant_shoot(Box[][] boxs){
        // Dessine chaque case
        for (Box[] row : boxs) {
            for (Box box : row) {
                if(box.getPlant()!=null){
                    if(box.getPlant() instanceof Peashooter ||box.getPlant() instanceof FreezePeashooter || box.getPlant() instanceof SunFlower) {
                        box.getPlant().shoot(boxs);
                }
            }}
        }
    }

    public static void all_Plant_shoot_move(Box[][] boxs,Wave wave,Player p){
        // Dessine chaque case
        for (Box[] row : boxs) {
            for (Box box : row) {
                if(box.getPlant()!=null){
                    if(box.getPlant() instanceof Peashooter || box.getPlant() instanceof FreezePeashooter || box.getPlant() instanceof SunFlower) {
                        box.getPlant().bullet_move(boxs,wave,p);
                    }
                }
            }
        }
    }

    public void movedZombie(Box[][] box,Wave wave){
        for(Entity z:getZombies()){
            Zombie zombie=(Zombie)z;
            int line=(((int)zombie.getPos().y()/100)-1);
            int column=(((int)zombie.getPos().x()/100));
            //System.out.println(zombie.isFreeze());
            if(!zombie.isFreeze()){
                if(zombie.isSpawned() && !this.contain_Plant()){
                    if(zombie.getPos().entity_move(zombie.getSpeed()).x()>=(((int)zombie.getPos().x())/100)*100){
                        RealCoordinates l=zombie.getPos().entity_move(zombie.getSpeed());
                        zombie.setPos(l);
                        addEntity(zombie);
                    }else{
                        RealCoordinates l=zombie.getPos().entity_move(zombie.getSpeed());
                        zombie.setPos(l);
                        removeEntity(zombie);
                        if(column-1>=0){
                            box[line][column-1].addEntity(zombie);
                        }else{
                             nb_InZone++;
                              wave.remove_enemy(zombie);
                        }
                    }}
            }
            if(zombie.isSpawned() && this.contain_Plant()){
                Plant p=getPlant();
                p.receivedDamage(zombie.getStrength());
                if(p.getHealth()<=0){
                    wave.remove_enemy(zombie);
                    removeEntity(p);
                }
            }
        }
    }

    public static boolean leftZombie(Box[][] boxs){
        for (Box[] row : boxs) {
            for (Box box : row) {
                for(Entity e:box.entities){
                    if(e instanceof Zombie){
                        return true;
                    }
                }
            }}return false;}

    public static void movedZombie_All(Box [][]boxs,Wave wave){
        // Dessine chaque case
        for (Box[] row : boxs) {
            for (Box box : row) {
                box.movedZombie(boxs,wave);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {
        if(actionListener != null){
            actionListener.actionPerformed(new ActionEvent(this,ActionEvent.RESERVED_ID_MAX+1,""));
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}