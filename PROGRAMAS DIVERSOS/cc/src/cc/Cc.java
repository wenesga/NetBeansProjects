/*
 * Escreva uma aplicaÃ§Ã£o que receba dois inteiros, calcule e mostre a soma dos
 * nÃºmeros, diferenÃ§a, produto, quociente e o resto.
 */
package cc;

import java.util.Scanner;
/**
 *
 * @author julio
 */
public class Cc
{
    public static void main( String[] args ) 
    {
        Scanner teclado = new Scanner( System.in );
        
        int num1;
        int num2;  
        int resto;
        
        System.out.print( "Entre com o primeiro inteiro: " );
        num1 = teclado.nextInt(); 
        
        System.out.print( "Entre com o segundo inteiro: " );
        num2 = teclado.nextInt(); 
        
        System.out.printf( "%d + %d = %d%n", num1, num2, num1 + num2 );
        System.out.printf( "%d - %d = %d%n", num1, num2, num1 - num2 );
        System.out.printf( "%d * %d = %d%n", num1, num2, num1 * num2 );
        System.out.printf( "%d / %d = %d%n", num1, num2, num1 / num2 );
        System.out.printf( "%d %% %d = %d %n", num1, num2, num1 % num2 );        
    }    
}