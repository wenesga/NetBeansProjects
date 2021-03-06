package Dao;

import Entidade.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 29/03/2016 - Classe: AlunoDAO
 */
public class AlunoDAO {

    private static final String INSERT = "insert into ALUNOS (NOME, IDADE, MATRICULA) values (?,?,?)";
    private static final String UPDATE = "update ALUNOS set NOME = ?, IDADE = ?, MATRICULA = ? where ID = ?";
    private static final String REMOVE = "delete from ALUNOS where ID = ?";
    private static final String SELECT = "select * from ALUNOS";

    public int salvar(Aluno aluno) {
        Connection conn = Conexao.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(INSERT);
            pstm.setString(1, aluno.getNome());
            pstm.setInt(2, aluno.getIdade());
            pstm.setString(3, aluno.getMatricula());
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                Conexao.fecharConexao(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    public int atualizar(Aluno aluno) {
        Connection conn = Conexao.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, aluno.getNome());
            pstm.setInt(2, aluno.getIdade());
            pstm.setString(3, aluno.getMatricula());
            pstm.setLong(4, aluno.getId());
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                Conexao.fecharConexao(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    public int excluir(Long id) {
        Connection conn = Conexao.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(REMOVE);
            pstm.setLong(1, id);
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                Conexao.fecharConexao(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    public List<Aluno> listar() {
        Connection conn = Conexao.getConnection();
        PreparedStatement pstm = null;
        List<Aluno> alunos = new ArrayList<Aluno>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(SELECT);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getLong("ID"));
                aluno.setNome(rs.getString("NOME"));
                aluno.setIdade(rs.getInt("IDADE"));
                aluno.setMatricula(rs.getString("MATRICULA"));

                alunos.add(aluno);
            }
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                Conexao.fecharConexao(conn, pstm, rs);
            }
            e.printStackTrace();
        }
        return alunos;
    }
}
