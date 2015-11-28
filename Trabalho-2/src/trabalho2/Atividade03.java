package trabalho2;
import java.util.Scanner;
/**
 * @author WENES
 */
public class Atividade03 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num, i, soma=0;
        
        System.out.println("Digite um numero N inteiro positivo: ");
        num = teclado.nextInt();
        
        for(i=0; i<=num; num--){
            soma += num;
        }
        System.out.println("Soma = "+ soma);
    }
}

//1+2+3+4+5 = 6+4+5 = 15