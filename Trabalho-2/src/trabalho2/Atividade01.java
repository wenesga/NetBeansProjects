package trabalho2;
import java.util.Scanner;
/**
 * @author WENES
 */
public class Atividade01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int idade=0, cont=0, soma=0;
        double media;
        String sexo;
        System.out.println("Digite a idade: ");
        idade = teclado.nextInt();
        while (idade > 0){
            System.out.println("Digite o sexo: ");
            sexo = teclado.next();
            if(sexo.equalsIgnoreCase("f")){
                cont++;
                soma += idade;
            }
            System.out.println("Digite a idade: ");
            idade = teclado.nextInt();
        }
        media = soma/cont;
        System.out.println("Idade Média mulher = "+ media);   
    }
}
