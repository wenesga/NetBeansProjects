import java.io.*;
import java.util.Scanner;
public class EX16_B
{ 
  public static void main(String args[])
  { RandomAccessFile loja = null;
  	Scanner entrada = new Scanner(System.in);
	Venda a, b;
	a = new Venda();
	b = new Venda();
	boolean achou = false;
	float total = 0;

	
    try
       { loja = new RandomAccessFile("c:\\vendas.dat", "rw");
		 System.out.print("Digite o codigo do vendedor a ser consultado ");
		 a.codigo_vendedor = entrada.nextInt();

		 if (loja.length() == 0)
		 	System.out.println("Arquivo vazio ! ");		 
		 else
		 	{ achou = false;
		 	  while (true)
				 {  b.codigo_vendedor = loja.readInt();
				    b.mes = loja.readInt();
				    b.ativo = loja.readInt();
				    b.nome_vendedor = loja.readUTF();
				    b.valor_venda = loja.readFloat();
				    if ((a.codigo_vendedor == b.codigo_vendedor) && (b.ativo == 1))
				 		{ total = total + b.valor_venda;
				 		  achou = true;
				 		}  
			  	 }
			 } // fim else 	 
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nNao existem vendas para este vendedor ! ");
		else
		   { try
		       { System.out.println("\nTotal das vendas: " + total);
		         loja.close();
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
	private static class Venda
	{ public int codigo_vendedor;
	  public int mes;
	  public int ativo;	  
	  public String nome_vendedor;
	  public float valor_venda;
	}
}