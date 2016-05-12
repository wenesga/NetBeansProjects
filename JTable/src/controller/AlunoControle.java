package controller;

import entidade.Aluno;
import facade.AlunoFacade;

import java.util.List;

public class AlunoControle {

    private AlunoFacade facade;

    public AlunoControle() {
        this.facade = new AlunoFacade();
    }

    public int addAluno(Aluno aluno) {
        return facade.save(aluno);
    }

    public int alterarAluno(Aluno aluno) {
        return facade.update(aluno);
    }

    public int excluirAluno(Long id) {
        return facade.remove(id);
    }

    public List<Aluno> findAlunos() {
        return facade.findAll();
    }
}
