
package Escenario;
import javax.swing.*;
import java.awt.Graphics;

public class Game extends JFrame{

    public Game() {
        add(new NewPanel());
    }
    public static void main(String[] args) {
        Game frame=new Game();
        frame.setTitle("TestPaintComponent");
        frame.setSize(2000,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
