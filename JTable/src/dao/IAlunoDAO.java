package dao;

import entidade.Aluno;

import java.util.List;

public interface IAlunoDAO {

    int save(Aluno aluno);

    int update(Aluno aluno);

    int remove(Long id);

    List<Aluno> findAll();
}
