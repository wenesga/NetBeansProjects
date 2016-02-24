package projeto_revisao;
/**
 * @author WENES
 */
public abstract class Pessoa {

    private String nome;
    private String cpf;
    private String cidade;
    private int idade;

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
        if ("00000000000".equals(cpf) || "11111111111".equals(cpf)) {
            System.out.println("Erro no CPF");
        }
  
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String ImprimeDados(){
        String mensagem = "Nome: " + getNome() + "CPF: " + getCpf() + "Cidade: " + getCidade() 
                + "Idade: " + getIdade();
        return mensagem;
    }
}
