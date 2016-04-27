package br.com.vendadireta.dao;
import br.com.vendadireta.entidade.Cliente;
import br.com.vendadireta.util.HibernateUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 10/04/2016 - Classe: ClienteDAO
 */
public class ClienteDAO extends GenericDAO<Cliente> {

    public Cliente autenticar(String cpf, String senha){
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        
        try{
            Criteria consulta = sessao.createCriteria(Cliente.class);
            
            consulta.add(Restrictions.eq("cpf", cpf));
            
            SimpleHash hash =new SimpleHash("md5", senha);
            consulta.add(Restrictions.eq("senha", hash.toHex()));
            
            Cliente resultado = (Cliente) consulta.uniqueResult();
            
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
