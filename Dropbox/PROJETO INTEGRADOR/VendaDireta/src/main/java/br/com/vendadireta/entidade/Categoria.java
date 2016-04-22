package br.com.vendadireta.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 02/04/2016 - Classe: Categoria
 */
@Entity
public class Categoria extends GenericEntidade {

    @Column(length = 50, nullable = false, name = "Nome_Categoria")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
