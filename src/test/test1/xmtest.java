package test1;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class xmtest{
    @Test
    public void test(){
        try {
            BufferedImage image = ImageIO.read(new File("D:/rescourse/tank.jpg"));
            assertNotNull(image);//断言

            BufferedImage image2 = ImageIO.read(xmtest.class.getClassLoader().getResourceAsStream("images/tankL.jpg"));
            assertNotNull(image2);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
