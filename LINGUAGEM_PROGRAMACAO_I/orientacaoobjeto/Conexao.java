package orientacaoobjeto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/aulajava";
    private static final String USUARIO = "root";
    private static final String SENHA = "070900";
    
    private Connection connect;
    private PreparedStatement adiciona;
    
    public Conexao(){
        try {
            connect = DriverManager.getConnection(URL,USUARIO, SENHA);
            adiciona = connect.prepareStatement("INSERT INTO funcionario" 
                    + "(nome, endereco, idade, cargo, salario)"
                    + "VALUES (?,?,?,?,?)");
            
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
    
    public int addFuncionario(Funcionario f) {
            int result = 0;
            
            try {
                adiciona.setString(1, f.getNome());
                adiciona.setString(2, f.getEndereco());
                adiciona.setInt(3, f.getIdade());
                adiciona.setString(4, f.getCargo());
                adiciona.setDouble(5, f.getSalario());
                
                result = adiciona.executeUpdate();
                
            }catch (Exception e) {
                System.err.println(e);
                System.exit(1);
            } 
        return result;
    }
}
