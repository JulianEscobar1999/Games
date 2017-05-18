package JuegoDeMemoria;
import javax.swing.*;
import java.awt.Graphics;


public class Game1 extends JFrame{

    public Game1() {
        add(new NewPanel1());
    }
    public static void main(String[] args) {
        Game1 frame=new Game1();
        frame.setTitle("TestPaintComponent");
        frame.setSize(496,560);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
