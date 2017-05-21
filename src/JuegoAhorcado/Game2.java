package JuegoAhorcado;
import javax.swing.*;
import java.awt.Graphics;


public class Game2 extends JFrame{

    public Game2() {
        add(new NewPanel2());
    }
    public static void main(String[] args) {
        Game2 frame=new Game2();
        frame.setTitle("TestPaintComponent");
        frame.setSize(466,560);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
