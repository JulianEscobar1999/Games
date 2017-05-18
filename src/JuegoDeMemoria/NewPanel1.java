package JuegoDeMemoria;

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
public class NewPanel1 extends JPanel implements KeyListener, ActionListener,MouseListener{
    private Timer timer;
    private int secuencia1;
    private int x,contador,delX, delY,a,b,c,d,e,f,h,n,score;
    
    public NewPanel1() {
        this.addMouseListener(this);
        addKeyListener(new TAdapter());
        setFocusable(true);
        this.timer=new Timer(25,this);
        this.timer.start();
        this.x=0;
        this.delX=0;
        this.delY=0;
        this.contador=0;
        this.secuencia1=0;
        this.a=0;
        this.score=100;
        a=b=c=d=e=f=h=n;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        
        
        
        //Image background = loadImage("blue_background.png");
        Image inCards = loadImage("invCar.jpg");        
        Image goku= loadImage("goku.jpg");
        Image cardumen= loadImage("cardumen.jpg");
        Image babel= loadImage("babel.jpg");
        Image bart= loadImage("bart.jpg");
        Image computador= loadImage("computador.jpg");
        Image mago= loadImage("mago.jpg");
        Image nn= loadImage("nn.jpg");
        Image skrillex= loadImage("skrillex.jpg");
        
        for(int i=0; i<4;i++){      
            for(int j=0;j<4;j++){           
           g.drawImage(inCards, i*120, j*120, this);
            }
        }
        
        if((delX==1||delY==1)&&(delX==11||delY==11)){a=1;}
        if((delX==2||delY==2)&&(delX==7||delY==7)){b=1;} //cardumen
        if((delX==3||delY==3)&&(delX==10||delY==10)){c=1;} //babel
        if((delX==4||delY==4)&&(delX==5||delY==5)){d=1;} //bart
        if((delX==12||delY==12)&&(delX==15||delY==15)){e=1;} //computador
        if((delX==6||delY==6)&&(delX==8||delY==8)){f=1;} //mago
        if((delX==9||delY==9)&&(delX==13||delY==13)){h=1;}//nn
        if((delX==14||delY==14)&&(delX==16||delY==16)){n=1;} //Skrillex
        
        
        if(delX==1||delY==1||a==1){g.drawImage(goku,0,0,this);}
        if(delX==2||delY==2||b==1){g.drawImage(cardumen,120,0,this);}
        if(delX==3||delY==3||c==1){g.drawImage(babel,240,0,this);}
        if(delX==4||delY==4||d==1){g.drawImage(bart,360,0,this);}
        if(delX==5||delY==5||d==1){g.drawImage(bart,0,120,this);}
        if(delX==6||delY==6||f==1){g.drawImage(mago,120,120,this);}
        if(delX==7||delY==7||b==1){g.drawImage(cardumen,240,120,this);}
        if(delX==8||delY==8||f==1){g.drawImage(mago,360,120,this);}
        if(delX==9||delY==9||h==1){g.drawImage(nn,0,240,this); }
        if(delX==10||delY==10||c==1){g.drawImage(babel,120,240,this);}
        if(delX==11||delY==11||a==1){g.drawImage(goku,240,240,this);}
        if(delX==12||delY==12||e==1){g.drawImage(computador,360,240,this);}
        if(delX==13||delY==13||h==1){g.drawImage(nn,0,360,this);}
        if(delX==14||delY==14||n==1){g.drawImage(skrillex,120,360,this);}
        if(delX==15||delY==15||e==1){g.drawImage(computador,240,360,this);}
        if(delX==16||delY==16||n==1){g.drawImage(skrillex,360,360,this);}
        
        if(score<=0){
            g.setColor(Color.RED);
            g.drawString("PERDISTE", 205, 502);   
            timer.stop();
        }else if(a==1&&b==1&&c==1&&d==1&&e==1&&f==1&&h==1&&n==1){                                                                 
            g.drawString("Score : "+score,420, 502);
            g.setColor(Color.BLUE);
            g.drawString("GANASTE", 205, 502);                         
            timer.stop();   
        }else{     
        g.drawString("Diviertete", 205, 502);
        }
        
        g.drawRoundRect(200, 485, 80, 30,2,3);
        
        
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
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        if(contador==0){
        if(ceroCero().contains(mp)){ 
                delX=1;                  
                System.out.println("00");                                          
        }else if(unoCero().contains(mp)){
                delX=2;
                System.out.println("10");                                          
        }else if(dosCero().contains(mp)){
                delX=3;                
                System.out.println("20");                
        }else if(tresCero().contains(mp)){
                delX=4;
                System.out.println("30");
        }else if(ceroUno().contains(mp)){
                delX=5;
                System.out.println("01");
        }else if(unoUno().contains(mp)){
                delX=6;         
                System.out.println("11");
        }else if(dosUno().contains(mp)){                
                delX=7;
                System.out.println("21");
        }else if(tresUno().contains(mp)){
                delX=8;
                System.out.println("31");
        }else if(ceroDos().contains(mp)){
                delX=9;
                System.out.println("02");                
        }else if(unoDos().contains(mp)){                
                delX=10;
                System.out.println("12");
        }else if(dosDos().contains(mp)){
                delX=11;
                System.out.println("22");
        }else if(tresDos().contains(mp)){
                delX=12;
                System.out.println("32");
        }else if(ceroTres().contains(mp)){
                delX=13;
                System.out.println("03");
        }else if(unoTres().contains(mp)){
                delX=14;
                System.out.println("13");
        }else if(dosTres().contains(mp)){
                delX=15;                
                System.out.println("23");
        }else if(tresTres().contains(mp)){
                delX=16;         
                System.out.println("33");
        }}else if(contador==1){
        
        if(ceroCero().contains(mp)){ 
                delY=1;                  
                System.out.println("00");                                          
        }else if(unoCero().contains(mp)){
                delY=2;
                System.out.println("10");                                          
        }else if(dosCero().contains(mp)){
                delY=3;                
                System.out.println("20");                
        }else if(tresCero().contains(mp)){
                delY=4;
                System.out.println("30");
        }else if(ceroUno().contains(mp)){
                delY=5;
                System.out.println("01");
        }else if(unoUno().contains(mp)){
                delY=6;         
                System.out.println("11");
        }else if(dosUno().contains(mp)){                
                delY=7;
                System.out.println("21");
        }else if(tresUno().contains(mp)){
                delY=8;
                System.out.println("31");
        }else if(ceroDos().contains(mp)){
                delY=9;
                System.out.println("02");                
        }else if(unoDos().contains(mp)){                
                delY=10;
                System.out.println("12");
        }else if(dosDos().contains(mp)){
                delY=11;
                System.out.println("22");
        }else if(tresDos().contains(mp)){
                delY=12;
                System.out.println("32");
        }else if(ceroTres().contains(mp)){
                delY=13;
                System.out.println("03");
        }else if(unoTres().contains(mp)){
                delY=14;
                System.out.println("13");
        }else if(dosTres().contains(mp)){
                delY=15;                
                System.out.println("23");
        }else if(tresTres().contains(mp)){
                delY=16;         
                System.out.println("33");
        } 
            
        }
        
        contador++;
        System.out.println("CLICK");
        if(contador==3){
            
                score-= 8;
                delY=0;
                delX=0;
                contador=0;                 
        }
        
        System.out.println("contador"+contador);
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
       
    }
    
