package fr.raphNerval.model.enemy;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class clacker extends Zombie{

    public Image getModel() {
        return model;
    }

    private Image model;
    public clacker(int reward, int strength) {

        super(500, 3, reward, strength);
          try {
            this.model = ImageIO.read(getClass().getResource("/images/Z.gif"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
