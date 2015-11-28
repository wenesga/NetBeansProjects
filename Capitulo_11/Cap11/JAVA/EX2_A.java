import java.io.*;
import java.util.Scanner;
public class EX2_A
{ 
  public static void main(String args[])
  { RandomAccessFile classe = null;
  	Scanner entrada = new Scanner(System.in);
	Aluno a, b;
	boolean repetido = false;
  	a = new Aluno();
  	b = new Aluno();

    try
       { classe = new RandomAccessFile("c:\\alunos.dat", "rw");
         System.out.print("\nDigite o numero do aluno a ser incluido ");
		 a.numero = entrada.nextInt();

		 entrada = new Scanner(System.in);
		 System.out.print("Digite o nome do aluno a ser incluido ");
		 a.nome = entrada.nextLine();
		 if (a.nome.length() < 20) //fixando o tamanho do nome em exatamente 20 caracteres
  			{ for (int i= a.nome.length() + 1; i <= 20; i++)
	  			{ a.nome = a.nome + " ";
	  			} 		
  			} 
  		 else
  			a.nome = a.nome.substring(0,20);
		    
		 System.out.print("Digite o curso do aluno a ser incluido ");
		 a.curso = entrada.nextLine();
	     if (a.curso.length() < 15) //fixando o tamanho do curso em exatamente 15 caracteres
  			{ for (int i= a.curso.length() + 1; i <= 15; i++)
	  			{ a.curso = a.curso + " ";
	  			} 		
  			} 
  		 else
  			a.curso = a.curso.substring(0,15);
		 
		 do
		  { System.out.print("Digite a primeira nota do aluno a ser incluido ");
		    a.nota1 = entrada.nextFloat();
		  } while ((a.nota1 < 0) || (a.nota1 > 10));
		 do
		  { System.out.print("Digite a segunda nota do aluno a ser incluido ");
		    a.nota2 = entrada.nextFloat();
		  } while ((a.nota2 < 0) || (a.nota2 > 10));
		 
		 repetido = false;
		 
		 while (true)
		 {  b.numero = classe.readInt();
		    b.nome = classe.readUTF();
		    b. curso = classe.readUTF();
		    b.nota1 = classe.readFloat();
		    b.nota2 = classe.readFloat();
		    if (a.numero == b.numero)
		       repetido = true;
	  	 }
	  }
	  catch(EOFException e)	 
	    { if (repetido == true)
	    	 System.out.println("\nNumero ja cadastrado !");
	      else
	        { try
	        	{ classe.writeInt(a.numero);
	        	  classe.writeUTF(a.nome);
	        	  classe.writeUTF(a.curso);
	        	  classe.writeFloat(a.nota1);
	        	  classe.writeFloat(a.nota2);
	        	  System.out.println("\nAluno inclu¡do com sucesso !");
                  classe.close();
	        	}
	        	catch(IOException e2)
	        	{ System.out.println("Erro de I/O");
	        	}
	        } 	 
	    	
	    }
     catch (IOException e)  
       { System.out.println("Erro na criacao o arquivo");
       }

}
	private static class Aluno
	{ public int numero;
	  public String nome;
	  public String curso;
	  public float nota1;
	  public float nota2;
	}
}



