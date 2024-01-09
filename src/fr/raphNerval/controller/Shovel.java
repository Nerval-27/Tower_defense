package fr.raphNerval.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Shovel extends JPanel implements MouseListener {

    //*****ATTRIBUTS*****//
    private Image img;
    private ActionListener actionListener;

    //*****CONSTRUCTEUR*****//
    public Shovel(){
        setSize(80,80);
        this.img = new ImageIcon(getClass().getResource("/images/buttons/Shovel.png")).getImage();
        addMouseListener(this);

    }

    //*****ACCESSEURS*****//
    public ActionListener getActionListener(){return actionListener;}
    public void setActionListener(ActionListener actionListener) {this.actionListener = actionListener;}

    //*****METHODES******//
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.img,0,0,null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {
        if (actionListener != null) {
            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.RESERVED_ID_MAX + 1, ""));
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

}
