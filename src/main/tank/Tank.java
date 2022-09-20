package tank;

import java.awt.*;

public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    //need this TankFrame reference, so the tank can put
    //a bullet object into the TankFrame
    private TankFrame tf = null;

    //when the tank is not moving
    private boolean moving = false;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    // method to draw the tank
    public void paint(Graphics g) {
        /* Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 50, 50);
        g.setColor(c); */

        switch (dir){//draw the tank according to tank's dir
            case LEFT:
                g.drawImage(ResourceManager.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.tankD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        if (!moving) return;

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

    //fire bullet method
    public void fire() {
        tf.bullets.add(new Bullet(this.x, this.y, this.dir, tf));
    }
}
