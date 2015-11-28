import java.io.*;
import java.util.Scanner;
public class EX4_A
{ 
  public static void main(String args[])
  { RandomAccessFile classe = null;
  	Scanner entrada = new Scanner(System.in);
	Aluno b = new Aluno();
	int numero;
	long c=0, auxi;
	boolean achou = false;

    try
       { classe = new RandomAccessFile("c:\\alunos.dat", "rw");
         System.out.print("\nDigite o numero do aluno ");
		 numero = entrada.nextInt();

         achou = false;
         c = 0;
		 while (true)
		 {  auxi = classe.getFilePointer(); //captura o byte onde começam os dados de um aluno
		    b.numero = classe.readInt();
		    b.nome = classe.readUTF();
		    b.curso = classe.readUTF();
		    b.nota1 = classe.readFloat();
		    b.nota2 = classe.readFloat();
		    if (numero == b.numero) 
		       { achou = true;
		         c = auxi;
		       }  
	  	 }
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nAluno nao cadastrado ! ");
		else
		   { try
		       { classe.seek(0);
			     classe.seek(c); 
			     b.numero = classe.readInt();
			     b.nome = classe.readUTF();
			     b.curso = classe.readUTF();
			     b.nota1 = classe.readFloat();
			     b.nota2 = classe.readFloat();
			     System.out.print("\nNome do aluno " + b.nome);
				 System.out.print("\nCurso do aluno " + b.curso);
				 System.out.print("\nDigite o novo curso do aluno ");
                 entrada = new Scanner(System.in);
				 b.curso = entrada.nextLine();
			     if (b.curso.length() < 15) //fixando o tamanho do curso em exatamente 15 caracteres
		  			{ for (int i= b.curso.length() + 1; i <= 15; i++)
  						{ b.curso = b.curso + " ";
  						} 		
					} 
	 			 else
					b.curso = b.curso.substring(0,15);

				 classe.seek(0);
			     classe.seek(c+26); //somou 26 bytes (4 bytes do numero e 22 bytes do nome) para posicionar-se exatamente no início do curso
			     classe.writeUTF(b.curso);
				 System.out.println("\nAlteracao realizada com sucesso !");
				 classe.close();
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