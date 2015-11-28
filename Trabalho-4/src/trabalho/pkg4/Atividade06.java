package trabalho.pkg4;
import java.util.Scanner;
public class Atividade06 {
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);
        int[] termo = new int[10];
        int i, razao;
        
        System.out.println("Primeiro termo da PA: ");
        termo[0] = tecla.nextInt();
        System.out.println("Razão da PA: ");
        razao = tecla.nextInt();
        
        for(i=1; i<10; i++){
            termo[i] = termo[i-1] + razao;                        
        } 
        
        for(i=0; i<10; i++){
            System.out.println("Termo["+i+"] = "+termo[i]);
        }
    }
}
