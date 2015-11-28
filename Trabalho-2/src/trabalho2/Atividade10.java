package trabalho2;
import javax.swing.JOptionPane;
/** @author WENES
 */
public class Atividade10{
    public static void main(String[] args) {
        int idade, cont=0,contM=0;
        String sexo;
        double salario=0, soma=0, media;
        
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
        
        while(idade > 0){
            sexo = JOptionPane.showInputDialog("Digite o Sexo: ");
            salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o Salário: "));
            if(sexo.equalsIgnoreCase("f") && salario<= 200){
                contM++;
            }
            cont++;
            soma = soma + salario;
            idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a Idade: "));
        }
        media = soma/cont;
        JOptionPane.showMessageDialog(null, String.format("Média do salário do Grupo: %.2f\nQuantidade de mulheres com salário de até 200,00: %d",media, contM));       
    }
}
