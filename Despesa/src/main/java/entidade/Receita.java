package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Cometario:  
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date   28/05/2016 - Classe: Receita
 */
@Entity
public class Receita extends GenericEntidade{

    @Column(length = 100, nullable = false)
    private String nome;
    
    @Column(nullable = false, precision = 2, scale = 6)
    private double valor;

    
    
    
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
