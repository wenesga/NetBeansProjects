package linguagem_programacao;
import java.util.Scanner;
/**
 * @author WENES
 */
public class Vetor1 {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        
        int[] vetor = new int[5];
        
        for(int i=0; i<vetor.length; i++){
            System.out.print("Vetor["+i+"] = ");
            vetor[i] = teclado.nextInt();
        } 
        
        for(int i=0; i<vetor.length; i++){
            System.out.println("Vetor["+i+"] = "+vetor[i]);
        }
    }
}
