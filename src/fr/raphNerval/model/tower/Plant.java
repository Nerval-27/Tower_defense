package fr.raphNerval.model.tower;

import fr.raphNerval.model.Entity;
import fr.raphNerval.view.GamePanel;

public class Plant extends  Entity {

    //*****ATTRIBUTS*****//
    private GamePanel gamePanel;
    protected int x,y;

    //*****CONSTRUCTEUR*****//
    public Plant(GamePanel gamePanel, int x, int y) {
        super(200, 0);
        this.gamePanel = gamePanel;
        this.x = x;
        this.y = y;
    }

    //*****ACCESSEURS*****//

    @Override
    public int getX() {return x;}

    @Override
    public int getY() {return y;}
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}

    //*****METHODES******//
    @Override
    public void move() {}

}
