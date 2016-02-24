package projeto_revisao;
/**
 * @author WENES
 */
public class Aluno extends Pessoa{
    private String matricula;
    private String turma;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    @Override
    public String ImprimeDados(){
        String mensagem = super.ImprimeDados() + "Matricula: " + getMatricula() + "Turma: " + getTurma() ;
        return mensagem;
    }
}
