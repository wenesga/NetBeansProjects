package trabalho2;
import javax.swing.JOptionPane;
/**
 * @author WENES
 */
public class Atividade02 {

    public static void main(String[] args) {
        
        double nota1, nota2, nota3, nota4, media;
        
        nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota1 do aluno"));
        nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota2 do aluno"));      
        nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota3 do aluno"));
        nota4 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota4 do aluno"));
        
        media = (nota1 + nota2 + nota3 + nota4)/4;
        
        if(media >= 7){
            JOptionPane.showMessageDialog(null, String.format("Aprovado - Média = %.2f", media));
        }
        else
            JOptionPane.showMessageDialog(null, String.format("Reprovado - Média =  %.2f", media));
    }
}