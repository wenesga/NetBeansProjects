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

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 14, nullable = false)
    private String cpf;

//    @Column(length = 12, nullable = false)
//    private String rg;

    @Column(length = 14, nullable = false)
    private String telefone;

    @Column(length = 100, nullable = false)
    private String endereco;

//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private Estado estado;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cidade cidade;

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

//    public String getRg() {
//        return rg;
//    }
//
//    public void setRg(String rg) {
//        this.rg = rg;
//    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

//    public Estado getEstado() {
//        return estado;
//    }
//
//    public void setEstado(Estado estado) {
//        this.estado = estado;
//    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    } 
}
