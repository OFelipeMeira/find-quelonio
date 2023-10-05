import javax.swing.*;

public class Label extends JLabel {
    public Label(String text, int posX, int posY){
        super(text);
        this.setBounds(posX,posY,200,200);
    }
}
