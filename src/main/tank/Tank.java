package tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    public static final int WIDTH = ResourceManager.tankD.getWidth();
    public static final int HEIGHT = ResourceManager.tankD.getHeight();
    private boolean living = true;
    private TankTeam team = TankTeam.BAD;//used for separate teams
    private Random random = new Random();//used for enemy tank's moving direction

    //need this TankFrame reference, so the tank can put
    //a bullet object into the TankFrame
    private TankFrame tf = null;

    //when the tank is not moving
    private boolean moving = false;

    public Tank(int x, int y, Dir dir, TankTeam team, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.team = team;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TankTeam getTeam() {
        return team;
    }

    public void setTeam(TankTeam team) {
        this.team = team;
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

        if (!living) {//check living
            this.tf.enemyTank.remove(this);
        }

        switch (dir) {//draw the tank according to tank's dir
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
        tf.bullets.add(new Bullet(this.x + 11, this.y + 11, this.dir, this.team, tf));
    }

    public void die() {
        this.living = false;
    }
}
