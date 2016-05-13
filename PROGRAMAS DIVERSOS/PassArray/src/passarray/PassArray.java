package passarray;

/**
 * @Descrição: Passando arrays e elementos de arrays individuais aos métodos
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 01/03/2016 - @TIPO Classe PassArray
 */
public class PassArray {

    public static void main(String[] args) {

        try {

            int[] array = {1, 2, 3, 4, 5};

            System.out.println("Efeito de passagem referência do Array inteio:\n"
                    + "Os valores originais estão aqui:");

            for (int value : array) {
                System.out.printf("   %d", value);
            }

            modifyArray(array);
            System.out.println("\n\nOs valores modificados estão aqui:");

            for (int value : array) {
                System.out.printf(" %d ", value);
            }

            System.out.printf("\n\nOs efeitos de passar um valor de um elemento:\n"
                    + "Array[3] depois de ser modificado: %d\n", array[3]);

            modifyElement(array[3]);
            System.out.printf("Array[3] depois da modificação do elemento : %d\n", array[3]);

        } catch (Exception ex) {

            System.out.println(" Erro tente novamente!");
        }
    }

    public static void modifyArray(int array2[]) {
        for (int counter = 0; counter < array2.length; counter++) {
            array2[counter] *= 2;
        }
    }

    public static void modifyElement(int element) {
        element *= 2;
        System.out.printf("Valor de elemento modificado: %d\n", element);
    }
}
