import java.io.*;
public class EX19
{
  public static void main(String args[])
   { RandomAccessFile clientes, contas;
     
     try
       { clientes = new RandomAccessFile("c:\\clientes.dat", "rw");
         System.out.println("Sucesso na criacao o arquivo de Clientes");
         clientes.close();
       }
     catch (IOException e)  
       { System.out.println("Erro na criacao do arquivo de Clientes");
       }
       
     try
       { contas = new RandomAccessFile("c:\\contas.dat", "rw");
         System.out.println("Sucesso na criacao o arquivo de Contas");
         contas.close();
       }
     catch (IOException e)  
       { System.out.println("Erro na criacao do arquivo de Contas");
       }       
   }
}   
