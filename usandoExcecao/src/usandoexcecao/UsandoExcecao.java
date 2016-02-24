package usandoexcecao;


public class  UsandoExcecao {
   public static void main( String[] args )
   {
      try { 
         metodo1(); // chama metodo1 
      } // fim do try
      catch ( Exception exception ) {  // captura a exceção lançada em metodo1
      
         System.err.printf( "%s\n", exception.getMessage() );
         exception.printStackTrace(); //  imprime rastreamento da pilha de exceções

         //  obtém informações de rastreamento da pilha
         StackTraceElement[] traceElements = exception.getStackTrace();
         
         System.out.println( "\nPilha traço getStackTrace:" );
         System.out.println( "Classe           \t\tArquivo\t\t\tLinha\tMetodo" );

         // faz um loop por traceElements para obter a descrição da exceção
         for ( StackTraceElement element : traceElements ) {
            System.out.printf( "%s\t", element.getClassName() );
            System.out.printf( "%s\t", element.getFileName() );
            System.out.printf( "%s\t", element.getLineNumber() );
            System.out.printf( "%s\n", element.getMethodName() );
         } // fim for
      } // fim catch
   } // fim main

   //  chama metodo2; lança exceções de volta para main
   public static void metodo1() throws Exception {
      metodo2();
   } // fim do método metodo1 

   // chama metodo; lança exceções de volta para metodo1
   public static void metodo2() throws Exception {
      metodo3();
   } //  fim do método metodo2

   // lança Exception de volta para metodo2
   public static void metodo3() throws Exception {
      throw new WenesExcecao();
   } // fi m do método metodo3 
   
   
   
   
   
   
   
   
} //  fim da classe UsandoExcecao





















/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
