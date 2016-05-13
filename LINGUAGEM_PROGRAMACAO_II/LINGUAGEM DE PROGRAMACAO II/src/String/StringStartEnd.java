package String;
/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 15/03/2016 - @TIPO Classe StringStartEnd
 */
public class StringStartEnd {

    public static void main(String[] args) {
        String[] strings = {"começado", "apartir", "terminou", "acabar"};

        // testa o método startsWith
        for (String string : strings) {
            if (string.startsWith("c")) {
                System.out.printf("\"%s\" inicia com \"c\"\n", string);
            }
        } // for final

        System.out.println();

        // testa o método startsWith iniciando da posição 2 de string
        for (String string : strings) {
            if (string.startsWith("a", 2)) {
                System.out.printf(
                        "\"%s\" incia com \"a\" em posição 2\n", string);
            }
        } // for final

        System.out.println();

        // testa o método endsWith
        for (String string : strings) {
            if (string.endsWith("r")) {
                System.out.printf("\"%s\" termina com \"r\"\n", string);
            }
        }

    }
}
