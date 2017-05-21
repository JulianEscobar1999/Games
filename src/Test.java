import java.io.*;
import java.util.*;

public class Test {

   public static void main(String args[]) {
      String[] Str = new String[10];
      Str[0]="COLOMBIA";
      Scanner leer = new Scanner(System.in);
      
      int pal = 0;    
      int[] h = new int[Str[pal].length()];
      
      int c = 0;
      System.out.println(Str[pal].length());
      while(c<10){
      c++;       
      char ñ = ' ';
      ñ = leer.next().charAt(0);
              
      for(int i=0; i<Str[pal].length();i++){
          if(Str[pal].charAt(i)==ñ||Str[pal].charAt(i)==ñ+64){
              h[i] = 1;
              System.out.println("LA ENCONTRE EN : "+(i+1));                                  
          }          
      }
      
      for(int j=0;j<Str[pal].length();j++){
          if(h[j]==1){
              System.out.print(Str[pal].charAt(j)); 
          }else if(h[j]==2){
              System.out.print(" ");
          }else if(h[j]!=1){
              System.out.print("_");
          }
          System.out.print(".");
      }
      }
      
   }
}