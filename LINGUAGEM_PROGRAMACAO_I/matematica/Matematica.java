package Aulas;
/** sqrt 27 = 5
 * 
 * 1  - 27-1 = 26
 * 2  - 26-3 = 23
 * 3  - 23-5 = 18 
 * 4  - 18-7 = 11
 * 5  - 11-9 = 2
 */
public class Matematica {
      /**
       * @param numero
       * @return a raiz quadrada no numero segundo Eq. de Pell.
       */
      int raiz (int numero) {
            int raiz = 0;
            int impar = 1;
            while (numero >= impar) {
                  numero = numero - impar;
                  impar = impar + 2;
                  ++raiz;
            }
            return raiz;
      }
}