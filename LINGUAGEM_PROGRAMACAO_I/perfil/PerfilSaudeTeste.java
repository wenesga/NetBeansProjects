/**
 * CLASSE PRINICIPAL
 */
package Aulas;
import java.util.Scanner;
public class PerfilSaudeTeste {
       
       public static void main (String[] args) {
              Scanner teclado = new Scanner(System.in);
              
             PerfilSaude pessoa = new PerfilSaude( );
                          
              String nome;
              String sobrenome;
              String sexo;
              int diaNasci;
              int mesNasci; 
              int anoNasci;  
              double altura;
              double peso;
             
              System.out.println("Nome : ");
              nome = teclado.nextLine();
              pessoa.setNome(nome);
            
              System.out.println("Sobrenome : ");
              pessoa.setSobrenome(teclado.nextLine());
              
              System.out.println("Sexo : ");
              pessoa.setSexo(teclado.nextLine());
              
              System.out.println("Dia de nascimento : ");
              pessoa.setDiaNasci(teclado.nextInt());
              
              System.out.println("Mês de nascimento : ");
              pessoa.setMesNasci(teclado.nextInt());
              
              System.out.println("Ano de nascimento : ");
              pessoa.setAnoNasci(teclado.nextInt());
              
              System.out.println("Altura : ");
              pessoa.setAltura(teclado.nextDouble());
              
              System.out.println("Peso : ");
              pessoa.setPeso(teclado.nextDouble());
              
              pessoa.mostrarTela();
       }
}
