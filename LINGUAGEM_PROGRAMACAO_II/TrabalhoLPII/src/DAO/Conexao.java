package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 29/03/2016 - Classe: ConnectionDao
 */
public class Conexao {

    private Connection conn;
    private String URL = "jdbc:mysql://localhost:3306/banco_aluno";
    private String SENHA = "";
    private String USUARIO = "root";
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private Statement statement;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ResultSetMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(ResultSetMetaData metaData) {
        this.metaData = metaData;
    }

    public Conexao() {
        try {
            this.conn = DriverManager.getConnection(this.URL, this.USUARIO, this.SENHA);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
//    public int Inserir(String sql) throws Exception, IllegalAccessException {
//        
//        if (this.conn.isClosed()) {
//            throw new IllegalStateException("Conexão com banco está fechada");
//        }
//        try{
//            this.statement = this.conn.createStatement();
//            this.statement.executeUpdate(sql, columnNames);
//        
//        }catch(Exception ex){
//            
//        }
//    }
    
    

    public DefaultTableModel ConfiguraConsulata(String consulta)
            throws SQLException, IllegalStateException {

        if (this.conn.isClosed()) {
            throw new IllegalStateException("Conexão com banco está fechada");
        }

        Vector<String> nomeColunas = new Vector<String>();
        Vector<Vector<Object>> linhas = new Vector<Vector<Object>>();

        try {
            this.statement = this.conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            this.resultSet = this.statement.executeQuery(consulta);

            this.metaData = resultSet.getMetaData();

            int numeroColunas = metaData.getColumnCount();

            for (int indiceColuna = 1; indiceColuna <= numeroColunas; indiceColuna++) {
                nomeColunas.add(metaData.getColumnName(indiceColuna));
            }

            while (resultSet.next()) {

                Vector<Object> vetor = new Vector<Object>();

                for (int indiceColuna = 1; indiceColuna <= numeroColunas; indiceColuna++) {
                    vetor.add(resultSet.getObject(indiceColuna));
                }
                linhas.add(vetor);
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        DefaultTableModel dtm = new DefaultTableModel(linhas, nomeColunas);

        return dtm;
    }

    public void FecharConexao() {

        try {
            if (!this.conn.isClosed()) {

                this.conn.close();
                this.statement.close();
                this.resultSet.close();

            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }
}
