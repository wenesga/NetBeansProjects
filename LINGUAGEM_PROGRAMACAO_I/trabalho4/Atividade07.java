package trabalho.pkg4;
import java.util.Random;
import java.util.Scanner;
public class Atividade07 {
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);
        
        int[] vetor = new int[10];
        int i, num;
        
        for(i=0; i<10; i++){
            Random gerador = new Random();
            vetor[i] = gerador.nextInt(100);
            System.out.println("Vetor["+i+"] = " + vetor[i]);
        }
        
        System.out.print("Pequisar vetor: ");
        num = tecla.nextInt();
        i=0;
        
        while(i<10 && vetor[i] != num)
            i++;
        if (i < 10)
            System.out.printf("%d Foi encontrado na posição %d", num, i);
        else
            System.out.println("Não foi encontrado:" + num);
    }
}

