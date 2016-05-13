package array;
// Figura 7.5: SumaArray.java
// Calculando a soma dos elementos de um array.
/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe SomaArray
 */

public class SomaArray {

    public static void main(String[] args) {

        int[] array = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};
        
        int total = 0;

        // adiciona o valor de cada elemento ao total
        
        for (int i = 0; i < array.length; i++) {
            
            total += array[i];
            
        }

        System.out.printf("Total de elementos do array: %d\n", total);
    }

}
