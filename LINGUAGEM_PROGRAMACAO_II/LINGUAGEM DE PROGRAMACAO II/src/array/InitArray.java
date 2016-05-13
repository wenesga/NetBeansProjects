package array;

/**
 * @Descrição: Inicializando os elementos de um array como valores padrão de zero.
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe IntArrey
 */
public class InitArray {

    public static void main(String[] args) {

        int[] array = new int[10];         

        System.out.printf(" %s %8s\n", "Indice","Valor"); // títulos de coluna

        // gera saída do valor de cada elemento do array              
        for (int i = 0; i < array.length; i++) {
            
            System.out.printf("%4d%10d\n", i, array[i]);
            
        }

    }

}




