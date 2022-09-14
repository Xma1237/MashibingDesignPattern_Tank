package tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        while(true){
            Thread.sleep(50);   //rest 50ms
            tf.repaint();            //refresh the screen to show movement
        }
    }
}
