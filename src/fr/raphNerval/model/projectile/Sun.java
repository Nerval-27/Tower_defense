package fr.raphNerval.model.projectile;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class Sun extends Bullet{

    //*****ATTRIBUTS*****//
    private Image image;
    private boolean show=true;

    //*****CONSTRUCTEUR*****//
    public Sun() {
        super();
        try {
            this.image= ImageIO.read(getClass().getResource("/images/bullet/sun.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //*****ACCESSEURS*****//
    public boolean isShow() {
        return show;
    }
    public void setShow(boolean show) {
        this.show = show;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
}
