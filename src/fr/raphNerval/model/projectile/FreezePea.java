package fr.raphNerval.model.projectile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FreezePea extends Bullet {

    //*****ATTRIBUTS*****//
    private Timer timer;
    private Image image;

    //*****CONSTRUCTEUR*****//
    public FreezePea() {
        super();
        try {
            this.image = ImageIO.read(getClass().getResource("/images/bullet/freezepea.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //*****ACCESSEURS*****//
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    //*****METHODES*****//
    public void stop_mouvement(int delay) {
        ActionListener stop = event -> {
            this.getTarget().setFreeze(false);
            System.out.println(this.getTarget().isFreeze());
            // Ajoutez une pause pour permettre la propagation du changement

            timer.stop(); // Maintenant, timer est accessible dans cette méthode
        };
        // Créer le Timer avec l'ActionListener pour gérer l'arrêt
        timer = new Timer(delay, stop);
        this.getTarget().setFreeze(true); // Mettez à true avant de démarrer le Timer
        timer.start(); // Démarrer le Timer
    }

}

