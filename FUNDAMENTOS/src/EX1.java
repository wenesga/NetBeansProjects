import java.io.IOException;
import java.io.RandomAccessFile;
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

