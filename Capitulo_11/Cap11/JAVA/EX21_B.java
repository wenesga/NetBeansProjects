import java.io.*;
import java.util.Scanner;
public class EX21_B
{ 
  public static void main(String args[])
  { RandomAccessFile contas = null, clientes = null;
  	Scanner entrada = new Scanner(System.in);
	Cliente c = new Cliente();
	Conta a, b;
  	a = new Conta();
  	b = new Conta();
	boolean repetido = false, achou = false;
	String nome="";
	
    try
       { clientes = new RandomAccessFile("c:\\clientes.dat", "rw");
         System.out.print("Digite o numero da conta a ser incluida ");
		 a.numero_conta = entrada.nextInt();

         System.out.print("Digite o numero do cliente ");
		 a.numero_cli = entrada.nextInt();

         System.out.print("Digite o saldo da conta ");
		 a.saldo = entrada.nextFloat();
		 a.ativo = 1;

		 entrada = new Scanner(System.in);

		 achou = false;

		 while (true)
		 {  c.numero = clientes.readInt();
		    c.ativo = clientes.readInt();
		    c.nome = clientes.readUTF();
		    if ((a.numero_cli == c.numero) && (c.ativo == 1))
		       { achou = true;
		         nome = c.nome;
		       }  
	  	 }
		 
	  }
	  catch(EOFException e)	 
	    { if (achou == false)
	    	 System.out.println("Cliente nao cadastrado! ");
	      else
	      { try
	          {  clientes.close();
	             repetido = false;
				 
				 contas = new RandomAccessFile("c:\\contas.dat", "rw");
				 while (true)
				 {  b.numero_conta = contas.readInt();
				 	b.numero_cli = contas.readInt();
				    b.saldo = contas.readFloat();
				    b.ativo = contas.readInt();
				    if ((a.numero_conta == b.numero_conta) && (b.ativo == 1))
				       repetido = true;
			  	 }
			  } // fim try	 
			catch (EOFException e2)
			{ if (repetido == true)
	    	 	System.out.println("\nJa existe conta cadastrada com este numero!");
	    	  else
	    	    { try { System.out.print("\nNome do cliente: " + nome);
	    	    		contas.writeInt(a.numero_conta);
	        	  		contas.writeInt(a.numero_cli);
	        	  		contas.writeFloat(a.saldo);
	        	  		contas.writeInt(a.ativo);
	        	  		System.out.println("\nConta incluida com sucesso !");
                  		contas.close();
                  	  }
                  catch (IOException e3)	  	
	                  { System.out.println("Erro de I/O");
	                  }
	    	    }
			}
			catch (IOException e2)
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


	private static class Conta
	{ public int numero_conta;
	  public int numero_cli;
	  public float saldo;
	  public int ativo;
	}
}



