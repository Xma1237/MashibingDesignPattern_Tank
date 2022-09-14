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
    @Override   //paint相当于画笔,画出坐标x,y开始- 长宽50,50的rectangle
    public void paint(Graphics g) { //会自动调用
        g.fillRect(x, y, 50, 50);
//        x += 10;
//        y += 10;
    }



    class MyKeyListener extends KeyAdapter {
        @Override//effective when press key
        public void keyPressed(KeyEvent e) {
            x += 10;    //tank move 10 pixel
//            repaint();  invoke method paint and show the movement

        }

        @Override//effective when release key
        public void keyReleased(KeyEvent e) {
            System.out.println("release");
        }


    }
}
