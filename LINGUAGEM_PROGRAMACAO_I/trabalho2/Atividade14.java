package trabalho2;
import javax.swing.JOptionPane;
/** @author WENES
 */
public class Atividade14{
    public static void main(String[] args){
        int i, n, r;
        String mensagem = "";
        n = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero: "));            
        
        for(i=1; i<=10; i++){
            r = n * i;
            mensagem += +n+" x "+i+" = "+r+"\n";  
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
