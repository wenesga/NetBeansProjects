package br.com.vendadireta.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 12/04/2016 - Classe: Fornecedor
 */
@Entity
public class Fornecedor extends GenericEntidade {

    @Column(length = 100, nullable = false, name = "Nome_Fornecedor")
    private String nome;

    @Column(length = 100, nullable = false, name = "Tipo_Fornecedor")
    private String tipo;

    @Column(length = 100, nullable = false, name = "Endereço")
    private String endereco;

    @Column(length = 12, nullable = false, name = "Telefone")
    private String telefone;

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Cidade")
    private Cidade cidade;
}
