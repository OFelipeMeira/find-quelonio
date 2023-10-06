import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Button extends JButton {

    public Button(int x, int y) {
        this.setBounds(x,y,100,100);

        try {
            this.setIcon( new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/turtlegif.gif"))));
        }
        catch (Exception e ){
            e.printStackTrace();
        }

        this.setBorder(null);
    }

}
