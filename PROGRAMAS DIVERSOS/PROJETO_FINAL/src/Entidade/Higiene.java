package Entidade;
/**
 * @author WENES GOMES
 */
public class Higiene extends Produto {
    
    public final String HIGIENE = "higiene";
    @Override
    public float gerarPrecoDeVenda() { 
        return (super.getPrecoDeCompra() + super.getPrecoDeCompra() * (super.getPercentualDeLucro() / 100));
    }
}