package String;
/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 15/03/2016 - @TIPO Classe StringCompare
 */
public class StringCompare {

    public static void main(String[] args) {
        String s1 = new String("olá"); // s1 é uma cópia de "hello"
        String s2 = "adeus";
        String s3 = "Feliz Aniversário";
        String s4 = "feliz aniversário";

        System.out.printf(
                "s1 = %s\ns2 = %s\ns3 = %s\ns4 = %s\n\n", s1, s2, s3, s4);

        // teste para igualdade
        if (s1.equals("olá")) // true
        {
            System.out.println("s1 é igual \"olá\"");
        } else {
            System.out.println("s1 o que são iguai \"olá\"");
        }

        // testa quanto à igualdade com ==
        if (s1 == "hello") // false; eles não são os mesmos objetos
        {
            System.out.println("s1 é o mesmo objeto como \"olá\"");
        } else {
            System.out.println("s1 is not the same object as \"hello\"");
        }

        // testa quanto à igualdade (ignora maiúsculas e minúsculas)
        if (s3.equalsIgnoreCase(s4)) // true
        {
            System.out.printf("%s equals %s with case ignored\n", s3, s4);
        } else {
            System.out.println("s3 does not equal s4");
        }

        // testa compareTo
        System.out.printf(
                "\ns1.compareTo( s2 ) is %d", s1.compareTo(s2));
        System.out.printf(
                "\ns2.compareTo( s1 ) is %d", s2.compareTo(s1));
        System.out.printf(
                "\ns1.compareTo( s1 ) is %d", s1.compareTo(s1));
        System.out.printf(
                "\ns3.compareTo( s4 ) is %d", s3.compareTo(s4));
        System.out.printf(
                "\ns4.compareTo( s3 ) is %d\n\n", s4.compareTo(s3));

        // testa regionMatches (distingue maiúsculas e minúsculas)
        if (s3.regionMatches(0, s4, 0, 5)) {
            System.out.println("First 5 characters of s3 and s4 match");
        } else {
            System.out.println(
                    "First 5 characters of s3 and s4 do not match");
        }

        // testa regionMatches (ignora maiúsculas e minúsculas)
        if (s3.regionMatches(true, 0, s4, 0, 5)) {
            System.out.println(
                    "First 5 characters of s3 and s4 match with case ignored");
        } else {
            System.out.println(
                    "First 5 characters of s3 and s4 do not match");
        }
    }
}
