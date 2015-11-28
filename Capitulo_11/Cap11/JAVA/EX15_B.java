import java.io.*;
import java.util.Scanner;
public class EX15_B
{ 
  public static void main(String args[])
  { RandomAccessFile loja = null;
  	Scanner entrada = new Scanner(System.in);
	Venda a, b;
	a = new Venda();
	b = new Venda();
	boolean achou = false;

	
    try
       { loja = new RandomAccessFile("c:\\vendas.dat", "rw");
		 System.out.print("Digite o codigo do vendedor a ser consultado ");
		 a.codigo_vendedor = entrada.nextInt();
		 System.out.print("Digite o mes a ser consultado ");
		 a.mes = entrada.nextInt();

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
				    if ((a.codigo_vendedor == b.codigo_vendedor) && (a.mes == b.mes) && (b.ativo == 1))
				 		{ System.out.print("\nCodigo: " + b.codigo_vendedor);
				 		  System.out.print("\nNome: " + b.nome_vendedor);
				 		  System.out.print("\nMes: " + b.mes);
				 		  System.out.print("\nValor da venda: " + b.valor_venda + "\n");
				 		  achou = true;
				 		}  
			  	 }
			 } // fim else 	 
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nVenda nao cadastrada ! ");
		else
		   { try
		       { loja.close();
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