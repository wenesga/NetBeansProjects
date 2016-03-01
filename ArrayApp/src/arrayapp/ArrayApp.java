package arrayapp;
import java.util.Random;
import java.util.Scanner;

/**
 * ArrayApp [TIPO] Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 29/02/2016
 */
public class ArrayApp {

    public static void main(String[] args) {

        try {

            Scanner ler = new Scanner(System.in);

            System.out.println("Entre com a primeira posiçoes: ");
            
            int posicao = ler.nextInt();

            int[] A = new int[posicao];
            int[] B = new int[posicao];
            int[] C = new int[posicao];

            Random r = new Random();
            
            for (int i = 0; i < posicao; i++) {
                A [i] = r.nextInt(50);
                B [i] = r.nextInt(50);
            }
            
            for (int j = 0; j < posicao; j++) {
                C [j] = A[j] + B[j];
            }
            
            for (int k = 0; k < posicao; k++) {
                System.out.printf("%5d %8d\n%d\n", A[k], B[k], C[k]);
            }

        } 
        
        catch (Exception ex) {
            
            System.out.printf("PRIMEIRA EXCESAO.\n");
        }

    }

}
