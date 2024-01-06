package fr.raphNerval.model.enemy;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class Mastiff extends Zombie{

    public Image getModel() {
        return model;
    }

    private Image model;
    public Mastiff (int reward, int strength) {

        super(10000, 1, reward, strength);
          try {
            this.model = ImageIO.read(getClass().getResource("/images/Mastiff.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
