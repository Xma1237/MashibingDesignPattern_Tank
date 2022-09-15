package tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //you need variables to make tank move the position
    int x = 200, y = 200;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 10;   //tank moving speed


    @Override   //paint相当于画笔,画出坐标x,y开始- 长宽50,50的rectangle
    public void paint(Graphics g) { //会自动调用
        g.fillRect(x, y, 50, 50);
//        x += 10;
//        y += 10;

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

    class MyKeyListener extends KeyAdapter {
        //set boolean false to left,right,up,down
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override//effective when press key
        public void keyPressed(KeyEvent e) {
            /*
            int keyCode = e.getKeyCode();

            System.out.println(keyCode);    //show the key you pressed

              not perfect for going upper/lower right/left at same time
            switch (keyCode) {
                case KeyEvent.VK_LEFT:  //VK_37 also works
                    x -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 10;
                    break;
                case KeyEvent.VK_UP:
                    y -= 10;
                    break;
                case 40:
                    y += 10;
                    break;
            }

             x += 10;    //tank move 10 pixel
            repaint();  invoke method paint and show the movement
            */
            //while pressing key, make boolean true
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        //effective when release key, set boolean back to false
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("release");
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (bL) dir = Dir.LEFT;
            if (bR) dir = Dir.RIGHT;
            if (bU) dir = Dir.UP;
            if (bD) dir = Dir.DOWN;
        }
    }
}
