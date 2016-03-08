package trabalho3;
import javax.swing.JOptionPane;
/** @author WENES
 */
public class TrianguloTeste {
    public static void main(String[] args){
        Triangulo tri = new Triangulo();
        int opcao = 1;
        double perimetro = 0;
        String tipo = null;
        
        while(opcao !=0){
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite umas das opçoes desejanda:\n"
                    + "\n1 - Informar o valor dos lados do triangulo "
                    + "\n2 - Verificar o tipo de triangulo "
                    + "\n3 - Verificar o perimetro do triangulo "
                    + "\n0 - Sair"));
            switch(opcao){
            case 1:
                double x = Integer.parseInt(JOptionPane.showInputDialog("Informe o primeiro lado: "));
                double y = Integer.parseInt(JOptionPane.showInputDialog("Informe o segundo lado: "));
                double z = Integer.parseInt(JOptionPane.showInputDialog("Informe o terceiro lado: "));
                tri.setLado1(x);
                tri.setLado2(y);
                tri.setLado3(z);
                JOptionPane.showMessageDialog(null, "Primeiro lado = "  +tri.getLado1()
                                                   +"\nSegundo lado = " +tri.getLado2()
                                                   +"\nTerceiro lado = "+tri.getLado3());
                
                if (tri.getLado1() > tri.getLado2()+tri.getLado3() || tri.getLado2() > tri.getLado1()+tri.getLado3() 
                        || tri.getLado3() > tri.getLado1()+tri.getLado2() 
                        || tri.getLado1()<=0 || tri.getLado2()<=0 || tri.getLado3()<=0) 
                JOptionPane.showMessageDialog(null,"Não é um triangulo"); break;
            
            case 2:
                if(tri.getLado1()==0.0||tri.getLado2()==0.0||tri.getLado3()==0.0)
                    JOptionPane.showMessageDialog(null, "Informe o valor dos lados do triângulo");
                else{
                    if (tri.getLado1() > tri.getLado2()+tri.getLado3() || tri.getLado2() > tri.getLado1()+tri.getLado3() 
                        || tri.getLado3() > tri.getLado1()+tri.getLado2() 
                        || tri.getLado1()<=0 || tri.getLado2()<=0 || tri.getLado3()<=0) 
                        JOptionPane.showMessageDialog(null,"Não é um triangulo");
                    else
                        tri.informaTipoTriangulo(); 
                }break;
            
            case 3:
                if(tri.getLado1() == 0 || tri.getLado2() == 0 || tri.getLado3() == 0)
                    JOptionPane.showMessageDialog(null, "Informe o valor dos lados do triângulo");
                else{
                    if (tri.getLado1() > tri.getLado2()+tri.getLado3() || tri.getLado2() > tri.getLado1()+tri.getLado3() 
                        || tri.getLado3() > tri.getLado1()+tri.getLado2() 
                        || tri.getLado1()<=0 || tri.getLado2()<=0 || tri.getLado3()<=0) 
                        JOptionPane.showMessageDialog(null,"Não é um triangulo");
                    else
                        tri.calculaPerimetro(); 
                } break;
            }
        }
    }
}