    public Rectangle ceroCero(){        
        return new Rectangle(0, 0, 120, 120);
    }
    public Rectangle unoCero(){        
        return new Rectangle(120, 0, 120, 120);
    }
    public Rectangle dosCero(){        
        return new Rectangle(240, 0, 120, 120);
    }
    public Rectangle tresCero(){        
        return new Rectangle(360, 0, 120, 120);
    }
    public Rectangle ceroUno(){        
        return new Rectangle(0, 120, 120, 120);
    }
    public Rectangle unoUno(){        
        return new Rectangle(120, 120, 120, 120);
    }
    public Rectangle dosUno(){        
        return new Rectangle(240, 120, 120, 120);
    }
    public Rectangle tresUno(){        
        return new Rectangle(360, 120, 120, 120);
    }
    public Rectangle ceroDos(){        
        return new Rectangle(0, 240, 120, 120);
    }
    public Rectangle unoDos(){        
        return new Rectangle(120, 240, 120, 120);
    }
    public Rectangle dosDos(){        
        return new Rectangle(240, 240, 120, 120);
    }
    public Rectangle tresDos(){        
        return new Rectangle(360, 240, 120, 120);
    }
    public Rectangle ceroTres(){        
        return new Rectangle(0, 360, 120, 120);
    }
    public Rectangle unoTres(){        
        return new Rectangle(120, 360, 120, 120);
    }
    public Rectangle dosTres(){        
        return new Rectangle(240, 360, 120, 120);
    }
    public Rectangle tresTres(){        
        return new Rectangle(360, 360, 120, 120);
    }
    
    
    
   private class TAdapter extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e){
            System.out.println("tecla soltada");
        }
        @Override
        public void keyPressed(KeyEvent e){
            System.out.println("tecla presionada");
            int key = e.getKeyCode();
            if(key==KeyEvent.VK_SPACE){
                System.out.println("VK_SPACE");
            }
            if(key==KeyEvent.VK_UP){
                
            }
            if(key==KeyEvent.VK_LEFT){
                
            }
            if(key==KeyEvent.VK_RIGHT){
                x=x-5;
                secuencia1++;
                System.out.println("hi");
            }
            if(key==KeyEvent.VK_DOWN){
                
            }
        }
    }
}
