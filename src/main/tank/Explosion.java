package tank;

import java.awt.*;

public class Explosion {
    private static int WIDTH = ResourceManager.explosions[0].getWidth();
    private static int HEIGHT = ResourceManager.explosions[0].getHeight();

    private int x, y;

    private boolean living = true;
    TankFrame tf = null;

    private int step = 0; //there are three steps of the explosion

    public Explosion(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceManager.explosions[step++], x, y, null);

        if (step >= ResourceManager.explosions.length) {
            step = 0;
        }
    }

}
