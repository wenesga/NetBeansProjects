import java.io.*;
import java.util.Scanner;
public class EX12_D
{ 
  public static void main(String args[])
  { RandomAccessFile loja = null, auxi = null;
  	Scanner entrada = new Scanner(System.in);
	Venda a, b;
	boolean repetido = false, gravou = false;
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
		    if ((b.ativo == 1) && (a.codigo_vendedor == b.codigo_vendedor) && (a.mes == b.mes))
		       repetido = true;
	  	 }
	  }
	  catch(EOFException e)	 
	    { if (repetido == true)
	    	 System.out.println("\nDados ja estao cadastrados !");
	      else
	        { try
	        	{ auxi = new RandomAccessFile("c:\\auxiliar.dat", "rw");
	        	
	        	  entrada = new Scanner(System.in);
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
		    	  
		    	  loja.seek(0);
                  gravou = false;
                  
                  if (loja.length() == 0)
                  { loja.writeInt(a.codigo_vendedor);
					loja.writeInt(a.mes);
					loja.writeInt(a.ativo);
				    loja.writeUTF(a.nome_vendedor);
					loja.writeFloat(a.valor_venda);
                  }
                  else
                  {
					  while (true)
			 			{  b.codigo_vendedor = loja.readInt();
			    		   b.mes = loja.readInt();
			    		   b.ativo = loja.readInt();
			    		   b.nome_vendedor = loja.readUTF();
			    		   b.valor_venda = loja.readFloat();
			    		   
				           if ((b.ativo == 1) && ((b.codigo_vendedor > a.codigo_vendedor) || ((b.codigo_vendedor == a.codigo_vendedor) && (b.mes > a.mes))) && (gravou == false))	  	
			        		  { auxi.writeInt(a.codigo_vendedor);
								auxi.writeInt(a.mes);
			        		    auxi.writeInt(a.ativo);
					        	auxi.writeUTF(a.nome_vendedor);
								auxi.writeFloat(a.valor_venda);
				        	  	gravou = true;
				        	  }			          
			        		auxi.writeInt(b.codigo_vendedor);
							auxi.writeInt(b.mes);
							auxi.writeInt(b.ativo);
					        auxi.writeUTF(b.nome_vendedor);
							auxi.writeFloat(b.valor_venda);
				        }	    	  
				    }
				  }    
		         catch(EOFException e2)
		        	{ System.out.println("\nVenda incluida com sucesso !");
	                  try { 
	                        if (gravou == false)
				  	 	 	  { auxi.writeInt(a.codigo_vendedor);
								auxi.writeInt(a.mes);
			        		    auxi.writeInt(a.ativo);
					        	auxi.writeUTF(a.nome_vendedor);
								auxi.writeFloat(a.valor_venda);
				        	  }
	                        loja.close();
	                        auxi.close();
	                        File arq1, arq2;
			            	arq1 = new File("c:\\vendas.dat");
			            	arq2 = new File("c:\\auxiliar.dat");
			            	arq1.delete();
			            	arq2.renameTo(arq1);
	                      }
	                  catch (IOException e3)    
	                  { System.out.println("Erro de I/O");
	                  }
		        	}//fim catch 	 
		         catch (IOException e2)    
	                { System.out.println("Erro de I/O");
	                }
	      } //fim else
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



