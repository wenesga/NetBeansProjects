import java.io.*;
import java.util.Scanner;
public class EX21_C
{ 
  public static void main(String args[])
  { RandomAccessFile contas = null, clientes = null, auxi = null;
  	Scanner entrada = new Scanner(System.in);
	Cliente c = new Cliente();
	Conta a, b;
  	a = new Conta();
  	b = new Conta();
	boolean repetido = false, achou = false, gravou = false;
	String nome="";
	
    try
       { clientes = new RandomAccessFile("c:\\clientes.dat", "rw");
         System.out.print("Digite o numero da conta a ser incluida ");
		 a.numero_conta = entrada.nextInt();

         System.out.print("Digite o numero do cliente ");
		 a.numero_cli = entrada.nextInt();

         System.out.print("Digite o saldo da conta ");
		 a.saldo = entrada.nextFloat();

		 entrada = new Scanner(System.in);

		 achou = false;

		 while (true)
		 {  c.numero = clientes.readInt();
		    c.nome = clientes.readUTF();
		    if (a.numero_cli == c.numero)
		       { achou = true;
		         nome = c.nome;
		       }  
	  	 }
		 
	  }
	  catch(EOFException e)	 
	    { if (achou == false)
	    	 System.out.println("Cliente nao cadastrado! ");
	      else
	      { try
	          {  clientes.close();
	             repetido = false;
				 
				 contas = new RandomAccessFile("c:\\contas.dat", "rw");
				 while (true)
				 {  b.numero_conta = contas.readInt();
				 	b.numero_cli = contas.readInt();
				    b.saldo = contas.readFloat();
				    if (a.numero_conta == b.numero_conta)
				       repetido = true;
			  	 }
			  } // fim try	 
			catch (EOFException e2)
			{ if (repetido == true)
	    	 	System.out.println("\nJa existe conta cadastrada com este numero!");
	    	  else
	    	    { try { System.out.print("\nNome do cliente: " + nome);
	    	    		contas.seek(0);
						auxi = new RandomAccessFile("c:\\auxiliar.dat", "rw");
						gravou = false;
						while (true)
		 				{ b.numero_conta = contas.readInt();
		 				  b.numero_cli = contas.readInt();
		 				  b.saldo = contas.readFloat();
			           	  if ((b.numero_conta > a.numero_conta) && (gravou == false))	  	
		        		  	  { auxi.writeInt(a.numero_conta);
		        		  	    auxi.writeInt(a.numero_cli);
		        		  	    auxi.writeFloat(a.saldo);
				        	  	gravou = true;
				        	  	System.out.println("\nConta incluida com sucesso !");
				        	  }			          
		        		  auxi.writeInt(b.numero_conta);
		        		  auxi.writeInt(b.numero_cli);
		        		  auxi.writeFloat(b.saldo);
			        	}
                  	  }//fim try
                  catch (EOFException e3)	  	
	                  { try 
	  	 	     			{ if (gravou == false)
		  	 	 	  			{ auxi.writeInt(a.numero_conta);
		        		  	      auxi.writeInt(a.numero_cli);
		        		  	      auxi.writeFloat(a.saldo);
		        	  			  System.out.println("\nConta incluida com sucesso !");
		        	  			}
		            		  contas.close();
		                      auxi.close();  
		            		  File arq1, arq2;
		            		  arq1 = new File("c:\\contas.dat");
		            		  arq2 = new File("c:\\auxiliar.dat");
		            		  arq1.delete();
		            		  arq2.renameTo(arq1);
		            		}
		            	catch (IOException e4)	  
		            	{ System.out.println("Erro de I/O");
		            	}
		              }//fim catch
		            catch (IOException e3)	  
		              { System.out.println("Erro de I/O");
		              }
		            }  //fim else
		         }//fim catch  	  
		       catch(IOException e3)
		         { System.out.println("Erro de I/O");
		         } //fim catch
	                  }
	  }  
     catch (IOException e)  
       { System.out.println("Erro na criacao o arquivo");
       }
 }//fim main

	private static class Cliente
	{ public int numero;
	  public String nome;
	}

	private static class Conta
	{ public int numero_conta;
	  public int numero_cli;
	  public float saldo;
	}
}