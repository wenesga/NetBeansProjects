package trabalho2;
import javax.swing.JOptionPane;
/**
 * @author WENES
 */
public class Atividade08{
    public static void main(String[] args) {
        int cont=0;
        double nota, media, soma = 0;
        nota = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota bimestral do 1º aluno"));
        while(nota >= 0 && nota <= 10){
            soma = soma + nota;
            cont++;
            nota = Double.parseDouble(JOptionPane.showInputDialog(String.format("Digite a nota bimestral do %dº aluno",cont+1)));
        }
        media = soma/cont;
        JOptionPane.showMessageDialog(null, String.format("Média da Turma = %.2f",media));
    }
}