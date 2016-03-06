package exemplosjavaCp7;

/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe InitArray3
 */
public class InitArray3 {

    public static void main(String[] args) {
        
        final int ARRAY_LENGTH = 10; // declara constante      
        
        int[] array = new int[ARRAY_LENGTH]; // cria o array

        // calcula o valor de cada elemento do array
        
        for (int i = 0; i < array.length; i++) {
            
            array[i] = 2 + 2 * i;
        }

        System.out.printf("%s%8s\n", "Index", "Value"); // títulos de coluna

        // gera a saída do valor de cada elemento do array
        
        for (int i = 0; i < array.length; i++) {
            
            System.out.printf("%3d%8d\n", i, array[i]);
        }
    } 
}
