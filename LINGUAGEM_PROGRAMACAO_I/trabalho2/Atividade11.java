package trabalho2;
import java.util.Scanner;
/**
 * @author WENES
 */
public class Atividade11 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int idade;

        System.out.println("Qual é sua Idade: ");
        idade = teclado.nextInt();
        
        if(idade < 16 ){
            System.out.println("Não é eleitor");
        }
        else if(idade >= 18 && idade <= 65)
            System.out.println("Eleitor obrigatório");
        else
            System.out.println("Eleitor facultativo");
    }
}