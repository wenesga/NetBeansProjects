package array;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 07/03/2016 - @TIPO Classe Cores
 */

public class Cores {
    
    public static void main(String[] args) {

        ArrayList<String> cor = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite as cores: ");
       
        cor.add(scan.nextLine());
        cor.add(scan.nextLine());
        cor.add(scan.nextLine());
        cor.add(scan.nextLine());
        cor.add(scan.nextLine());
        
        System.out.println("------");
        
        System.out.println(cor.get(2));
        System.out.println(cor.get(3));
        
        cor.remove(cor.get(2));
        cor.remove(cor.get(2));
        
        System.out.println("------");
        
        System.out.println(cor);
        
        cor.clear();
        
        System.out.println("------");
        
        if(cor.size() == 0) {
            System.out.println("Digite duas cores:");
            cor.add(scan.nextLine());
            cor.add(scan.nextLine());
            System.out.println("------");
            System.out.println(cor);
        }

    }

}
