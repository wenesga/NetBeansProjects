package capitulo7;
import java.util.ArrayList;
import java.util.Scanner;
public class Capitulo7 {

    public static void main(String[] args) {
        
        ArrayList<String> animais = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        
        System.out.println("Digite o nome do animal vaca");
        animais.add(s.next());
        
        animais.add("Gato");
        animais.add("Cavalo");
        
        System.out.println("Tamho do array = "+ animais.size());
        System.out.println("Indice do elemento vaca = " + animais.indexOf("vaca"));
        
        System.out.println(animais);        
    }
}
