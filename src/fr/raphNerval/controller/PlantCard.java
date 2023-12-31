package fr.raphNerval.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlantCard extends JPanel implements MouseListener {
    //*****ATTRIBUTS*****//
    private Image cardImg;
    private ActionListener actionListener;

    //*****CONSTRUCTEUR*****//
    public PlantCard(String str){
        this.setSize(64,90);
        this.cardImg = new ImageIcon(getClass().getResource(str)).getImage();
        this.addMouseListener(this);
    }

    //*****ACCESSEURS*****//
    public void setActionListener(ActionListener actionListener){this.actionListener=actionListener;}
    public Image getCardImg() {return cardImg;}

    //*****METHODES******//
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.cardImg,0,0,null);
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
