import javax.swing.*;
import java.awt.*;

public class CloseBtn extends JButton {
    CloseBtn(){
        super("X");
        this.setBounds(10,10,45,45);
        this.setBackground(Color.RED);
        this.addActionListener( e -> System.exit(0));
    }
}
