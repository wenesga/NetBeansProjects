/**
 * @author WENES
 */
package linguagem_programacao;
import java.util.Scanner;
public class SwitchCase {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int diaSemana;
        System.out.println("Digite um dia da semana (1-7):");
        diaSemana = teclado.nextInt();
        
        switch(diaSemana){
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6:  System.out.println("Dia Útil"); break;
        case 1: 
        case 7:  System.out.println("Fim de semana"); break;
        default: System.out.println("Não é um dia da semana valido");
        }
    }
}
