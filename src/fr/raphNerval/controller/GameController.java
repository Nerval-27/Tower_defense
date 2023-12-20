package fr.raphNerval.controller;

import fr.raphNerval.view.GamePanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameController implements MouseListener {

    //*****ATTRIBUTS*****//
    private GamePanel gamePanel;

    //*****CONSTRUCTEUR*****//
    public GameController(GamePanel gp){
        this.gamePanel = gp;
    }

    //*****METHODES******//
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
