package Farmacia;

public class Higiene extends Produto {

    public float gerarPrecoDeVenda(){ 
        return (super.getPrecoDeCompra() + super.getPrecoDeCompra() * 30/100);
    }

    public void definirPercentualDeLucro() {
        super.setPercentualDeLucro(30);
    }
}

