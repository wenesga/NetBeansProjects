package atividadelpii;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * @Descrição: 
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 09/03/2016 - @TIPO Classe NovoClass
 */
public class Atividade2 {

    static int x; // Variavél de Classe

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        try {
            
            for (x = 0; x < 5; x++) {

                System.out.print("Digite a " + (x + 1) + "ª palavra: ");
                String temp = teclado.nextLine();
                compara(lista, temp);
            }

            for (String imprimir : lista) {
                System.err.println(imprimir);
            }
            
        } catch (Exception ex) {

            System.out.println("Ocorreu um erro a String não pode se nula");
        }
    }

    public static void compara(ArrayList lista, String temp) {
        
        if (lista.contains(temp)) {
            lista.clear();
            x = -1;
            System.err.println("Já existe um nome \"" + temp + "\" \nVamos tentar novamente?");
        } else {
            lista.add(temp);
        }
    }
}
