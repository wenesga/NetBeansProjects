package trabalho2;
import java.util.Scanner;
/**
 * @author WENES
 */
public class Atividade09 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int idade, cont=0;
        double soma=0, media;
        System.out.print("Digite a 1ª idade: ");
        idade = teclado.nextInt();
        while(idade != 0){
            cont++;
            soma = soma + idade;
            System.out.printf("Digite a %dª idade: ", cont+1);
            idade = teclado.nextInt();
        }
        media = soma/cont;
        System.out.println("Média das idades = "+media);
    }
}
