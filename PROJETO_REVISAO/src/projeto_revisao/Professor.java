package projeto_revisao;
/**
 * @author WENES
 */
public class Professor extends Pessoa{
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    @Override
    public String ImprimeDados(){
        String mensagem = super.ImprimeDados() + "Matricula: " + getMatricula()  ;
        return mensagem;
    }
}
