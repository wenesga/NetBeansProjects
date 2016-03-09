package atividadelpii;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 09/03/2016 - @TIPO Classe NovoClass
 */
public class NovoClass {

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        for (int x = 0; x < 5; x++) {

            System.out.print("Digite a " + (x + 1) + "ª palavra: ");
            String temp = teclado.nextLine();
            compara(lista, temp, x);
        }

        for (String imprimir : lista) {
            System.err.println(imprimir);
        }
    }

    public static void compara(ArrayList lista, String temp, int x) {

        if (lista.contains(temp)) {
            lista.clear();
            x = -1;
            System.err.println("Já existe um nome \"" + temp + "\" \nVamos tentar novamente?");
        } else 
            lista.add(temp);
    }
}
