package String;
/**
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 15/03/2016 - @TIPO Classe StringConcatenation
 */
public class StringConcatenation {

    public static void main(String[] args) {

        String s1 = "Wenes ";
        String s2 = "Gomes";

        System.out.printf("s1 = %s\ns2 = %s\n", s1, s2);
        System.out.printf("Resultado para s1.concat( s2 ) = %s\n", s1.concat(s2));
        System.out.printf("s1 depois de concatenação = %s\n", s1);
    }
}
