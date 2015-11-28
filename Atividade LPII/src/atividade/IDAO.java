package atividade;

public interface IDAO 
{
    public Usuario getUsuario( String id );
    public void inserirUsuario( Usuario usuario );
    public void atualizarUsuario( Usuario usuario );
    public void deletarUsuario( Usuario usuario );
}