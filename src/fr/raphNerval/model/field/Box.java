package fr.raphNerval.model.field;


import fr.raphNerval.Player.player;
import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.Entity;
import fr.raphNerval.model.enemy.Wave;
import fr.raphNerval.model.enemy.Zombie;
import fr.raphNerval.model.tower.Plant;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Box extends JPanel implements MouseListener {

    //*****ATTRIBUTS*****//
    private List<Entity> entities;
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public List<Entity> getEntities() {
        return entities;
    }
    private boolean isEmpty;
    private ActionListener actionListener;

    //*****CONSTRUCTEUR*****//
    public Box() {
        setBorder(new LineBorder(Color.GREEN));
        setOpaque(false);
        addMouseListener(this);
        //setBackground(Color.green);
        setSize(100, 120);

        this.entities = new ArrayList<>();
        this.isEmpty = true;
    }

    //*****ACCESSEURS*****//

    public void setActionListener(ActionListener actionListener){this.actionListener = actionListener;}

  
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

    //public Entity getEntity(){return entity;}

   public boolean isEmpty() {
        return entities.isEmpty();  // Vérifiez si la liste d'entités est vide
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
                box.getPlant().shoot(boxs);
            }
            }
        }
    }

      public static void all_Plant_shoot_move(Box[][] boxs,player p){
                // Dessine chaque case
        for (Box[] row : boxs) {
            for (Box box : row) {
                if(box.getPlant()!=null){
                box.getPlant().bullet_move(boxs,p);
                System.out.println(p.getMoney());
            }
            }
        }
    }


    public void movedZombie(Box[][] box){
        for(Entity z:getZombies()){
            Zombie zombie=(Zombie)z;
             int line=(((int)zombie.getPos().y()/100)-1);
              int column=(((int)zombie.getPos().x()/100));
              System.out.println(zombie.isFreeze());
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
                  }
            }}
        }
            if(zombie.isSpawned() && this.contain_Plant()){
                Plant p=getPlant();
                p.receivedDamage(zombie.getStrength());
                if(p.getHealth()<=0){
                       removeEntity(p);
                    }
                    }
                }
            }

        public static void movedZombie_All(Box [][]boxs){
              // Dessine chaque case
        for (Box[] row : boxs) {
            for (Box box : row) {
                box.movedZombie(boxs);
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
