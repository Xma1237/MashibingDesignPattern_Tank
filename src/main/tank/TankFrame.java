package tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    int x = 200, y = 200;

    @Override   //paint相当于画笔,画出坐标x,y开始- 长宽50,50的rectangle
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        x += 10;
        y += 10;
    }
}
