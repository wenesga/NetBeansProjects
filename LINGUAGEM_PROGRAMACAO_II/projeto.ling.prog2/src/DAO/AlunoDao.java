package DAO;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 * @Cometario: Trabalho de Linguagem de Programação II
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 29/03/2016 - Classe: AlunoDao
 */
public class AlunoDao {

    Conexao c = new Conexao();

    public TableModel ListaAlunos() {

        DefaultTableModel tm = new DefaultTableModel();
        try {
            tm = c.ConfiguraConsulata("Select * from Aluno");

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {

            c.FecharConexao();
        }
        return tm;
    }
}
