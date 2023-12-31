package fr.raphNerval.model.field;


import fr.raphNerval.model.Entity;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Box extends JPanel implements MouseListener {

    //*****ATTRIBUTS*****//
    private Entity entity;
    private boolean isEmpty;
    private ActionListener actionListener;

    //*****CONSTRUCTEUR*****//
    public Box() {
        setBorder(new LineBorder(Color.RED));
        setOpaque(false);
        addMouseListener(this);
        //setBackground(Color.green);
        setSize(100, 120);

        this.entity = null;
        this.isEmpty = true;
    }

    //*****ACCESSEURS*****//
    public Entity getEntity(){return entity;}

    public boolean isEmpty() {return isEmpty;}
    public void setActionListener(ActionListener actionListener){this.actionListener = actionListener;}

    public void setEntity(Entity entity) {this.entity = entity;}

    //*****METHODES*****//

    public void addEntity(Entity entity) {
        this.entity = entity;
        this.isEmpty = false;
        this.repaint();
    }
    public void removeEntity() {
        this.entity = null;
        this.isEmpty = true;
        this.repaint();
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
