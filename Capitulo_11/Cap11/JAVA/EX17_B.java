import java.io.*;
import java.util.Scanner;
public class EX17_B
{ 
  public static void main(String args[])
  { RandomAccessFile loja = null;
  	Scanner entrada = new Scanner(System.in);
	Venda a, b;
	a = new Venda();
	b = new Venda();
	boolean achou = false;
	float maior = 0;
	int c = 0,mes;

	
    try
       { loja = new RandomAccessFile("c:\\vendas.dat", "rw");
		 System.out.print("Digite o mes a ser consultado ");
		 mes = entrada.nextInt();
		 
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
				    
				    if ((b.mes == mes) && (b.ativo == 1))
				    	{ achou = true;
				    	  if (c == 0)
						 	{ a.codigo_vendedor = b.codigo_vendedor;
						   	  a.nome_vendedor = b.nome_vendedor;
						   	  maior = b.valor_venda; 
						   	  c = 1;
						   	}
						  else
						    if (b.valor_venda > maior) 	  
						    	{ a.codigo_vendedor = b.codigo_vendedor;
						   	  	  a.nome_vendedor = b.nome_vendedor;
						   	  	  maior = b.valor_venda; 
						    	}
						 }   	
				 }  
			 } // fim else 	 
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nNao existem vendas neste mes ! ");
		else
		   { try
		       { System.out.print("\nCodigo: " + a.codigo_vendedor);
		       	 System.out.print("\nNome: " + a.nome_vendedor);
		       	 System.out.print("\nValor da venda: " + maior + "\n");
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