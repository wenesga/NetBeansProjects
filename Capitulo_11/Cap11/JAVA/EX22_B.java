import java.io.*;
import java.util.Scanner;
public class EX22_B
{ 
  public static void main(String args[])
  { RandomAccessFile contas = null, clientes = null;
  	Scanner entrada = new Scanner(System.in);
	Cliente c = new Cliente();
	Conta a;
  	a = new Conta();
	boolean repetido = false, achou = false;
	int numero=0;
	String nome="";
	
    try
       { clientes = new RandomAccessFile("c:\\clientes.dat", "rw");
		 System.out.print("Digite o codigo do cliente desejado ");
		 numero = entrada.nextInt();

		 achou = false;
		 while (true)
			 {  c.numero = clientes.readInt();
			    c.ativo = clientes.readInt();
			    c.nome = clientes.readUTF();
			    if ((numero == c.numero) && (c.ativo == 1))
			 		{ nome = c.nome;
			 		  achou = true;
			 		}  
		  	 }
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nCliente nao cadastrado! ");
		else
		   { try
		       { clientes.close();
				 contas = new RandomAccessFile("c:\\contas.dat", "rw");
					 achou = false;
					 while (true)
						 {  a.numero_conta = contas.readInt();
						    a.numero_cli = contas.readInt();
						    a.saldo = contas.readFloat();
						    a.ativo = contas.readInt();
						    if ((numero == a.numero_cli) && (a.ativo == 1))
						 		{ System.out.print("\nNumero da conta: " + a.numero_conta + " Saldo: " + a.saldo + "\n");
						 		  achou = true;
						 		}  
					  	 }
				  } //fim try
				 catch(EOFException e2) 
				 { if (achou == false)
				 	{ System.out.println("\nNao existe conta cadastrada para este cliente!");
				 	}
				   try { contas.close();
				   	   }	
				   catch (IOException e3)	   
				      { System.out.println("\nErro de I/O");
				      }
				 }
				 catch(IOException e2) 
				 { System.out.println("\nErro de I/O");
				 }		       
		   } //fim else
	  } // fimn catch (EOFException e) 
	catch(IOException e)  
	  { System.out.println("Erro na criacao o arquivo");
	  }
}//fim main
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