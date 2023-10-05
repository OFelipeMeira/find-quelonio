import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class Tela extends JFrame implements KeyListener{
    private final int screenWidth;
    private final int screenHeight;
    private final Button button;

    Tela(String title){
        super(title);
        this.setBounds(0,0,250,250);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground( Color.WHITE );

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = (int)size.getWidth();
        this.screenHeight = (int)size.getHeight();

        Random rnd = new Random();
        int newPosX = rnd.nextInt(screenWidth-100);
        int newPosY = rnd.nextInt(screenHeight-100);
        this.button = new Button(newPosX, newPosY );

        // Finish the game
        this.button.addActionListener(e -> {
           this.finishGame();
        });

        this.add(this.button);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // WASD and Arrows Keys
        switch (e.getKeyCode()) {
            case 37, 38, 39, 40, 65, 68, 87, 83 -> move(e.getKeyCode());
        }
    }

    private void move(int keyCode){
        switch (keyCode) {
            case 37, 65 -> {
                if (this.getX() > 0) {
                    this.setLocation(this.getX() - 20, this.getY());
                    this.button.setLocation(this.button.getX()+20, this.button.getY());
                }
            }
            case 38, 87 -> {
                if (this.getY() > 0) {
                    this.setLocation(this.getX(), this.getY() - 20);
                    this.button.setLocation(this.button.getX(), this.button.getY() + 20);
                }
            }
            case 39, 68 -> {
                if (this.getX() + this.getWidth() < this.screenWidth) {
                    this.setLocation(this.getX() + 20, this.getY());
                    this.button.setLocation(this.button.getX() - 20, this.button.getY());
                }
            }
            case 40, 83 -> {
                if (this.getY() + this.getHeight() < this.screenHeight) {
                    this.setLocation(this.getX(), this.getY() + 20);
                    this.button.setLocation(this.button.getX(), this.button.getY() - 20);
                }
            }
        }
    }

    private void finishGame(){
        this.setBounds((screenWidth-200)/2 , (screenHeight-200)/2, 200,200);
        Label text = new Label("Oh no, you found me,",25,-50);
        Label text2 = new Label("Let me try again!",25,-30);
        this.add(text);
        this.add(text2);
        this.button.setBounds(25,100,150,50);
        this.button.setText("End Game");
        this.button.setIcon(new ImageIcon());
        this.button.addActionListener(f ->{
            System.exit(0);
        });
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
