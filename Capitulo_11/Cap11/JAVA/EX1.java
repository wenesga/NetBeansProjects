import java.io.*;
public class EX1
{
  public static void main(String args[])
   { RandomAccessFile alunos;
     
     try
       { alunos = new RandomAccessFile("c:\\alunos.dat", "rw");
         System.out.println("Sucesso na criacao o arquivo");
         alunos.close();
       }
     catch (IOException e)  
       { System.out.println("Erro na criacao do arquivo");
       }
   }
}   
