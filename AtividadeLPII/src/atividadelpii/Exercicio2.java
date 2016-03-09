package atividadelpii;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com> 
 * @date 07/03/2016 - @TIPO Classe Exercicio2
 */
public class Exercicio2 {

    public static void main(String[] args) {

        ArrayList<String> palavra = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        for (int x = 0; x < 5; x++) {

            System.out.print("Digite a palavras " + (x+1) + ": ");
            String temp = scan.nextLine();
            
            if (palavra.contains(temp)) {
                x = -1;
                palavra.clear();
                System.err.println("Já existe um palavra \""+temp+"\"! \nVamos tentar novamente?");
                
            } else {
                palavra.add(temp);
            }
        }
        System.out.println(palavra);
    }
}
