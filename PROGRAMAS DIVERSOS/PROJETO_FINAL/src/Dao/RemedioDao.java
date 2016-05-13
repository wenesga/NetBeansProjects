package Dao;
import Entidade.Remedio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.*;
/**
 * @author WENES
 */
public class RemedioDao extends Conexao{
    private PreparedStatement adiciona;
    
    private Remedio remedio;

    public Remedio getRemedio() {
        return remedio;
    }
    
    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }
    
    @Override
    public int inserir() {
        int result = 0;

        try {
            
            String sql = "INSERT INTO produtos" 
                + "(descricao, precodecompra, percentualdelucro, categoria, precodevenda)"
                + "VALUES (?,?,?,?,?)";
            
            System.out.println(sql);
            
            adiciona = getConnect().prepareStatement(sql);

            adiciona.setString(1, this.getRemedio().getDescricao());
            adiciona.setFloat(2, this.getRemedio().getPrecoDeCompra());
            adiciona.setFloat(3, this.getRemedio().getPercentualDeLucro());
            adiciona.setString(4, this.getRemedio().REMEDIO);
            adiciona.setDouble(5, this.getRemedio().gerarPrecoDeVenda());

            result = adiciona.executeUpdate();

        }catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        } 
        return result;
    }

    @Override
    public int atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int excluir() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public ResultSet consultaRemedio(){
    try {
               
        adiciona = getConnect().prepareStatement("select codigo,descricao,precodecompra,"
                + "percentualdelucro,precodevenda from produtos where categoria='remedio'");        
        return adiciona.executeQuery();
               
    }catch (Exception e){
        System.err.println(e);
        System.exit(1);
    } 
    return null;
    }
}
