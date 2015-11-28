import java.io.*;
import java.util.Scanner;
public class EX12_B
{ 
  public static void main(String args[])
  { RandomAccessFile loja = null;
  	Scanner entrada = new Scanner(System.in);
	Venda a, b;
	boolean repetido = false;
  	a = new Venda();
  	b = new Venda();

    try
       { loja = new RandomAccessFile("c:\\vendas.dat", "rw");
         System.out.print("\nDigite o codigo do vendedor a ser incluido ");
		 a.codigo_vendedor = entrada.nextInt();
		 System.out.print("Digite o mes da venda a ser incluida ");
		 a.mes = entrada.nextInt();

		 repetido = false;
		 
		 while (true)
		 {  b.codigo_vendedor = loja.readInt();
		    b.mes = loja.readInt();
		    b.ativo = loja.readInt();
		    b.nome_vendedor = loja.readUTF();
		    b.valor_venda = loja.readFloat();
		    if ((a.codigo_vendedor == b.codigo_vendedor) && (a.mes == b.mes) && (b.ativo == 1))
		       repetido = true;
	  	 }
	  }
	  catch(EOFException e)	 
	    { if (repetido == true)
	    	 System.out.println("\nDados ja estao cadastrados !");
	      else
	        { try
	        	{ entrada = new Scanner(System.in);
		 		  System.out.print("Digite o nome do vendedor a ser incluido ");
		 		  a.nome_vendedor = entrada.nextLine();
		          if (a.nome_vendedor.length() < 20) //fixando o tamanho do nome em exatamente 20 caracteres
  					 { for (int i= a.nome_vendedor.length() + 1; i <= 20; i++)
	  					 { a.nome_vendedor = a.nome_vendedor + " ";
	  					 } 		
  					 } 
  		 		  else
  					 a.nome_vendedor = a.nome_vendedor.substring(0,20);
		    	  System.out.print("Digite o valor da venda a ser incluida ");
		    	  a.valor_venda = entrada.nextFloat();
		    	  a.ativo = 1;
		    
				  loja.writeInt(a.codigo_vendedor);
	        	  loja.writeInt(a.mes);
	        	  loja.writeInt(a.ativo);
	        	  loja.writeUTF(a.nome_vendedor);
	        	  loja.writeFloat(a.valor_venda);
	        	  System.out.println("\nVenda incluida com sucesso !");
                  loja.close();
	        	}
	        	catch(IOException e2)
	        	{ System.out.println("Erro de I/O");
	        	}
	        } 	 
	    	
	    }
     catch (IOException e)  
       { System.out.println("Erro na criacao o arquivo");
       }

}
	private static class Venda
	{ public int codigo_vendedor;
	  public int mes;
	  public int ativo;
	  public String nome_vendedor;
	  public float valor_venda;
	}
}



