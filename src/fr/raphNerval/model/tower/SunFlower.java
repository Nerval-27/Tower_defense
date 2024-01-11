package fr.raphNerval.model.tower;

import fr.raphNerval.model.projectile.Sun;
import fr.raphNerval.player.Player;
import fr.raphNerval.view.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import java.awt.event.ActionListener;



public class SunFlower extends Plant {

    //*****ATTRIBUTS*****//
    private Image img;
    private Timer timer;
    private Timer timer_2;
    private boolean active=false;

    //*****CONSTRUCTEUR*****//
    public SunFlower(GamePanel gamePanel, int x, int y){
        super(gamePanel,x,y);
        try {
            this.img = ImageIO.read(getClass().getResource("/images/plants/sunflower.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //*****ACCESSEURS*****//
    public Image getImg(){return img;}
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    //*****METHODES*****//

   public void show_bullet(int delay,Player p) {
        ActionListener show_b = event -> {
              ((Sun)this.getBullet()).setShow(false);
               p.setMoney(p.getMoney()+25);
               this.setActive(false);
            // Ajoutez une pause pour permettre la propagation du changement
            timer.stop();// Maintenant, timer est accessible dans cette méthode
        };
        // Créer le Timer avec l'ActionListener pour gérer l'arrêt
        timer = new Timer(delay, show_b);
        ((Sun)this.getBullet()).setShow(true);
        timer.start(); // Démarrer le Timer
   }

}



