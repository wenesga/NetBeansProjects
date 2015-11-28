package trabalho3;
import javax.swing.JOptionPane;
/**@author WENES
 */
public class Triangulo {
    private double lado1=0;
    private double lado2=0;
    private double lado3=0;
//------------------------
    public double getLado1() {
        return lado1;
    }
    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }
    public double getLado2() {
        return lado2;
    }
    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }
    public double getLado3() {
        return lado3;
    }
    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
//------------------------  
    public double calculaPerimetro(){
        double perimetro;
        perimetro = (lado1 + lado2 + lado3);
        JOptionPane.showMessageDialog(null,String.format("Perimetro = " + perimetro));
        return perimetro;
    }
//------------------------
    public String informaTipoTriangulo(){
        String tipo;
        if(lado1 == lado2 && lado1 == lado3){
            tipo = "Equilátero";
            JOptionPane.showMessageDialog(null, tipo);
        }
        else if(lado1 == lado2 || lado1 == lado3){
            tipo = "Isóceles";
            JOptionPane.showMessageDialog(null, tipo);
        }
        else{
            tipo = "Escaleno";
            JOptionPane.showMessageDialog(null, tipo);
        }
        return tipo;
    }
}
