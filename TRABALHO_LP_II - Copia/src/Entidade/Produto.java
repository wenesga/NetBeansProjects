package Entidade;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 29/03/2016 - Classe: Aluno
 */
public class Produto {

    private Long id;
    private String nome;
    private int estoqueMinimo;
    private String decricacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getDecricacao() {
        return decricacao;
    }

    public void setDecricacao(String decricacao) {
        this.decricacao = decricacao;
    }
}
