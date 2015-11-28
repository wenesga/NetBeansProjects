import java.io.*;
import java.util.Scanner;
public class EX25_A
{ 
  public static void main(String args[])
  { RandomAccessFile contas = null;
  	Scanner entrada = new Scanner(System.in);
	Conta a = new Conta();
	int numero;
	float valor = 0;
	long c=0, auxi;
	boolean achou = false;

    try
       { contas = new RandomAccessFile("c:\\contas.dat", "rw");
         System.out.print("\nDigite o numero da conta ");
		 numero = entrada.nextInt();

         achou = false;
         c = 0;
		 while (true)
		 {  auxi = contas.getFilePointer(); //captura o byte onde começam os dados de um aluno
		    a.numero_conta = contas.readInt();
		    a.numero_cli = contas.readInt();
		    a.saldo = contas.readFloat();
		    if (numero == a.numero_conta) 
		       { achou = true;
		         c = auxi;
		       }  
	  	 }
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nConta nao cadastrada! ");
		else
		   { try
		       { contas.seek(0);
			     contas.seek(c); 
			     a.numero_conta = contas.readInt();
			     a.numero_cli = contas.readInt();
			     a.saldo = contas.readFloat();
			     System.out.print("\nNumero conta: " + a.numero_conta);
			     System.out.print("\nNumero cliente: " + a.numero_cli);
			     System.out.print("\nSaldo atual da conta: " + a.saldo);			     
				 System.out.print("\nDigite o valor do saque ");
				 valor = entrada.nextFloat();
				 valor = a.saldo - valor;
				 contas.seek(0);
			     contas.seek(c+8); //somou 8 bytes (4 bytes do numero da conta e 4 bytes para o nome do cliente) para posicionar-se exatamente no início do saldo
			     contas.writeFloat(valor);
				 System.out.println("\nSaque efetuado com sucesso!");
				 contas.close();
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
	private static class Conta
	{ public int numero_conta;
	  public int numero_cli;
	  public float saldo;
	}
}