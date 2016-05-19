package arraylistcollection;
import java.util.ArrayList;
/**
 * @Cometario: Lista de coleções: coleções de cores
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 16/05/2016 - Classe: ArrayListCollection
 */
public class ListaCores {
    public static void main(String[] args) {
        ArrayList< String> cores = new ArrayList< String>();
        cores.add("Verde");
        cores.add(0, "Amarelo");
        System.out.print("EXIBIR LISTA DE CONTEUDO COM CONTADOR CONTROLADA LOOP:");

        for (int i = 0; i < cores.size(); i++) {
            System.out.printf(" %s", cores.get(i));
        }

        display(cores,"\nEXIBIR LISTA DE CONTEUDO COM REFOÇADA PARA DECLARAÇÃO:");
        cores.add("Verde"); 
        cores.add("Amarelo");
        
        display(cores, "LISTA COM DOIS NOVOS ELEMENTOS:");
        cores.remove("Amarelo"); 
        
        display(cores, "REMOVER A PRIMEIRA INSTANCIA DE AMARELO:");
        cores.remove(1); 
        
        display(cores, "REMOVER SEGUNDA LISTA ELEMENTO  (VERDE):");
        System.out.printf("\"Verde\" esta %s na lista\n", cores.contains("Verde") ? "" : "não ");
        System.out.printf("Size: %s\n", cores.size());
    }
    public static void display(ArrayList< String> items, String header) {
        System.out.print(header); 
        for (String item : items) {
            System.out.printf(" %s", item);
        }
        System.out.println(); 
    } 
} 