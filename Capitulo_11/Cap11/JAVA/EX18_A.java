import java.io.*;
import java.util.Scanner;
public class EX18_A
{ 
  public static void main(String args[])
  { RandomAccessFile loja = null;
  	Scanner entrada = new Scanner(System.in);
	Venda a, b;
	a = new Venda();
	b = new Venda();
	float maior = 0;
	int c = 0;

	
    try
       { loja = new RandomAccessFile("c:\\vendas.dat", "rw");
		 
		 if (loja.length() == 0)
		 	System.out.println("Arquivo vazio ! ");		 
		 else
		 	{ while (true)
				 {  b.codigo_vendedor = loja.readInt();
				    b.mes = loja.readInt();
				    b.nome_vendedor = loja.readUTF();
				    b.valor_venda = loja.readFloat();
				    
		    	   if (c == 0)
					  { a.codigo_vendedor = b.codigo_vendedor;
					    a.mes = b.mes;
					    a.nome_vendedor = b.nome_vendedor;
					    a.valor_venda = b.valor_venda;
					    maior = b.valor_venda; 
						c = 1;
					  }
				   else
				      if (b.valor_venda > maior) 	  
				    	 { a.codigo_vendedor = b.codigo_vendedor;
					       a.mes = b.mes;
					       a.nome_vendedor = b.nome_vendedor;
					       a.valor_venda = b.valor_venda;
					       maior = b.valor_venda; 
				    	 }
				 }  
			 } // fim else 	 
	  } //fim try
	catch (EOFException e)  
	  { try
	       { System.out.print("\nCodigo: " + a.codigo_vendedor);
	       	 System.out.print("\nNome: " + a.nome_vendedor);
	       	 System.out.print("\nMes: " + a.mes);
	       	 System.out.print("\nValor da venda: " + a.valor_venda + "\n");
	         loja.close();
		   } //fim try
		catch (IOException e2)   		 
		   { System.out.println("\nErro de I/O");
		   }
	  } // fimn catch (EOFException e) 
	catch(IOException e)  
	  { System.out.println("Erro na criacao o arquivo");
	  }
}//fim main
	private static class Venda
	{ public int codigo_vendedor;
	  public int mes;
	  public String nome_vendedor;
	  public float valor_venda;
	}
}