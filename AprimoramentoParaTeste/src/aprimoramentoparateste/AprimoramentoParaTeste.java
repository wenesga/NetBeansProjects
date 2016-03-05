package aprimoramentoparateste;

/**
 * @Descrição: ATIVIDADE DE APRIMORAMENTO DE TESTE-PROFESSOR: EEECLAUDIO
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 01/03/2016 - @TIPO Classe AprimoramentoParaTeste.
 */
public class AprimoramentoParaTeste {

    public static void main(String[] args) {

        try {
            int[] array = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};
            int total = 0;

            // adiciona o valor de cada elemento ao total
            for (int number : array) {

                total = total + number;
            }

            System.out.printf("Total da somas dos elementos de array: %d\n", total);
            
            //total = 87/0;
        
        } catch (ArithmeticException ex) {
            
            System.out.println("Aconteceu um erro");

        }
    }
}