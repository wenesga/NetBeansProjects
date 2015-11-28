package imc;
import javax.swing.JOptionPane;
public class IMC {
    
    public static void main(String[] args) {
               
        String peso2 = JOptionPane.showInputDialog("Digite seu peso");
        String altura2 = JOptionPane.showInputDialog("Digite sua altura");
        
        double peso = Double.parseDouble(peso2);
        double altura = Double.parseDouble(altura2);
        double imc = peso / (altura * altura);
        
        String msg = (imc >= 20 && imc <= 25) ? "Peso ideal" : "Sobrepeso";
        
        System.out.println("IMC =  " + imc);
        System.out.println(msg);
    }
    
}
