package br.com.vendadireta.entidade;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 02/04/2016 - Classe: Produto
 */
@Entity
public class Produto extends GenericEntidade {

    @Column(length = 100, nullable = false, name = "Decrição")
    private String decricao;

    @Column(nullable = false, precision = 6, scale = 2, name = "Valor_de_Compra")
    private BigDecimal valor_de_compra;

    @Column(nullable = false, precision = 6, scale = 2, name = "Valor_de_Venda")
    private BigDecimal valor_de_venda;

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Marca")
    private Marca marca;

    @Column(length = 4, nullable = false, name = "Estoque")
    private short estoque;

    @Column(length = 4, nullable = false, name = "Estoque_Minimo")
    private short estoque_minimo;

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Fornecedor")
    private Fornecedor fornecedor;
}
