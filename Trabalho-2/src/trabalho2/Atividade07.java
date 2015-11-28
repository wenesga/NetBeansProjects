package trabalho2;
import java.util.Scanner;
/**
 * @author WENES
 */
public class Atividade07 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        double valorItem=0;
        double somaItem=0;
        double somaItemDesconto;
        int cont=1;
        System.out.print("Digite o valor do 1º item = ");
        valorItem = teclado.nextDouble();
        while(valorItem != -1){
            cont++;
            somaItem = somaItem + valorItem;
            System.out.printf("Digite o valor do %dº item = ",cont);
            valorItem = teclado.nextDouble();
        }
        somaItemDesconto = somaItem - somaItem * 0.1;
        System.out.println("Soma Total = "+ somaItem);
        System.out.println("Soma Total com Desconto = "+ somaItemDesconto);
    }    
}
