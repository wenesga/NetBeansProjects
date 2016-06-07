package Dao;

import Entidade.Produto;
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

    private static final String INSERT = "insert into PRODUTO (NOME, ESTOQUE_MINIMO, DESCRICAO) values (?,?,?)";
    private static final String UPDATE = "update PRODUTO set NOME = ?, ESTOQUE_MINIMO = ?, DESCRICAO = ? where ID = ?";
    private static final String REMOVE = "delete from PRODUTO where ID = ?";
    private static final String SELECT = "select * from PRODUTO";

    public int salvar(Produto aluno) {
        Connection conn = Conexao.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(INSERT);
            pstm.setString(1, aluno.getNome());
            pstm.setInt(2, aluno.getEstoqueMinimo());
            pstm.setString(3, aluno.getDecricacao());
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

    public int atualizar(Produto aluno) {
        Connection conn = Conexao.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, aluno.getNome());
            pstm.setInt(2, aluno.getEstoqueMinimo());
            pstm.setString(3, aluno.getDecricacao());
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

    public List<Produto> listar() {
        Connection conn = Conexao.getConnection();
        PreparedStatement pstm = null;
        List<Produto> alunos = new ArrayList<Produto>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(SELECT);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Produto aluno = new Produto();
                aluno.setId(rs.getLong("ID"));
                aluno.setNome(rs.getString("NOME"));
                aluno.setEstoqueMinimo(rs.getInt("ESTOQUE_MINIMO"));
                aluno.setDecricacao(rs.getString("DESCRICAO"));

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
