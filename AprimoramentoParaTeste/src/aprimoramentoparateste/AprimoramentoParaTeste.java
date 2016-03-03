package aprimoramentoparateste;

/**ATIVIDADE - PROFESSOR: CLAUDIO - WENES
 * @Descrição: ATIVIDADE - PROFESSOR: CLAUDIO - WENES
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 01/03/2016 - @TIPO Classe AprimoramentoParaTeste
 */
public class AprimoramentoParaTeste {

    public static void main(String[] args) {

        try {
            int[] array = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};
            int total = 0;

            // adiciona o valor de cada elemento ao total
            for (int number : array) {

                total += number;
            }

            System.out.printf("Total de elementos de array: %d\n", total);

        
        } catch (Exception ex) {
            
            System.out.println(" Wenes");

        }
    }
}