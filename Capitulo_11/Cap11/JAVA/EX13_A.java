import java.io.*;
import java.util.Scanner;
public class EX13_A
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
         System.out.print("\nDigite o codigo do vendedor ");
		 a.codigo_vendedor = entrada.nextInt();
         System.out.print("Digite o mes desejado ");
       	 a.mes = entrada.nextInt();

         achou = false;
         c = 0;
		 while (true)
		 {  auxi = loja.getFilePointer(); //captura o byte onde começam os dados de uma venda
		    b.codigo_vendedor = loja.readInt();
		    b.mes = loja.readInt();
		    b.nome_vendedor = loja.readUTF();
		    b.valor_venda = loja.readFloat();
		    if ((a.codigo_vendedor == b.codigo_vendedor) && (a.mes == b.mes))
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
			     loja.seek(c); 
			     b.codigo_vendedor = loja.readInt();
			     b.mes = loja.readInt();
			     b.nome_vendedor = loja.readUTF();
			     b.valor_venda = loja.readFloat();
			     System.out.print("\nNome do vendedor " + b.nome_vendedor);
				 System.out.print("\nValor atual da venda " + b.valor_venda);
				 System.out.print("\nDigite novo valor da venda ");
				 b.valor_venda = entrada.nextFloat();

				 loja.seek(0);
			     loja.seek(c+30); //somou 30 bytes (4 bytes do codigo, 4 bytes do mes e 22 bytes do nome e 17 bytes do curso) para posicionar-se exatamente no início do valor da venda
			     loja.writeFloat(b.valor_venda);
				 System.out.println("\nAlteracao realizada com sucesso !");
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
	  public String nome_vendedor;
	  public float valor_venda;
	}
}