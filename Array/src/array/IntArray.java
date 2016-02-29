package array;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Array [TIPO] Descrição: Descrição:
 *
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 29/02/2016
 */
public class IntArray {

    public static void main(String[] args) {

        try {

            final int ARRAY_LENGTH = 10; // declara constante      
            int[] array = new int[ARRAY_LENGTH]; // cria o array

            // calcula o valor de cada elemento do array
            for (int counter = 0; counter < array.length; counter++) {
                array[counter] = 2 + 2 * counter;
            }

            System.out.printf("%s%8s\n", "Index", "Value"); // títulos de coluna

            // gera a saída do valor de cada elemento do array
            for (int counter = 0; counter < array.length; counter++) {
                System.out.printf("%5d%8d\n", counter, array[counter]);

            }

        } catch (InputMismatchException inputMismatchException) {
            System.err.printf("\nException: %s\n", inputMismatchException);
            scanner.nextLine(); // descarta entrada para o usuário poder tentar de novo          
            System.out.println("You must enter integers. Please try again.\n");
        }
    }

}
