package br.com.vendadireta.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @Cometario: Produtos pedidos
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 03/04/2016 - Classe: ProdutoPedido
 */
@Entity
public class ProdutoPedido extends GenericEntidade {

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Pedito")
    private Pedido pedido;

    @Column(length = 11, nullable = false, name = "Quantidade_Produto")
    private int quantidade_produto;
}
