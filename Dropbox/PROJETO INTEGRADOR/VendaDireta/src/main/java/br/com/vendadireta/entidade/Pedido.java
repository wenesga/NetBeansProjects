package br.com.vendadireta.entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 02/04/2016 - Classe: Pedido
 */
@Entity
public class Pedido extends GenericEntidade {

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Forma_Pagamento")
    private FormaPagamento forma_de_agamento;

    @Column(nullable = false, name = "Data_do_Pedito")
    @Temporal(TemporalType.DATE)
    private Date data_pedido;

    @Column(nullable = false, name = "Prazo_de_Pagamento")
    @Temporal(TemporalType.DATE)
    private Date prazo_de_pagamento;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPagamento getFormaPagamento() {
        return forma_de_agamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.forma_de_agamento = formaPagamento;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Date getPrazo_pagamento() {
        return prazo_de_pagamento;
    }

    public void setPrazo_pagamento(Date prazo_pagamento) {
        this.prazo_de_pagamento = prazo_pagamento;
    }

}
