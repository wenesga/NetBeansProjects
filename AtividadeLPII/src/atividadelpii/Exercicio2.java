package atividadelpii;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.beans.binding.Bindings;

/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com> 
 * @date 07/03/2016 - @TIPO Classe Exercicio2
 */
public class Exercicio2 {

    public static void main(String[] args) {

        ArrayList<String> palavra = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite 5 palavras: ");

        try {

            palavra.add(scan.nextLine());
            palavra.add(scan.nextLine());
            palavra.add(scan.nextLine());
            palavra.add(scan.nextLine());
            palavra.add(scan.nextLine());

            compararString(palavra, null);
            System.out.println(palavra);

        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Ocorreu um erro!");
        }

    }

    public static String compararString(ArrayList palavra, String msg) {

        msg = "Já existe";

        for (int i = 0; i < palavra.size(); i++) {

            if (palavra.get(0) == palavra.get(i + 1)) {

                System.out.println(msg);
                palavra.clear();
            }
        }

        System.out.println("Digite 5 palavras: ");
        return msg;
    }
}
