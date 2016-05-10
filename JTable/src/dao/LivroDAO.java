package dao;

import entity.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 31/03/13
 * Time: 01:01
 * http://www.mballem.com/
 */
public class LivroDAO implements ILivroDAO {

    private static final String SQL_INSERT =
            "insert into LIVROS (EDITORA, TITULO, ISBN) values (?,?,?)";

    private static final String SQL_UPDATE =
            "update LIVROS set EDITORA = ?, TITULO = ?, ISBN = ? where ID = ?";

    private static final String SQL_REMOVE =
            "delete from LIVROS where ID = ?";

    private static final String SQL_FIND_ALL =
            "select * from LIVROS";


    public int save(Livro livro) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
            pstm.setString(1, livro.getEditora());
            pstm.setString(2, livro.getTitulo());
            pstm.setString(3, livro.getIsbn());
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }  finally {
                DBConnection.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    public int update(Livro livro) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, livro.getEditora());
            pstm.setString(2, livro.getTitulo());
            pstm.setString(3, livro.getIsbn());
            pstm.setLong(4, livro.getId());
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }  finally {
                DBConnection.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    public int remove(Long id) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_REMOVE);
            pstm.setLong(1, id);
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }  finally {
                DBConnection.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    public List<Livro> findAll() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Livro> livros = new ArrayList<Livro>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(SQL_FIND_ALL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getLong("ID"));
                livro.setEditora(rs.getString("EDITORA"));
                livro.setTitulo(rs.getString("TITULO"));
                livro.setIsbn(rs.getString("ISBN"));

                livros.add(livro);
            }
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }  finally {
                DBConnection.close(conn, pstm, rs);
            }
            e.printStackTrace();
        }
        return livros;
    }
}

