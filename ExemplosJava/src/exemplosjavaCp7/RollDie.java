package exemplosjavaCp7;
import java.util.Random;

// Figura 7.7: RollDie.java

/*
 * @Descrição: Programa de jogo de dados utilizando arrays em vez de switch
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe RollDie
 */

public class RollDie {

    public static void main(String[] args) {
        
        Random aleatorio = new Random();   // gerador de número aleatório
        
        int[] frequencia = new int[7];      // array de contadores de frequência

        // lança o dados 6000 vezes; utiliza o valor do dado como índice de frequência 
        
        for (int i = 1; i <= 6000; i++) {
            
            ++frequencia[1 + aleatorio.nextInt(6)];
            
        }

        System.out.printf("%s%10s\n", "Face", "Frequency");

        // gera saída do valor de cada elemento do array
        
        for (int j = 1; j < frequencia.length; j++) {
            
            System.out.printf("%4d%10d\n", j, frequencia[j]);
            
        }
    }
}
