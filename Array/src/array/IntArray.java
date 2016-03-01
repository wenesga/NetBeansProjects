package array;
import java.util.InputMismatchException;

/**
 * Array [TIPO] Descrição: Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 29/02/2016
 */
public class IntArray {

    public static void main(String[] args) {

        try {

            final int ARRAY_LENGTH = 5;       
            
            int[] array = new int[ARRAY_LENGTH]; 


            for (int counter = 0; counter < array.length; counter++) {
                array[counter] = 2 + 2 / counter;
            }

            System.out.printf("%s%8s\n", "Indice", "Valor"); 

            for (int counter = 0; counter < array.length; counter++) {
                System.out.printf("%5d%8d\n", counter, array[counter]);
            }
        } 
        
        catch (Exception ex) {
            System.out.println("PRIMEIRA EXCESAO.\n");
        }
    }
}
