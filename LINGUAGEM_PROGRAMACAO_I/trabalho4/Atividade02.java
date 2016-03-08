package trabalho.pkg4;
import java.util.Random;

public class Atividade02 {
    public static void main(String[]args){
        
        int[] temperatura = new int[12];
        int i, maior = 0, menor = 0, cont1 = 1, cont2 = 1;
        
        for(i=0; i<12; i++){
            
            Random aleatorio = new Random();
            
            temperatura[i] = aleatorio.nextInt(50)-10;
            
            System.out.printf("Temperatura mês %d = %d\n", i+1, temperatura[i]);
            
            if(i==0){
                maior = temperatura[i];
                menor = temperatura[i];
            }
            
            else {
                if(temperatura[i] >= maior){
                maior = temperatura[i];
                cont1 = i+1; 
                }
                else if(temperatura[i] <= menor){
                menor = temperatura[i];
                cont2 = i+1;  
                }
            } 
        }
        System.out.println("---------------------------------");
        System.out.print("Maior temperatura do ano = "+maior);
        System.out.println(" no Mês = "  +cont1);
        System.out.print("Maior temperatura do ano = "+menor);
        System.out.println(" no Mês = "  +cont2);
    }
}
