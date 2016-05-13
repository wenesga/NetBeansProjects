package String;
/**
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 14/03/2016 - @TIPO Classe StringConstructors
 */
public class StringConstructors {

    public static void main(String[] args) {

        char[] charArray = {'W', 'e', 'n', 'e', 's', ' ', 'A', 'q', 'u', 'i', 'n', 'o'};

        String s = new String("Alô!");

        // Utiliza os construtores String  
        
        try {
            String s1 = new String();
            String s2 = new String(s);
            String s3 = new String(charArray);
            String s4 = new String(charArray, 6, 6);
            System.out.printf("s1 = %s\ns2 = %s\ns3 = %s\ns4 = %s\n", s1, s2, s3, s4);

        } catch (Exception ex) {

            System.out.println("Aconteceu erro");
        }
    }
}
