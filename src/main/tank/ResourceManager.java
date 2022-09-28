package tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManager {
    public static BufferedImage tankL, tankR, tankU, tankD;
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;

    public static BufferedImage[] explosions = new BufferedImage[3];

    static {
        try {
            tankL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankL.jpg"));
            tankR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankR.jpg"));
            tankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankU.jpg"));
            tankD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankD.jpg"));

            bulletL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/BulletL.jpg"));
            bulletR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/BulletR.jpg"));
            bulletU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/BulletU.jpg"));
            bulletD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/BulletD.jpg"));

            for (int i = 0; i < 3; i++) {
                explosions[i] = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/explosion" + (i) + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
