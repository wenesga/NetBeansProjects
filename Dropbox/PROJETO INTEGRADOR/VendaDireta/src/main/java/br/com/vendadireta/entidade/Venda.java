package br.com.vendadireta.entidade;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 25/04/2016 - Classe: Venda
 */
@Entity
public class Venda extends GenericEntidade {

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal valorTotal;

    @ManyToOne
    private Cliente cliente;

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
