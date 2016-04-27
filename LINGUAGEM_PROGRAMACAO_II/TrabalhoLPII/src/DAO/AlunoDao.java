package DAO;
import ENTIDADE.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    

    public int InserirAluno(Aluno aluno) {
        int result = 0;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Insert into aluno");
            sb.append("matricula, nome, idade");
            sb.append("?,?,?");
            Connection conn = c.getConn();
            PreparedStatement comando = c.getConn().prepareStatement(sb.toString());
            comando.setString(1, aluno.getMatricula());
            comando.setString(2, aluno.getNome());
            comando.setInt(3, aluno.getIdade());
            result = comando.executeUpdate();
        } catch (SQLException ex) {

        }
        return result;
    }

    
    public int ExcluirAluno(String matricula) {

        int result = 0;

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Delete from aluno");
            sb.append("where matricula = ?");
            Connection conn = c.getConn();
            PreparedStatement comando = c.getConn().prepareStatement(sb.toString());
            comando.setString(1, matricula);
            result = comando.executeUpdate();
        } catch (SQLException ex) {

        }
        return result;
    }

    
    public int AtualizarAluno(Aluno aluno) {
        int result = 0;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE aluno ");
            sb.append("set nome = ?,  Set idade = ?");
            Connection conn = c.getConn();
            PreparedStatement comando = c.getConn().prepareStatement(sb.toString());
            comando.setString(1, aluno.getNome());
            comando.setInt(2, aluno.getIdade());
            comando.setString(3, aluno.getMatricula());
            result = comando.executeUpdate();
        } catch (SQLException ex) {

        }
        return result;
    }
}
