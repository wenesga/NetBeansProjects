package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author WENES
 */
public abstract class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/farmacia";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    private Connection connect;
    private PreparedStatement adiciona;
    protected ResultSet resultado;

    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public PreparedStatement getAdiciona() {
        return adiciona;
    }

    public void setAdiciona(PreparedStatement adiciona) {
        this.adiciona = adiciona;
    }
    
    public Conexao(){
        try {
          this.setConnect(DriverManager.getConnection(URL,USUARIO, SENHA));
            
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
    
    public Conexao(String url, String usuario, String senha ){
        try {          
            this.setConnect(DriverManager.getConnection(url,usuario, senha));
            
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    public void fecharConexao() {
            try {          
            this.getConnect().close();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
    
    public abstract int inserir();
    public abstract int atualizar();
    public abstract int excluir(); 
}
