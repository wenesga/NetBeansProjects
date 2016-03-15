package String;

/**
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 14/03/2016 - @TIPO Classe StringMiscellaneous
 */

public class StringMiscellaneous {
    
    public static void main(String[] args) {

        String s1 = "Wenes Gomes";
          char[] charArray = new char[ 5 ];
   
          System.out.printf( "s1: %s", s1 );
   
          // testa o método length
          System.out.printf( "\nComprimento para s1: %d", s1.length() );
   
          // faz loop pelos caracteres em s1 com charAt e os exibe na ordem inversa
          System.out.print( "\nA sequência de caracteres recuperado é: " );
   
          for (int count = s1.length() -1; count >= 0; count--)
                       
          System.out.printf( "%c ", s1.charAt( count ) );
   
          // copia caracteres a partir de string para charArray
          s1.getChars( 0, 5, charArray, 0 );
          System.out.print( "\nA array de caracteres é: " );
   
          for ( char character : charArray )
             System.out.print( character );
   
          System.out.println();

    }
}
