package Calculadora;
import javax.swing.JOptionPane;

public class Calculadora {
    public static void main(String args[]){
        String result = "";
        int num, i, mult = 1;
        num = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero: "));
        
        for ( i = 1; i <= 10; i++ ){
            mult = num * i;
            result = result + num +" x "+ i +" = "+ mult + "\n";
        }
        JOptionPane.showMessageDialog(null, result ); 
    }
}