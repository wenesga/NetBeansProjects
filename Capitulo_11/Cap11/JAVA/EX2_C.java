import java.io.*;
import java.util.Scanner;
public class EX2_C
{ 
  public static void main(String args[])
  { RandomAccessFile classe = null, auxi = null;
  	Scanner entrada = new Scanner(System.in);
	Aluno a, b;
	boolean repetido = false, gravou = false;
  	a = new Aluno();
  	b = new Aluno();

    try
       { classe = new RandomAccessFile("c:\\alunos.dat", "rw");
         System.out.print("\nDigite o numero do aluno a ser incluido ");
		 a.numero = entrada.nextInt();

		 repetido = false;
		 while (true)
		 {  b.numero = classe.readInt();
		    b.nome = classe.readUTF();
		    b.curso = classe.readUTF();
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
	        	{ entrada = new Scanner(System.in);
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
					  
					classe.seek(0);
					auxi = new RandomAccessFile("c:\\auxiliar.dat", "rw");
					gravou = false;
					while (true)
		 			{  b.numero = classe.readInt();
		    		   b.nome = classe.readUTF();
		    		   b.curso = classe.readUTF();
		    		   b.nota1 = classe.readFloat();
		    		   b.nota2 = classe.readFloat();
			           if ((b.numero > a.numero) && (gravou == false))	  	
		        		  { auxi.writeInt(a.numero);
							auxi.writeUTF(a.nome);
				        	auxi.writeUTF(a.curso);
							auxi.writeFloat(a.nota1);
			        	  	auxi.writeFloat(a.nota2);
			        	  	gravou = true;
			        	  }			          
						auxi.writeInt(b.numero);
						auxi.writeUTF(b.nome);
				        auxi.writeUTF(b.curso);
						auxi.writeFloat(b.nota1);
			        	auxi.writeFloat(b.nota2);
			        }
	  	 	 } //fim try
	  	 	 catch(EOFException e2)		
	  	 	 { try 
	  	 	     { if (gravou == false)
		  	 	 	  { auxi.writeInt(a.numero);
						auxi.writeUTF(a.nome);
			        	auxi.writeUTF(a.curso);
						auxi.writeFloat(a.nota1);
		        	  	auxi.writeFloat(a.nota2);
		        	  	System.out.println("\nAluno incluido com sucesso !");
		        	  }
		            classe.close();
		            auxi.close();  
		            File arq1, arq2;
		            arq1 = new File("c:\\alunos.dat");
		            arq2 = new File("c:\\auxiliar.dat");
		            arq1.delete();
		            arq2.renameTo(arq1);
		         } //fim try	  
		       catch(IOException e3)
		         { System.out.println("Erro de I/O");
		         } //fim catch
	         }//fim catch
	         catch(IOException e3)
		     { System.out.println("Erro de I/O");
		     } //fim catch
	   	  }// fim else
	   }//fim catch
     catch (IOException e3)  
       { System.out.println("Erro na criacao o arquivo");
       }
} //fim main

	private static class Aluno
	{ public int numero;
	  public String nome;
	  public String curso;
	  public float nota1;
	  public float nota2;
	}
}