package Aulas;
import java.util.Scanner;
public class MatematicaTeste {
       
      public static void main (String [] args) {
             
              Scanner teclado =  new Scanner(System.in);
      
              Matematica m = new Matematica ();
              
              System.out.print("Calcular Raiz Quadrada: ");
              int numero = teclado.nextInt();
           
              System.out.println("A Raiz Quadrada de " + numero +" é: " + m.raiz(numero));
              
              System.out.println("Raiz quadrada do sistema: " + Math.sqrt(800));
             
      }
}
