package projeto_revisao;
/**
 * @author WENESkk
 */
public class Teste {
    
    public static void main(String[] args) {
        
        Aluno aluno = new Aluno();
        Professor professor = new Professor();
        
        aluno.setNome("Wenes, ");
        aluno.setMatricula("20151010131, ");
        aluno.setTurma("3º periodo, ");
        aluno.setCpf("888888888, ");
        aluno.setCidade("Arraias, ");
        aluno.setIdade(3 );
        
        System.out.println(aluno.ImprimeDados());
        
        professor.setNome("Claudio, ");
        professor.setMatricula("20151010131, ");
        professor.setCpf("00000000000, ");
        professor.setCidade("Campos Belos, ");
        professor.setIdade(3);

        System.out.println(professor.ImprimeDados()); 
    }
}
