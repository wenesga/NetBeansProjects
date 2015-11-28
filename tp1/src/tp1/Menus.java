package tp1;
import java.util.Scanner;

public class Menus {
    Scanner S = new Scanner(System.in);
    Lista Lista = new Lista();
    Menus menu;
    Usuário U = new Usuário();
    Cinéfilo C = new Cinéfilo();
    Administrador Adm = new Administrador();
    Diretor D = new Diretor();
    Artista Art = new Artista();
    Filme F = new Filme();
    
    public void menu_principal(Object[] Lista_filmes, Object[] Lista_cinéfilo, Object[] Lista_administrador, Object[] Lista_diretores, Object[] Lista_artistas, Menus menu){
        int n;
        System.out.println("O que deseja fazer?\n1- Login\n2- Cadastrar\n3- Sair e salvar alterações");
        n = S.nextInt();
        switch(n){
            case 1: String login,senha;
                    System.out.println("Login:");
                    login = S.next();
                    System.out.println("Senha:");
                    senha = S.next();
                    if(U.procurar_usuário_login_senha(Lista_cinéfilo, Lista_administrador, login, senha)==1){
                        menu_cinéfilo(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, C.procurar_cinéfilo(Lista_cinéfilo, login, senha), menu);
                    }
                    else if(U.procurar_usuário_login_senha(Lista_cinéfilo, Lista_administrador, login, senha)==2){
                        menu_administrador(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Adm.procurar_administrador(Lista_administrador, login, senha), menu);
                    }
                    else System.out.println("Login ou senha inválidos");
                        menu_principal(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, menu);
                break;
            case 2: System.out.println("Deseja cadastrar cinéfilo ou administrador?\n1-Cinéfilo\n2-Administrador\n3-Voltar ao menu principal");
                    int c;
                    c = S.nextInt();
                    if(c==1){
                        C.cadastrar_cinéfilo(Lista_cinéfilo, Lista_administrador);
                    }
                    if(c==2){
                        Adm.cadastrar_administrador(Lista_cinéfilo, Lista_administrador);
                    }
                    menu_principal(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, menu);
                break;
            case 3: 
                break;
        }
    }
    public void menu_cinéfilo(Object[] Lista_filmes, Object[] Lista_cinéfilo, Object[] Lista_administrador, Object[] Lista_diretores, Object[] Lista_artistas, Cinéfilo Cinéf, Menus menu){
        int n;
        System.out.println("O que deseja fazer?\n1- Adicionar filme na lista de preferidos\n2- Adicionar filmes na lista pendentes de assistir"
                + "\n3- Remover filme da lista de preferidos\n4- Remover filme da lista de pendentes\n5- Listar filmes preferidos\n6- Listar filmes pendentes"
                + "\n7- Procurar filme no sistema\n8- Listar filmes de um diretor\n9- Sair");
        n = S.nextInt();
        switch(n){
            case 1: Cinéf.setLista_filmes_preferidos(Cinéf.cadastrar_filme_cinéfilo(Lista_filmes, C.getLista_filmes_preferidos()));
                    menu_cinéfilo(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Cinéf, menu);
                break;
            case 2: Cinéf.setLista_filmes_assistir(Cinéf.cadastrar_filme_cinéfilo(Lista_filmes, C.getLista_filmes_assistir()));
                    menu_cinéfilo(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Cinéf, menu);
                break;
            case 3: Cinéf.setLista_filmes_preferidos(Cinéf.excluir_filme_cinéfilo(Cinéf.getLista_filmes_preferidos()));
                    menu_cinéfilo(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Cinéf, menu);
                break;
            case 4: Cinéf.setLista_filmes_assistir(Cinéf.excluir_filme_cinéfilo(Cinéf.getLista_filmes_assistir()));
                    menu_cinéfilo(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Cinéf, menu);
                break;
            case 5: Cinéf.listar_filmes_cinéfilo(Cinéf.getLista_filmes_preferidos());
                    menu_cinéfilo(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Cinéf, menu);
                break;
            case 6: Cinéf.listar_filmes_cinéfilo(Cinéf.getLista_filmes_assistir());
                    menu_cinéfilo(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Cinéf, menu);
                break;
            case 7: F.listar_filmes(Lista_filmes);
                    menu_cinéfilo(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Cinéf, menu);
                break;
            case 8: System.out.println("Digite o nome do diretor:");
                    String Nome_diretor = S.next();
                    D.listar_filmes_pessoa(Lista_diretores, Nome_diretor);
                break;
            case 9: menu_principal(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, menu);
                break;
        }
        
    }
    public void menu_administrador(Object[] Lista_filmes, Object[] Lista_cinéfilo, Object[] Lista_administrador, Object[] Lista_diretores, Object[] Lista_artistas, Administrador Admin, Menus menu){
        int n;
        System.out.println("O que deseja fazer?\n1- Adicionar Filme\n2- Adicionar Artistas\n3- Adicionar Diretores\n4- Remover Filme\n5- Remover Artista\n6- Remover Diretor"
                + "\n7- Listar filmes cadastrados\n8- Sair");
        String Nome_pessoa, Nome_filme;
        n = S.nextInt();
        switch(n){
            case 1: F.cadastrar_filme(Lista_filmes, Lista_diretores, Lista_artistas);
                    menu_administrador(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Admin, menu);
                break;
            case 2: Art.cadastrar_artista(Lista_artistas);
                    menu_administrador(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Admin, menu);
                break;
            case 3: D.cadastrar_diretor(Lista_diretores);
                    menu_administrador(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Admin, menu);
                break;
            case 4: System.out.println("Digite o nome do filme");
                    Nome_filme = S.next();
                    F.excluir_filme(Lista_filmes, Lista_artistas, Lista_diretores, Nome_filme);
                    menu_administrador(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Admin, menu);
                break;
            case 5: System.out.println("Digite o nome da pessoa");
                    Nome_pessoa = S.next();
                    Art.excluir_pessoa(Lista_filmes, Lista_diretores, Lista_artistas, Nome_pessoa, 1);
                    menu_administrador(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Admin, menu);
                break;
            case 6:System.out.println("Digite o nome da pessoa");
                    Nome_pessoa = S.next();
                    Art.excluir_pessoa(Lista_filmes, Lista_diretores, Lista_artistas, Nome_pessoa, 0);
                    menu_administrador(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Admin, menu);
                break;
            case 7: F.listar_filmes(Lista_filmes);
                    menu_administrador(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, Admin, menu);
                break;
            case 8: menu_principal(Lista_filmes, Lista_cinéfilo, Lista_administrador, Lista_diretores, Lista_artistas, menu);
                break;
        }
        }
     
    
}
