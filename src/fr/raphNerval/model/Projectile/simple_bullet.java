package fr.raphNerval.model.Projectile;

import java.awt.*;
import javax.imageio.ImageIO;

import java.io.IOException;

public class simple_bullet extends projectile{
     public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    private Image image;
    public simple_bullet() {
        super();
         try {
            this.image= ImageIO.read(getClass().getResource("/images/Circle Green Sphere Gradient PNG - Free Download.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    
}}
