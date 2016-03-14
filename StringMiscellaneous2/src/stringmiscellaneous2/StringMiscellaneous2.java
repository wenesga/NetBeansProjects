package stringmiscellaneous2;

/**
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 14/03/2016 - @TIPO Classe StringMiscellaneous2
 */
public class StringMiscellaneous2 {

    public static void main(String[] args) {
        try {
            String s1 = "Alô";
            String s2 = "WENES";
            String s3 = "   aquino   ";

            System.out.printf("s1 = %s\ns2 = %s\ns3 = %s\n\n", s1, s2, s3);

            // testa o método replace
            System.out.printf("Substituir 'l' por 'L' em s1: %s\n\n", s1.replace('l', 'L'));

            // testa o toLowerCase e toUpperCase
            System.out.printf("s1.toUpperCase() = %s\n", s1.toUpperCase());
            System.out.printf("s2.toLowerCase() = %s\n\n", s2.toLowerCase());

            // testa o método trim
            System.out.printf("s3 depois aparar = \"%s\"\n\n", s3.trim());

            // testa o método toCharArray
            char[] charArray = s1.toCharArray();
            System.out.print("s1 Como uma array de caracteres = ");
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro");
        }
    }
}
