package trabalho.pkg4;
import java.util.Random;
public class Ram {

    public static void main(String[] args) {
        int[] vetorA = new int[10];
        int[] vetorB = new int[10];
        int[] vetorC = new int[20];
        int j=0;
        
        for(int i=0; i<10; i++){
            Random aleatorio1 = new Random();
            vetorA[i] = aleatorio1.nextInt(50);
            System.out.println("VetorA["+i+"] = "+vetorA[i]);
        }
        
        System.out.println("--------------");
        
        for(int i=0; i<10; i++){
            Random aleatorio2 = new Random();
            vetorB[i] = aleatorio2.nextInt(50);
            System.out.println("VetorB["+i+"] = "+vetorB[i]);
        }
        
        System.out.println("--------------");
        
        for(int i=0; i<10; i++){
            vetorC[j] = vetorA[i];
            j=j+2;
        }
        j=1;
        for(int i=0; i<10; i++){
            vetorC[j] = vetorB[i];
            j=j+2;
        }
        
        for(int i=0; i<20; i++){
            System.out.println("VetorC["+i+"] = "+vetorC[i]);
        }
        
    }
    
}
