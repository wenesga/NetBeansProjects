package tp1;

public class Cinéfilo extends Usuário{
    Cinéfilo C;
    public void init_lista_cinéfilo(){
        //inicia a lista de cinéfilos
        Lista.init_lista(C);
    }
    
    String Lista_filmes_preferidos[], Lista_filmes_assistir[];   

    public String[] getLista_filmes_preferidos() {
        return Lista_filmes_preferidos;
    }

    public void setLista_filmes_preferidos(String[] Lista_filmes_preferidos) {
        this.Lista_filmes_preferidos = Lista_filmes_preferidos;
    }

    public String[] getLista_filmes_assistir() {
        return Lista_filmes_assistir;
    }

    public void setLista_filmes_assistir(String[] Lista_filmes_assistir) {
        this.Lista_filmes_assistir = Lista_filmes_assistir;
    }
    
    
    public void listar_filmes_cinéfilo(Object[] Lista_filmes){
        System.out.println("Filmes em sua lista:");
        int i=0;
        Lista.L = Lista_filmes;
        //Temporaria
        Filme F = (Filme)Lista.retorna_elemento(0);
        //percorre a lista de filmes exibindo seus nomes
        while((F!=null)&&(i<Lista.L.length)){
            F=(Filme)Lista.retorna_elemento(i);
            System.out.println("\n"+F.getNome());
            i++;
        }
    }
    
    public String[] cadastrar_filme_cinéfilo(Object[] Lista_filmes_global, String[] Lista_filmes_cinéfilo){
        System.out.println("Filmes disponíveis:");
        int i=0;
        Lista.L = Lista_filmes_cinéfilo;
        //Temporaria
        Filme F =new Filme();
        System.out.println("Deseja adicionar algum filme?'s' para sim");
        if("s".equals(S.next())){
            //exibe a lista de todos os filmes cadastrados
            F.listar_filmes(Lista_filmes_global);
            String Nome_filme;
            System.out.println("Digite o nome do filme");
            Nome_filme = S.next();
            //muda a lista de filmes GLOBAL para a lista de filme do CINÉFILO
            //verifica se o nome do filme está na lista GLOBAL
            if(F.procurar_filme(Lista_filmes_global, Nome_filme)!=null){
                //agora, percorre a lista de filmes do cinéfilo para ver se tem algum com o nome inserido
                //temporaria para comparar os nomes
                i=0;
                String Temp = (String)Lista.retorna_elemento(0);
                while((Temp!=null)&&(i<Lista.L.length)){
                    Temp=(String)Lista.retorna_elemento(i);
                    if(Nome_filme.equals(Temp)){
                        i=Lista.L.length+1;
                    }
                    else i++;
                }
                if(i==Lista.L.length+1){
                        System.out.println("Filme já cadastrado na lista do cinéfilo");
                }
                else {
                    //caso não esteja cadastrado na lista do cinéfilo, insere o filme na lista dele
                    Lista.insere_elemento(Temp);
                    //muda a referencia
                    Lista_filmes_cinéfilo=(String[])Lista.L;
                    System.out.println("Filme cadastrado com sucesso");
                    return Lista_filmes_cinéfilo;
                }
            }
        }
        else System.out.println("Filme não encontrado na lista de filmes do sistema");
        
        System.out.println("Deseja adicionar outro filme? 's' para sim");
        if("s".equals(S.next())){
            cadastrar_filme_cinéfilo(Lista_filmes_global, Lista_filmes_cinéfilo);
        }
        return Lista_filmes_cinéfilo;
    }
    
    public String[] excluir_filme_cinéfilo(String[] Lista_filmes){
        Lista.L = Lista_filmes;
        //Temporaria
        //exibe os filmes da lista
        System.out.println("Filmes em sua lista:");
        listar_filmes_cinéfilo(Lista_filmes);
        String ch = "s";
        
        System.out.println("Deseja excluir algum filme? 's' para sim");
        ch = S.next();
        while(ch.equals("s")){
            int i=0;
            String Nome_filme;
            System.out.println("Digite o nome do filme");
            Nome_filme=S.next();
            Filme F = (Filme)Lista.retorna_elemento(0);
            //percorre a lista de filmes para ver se tem algum com o nome inserido
            while((F!=null)&&(i<Lista.L.length)){
                F=(Filme)Lista.retorna_elemento(i);
                if(Nome_filme.equals(F.getNome())){
                    //caso tenha, exclui o filme na lista
                    Lista.excluir_elemento(i);
                    //muda a referencia
                    Lista_filmes =(String[]) Lista.L;
                    i=Lista.L.length+1;
                }
                else i++;
            }
            if(i==Lista.L.length+1){
                System.out.println("Filme removido com sucesso");
                return Lista_filmes;
            }
            else System.out.println("Nenhum filme encontrado");
            System.out.println("Deseja cadastrar outro filme? 's' para sim");
            ch=S.next();
        }
        return Lista_filmes;
    }
    
    void cadastrar_cinéfilo(Object[] Lista_cinéfilo, Object[] Lista_administrador){
        String login, senha;
        Cinéfilo C = new Cinéfilo();
        System.out.println("Digite o login do cinéfilo");
        login = S.next();
        if(C.procurar_usuário_login(Lista_cinéfilo,Lista_administrador,login)==null){
            System.out.println("Digite a senha");
            senha = S.next();
            C.setLogin(login);
            C.setSenha(senha);
            Lista.L=Lista_cinéfilo;
            Lista.insere_elemento(C);
            Lista_cinéfilo=Lista.L;
        }
    }
    
    public Cinéfilo procurar_cinéfilo(Object[] Lista_cinéfilo, String login, String senha){
        int i=0;
        //temporaria
        Lista.L = Lista_cinéfilo;
        Cinéfilo C = (Cinéfilo)Lista.retorna_elemento(0);
        //percorre a lista de filmes comparando com o nome_filme
        while((C!=null)&&(i<Lista.L.length)){
            C=(Cinéfilo)Lista.retorna_elemento(i);
            if((login.equals(C.getLogin()))&&(senha.equals(C.getSenha()))){
                return C;
            }
            else i++;
        }
        return null;
    } 
}
