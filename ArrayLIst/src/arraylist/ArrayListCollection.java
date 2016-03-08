package arraylist;
import java.util.ArrayList;

/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 07/03/2016 - @TIPO Classe ArrayListCollection
 */
public class ArrayListCollection {

    public static void main(String[] args) {
        // cria um novo ArrayList de strings
        ArrayList< String> items = new ArrayList< String>();

        items.add("red"); // acrescenta um item à lista          
        items.add(0, "yellow"); // insere o valor no índice 0

        // cabeçalho
        System.out.print(
                "O conteúdo da lista de exibição com contador controlado Loop:");

        // exiba as cores na lista
        for (int i = 0; i < items.size(); i++) {
            System.out.printf(" %s", items.get(i));
        }

        // exibe as cores utilizando foreach no método display
        display(items,
                "\nO conteúdo da lista de exibição com instrução for aprimorada:");

        items.add("green"); // adiciona "green" ao final da lista
        items.add("yellow"); // adiciona "yellow" ao final da lista      
        display(items, "Lista com dois novos elementos:");

        items.remove("yellow"); // remove o primeiro "yellow"
        display(items, "Remover primeira instância do amarelo:");

        items.remove(1); // remove o item no índice 1
        display(items, "Retirar segundo elemento da lista (green):");

        // verifica se um valor está em List
        System.out.printf("\"red\" é %s na lista\n",
                items.contains("red") ? "" : "não ");

        // exibe o número de elementos em List
        System.out.printf("Tamanho: %s\n", items.size());
    }

    // exibe os elementos do ArrayList no console
    public static void display(ArrayList< String> items, String header) {
        System.out.print(header); // exibe o cabeçalho

        // exibe cada elemento nos itens
        for (String item : items) {
            System.out.printf(" %s", item);
        }

        System.out.println(); // exibe o fi m de linha
    } // fi m do método display

}
