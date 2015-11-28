package trabalho2;
import java.util.Scanner;
/**
 * @author WENES
 */
public class Atividade13 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int codigo, cont;
        double valor;
        
        for(cont=1;cont<=15; cont++){
            
            System.out.print("Digite o código do cliente "+ cont +":");
            codigo = teclado.nextInt();
            System.out.print("Digite o valor das compras do ano passado: ");
            valor = teclado.nextDouble();
            if(valor < 1000){
                valor = (valor * 0.1);
                System.out.println("Valor do bonus = " + valor);
            }
            else{
                valor = (valor * 0.15); 
                System.out.println("Valor do bonus " + valor);
            }
            System.out.println("------------------------");
        }
    }
}