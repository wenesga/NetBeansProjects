package ativdadepii;

import java.util.ArrayList;
import java.util.UnknownFormatConversionException;

/*
 * @Descrição: Demonstração da coleção ArrayList genérica.
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 05/03/2016 - @TIPO Classe ColecaoArrayList
 */
public class ColecaoArrayList {

    public static void main(String[] args) {
        
        // cria um novo ArrayList de strings
        ArrayList< String> items = new ArrayList< String>();

        items.add("vermelho");       // acrescenta um item à lista          
        items.add(0, "amarelo");     // insere o valor no índice 0

        // cabeçalho
        System.out.print("O conteúdo da lista de exibição com contador controlado Loop:");

        try {

            // exiba as cores na lista
            for (int i = 0; i < items.size(); i++) {
                System.out.printf(" %s", items.get(i));
            }

            // exibe as cores utilizando foreach no método display
            display(items, "\nO conteúdo da lista de exibição com instrução aprimorada:");

            items.add("verde");      // adiciona "verde" ao final da lista
            items.add("amarelo");    // adiciona "amarelo" ao final da lista      
            display(items, "Lista com dois novos elementos:");

            items.remove("amarelo"); // remove o primeiro "yellow"
            display(items, "Remover primeira instância do amarelo:");

            items.remove(1);         // remove o item no índice 1
            display(items, "Retirar segundo elemento da lista (verde):");

            // verifica se um valor está em List
            System.out.printf("\"vermelho\" é %perca a lista\n", items.contains("vermelho") ? "" : "não ");

            // exibe o número de elementos em List
            System.out.printf("Tamanho: %s\n", items.size());

        } catch (UnknownFormatConversionException excepition) {
            
            System.out.println("Ocorreu um erro");
        }

    }

    // exibe os elementos do ArrayList no console
    public static void display(ArrayList< String> items, String header) {
        System.out.print(header); // exibe o cabeçalho

        // exibe cada elemento nos itens
        for (String item : items) {
            System.out.printf(" %s", item);
        }

        System.out.println(); // exibe o fim de linha
    }
}
