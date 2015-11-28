package linguagem_programacao;
import javax.swing.JOptionPane;
/** @author WENES
 *import javax.swing.JOptionPane;  -  ENTRADA BÁSICA PARA CAIXA DE DIÁLOGO.
 *JOptionPane.showInputDialog();   -  RECEBE MENSAGEM DO TECLADO.
 *Double.parseDouble();            -  CONVERTE DO TECLADO PARA OUTRO TIPO.
 *String.format();                 -  FORMATA O TEXTO.
 *JOptionPane.showMessageDialog(); -  EXIBI A MENSAGEM FORMATADA
 */
public class AlunoTeste {
    public static void main(String[] args){
        
        Aluno a1 = new Aluno("Wenes",  "00001");
        Aluno a2 = new Aluno("Aquino", "00002");
        
        double nota1;
        double nota2;
        String mensagem1;
        
        mensagem1 = JOptionPane.showInputDialog(String.format("Digite a nota1 do aluno %s", a1.getNome()));
        nota1 = Double.parseDouble(mensagem1);
        mensagem1 = JOptionPane.showInputDialog(String.format("Digite a nota2 do aluno %s", a1.getNome()));
        nota2 = Double.parseDouble(mensagem1);
        
        a1.setNota1(nota1);
        a1.setNota2(nota2);
        a1.calcMedia();
        
        mensagem1 = JOptionPane.showInputDialog(String.format("Digite a nota1 do aluno %s", a2.getNome()));
        nota1 = Double.parseDouble(mensagem1);
        mensagem1 = JOptionPane.showInputDialog(String.format("Digite a nota2 do aluno %s", a2.getNome()));
        nota2 = Double.parseDouble(mensagem1);
        
        a2.setNota1(nota1);
        a2.setNota2(nota2);
        a2.calcMedia();
        
        JOptionPane.showMessageDialog(null, String.format("ALUNO: %s \nMEDIA: %.2f \nSITUAÇÃO: %s \n\nALUNO: %s \nMEDIA: %.2f \nSITUAÇÃO: %s", a1.getNome(), a1.getMedia(), a1.informaSituacao(),  a2.getNome(), a2.getMedia(), a2.informaSituacao()));
    }       
}