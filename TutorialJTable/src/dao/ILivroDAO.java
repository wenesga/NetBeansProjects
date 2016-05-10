package dao;

import entity.Livro;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 31/03/13
 * Time: 01:00
 * http://www.mballem.com/
 */
public interface ILivroDAO {

    int save(Livro livro);

    int update(Livro livro);

    int remove(Long id);

    List<Livro> findAll();
}
