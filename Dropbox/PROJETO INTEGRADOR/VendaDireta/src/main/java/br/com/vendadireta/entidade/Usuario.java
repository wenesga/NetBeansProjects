package br.com.vendadireta.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 02/04/2016 - Classe: Usuario
 */
@Entity
public class Usuario extends GenericEntidade {

    @Column(length = 50, nullable = false, name = "Usuário")
    private String nome;

    @Column(length = 11, name = "CPF")
    private String cpf;

    @Column(length = 50, nullable = false, name = "Senha")
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
