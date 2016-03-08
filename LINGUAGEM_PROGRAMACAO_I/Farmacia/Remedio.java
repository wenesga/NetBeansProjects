package Farmacia;
import javax.swing.JOptionPane;

public class Remedio extends Produto { 
    public float gerarPrecoDeVenda() { 
        return (super.getPrecoDeCompra() + super.getPrecoDeCompra() * (super.getPercentualDeLucro() / 100));
    }
        
    public void definirPercentualDeLucro() {
        super.setPercentualDeLucro(Float.parseFloat(JOptionPane.showInputDialog
        ("Digite o percentual de lucro do produto")));
    }
}