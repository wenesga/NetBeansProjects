package linguagem_programacao;
import javax.swing.JOptionPane;
/** @author WENES
*/
public class Nome {
    public static void main(String[] args){
        String teclado;
        double Nota;   
        teclado = JOptionPane.showInputDialog("Digite a nota: ");
        Nota = Double.parseDouble(teclado);
        JOptionPane.showMessageDialog(null,  String.format("Sua nota é: %s", Nota));  
    } 
}
