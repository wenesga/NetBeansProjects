import java.io.*;
import java.util.Scanner;
public class EX20_D
{ 
  public static void main(String args[])
  { RandomAccessFile clientes = null, auxi = null;
  	Scanner entrada = new Scanner(System.in);
	Cliente a, b;
	boolean repetido = false, gravou = false;
  	a = new Cliente();
  	b = new Cliente();

    try
       { clientes = new RandomAccessFile("c:\\clientes.dat", "rw");
         System.out.print("\nDigite o numero do cliente a ser incluido ");
		 a.numero = entrada.nextInt();
		 a.ativo = 1;
		 
		 repetido = false;
		 while (true)
		 {  b.numero = clientes.readInt();
		    b.ativo = clientes.readInt(); 
		    b.nome = clientes.readUTF();
		    if ((a.numero == b.numero) && (b.ativo == 1))
		       repetido = true;
	  	 }
	  }
	  catch(EOFException e)	 
	    { if (repetido == true)
	    	 System.out.println("\nJa existe cliente cadastrado com este numero !");
	      else
	        { try
	        	{   entrada = new Scanner(System.in);
		 			System.out.print("Digite o nome do cliente a ser incluido ");
		 			a.nome = entrada.nextLine();
		 			if (a.nome.length() < 20) //fixando o tamanho do nome em exatamente 20 caracteres
  						{ for (int i= a.nome.length() + 1; i <= 20; i++)
	  						{ a.nome = a.nome + " ";
	  						} 		
  						} 
  		 			else
  						a.nome = a.nome.substring(0,20);
		    
					clientes.seek(0);
					auxi = new RandomAccessFile("c:\\auxiliar.dat", "rw");
					gravou = false;
					while (true)
		 			{  b.numero = clientes.readInt();
		 			   b.ativo = clientes.readInt();
		    		   b.nome = clientes.readUTF();
			           if ((b.numero > a.numero) && (gravou == false))	  	
		        		  { auxi.writeInt(a.numero);
		        		    auxi.writeInt(a.ativo);
							auxi.writeUTF(a.nome);
			        	  	gravou = true;
			        	  }			          
						auxi.writeInt(b.numero);
						auxi.writeInt(b.ativo);
						auxi.writeUTF(b.nome);
			        }
	  	 	 } //fim try
	  	 	 catch(EOFException e2)		
	  	 	 { try 
	  	 	     { if (gravou == false)
		  	 	 	  { auxi.writeInt(a.numero);
		  	 	 	    auxi.writeInt(a.ativo);
						auxi.writeUTF(a.nome);
		        	  	System.out.println("\nCliente incluido com sucesso !");
		        	  }
		            clientes.close();
		            auxi.close();  
		            File arq1, arq2;
		            arq1 = new File("c:\\clientes.dat");
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

	private static class Cliente
	{ public int numero;
	  public int ativo;
	  public String nome;
	}
}