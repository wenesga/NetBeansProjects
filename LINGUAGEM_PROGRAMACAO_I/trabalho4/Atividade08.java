package trabalho.pkg4;
import java.util.Scanner;
public class Atividade08 {
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);
        
        int num, i;
        double e=1, fator, j;
        
        System.out.println("Digite um numero: ");
        num = tecla.nextInt();
        
        for(i=1; i<=num; i++){
            j=i;
            fator=1;
            while(j>0){
                fator = fator * j;
                j--;
            }
            e = e + 1/fator;
        }
        System.out.printf("Para n = %d, e = %f", num, e);
    }
}
