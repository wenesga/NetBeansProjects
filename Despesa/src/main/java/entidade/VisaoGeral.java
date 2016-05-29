package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 28/05/2016 - Classe: VisaoGeral
 */
@Entity
public class VisaoGeral extends GenericEntidade{

    
    @Column(nullable = false, precision = 2, scale = 6)
    private double receitaTotal;
    
    
    @Column(nullable = false, precision = 2, scale = 6)
    private double despesaTotal;
    
    @Column(nullable = false, precision = 2, scale = 6)
    private double saldo;

    
    
    public double getReceitaTotal() {
        return receitaTotal;
    }

    public void setReceitaTotal(double receitaTotal) {
        this.receitaTotal = receitaTotal;
    }

    public double getDespesaTotal() {
        return despesaTotal;
    }

    public void setDespesaTotal(double despesaTotal) {
        this.despesaTotal = despesaTotal;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
