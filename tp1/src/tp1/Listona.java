package tp1;

public class Listona implements java.io.Serializable{
    //declara e instancializa as listas
    Filme F = new Filme();
    Artista Art = new Artista();
    Diretor D = new Diretor();
    Cinéfilo C = new Cinéfilo();
    Administrador Adm = new Administrador();

    public void init_listas(){
        F.init_lista_filmes();
        Art.init_lista_artista();
        D.init_lista_diretor();
        C.init_lista_cinéfilo();
        Adm.init_lista_administrador();
    }
}
