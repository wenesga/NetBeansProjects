package tp1;

public class Artista extends Pessoa{
    Artista A;
    public void init_lista_artista(){
        //inicia a lista de artistas
        Lista.init_lista(A);
    }
    //cadastra artista
    public void cadastrar_artista(Object[] Lista1)
    {
        Lista.L=Lista1;
        Artista A = new Artista();
        
        System.out.println("Digite o nome do artista:");
        A.setNome(S.next());
        
        System.out.println("Digite a data de nascimento:");
        Data D = new Data();
        D.setData(D);
        A.setNascimento(D);
        
        System.out.println("Digite a cidade:");
        A.setCidade(S.next());
        
        System.out.println("Digite a nacionalidade:");
        A.setNacionalidade(S.next());

        System.out.println("Digite a biografia:");
        A.setBiografia(S.next());
        
        Lista.insere_elemento(A);
        //muda a referencia da lista
        Lista1=Lista.L;
    }  
}
