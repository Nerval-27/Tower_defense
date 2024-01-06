package fr.raphNerval.model.Projectile;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class stop_bullet extends projectile {
    private Timer timer; // Déplacer la déclaration ici

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    private Image image;

    public stop_bullet() {
        super();
        try {
            this.image = ImageIO.read(getClass().getResource("/images/blue.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
