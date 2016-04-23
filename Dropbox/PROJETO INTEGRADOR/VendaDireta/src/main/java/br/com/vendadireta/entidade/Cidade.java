package br.com.vendadireta.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 03/04/2016 - Classe: Cidade
 */
@Entity
public class Cidade extends GenericEntidade {

    @Column(length = 50, nullable = false, name = "Nome_Cidade")
    private String nome;

    @ManyToOne
    @JoinColumn(nullable = false, name = "Código_Estado")
    private Estado estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}