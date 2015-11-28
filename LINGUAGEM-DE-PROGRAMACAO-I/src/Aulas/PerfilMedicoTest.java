//Clase para testar o aplicativo perfil Médico
package Aulas;
import java.util.Scanner;//programa utiliza a classe scanner  
public class PerfilMedicoTest  
{  
    //inicia o main  
    public static void main( String[] args )  
    {  
        PerfilMedico p1 = new PerfilMedico();  
          
        //cria o scanner  
        Scanner input = new Scanner( System.in);  
        String nome;//variavel que armazena o nome  
        String sobrenome;//variavel que armazena o sobrenome  
        String sexo;//variavel que armazena o sexo  
        int dia;//variavel que armazena o dia  
        int mes;//variavel que armazena o mes  
        int ano;//variavel que armazena o ano  
        double altura;//variavel que armazena a altura  
        double peso;//variavel que armazena o peso  
          
        System.out.print("NOME\n");  
        nome = input.next();  
        p1.getNome();  
          
        System.out.print("SOBRENOME\n");  
        sobrenome = input.next();  
        p1.getSobrenome();  
          
        System.out.print("SEXO\n");  
        sexo = input.next();  
        p1.getSexo();  
          
        System.out.print("NASCIMENTO\n");  
        System.out.print("DIA: ");  
        dia = input.nextInt();  
        p1.getDia();  
        System.out.print("MES: ");  
        mes = input.nextInt();  
        p1.getMes();  
        System.out.print("ANO: ");  
        ano = input.nextInt();  
        p1.getAno();  
          
        System.out.print("ALTURA\n");  
        altura = input.nextDouble();  
        p1.getAltura();  
          
        System.out.print("PESO\n");  
        peso = input.nextDouble();  
        p1.getPeso();  
          
        //Chama a mensagem  
          p1.displayInfo();
           
    }//fim do metodo main  
}//fim da classe  
