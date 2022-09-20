package tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 15;
    private static final int WIDTH = 15, HEIGHT = 15;
    private int x, y;
    private Dir dir;
    private boolean live = true;
    TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x + 10;
        this.y = y + 10;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }

        /* Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c); */
        switch (dir){
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
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

        //if bullet is out of border, change live to false for delete
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live = false;

    }

}
