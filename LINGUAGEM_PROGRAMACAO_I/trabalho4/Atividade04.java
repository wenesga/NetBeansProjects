package trabalho.pkg4;
import java.util.Scanner;
public class Atividade04 {
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);
        int i, num, cont=1;
        System.out.println("Digite um numero: ");
        num = tecla.nextInt();
        
        for(i=1; i<num; i++){
            if(num % i == 0)
                cont++;
        }
        
        if(cont>2)
            System.out.println("Não é primo");
        else
            System.out.println("É primo");
    }
}
