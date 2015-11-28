import java.io.*;
import java.util.Scanner;
public class EX7A
{ 
  public static void main(String args[])
  { RandomAccessFile classe = null;
  	Scanner entrada = new Scanner(System.in);
	Aluno b = new Aluno();
	boolean achou = false;
	float media;

    try
       { classe = new RandomAccessFile("c:\\alunos.dat", "rw");

         achou = false;
		 while (true)
		 {  b.numero = classe.readInt();
		    b.nome = classe.readUTF();
		    b.curso = classe.readUTF();
		    b.nota1 = classe.readFloat();
		    b.nota2 = classe.readFloat();
            media = (float)((b.nota1 + b.nota2) / 2);
            if (media >= 7)
               { System.out.print("\nNome: " + b.nome);
            	 System.out.print("\nCurso: " + b.curso);            
            	 System.out.print("\nNota1: " + b.nota1);
            	 System.out.print("\nNota2: " + b.nota2);            
            	 System.out.print("\nMedia: " + media + "\n");
	  	 	   }
	  	 }	   
	  } //fim try
	catch (EOFException e)  
	  { try
	       { classe.close();
	
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
	  public String nome;
	  public String curso;
	  public float nota1;
	  public float nota2;
	}
}