package linguagem_programacao;
// Entrada básica com uma caixa de diálogo.
import javax.swing.JOptionPane;
public class NameDialog
{
   public static void main( String[] args )
   {
       String name;
       // pede para o usuário inserir seu nome
       name = JOptionPane.showInputDialog( "Qual é seu nome?" );
       // exibe a mensagem para cumprimentar o usuário pelo nome
       JOptionPane.showMessageDialog( null, String.format( "Bem vido, %s, para Programação Java!", name ));
   }
} 