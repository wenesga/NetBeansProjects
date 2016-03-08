package atividadelpii;

import java.util.Random;

/**
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 07/03/2016 - @TIPO Classe exercício1
 */
public class Exercicio1 {

    public static void main(String[] args) {

        int[] array = new int[10];
        Random aleatorio = new Random();

        try {

            for (int i = 0; i < array.length; i++) {
                array[i] = aleatorio.nextInt(100);
                System.out.println("array[" + i + "] = " + array[i]);
            }

            maiorMenor(array, 0, 0, 0);

        } catch (RuntimeException exception) {

            System.out.println("Ocorreu um erro!");

        }

    }

    public static int maiorMenor(int[] array, int i, int maior, int menor) {

        for (i = 0; i < array.length; i++) {

            if (i == array[0]) {
                maior = array[i];
            } else if (array[i] >= maior) {
                maior = array[i];
            }
        }

        System.out.println("Maior  = " + maior);
        return maior;
    }
}
