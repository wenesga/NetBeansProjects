package br.com.vendadireta.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 02/04/2016 - Classe: Cliente
 */
@Entity
public class Cliente extends GenericEntidade {

    @Column(length = 100, nullable = false, name = "Nome_Cliente")
    private String nome;

    @Column(length = 11, nullable = false, name = "CPF")
    private String cpf;

    @Column(length = 15, nullable = false, name = "RG")
    private Long rg;

    @Column(length = 12, nullable = false, name = "Telefone")
    private String telefone;

    @Column(length = 100, nullable = false, name = "Endereço")
    private String endereco;

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Cidade")
    private Cidade cidade;

}
