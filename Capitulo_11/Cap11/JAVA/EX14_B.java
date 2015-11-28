import java.io.*;
import java.util.Scanner;
public class EX14_B
{ 
  public static void main(String args[])
  { RandomAccessFile loja = null;
  	Scanner entrada = new Scanner(System.in);
	Venda a, b;
	a = new Venda();
	b = new Venda();
	long c=0, auxi;
	boolean achou = false;

    try
       { loja = new RandomAccessFile("c:\\vendas.dat", "rw");
		 System.out.print("Digite o codigo do vendedor a ser excluido ");
		 a.codigo_vendedor = entrada.nextInt();
		 System.out.print("Digite o mes a ser excluido ");
		 a.mes = entrada.nextInt();
		 
         achou = false;

		 while (true)
		 {  auxi = loja.getFilePointer(); //captura o byte onde começam os dados de uma venda
		    b.codigo_vendedor = loja.readInt();
			b.mes = loja.readInt();
			b.ativo = loja.readInt();
			b.nome_vendedor = loja.readUTF();
			b.valor_venda = loja.readFloat();

		    if ((b.codigo_vendedor == a.codigo_vendedor) && (b.mes == a.mes) && (b.ativo == 1))
		       { achou = true;
		         c = auxi;
		       }  
	  	 }
	  } //fim try
	catch (EOFException e)  
	  { if (achou == false)
		   System.out.println("\nVenda nao cadastrada ! ");
		else
		   { try
		       { loja.seek(0);
			     loja.seek(c+8); //somou 8 bytes (4 bytes do código e 4 bytes para o mes) para posicionar-se exatamente no início do campo ativo
			     loja.writeInt(0);
				 System.out.println("\nExclusao realizada com sucesso !");
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