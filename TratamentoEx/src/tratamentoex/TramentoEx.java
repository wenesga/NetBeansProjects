package tratamentoex;
// wenes
import java.util.InputMismatchException;
import java.util.Scanner;

public class TramentoEx {

    // demonstra o lançamento de uma exceção quando ocorre uma divisão por zero
    public static int quotiente(int numerador, int denominador) {
        return numerador / denominador;  // possível divisão por zero
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true; // determina se mais entradas são necessárias

        do {
            try {
                System.out.print("Digite o numerador inteiro: ");
                int numerador = scanner.nextInt();

                System.out.print("Digite o denominador inteiro: ");
                int denominador = scanner.nextInt();

                int resultado = quotiente(numerador, denominador);
                System.out.printf("\nResultado: %d / %d = %d\n", numerador, denominador, resultado);
                continueLoop = false; // entrada bem­sucedida; fim do loop                  
            } 
            
            catch (InputMismatchException inputMismatchException) {
                System.err.printf("\nExceção: %s\n", inputMismatchException);
                scanner.nextLine(); // descarta entrada para o usuário poder tentar de novo
                System.out.println("Você deve entrar com um numero interio. Tente novamente.\n");
            
            } catch (ArithmeticException arithmeticException) {
                System.err.printf("\nExceção: %s\n", arithmeticException);
                System.out.println("O denominador tem que ser diferente de zero. Tente novamente.\n");
            }
        } while (continueLoop);
    }
}
