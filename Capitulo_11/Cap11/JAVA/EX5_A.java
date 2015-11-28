import java.io.*;
import java.util.Scanner;
public class EX5_A
{ 
  public static void main(String args[])
  { RandomAccessFile classe = null, auxi = null;
  	Scanner entrada = new Scanner(System.in);
	Aluno b = new Aluno();
	int numero;
	boolean achou = false;

    try
       { classe = new RandomAccessFile("c:\\alunos.dat", "rw");
         auxi = new RandomAccessFile("c:\\auxiliar.dat", "rw");
         
         System.out.print("\nDigite o numero do aluno ");
		 numero = entrada.nextInt();

         achou = false;
		 while (true)
		 {  b.numero = classe.readInt();
		    b.nome = classe.readUTF();
		    b.curso = classe.readUTF();
		    b.nota1 = classe.readFloat();
		    b.nota2 = classe.readFloat();
		    if (numero == b.numero) 
		       achou = true;
		    else
		       { auxi.writeInt(b.numero);
		         auxi.writeUTF(b.nome);
		         auxi.writeUTF(b.curso);
		         auxi.writeFloat(b.nota1);
		         auxi.writeFloat(b.nota2);
		       }  
	  	 }
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nAluno nao cadastrado ! ");
		else
		   { System.out.println("\nAluno excluido com sucesso ! ");
			 try
		       { classe.close();
			     auxi.close(); 
			     File arq1, arq2;
		         arq1 = new File("c:\\alunos.dat");
		         arq2 = new File("c:\\auxiliar.dat");
		         arq1.delete();
		         arq2.renameTo(arq1);
			   } //fim try
			catch (IOException e2)   		 
			   { System.out.println("\nErro de I/O");
			   }
		   } //fim else
	  } // fimn catch (EOFException e) 
	catch(IOException e)  
	  { System.out.println("Erro na criacao o arquivo");
	  }
}//fim main
	private static class Aluno
	{ public int numero;
	  public String nome;
	  public String curso;
	  public float nota1;
	  public float nota2;
	}
}