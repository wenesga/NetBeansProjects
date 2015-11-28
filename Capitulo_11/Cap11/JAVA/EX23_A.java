import java.io.*;
import java.util.Scanner;
public class EX23_A
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
	char letra;
	
    try
       { clientes = new RandomAccessFile("c:\\clientes.dat", "rw");
		 System.out.print("Digite a letra inicial dos nomes que deseja cosultar ");
		 letra = entrada.nextLine().charAt(0);

		 achou = false;
		 while (true)
			 {  c.numero = clientes.readInt();
			    c.nome = clientes.readUTF();
			    if (Character.toUpperCase(c.nome.charAt(0)) == Character.toUpperCase(letra))
			 		{ nome = c.nome;
			 		  achou = false;
			 		  System.out.println("Cliente: " + c.nome);
			 		  try { contas = new RandomAccessFile("c:\\contas.dat", "rw");
			 		  		while (true)
				 		  		{ a.numero_conta = contas.readInt();
							      a.numero_cli = contas.readInt();
							      a.saldo = contas.readFloat();
							      if (c.numero == a.numero_cli)
							 		{ System.out.print("\nNumero da conta: " + a.numero_conta + " Saldo: " + a.saldo + "\n");
							 		  achou = true;
							 		}  
				 		  		}
			 		  	   }	
			 		   catch (EOFException e2)		
			 		   { try { contas.close();
			 		    	   if (achou == false)
			 		    	   		System.out.println("Não existe conta para este cliente!");
			 		   		 }
			 		   	  catch (IOException e3)		
					 		 { System.out.println("Erro de I/O");
					 		 }
			 		   }
  			 		   catch (IOException e2)		
			 		   { System.out.println("Erro de I/O");
			 		   }
	
			 		  }//fim if
			 		  
			 		  
			 }//fim while
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nCliente nao cadastrado! ");
	  } // fimn catch (EOFException e) 
	catch(IOException e)  
	  { System.out.println("Erro na criacao o arquivo");
	  }
}//fim main
	private static class Cliente
	{ public int numero;
	  public String nome;
	}

	private static class Conta
	{ public int numero_conta;
	  public int numero_cli;
	  public float saldo;
	}
}