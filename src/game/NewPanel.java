/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class NewPanel extends JPanel implements KeyListener, ActionListener{
    private Timer timer;
    private int secuencia1;
    private int x,salto,bandera,vi,noPaint,bicho;
    public NewPanel() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        this.timer=new Timer(25,this);
        this.timer.start();
        this.x=0;
        this.bandera=0;
        this.salto=0;
        this.secuencia1=0;
        this.vi=0;
        this.noPaint=0;
        this.bicho=0;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondoA = loadImage("blue_background.png");  
        Image nube = loadImage("clouds.png");
        Image suelo = loadImage("ground_loop.png");
        Image rojo= loadImage("walking.png");
        Image villano = loadImage("enemy_run.png");
        Image jump = loadImage("jump.png");
        Image gameOver= loadImage("gameover.jpg");
        for(int i=0; i<=800;i++){g.drawImage(fondoA, i*22, 0, this);}
        for(int i=0; i<=100; i++){g.drawImage(nube, x+(i*335), 20, this);}
        for(int i=0;i<=900;i++){g.drawImage(suelo, x+i*112, 514, this);}
        
        
        if(bandera==1){salto-=2;x-=3;        
            if(salto==-140){bandera=2;}
            g.drawImage(jump, 200, 380+salto, 295, 514+salto, 0, 0, 96, 142, this);
        }else{g.drawImage(rojo, 200, 380+salto, 315, 514+salto, secuencia1*115, 0, (secuencia1*115)+115, 134, this);}
         
        if(bandera==2){salto+=2;x-=2;
            if(salto==0){bandera=0;}
        }
          
    //para m/o lento
        noPaint++;
        if(noPaint==6){
        vi++;
        if(vi==2){vi=0;}
        noPaint=0;
        }
        bicho++;
        
        for(int s=0; s<200 ; s++){
        g.drawImage(villano,900+(s*1500)-bicho+x , 400,  970+(s*1500)-bicho+x  ,514,         vi*105,      0,     (vi*105)+105,     101, this);         
        if(comparador(900+(s*1500)-bicho+x , 400)==1||comparador(900+(s*1500)-bicho+x+70,400)==1){
            bandera=5;                       
        }              
        }
        
        if(bandera==5){
            g.drawImage(gameOver,0,0,this);
        }
        
    }
    public Rectangle niño(){
        return new Rectangle(200, 380+salto, 115, 70);
    }
    
    public Point point(int a, int b){
        return new Point(a,b);
    }
    
    public int comparador(int a, int b){
        int p=0;
        if(niño().contains(point(a,b))){      
            p=1;            
            System.out.println("ENcontrado");
        }                
        return p;
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii=new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        
        if(this.secuencia1==4){
            this.secuencia1=0;
        }
        
        
        
    }
   private class TAdapter extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e){
            
        }
        @Override
        public void keyPressed(KeyEvent e){
            
            
            int key = e.getKeyCode();
            
            if(key==KeyEvent.VK_SPACE){
            
            
            }
            if(key==KeyEvent.VK_UP){
            
                
                if(bandera==0){ bandera=1;}
            
            
            }
            if(key==KeyEvent.VK_LEFT){
                
            }
            if(key==KeyEvent.VK_RIGHT){  
                //Para que al saltar no ejecute la secuencia
                
                if(bandera==0){
                if(noPaint==3){                
                secuencia1++;                
                }
                x-=5;
                }
            }
            if(key==KeyEvent.VK_DOWN){
                
            }
        }
    }
}
