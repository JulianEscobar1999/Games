package JuegoAhorcado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


class NewPanel2 extends JPanel implements ActionListener,MouseListener,KeyListener{
    private Timer timer;
    private int secuencia1;
    private int x,c,bandera,muerte,salida,pal;
    private char l;
    private String[] Str;
    private int[] h;
    private Random rnd = new Random();
     
         
    public NewPanel2() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        this.addMouseListener(this);       
        this.timer=new Timer(25,this);
        this.timer.start();
        this.x=0; 
        this.c =0;
        this.l = 0;
        this.bandera=4;
        this.muerte=0;
        this.Str = new String[10];
        this.salida = 0;
        //solo mayusculas, Con minusculas toca extender el if
        Str[0]="ALMOHADA";
        Str[1]="SEBASTIAN";
        Str[2]="CUADERNO";
        Str[3]="CORTINA";
        Str[4]="AEROSOL";
        Str[5]="MEXICO";
        Str[7]="COMPUTADOR"; 
        Str[8]="RUMANIA";               
        Str[9]="MURCIELAGO";               
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);                                       
        
     Image abcd = loadImage("abc.jpg");
     Image ext = loadImage("ABCext.jpg");
     Image game = loadImage("game.jpg");
     Image stick = loadImage("stick.png");
     Image win = loadImage("win.jpg");
     g.drawImage(abcd, 0,370, this);
     System.out.println(l);
     
      //Comparar            
      //palabra a trabajar:
      int color =  (int)(rnd.nextDouble()*2 + 0);  
      if(color==1){
          g.setColor(Color.BLACK);
      }else if(color==0){
        g.setColor(Color.WHITE);
        }
      
      g.drawString("PRESIONE R PARA EMPEZAR", 250, 13);
      
      if(bandera==4){
      int alea =  (int)(rnd.nextDouble()*9 + 0);  
      pal=alea;
      bandera=3;
      }
      
      if(bandera==3){      
      h = new int[Str[pal].length()];    
      bandera =0;
      }
                   
      for(int y=0; y<Str[pal].length();y++){
          //lineas base
          g.setColor(Color.BLACK);
          g.drawLine(30+(y*45), 330, 70+(y*45), 330);
      }
      //SI PIERDE
      if(bandera==2){
           
                g.drawImage(game,0,0,this);                                              
      }
      
      //SI GANA
      if(bandera ==1){
            try { 
                g.drawImage(win,0,0,this);
                Thread.sleep(2000);                
            } catch (InterruptedException ex) {Logger.getLogger(NewPanel2.class.getName()).log(Level.SEVERE, null, ex);}                        
        } 
      
      if(bandera==0){                   
      for(int i=0; i<Str[pal].length();i++){
          if(Str[pal].charAt(i)==l||Str[pal].charAt(i)==l+64){
              //En el click siempre aumenta 1 entonces antes de pintar si es acertado se le resta
              if(salida ==0){muerte--;salida=1;}
              h[i] = 1;
              System.out.println("LA ENCONTRE EN : "+(i+1));                                  
          }          
      }   
      int c = 0;
          
      for(int j=0;j<Str[pal].length();j++){
          if(h[j]==1){
              int letraInt = Str[pal].charAt(j)-65;
              g.drawImage(ext,30+(45*j),290,70+(45*j),330,0+(letraInt*40),0,40+(letraInt*40),40,this);
              System.out.print(Str[pal].charAt(j));
          }          
          c+=h[j];
          if(c==h.length){bandera=1;break;}
          if(muerte==7){bandera=2;};
      }
      g.drawImage(stick, 10, 50, 260, 250, 0+(muerte*250), 0, 250+(muerte*250), 200, this);                   
      }
      
        
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii=new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();                  
    }       
    @Override
    public void mouseClicked(MouseEvent e) {
        Point pt = e.getPoint();
        
        if(A().contains(pt)){System.out.println("A"); l = 'A';} 
        if(B().contains(pt)){System.out.println("B");l = 'B';}
        if(C().contains(pt)){System.out.println("C");l = 'C';}
        if(D().contains(pt)){System.out.println("D");l = 'D';}
        if(E().contains(pt)){System.out.println("E");l = 'E';}
        if(F().contains(pt)){System.out.println("F");l = 'F';}
        if(G().contains(pt)){System.out.println("G");l = 'G';}
        if(H().contains(pt)){System.out.println("H");l = 'H';}
        if(I().contains(pt)){System.out.println("I");l = 'I';}
        if(J().contains(pt)){System.out.println("J");l = 'J';}
        if(K().contains(pt)){System.out.println("K");l = 'K';}
        if(L().contains(pt)){System.out.println("L");l = 'L';}
        if(M().contains(pt)){System.out.println("M");l = 'M';}
        if(N().contains(pt)){System.out.println("N");l = 'N';}
        if(Ñ().contains(pt)){System.out.println("Ñ");l = 'Ñ';}
        if(O().contains(pt)){System.out.println("O");l = 'O';}
        if(P().contains(pt)){System.out.println("P");l = 'P';}
        if(Q().contains(pt)){System.out.println("Q");l = 'Q';}
        if(R().contains(pt)){System.out.println("R");l = 'R';}
        if(S().contains(pt)){System.out.println("S");l = 'S';}
        if(T().contains(pt)){System.out.println("T");l = 'T';}
        if(U().contains(pt)){System.out.println("U");l = 'U';}
        if(V().contains(pt)){System.out.println("V");l = 'V';}
        if(W().contains(pt)){System.out.println("W");l = 'W';}
        if(X().contains(pt)){System.out.println("X");l = 'X';}
        if(Y().contains(pt)){System.out.println("Y");l = 'Y';}
        if(Z().contains(pt)){System.out.println("Z");l = 'Z';}
        muerte++;
        System.out.println("click");
        salida = 0;
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

    
    public Rectangle A(){return new Rectangle(0, 370, 50, 50);}
    public Rectangle B(){return new Rectangle(50, 370, 50, 50);}
    public Rectangle C(){return new Rectangle(100, 370, 50, 50);}
    public Rectangle D(){return new Rectangle(150, 370, 50, 50);}
    public Rectangle E(){return new Rectangle(200, 370, 50, 50);}
    public Rectangle F(){return new Rectangle(250, 370, 50, 50);}
    public Rectangle G(){return new Rectangle(300, 370, 50, 50);}
    public Rectangle H(){return new Rectangle(350, 370, 50, 50);}
    public Rectangle I(){return new Rectangle(400, 370, 50, 50);}
    public Rectangle J(){return new Rectangle(0, 420, 50, 50);}
    public Rectangle K(){return new Rectangle(50, 420, 50, 50);}
    public Rectangle L(){return new Rectangle(100, 420, 50, 50);}
    public Rectangle M(){return new Rectangle(150, 420, 50, 50);}
    public Rectangle N(){return new Rectangle(200, 420, 50, 50);}
    public Rectangle Ñ(){return new Rectangle(250, 420, 50, 50);}    
    public Rectangle O(){return new Rectangle(300, 420, 50, 50);}
    public Rectangle P(){return new Rectangle(350, 420, 50, 50);}
    public Rectangle Q(){return new Rectangle(400, 420, 50, 50);}
    public Rectangle R(){return new Rectangle(0, 470, 50, 50);}
    public Rectangle S(){return new Rectangle(50, 470, 50, 50);}
    public Rectangle T(){return new Rectangle(100, 470, 50, 50);}
    public Rectangle U(){return new Rectangle(150, 470, 50, 50);}
    public Rectangle V(){return new Rectangle(200, 470, 50, 50);}
    public Rectangle W(){return new Rectangle(250, 470, 50, 50);}
    public Rectangle X(){return new Rectangle(300, 470, 50, 50);}
    public Rectangle Y(){return new Rectangle(350, 470, 50, 50);}
    public Rectangle Z(){return new Rectangle(400, 470, 50, 50);}

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    private class TAdapter extends KeyAdapter{
        
        @Override
        public void keyReleased(KeyEvent e){
           // System.out.println("Released");
        }
        
        @Override
        public void keyPressed(KeyEvent e){
            
            int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_R){
              bandera=4;
              l=0;
              muerte=0;
              salida =0;
            }
            
            
            
        }
        
    }          
}
