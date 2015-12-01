package Entidade;
/**
 * @author WENES
 */
public class Remedio extends Produto { 
    
    public final String REMEDIO = "remedio";
    
    @Override
    public float gerarPrecoDeVenda() { 
        return (this.getPrecoDeCompra() + this.getPrecoDeCompra() * (this.getPercentualDeLucro() / 100));
    }
}











    /*    
    public void definirPercentualDeLucro() {
        super.setPercentualDeLucro(Float.parseFloat(JOptionPane.showInputDialog
        ("Digite o percentual de lucro do produto")));
    }*/