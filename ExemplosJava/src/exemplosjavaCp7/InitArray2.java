package exemplosjavaCp7;

/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe InitArray2
 */
public class InitArray2 {

    public static void main(String[] args) {
        
        // lista de inicializador especifica o valor de cada elemento
        
        int[] array = {32, 27, 64, 18, 95, 14, 90, 70, 60, 37};

        System.out.printf("%s%8s\n", "Index", "Value"); // títulos de coluna

        // gera saída do valor de cada elemento do array
        
        for (int i = 0; i < array.length; i++) {
            
            System.out.printf("%3d%8d\n", i, array[i]);
        }
    }
}




