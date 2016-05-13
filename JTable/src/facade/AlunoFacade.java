package facade;

import dao.AlunoDAO;
import entidade.Aluno;

import java.util.List;

public class AlunoFacade {

    private AlunoDAO dao;

    public AlunoFacade() {
        this.dao = new AlunoDAO();
    }

    public int save(Aluno aluno) {
        return dao.save(aluno);
    }

    public int update(Aluno aluno) {
        return dao.update(aluno);
    }

    public int remove(Long id) {
        return dao.remove(id);
    }

    public List<Aluno> findAll() {
        return dao.findAll();
    }
}
