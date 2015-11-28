package capitulo6;
import java.util.Scanner;
public class AulaMetodo {
    
    public static void main(String[] args) {
       int num1, num2, num3;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite 3 numero: ");
        num1 = teclado.nextInt();
        num2 = teclado.nextInt();
        num3 = teclado.nextInt();
        int menor = calculaMenor(num1, num2, num3);
        System.out.println("menor = "+menor);
    }
    
    public static int calculaMenor(int n1, int n2, int n3){
        int menor;
        if(n1 < n2 && n1 < n3){
            menor = n1;
        }
        else if (n2 < n1 && n2 < n3){
            menor = n2;
        }
        else 
            menor = n3;
        return menor;
    }
    
    
}
