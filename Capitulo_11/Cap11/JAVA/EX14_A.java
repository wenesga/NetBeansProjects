import java.io.*;
import java.util.Scanner;
public class EX14_A
{ 
  public static void main(String args[])
  { RandomAccessFile loja = null, auxi = null;
  	Scanner entrada = new Scanner(System.in);
	Venda a, b;
	a = new Venda();
	b = new Venda();
	boolean achou = false;

	
    try
       { loja = new RandomAccessFile("c:\\vendas.dat", "rw");
		 System.out.print("Digite o codigo do vendedor a ser exclu¡do ");
		 a.codigo_vendedor = entrada.nextInt();
		 System.out.print("Digite o mes a ser excluido ");
		 a.mes = entrada.nextInt();

		 if (loja.length() == 0)
		 	System.out.println("Arquivo vazio ! ");		 
		 else
		 	{ auxi = new RandomAccessFile("c:\\auxiliar.dat", "rw");
		 	  achou = false;
		 	  while (true)
				 {  b.codigo_vendedor = loja.readInt();
				    b.mes = loja.readInt();
				    b.nome_vendedor = loja.readUTF();
				    b.valor_venda = loja.readFloat();
				    if ((a.codigo_vendedor == b.codigo_vendedor) && (a.mes == b.mes))
				       achou = true;
				    else   				       
				       { auxi.writeInt(b.codigo_vendedor);
				    	 auxi.writeInt(b.mes);
				    	 auxi.writeUTF(b.nome_vendedor);
				    	 auxi.writeFloat(b.valor_venda);
				       }  
			  	 }
			 } // fim else 	 
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nVenda nao cadastrada ! ");
		else
		   { try
		       { 
				 loja.close();
			     auxi.close(); 
			     File arq1, arq2;
			     arq1 = new File("c:\\vendas.dat");
			     arq2 = new File("c:\\auxiliar.dat");
			     arq1.delete();
			     arq2.renameTo(arq1);
				 System.out.println("\nExclusao realizada com sucesso !");
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
	  public String nome_vendedor;
	  public float valor_venda;
	}
}