package fr.raphNerval.model.field;


import fr.raphNerval.model.Entity;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class Box extends JPanel  {

    //*****ATTRIBUTS*****//

    private Entity entity;
    private boolean isEmpty;

    //*****CONSTRUCTEUR*****//
    public Box() {
        setBorder(new LineBorder(Color.RED));
        setOpaque(false);
        setSize(100, 120);

        this.entity = null;
        this.isEmpty = true;
    }

    //*****ACCESSEURS*****//
    public void addEntity(Entity p){
        this.entity = p;
        this.isEmpty = false;
        this.repaint();
    }
    public Entity getEntity(){return entity;}

    public boolean isEmpty() {return isEmpty;}

    //*****METHODES*****//
    public void removeEntity(){
        this.entity = null;
        this.isEmpty = true;
    }

    public void draw(Graphics g) {
        //g.drawRect(getX(), getY(), getWidth(), getHeight());
        if (!isEmpty) {
            entity.draw(g,getX(),getY());
        }
    }

}


