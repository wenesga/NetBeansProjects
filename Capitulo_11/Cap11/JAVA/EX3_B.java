import java.io.*;
import java.util.Scanner;
public class EX3_B
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
		    b.ativo = classe.readInt();
		    b.nome = classe.readUTF();
		    b.curso = classe.readUTF();
		    b.nota1 = classe.readFloat();
		    b.nota2 = classe.readFloat();
		    if ((numero == b.numero) && (b.ativo == 1))
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
			     b.ativo = classe.readInt();
			     b.nome = classe.readUTF();
			     b.curso = classe.readUTF();
			     b.nota1 = classe.readFloat();
			     b.nota2 = classe.readFloat();
			     System.out.print("\nNome do aluno " + b.nome);
				 System.out.print("\nCurso do aluno " + b.curso);
				 System.out.print("\nA primeira nota e " + b.nota1);
				 do { System.out.print("\nDigite o novo valor da primeira nota ");
				 	  b.nota1 = entrada.nextFloat();
					} while ((b.nota1 < 0) || (b.nota1 > 10));
				 System.out.print("\nA segunda nota e : " + b.nota2);
				 do { System.out.print("\nDigite o novo valor da segunda nota ");
				 	  b.nota2 = entrada.nextFloat();
					} while ((b.nota2 < 0) || (b.nota2 > 10));
				 classe.seek(0);
			     classe.seek(c+47); //somou 47 bytes (4 bytes do numero, 4 bytes do ativo, 22 bytes do nome e 17 bytes do curso) para posicionar-se exatamente no início das notas
			     classe.writeFloat(b.nota1);
			     classe.writeFloat(b.nota2);
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
	  public int ativo;
	  public String nome;
	  public String curso;
	  public float nota1;
	  public float nota2;
	}
}