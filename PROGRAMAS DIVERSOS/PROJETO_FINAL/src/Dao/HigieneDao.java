package Dao;
import Entidade.Higiene;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.*; //teste
/**
 * @author WENES
 */
public class HigieneDao extends Conexao{
    private PreparedStatement adiciona;
    
    private Higiene higiene;

    public Higiene getHigiene() {
        return higiene;
    }

    public void setHigiene(Higiene higiene) {
        this.higiene = higiene;
    }

    @Override
    public int inserir() {
        int result = 0;

        try {

            adiciona = getConnect().prepareStatement("INSERT INTO produtos" 
                + "(descricao, precodecompra, percentualdelucro, categoria, precodevenda)"
                + "VALUES (?,?,?,?,?)");

            adiciona.setString(1, this.getHigiene().getDescricao());
            adiciona.setFloat(2, this.getHigiene().getPrecoDeCompra());
            adiciona.setFloat(3, this.getHigiene().getPercentualDeLucro());
            adiciona.setString(4, this.getHigiene().HIGIENE);
            adiciona.setDouble(5, this.getHigiene().gerarPrecoDeVenda());

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
    
    public ResultSet consultaHigiene(){
    try {
               
        adiciona = getConnect().prepareStatement("select codigo,descricao,precodecompra,"
                + "percentualdelucro,precodevenda from produtos where categoria='higiene'");        
        return adiciona.executeQuery();
               
    }catch (Exception e){
        System.err.println(e);
        System.exit(1);
    } 
    return null;
    }
}
