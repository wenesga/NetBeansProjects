package trabalho2;
import javax.swing.JOptionPane;
/**
 * @author WENES
 */
public class Atividade04 {
    public static void main(String[] args) {
        int i, somaPar=0, multImpar=1;
        int[] num = new int[20];
        for(i=0; i< num.length; i++){
            num[i] = Integer.parseInt(JOptionPane.showInputDialog(String.format("Digite o %dº numero", i+1)));
            if(num[i] % 2 == 0){
                somaPar +=num[i];
            }
            else{
                multImpar *= num[i];
            }
        }
        JOptionPane.showMessageDialog(null, String.format("Soma dos Pares = %d \nMultiplicação dos impares =  %d", somaPar ,multImpar));
    }
}