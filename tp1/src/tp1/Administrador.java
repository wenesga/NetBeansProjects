package tp1;

public class Administrador extends Usuário{
    Administrador A;
    public void init_lista_administrador(){
        //inicia a lista de administradores
        Lista.init_lista(A);
    }
     void cadastrar_administrador(Object[] Lista_cinéfilo, Object[] Lista_administrador){
        String login, senha;
        Administrador A = new Administrador();
        System.out.println("Digite o login do administrador");
        login = S.next();
        if(A.procurar_usuário_login(Lista_cinéfilo,Lista_administrador,login)==null){
            System.out.println("Digite a senha");
            senha = S.next();
            A.setLogin(login);
            A.setSenha(senha);
            Lista.L=Lista_administrador;
            Lista.insere_elemento(A);
            Lista_administrador=Lista.L;
        }
    }
     
    public Administrador procurar_administrador(Object[] Lista_administrador, String login, String senha){
        int i=0;
        //temporaria
        Lista.L=Lista_administrador;
        Administrador A = (Administrador)Lista.retorna_elemento(0);
        //percorre a lista de filmes comparando com o nome_filme
        while((A!=null)&&(i<Lista.L.length)){
            if((login.equals(A.getLogin()))&&(senha.equals(A.getSenha()))){
                return A;
            }
            else {
                i++;
                A=(Administrador)Lista.retorna_elemento(i);
            }
        }
        return null;
    } 
}
