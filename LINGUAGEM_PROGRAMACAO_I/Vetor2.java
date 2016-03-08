package linguagem_programacao;
import java.util.Scanner;
import java.util.Random;
/**@author WENES
 */
public class Vetor2 {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        
        int[] vetor = new int[8];
        int[] soma = new int[8];
        
        for(int i=0; i < 8; i++){
            Random aleatoria = new Random();
            vetor[i] = aleatoria.nextInt(100);
        }
        
        for(int i=0; i<vetor.length; i++){
            System.out.println("Vetor["+i+"] = "+vetor[i]);
        }
        
        System.out.println("\n");
        
        for(int i=0; i<vetor.length; i++){
            soma[i] = i + vetor[i];
            System.out.println("Soma["+i+"] = "+soma[i]);
        }   
    }
}
