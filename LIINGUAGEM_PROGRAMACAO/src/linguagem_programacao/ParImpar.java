package linguagem_programacao;
import java.util.Scanner;
public class ParImpar {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n;
        System.out.println("Digite um numero");
        n = teclado.nextInt();
        
        switch(n%2){
        case 0: System.out.println("Par"); break;
        case 1: System.out.println("Impar"); break;
        }
    }
}