package trabalho.pkg4;
import java.util.Random;
public class Atividade05 {
    public static void main(String[] args) {
        int[] vetor = new int[9];
        int i, j, cont=0;
        
        for(i=0; i<9; i++){
            Random gerador = new Random(); 
            vetor[i] = gerador.nextInt(100);
            System.out.println("Vetor["+i+"] = " + vetor[i]);
        }
        
        System.out.println("---------------------");
        
        for(i=0; i<9; i++){
            for(j=2; j<vetor[i]; j++){
                if(vetor[i] % j == 0)
                    cont++;
            }
            if(cont == 0)
                System.out.println("Vetor["+i+"] = "+vetor[i]);
            cont = 0;
        }
    }
}
