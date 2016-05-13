package atividade;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Optional;

public class UsuarioDAO extends DAO implements IDAO
{
    private Usuario usuario;
    
    public UsuarioDAO()
    {
        super();
    }
    
    @Override
    public Usuario getUsuario(String id) 
    {
        try
        {
            instrucao = conexao.prepareStatement(
            "SELECT * FROM usuarios WHERE ID = " + id );
            resultado = instrucao.executeQuery();
            
            if( resultado.next() ) // tem resultado?
            {
                usuario = new Usuario(
                        resultado.getInt( "id" ),
                        resultado.getString( "nome" ),
                        resultado.getString( "email" ),
                        resultado.getString( "senha" ) 
                );                
                return usuario;
            }            
        }
        catch( SQLException sql )
        {
              JOptionPane.showMessageDialog(null,"Usuário não encontrado!");
        }        
        return null;
    }

    @Override
    public void inserirUsuario( Usuario usuario ) 
    {
        try
        {
            instrucao = conexao.prepareStatement("INSERT INTO usuarios VALUES(null,?,?,?)");
            instrucao.setNString( 1, usuario.getNome() );
            instrucao.setNString( 2, usuario.getEmail() );
            instrucao.setNString( 3, usuario.getSenha() );
            instrucao.executeUpdate(); 
            JOptionPane.showMessageDialog(null,"Usuário inserido com sucesso!");
        }
        catch( SQLException e )
        {
            System.err.println("Não foi possível inserir novo usuário!");
        }
    }

    @Override
    public void atualizarUsuario(Usuario usuario) 
    {
        try
        {
            instrucao = conexao.prepareStatement(
            "UPDATE usuarios SET nome = ?, email = ?, senha = ? "
                    + "WHERE id = " + usuario.getId());
            instrucao.setNString( 1, usuario.getNome() );
            instrucao.setNString( 2, usuario.getEmail() );
            instrucao.setNString( 3, usuario.getSenha() );
            instrucao.executeUpdate(); 
            JOptionPane.showMessageDialog(null,"Informações alteradas com sucesso ");
        }
        catch( SQLException e )
        {
            System.err.println("Não foi possível atualizar o usuário!");
        }
    }

    @Override
    public void deletarUsuario(Usuario usuario) 
    {
        try
        {
            instrucao = conexao.prepareStatement(
            "DELETE FROM usuarios WHERE nome = " + usuario.getNome() + "id = " + usuario.getId());            
            instrucao.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuário excluído com sucesso ");
        }
        catch( SQLException e )
        {
            System.err.println("Não foi possível excluir o usuário!");
        }
    }  
    
    public void selecionarTodos(Usuario usuario)
    {
         try
        {
            instrucao = conexao.prepareStatement("SELECT * FROM usuarios");
            resultado = instrucao.executeQuery();
            
            if( resultado.next()) 
            {
                usuario = new Usuario(
                        resultado.getInt( "id" ),
                        resultado.getString( "nome" ),
                        resultado.getString( "email" ),
                        resultado.getString( "senha" ) 
                );                
            }            
        }
        catch( SQLException sql )
        {
              JOptionPane.showMessageDialog(null,"Falha na conexão!");
        }        
    }
}