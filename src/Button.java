import javax.swing.*;

public class Button extends JButton {

    public Button(int x, int y) {
        this.setBounds(x,y,100,100);
//        this.setText("Coin");

        ImageIcon img = new ImageIcon("C:\\Users\\T-GAMER\\Desktop\\teste java\\JogoTela\\src\\imgs\\turtlegif.gif");

        this.setIcon(img);
        this.setBorder(null);
    }

}
