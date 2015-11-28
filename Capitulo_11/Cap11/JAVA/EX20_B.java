import java.io.*;
import java.util.Scanner;
public class EX20_B
{ 
  public static void main(String args[])
  { RandomAccessFile clientes = null;
  	Scanner entrada = new Scanner(System.in);
	Cliente a, b;
	boolean repetido = false;
  	a = new Cliente();
  	b = new Cliente();

    try
       { clientes = new RandomAccessFile("c:\\clientes.dat", "rw");
         System.out.print("\nDigite o numero do cliente a ser incluido ");
		 a.numero = entrada.nextInt();

		 entrada = new Scanner(System.in);
		 System.out.print("Digite o nome do cliente a ser incluido ");
		 a.nome = entrada.nextLine();
		 if (a.nome.length() < 20) //fixando o tamanho do nome em exatamente 20 caracteres
  			{ for (int i= a.nome.length() + 1; i <= 20; i++)
	  			{ a.nome = a.nome + " ";
	  			} 		
  			} 
  		 else
  			a.nome = a.nome.substring(0,20);
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
	    	 System.out.println("\nJa existe cliente cadastrado com este numero!");
	      else
	        { try
	        	{ clientes.writeInt(a.numero);
	        	  clientes.writeInt(a.ativo);
	        	  clientes.writeUTF(a.nome);
	        	  System.out.println("\nCliente incluido com sucesso !");
                  clientes.close();
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
	private static class Cliente
	{ public int numero;
	  public int ativo;
	  public String nome;
	}
}



