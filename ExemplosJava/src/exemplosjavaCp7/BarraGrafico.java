package exemplosjavaCp7;

/* Figura 7.6: BarraGrafico.java
 * @Descrição: programa de impressão de gráfico de barras.
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe BraficoBarra
 */
public class BarraGrafico {

    public static void main(String[] args) {
        
        int[] array = {0, 0, 0, 0, 0, 0, 1, 2, 4, 2, 1};

        System.out.println("Atribuição de notas:");

        // para cada elemento de array, gera saída de uma barra do gráfico
        
        for (int i = 0; i < array.length; i++) {
            
            // imprime rótulo de barra ( "00­09: ", …, "90­99: ", "100: " )
            
            if (i == 10) {
                
                System.out.printf("%5d: ", 100);
                
            } else {
                
                System.out.printf("%02d­%02d: ", i * 10, i * 10 + 9);
            }

            // imprime a barra de asteriscos   
            
            for (int j = 0; j < array[i]; j++) {
                
                System.out.print("*");
                
            }

            System.out.println(""); //inicia uma nova linha de saída
        } 
    }

}
