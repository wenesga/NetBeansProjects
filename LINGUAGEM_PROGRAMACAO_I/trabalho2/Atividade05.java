package trabalho2;
import java.util.Scanner;
/**
 * @author WENES
 */
public class Atividade05{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cont=0;
        double nota1 = 0, nota2, media, soma = 0, mediaTurma;

        System.out.print("Digite a 1ª nota do aluno = ");
        nota1 = teclado.nextDouble();
        
        while(nota1 != -1){
            System.out.print("Digite a 2ª nota do aluno = ");
            nota2 = teclado.nextDouble();
            cont++;
            media = (nota1 + nota2) / 2;
            soma += media;
            
            System.out.printf("Média do %dº aluno = %.2f\n",cont, media);
            System.out.println("------------------------------");
            
            System.out.print("Digite a 1ª nota do aluno = ");
            nota1 = teclado.nextDouble();
        }
        mediaTurma = soma / cont;
        System.out.println("Média da Turma = " + mediaTurma);
    }
}
