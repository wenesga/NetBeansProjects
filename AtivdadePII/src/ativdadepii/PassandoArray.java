package ativdadepii;

/*
 * @Descrição: Passando arrays e elementos de arrays individuais aos métodos.
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 05/03/2016 - @TIPO Classe ColecaoArrayList
 */
public class PassandoArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.println(
                "Efeitos da passagem de referência para todo array:\n"
                + "Os valores do array original são:");

        // gera saída de elementos do array original
        
        for (int value : array) {
            System.out.printf("   %d", value);
        }

        modifyArray(array); // passa a referência do array
        
        System.out.println("\n\nOs valores do array modificado são:");

        // gera saída de elementos do array modificado
        
        for (int value : array) {
            System.out.printf("   %d", value);
        }

        System.out.printf("\n\nEfeitos do valor do elemento do array de passagem:\n"
                + "array[3] antes de modifyElement: %d\n", array[3]);

        modifyElement(array[3]); // tenta modificar o array[ 3 ]
        
        System.out.printf("array[3] depois de modifyElement: %d\n", array[3]);
    }

    // multiplica cada elemento de um array por 2                 
    
    public static void modifyArray(int[] array2) {  //método modifyArray
        
        for (int counter = 0; counter < array2.length; counter++) {
            array2[counter] *= 2;
        }
    }                                 

    // multiplica argumento por 2                              
    
    public static void modifyElement(int element) {  //método modifyElement
        
        element *= 2;
        System.out.printf("Valor do elemento no elemento de modificação: %d\n", element);
    } // fim do método modifyElement                            
}



