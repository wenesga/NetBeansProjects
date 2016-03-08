package trabalho2;
import javax.swing.JOptionPane;
/** @author WENES
 */
public class Atividade12{
    public static void main(String[] args) {
        int n, cont, soma=0;
        n = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro positivo")); 
        
        for(cont = 1; cont <= n * 2; cont+=2){
            soma = soma + cont;    
        }
        JOptionPane.showMessageDialog(null, String.format("Resultado %d^2 = %d", n, soma));
    }
}