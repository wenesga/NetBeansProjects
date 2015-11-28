import java.io.*;
import java.util.Scanner;
public class EX5_B
{ 
  public static void main(String args[])
  { RandomAccessFile classe = null;
  	Scanner entrada = new Scanner(System.in);
	Aluno b = new Aluno();
	int numero;
	long c;
	boolean achou = false;

    try
       { classe = new RandomAccessFile("c:\\alunos.dat", "rw");
         System.out.print("\nDigite o numero do aluno a ser excluido ");
		 numero = entrada.nextInt();

         achou = false;
		 while (true)
		 {  b.numero = classe.readInt();
		    c = classe.getFilePointer();
		    b.ativo = classe.readInt();		    
		    if ((numero == b.numero) && (b.ativo == 1))
		       { classe.seek(c); //reposiciona-se no inicio de ativo, para alterar seu valor de zero para um
		         classe.writeInt(0);
		         achou = true;
		       }  
		    b.nome = classe.readUTF();
		    b.curso = classe.readUTF();
		    b.nota1 = classe.readFloat();
		    b.nota2 = classe.readFloat();
	  	 }
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nAluno nao cadastrado ! ");
		else System.out.println("\nAluno excluido com sucesso ! ");   
		try
	       { 
			 classe.close();
		   } //fim try
		catch (IOException e2)   		 
		   { System.out.println("\nErro de I/O");
		   }
	  } // fimn catch (EOFException e) 
	catch(IOException e)  
	  { System.out.println("Erro na criacao o arquivo");
	  }
}//fim main
	private static class Aluno
	{ public int numero;
	  public int ativo;
	  public String nome;
	  public String curso;
	  public float nota1;
	  public float nota2;
	}
}