package tp1;
import java.util.Scanner;

public class Pessoa {
    protected String Nome,Cidade,Nacionalidade,Biografia;
    protected Data Nascimento;
    protected Scanner S = new Scanner(System.in);    
    protected String Lista_filmes[];
    //Parametros
    protected Lista Lista = new Lista();
    //

    public String getNome() {
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCidade() {
        return Cidade;
    }
    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getNacionalidade() {
        return Nacionalidade;
    }
    public void setNacionalidade(String Nacionalide) {
        this.Nacionalidade = Nacionalidade;
    }

    public String getBiografia() {
        return Biografia;
    }
    public void setBiografia(String Biografia) {
        this.Biografia = Biografia;
    }

    public String[] getLista_filmes() {
        return Lista_filmes;
    }

    public void setLista_filmes(String[] Lista_filmes) {
        this.Lista_filmes = Lista_filmes;
    }

    public Data getNascimento() {
        return Nascimento;
    }

    public void setNascimento(Data Nascimento) {
        this.Nascimento = Nascimento;
    }
    
    
    //insere o filme na lista do diretor/artista
    //recebe a lista de filmes da pessoa e o nome do filme a ser cadastrado
    public void cadastrar_filmes_pessoa(Object[] Lista1, String Nome_filme)
    {
        int i=0;
        Lista.L = Lista1;
        //temporaria para verificar se o filme já está inserido na lista de filmes da pessoa
        String Temp = (String)Lista.retorna_elemento(0);
        //verifica se o filme já está cadastrado
        while((Temp!=null)&&(i<Lista.L.length)){
            Temp=(String)Lista.retorna_elemento(i);
            if(Nome_filme.equals(Temp)){
                i=Lista.L.length+1;
            }
            else i++;
        }
        //se não estiver cadastrado, insere na lista de filmes da pessoa
        if(i!=Lista.L.length+1){
            Lista.insere_elemento(Nome_filme);
            //muda a referencia da lista
            Lista1=Lista.L;
        }
        else System.out.println("Filme já cadastrado na pessoa");
    }
    
    //exclui o filme da lista do diretor/artista
    public void excluir_filmes_pessoa(Object[] Lista1, String Nome_filme){
        int i=0;
        Lista.L = Lista1;
        //temporaria para verificar se o filme está inserido na lista de filmes da pessoa
        String Temp = (String)Lista.retorna_elemento(0);
        //verifica se o filme já está cadastrado
        while((Temp!=null)&&(i<Lista.L.length)){
            Temp=(String)Lista.retorna_elemento(i);
            if(Nome_filme.equals(Temp)){
                //se estiver cadastrado, exclui o filme da lista da pessoa
                Lista.excluir_elemento(i);
                i=Lista.L.length+1;
            }
            else i++;
        }
        //muda a referencia da lista
        Lista1=Lista.L;
    }
    
    public void listar_filmes_pessoa(Object[] Lista_diretores, String Nome_pessoa){
        int i=0;
        Lista.L = Lista_diretores;
        //pesquisa o nome do diretor
        Diretor D =(Diretor) Lista.retorna_elemento(0);
        while((D!=null)&&(i<Lista.L.length)){
            if(Nome_pessoa.equals(D.getNome())){
                i=0;
                Lista.L = D.getLista_filmes();
                String Nome_filme = (String)Lista.retorna_elemento(0);
                while((Nome_filme!=null)&&(i<Lista.L.length)){
                    System.out.println(Nome_filme+"\n");
                }
                Lista.L=Lista_diretores;
                i=Lista.L.length+1;
            }
            else System.out.println("Diretor não tem filmes cadastrados");
        }
    }
    
    public Pessoa procurar_pessoa(Object[] Lista1, String Nome_pessoa){
        int i=0;
        Lista.L = Lista1;
        //Temporaria
        Pessoa P = (Pessoa)Lista.retorna_elemento(0);
        //percorre a lista de filmes comparando com o nome_pessoa
        while((P!=null)&&(i<Lista.L.length)){
            P=(Pessoa)Lista.retorna_elemento(i);
            if(Nome_pessoa.equals(P.getNome())){
                i=Lista.L.length+1;
            }
            else i++;
        }
        //se encontrar a pessoa, retorna ela
        if(i!=Lista.L.length+1){
            return P;
        }
        //se não encontrar, retorna null
        else {
            return null;
        }
    }
    
    public void excluir_pessoa(Object[] Lista_filmes, Object[] Lista_diretores, Object[] Lista_artistas, String Nome_pessoa, int Artista_Diretor){
        int i=0,j=0;
        Object[] Lista2 = Lista_filmes;
        //verifica se a pessoa está cadastrada
        //caso em que a pessoa a ser excluida é artista (Artista_Diretor = 1)
        if(Artista_Diretor==1) Lista.L = Lista_artistas;
        else Lista.L = Lista_diretores;
        
        Pessoa P = (Pessoa)Lista.retorna_elemento(0);
        while((P!=null)&&(i<Lista.L.length)){
            if(Nome_pessoa.equals(P.getNome())){
                i=Lista.L.length+1;
            }
            else {
                i++;
                P=(Pessoa)Lista.retorna_elemento(i);
            }
        }
        
        //se encontrar a pessoa
        if(i==Lista.L.length+1){
            //percorre a lista de filmes da PESSOA e a lista de pessoas dos FILMES comparando os nome
            //retira a pessoa da lista dos filmes se ela estiver cadastrada na lista de algum filme
            if(P.getLista_filmes()!=null){
                String[] Listinha = P.getLista_filmes();
                String Nome_filme = Listinha[0];
                i=0;
                j=0;
                //verifica o nome de todos os filmes da pessoa
                while((Nome_filme!=null)&&(i<Listinha.length)){
                    //escolhe o nome do filme
                    Filme F = (Filme)Lista2[0];

                    while((F!=null)&&(j<Lista2.length)){
                        //escolhe o filme
                        if(Nome_filme.equals(F.getNome())){
                            //se achou o filme, exclui a pessoa da lista de pessoas do filme
                            //caso em que a pessoa a ser excluida é artista (Artista_Diretor = 1)
                            if(Artista_Diretor==1){
                                //muda a referencia da lista
                                Lista.L = F.getElenco();
                            }
                            else Lista.L = F.getDiretores();
                            int k=0;
                            Pessoa Pzinho =(Pessoa)Lista.retorna_elemento(0);
                            while((Pzinho!=null)&&(k<Lista.L.length)){
                                if(Nome_pessoa.equals(Pzinho.getNome())){
                                    Lista.excluir_elemento(k);
                                    if(Artista_Diretor==1){
                                        Artista[] Temp =(Artista[])Lista.L;
                                        F.setElenco(Temp);
                                        j=Lista.L.length+1;
                                    }
                                    else{
                                        Diretor[] Temp = (Diretor[])Lista.L;
                                        F.setDiretores(Temp);
                                        j=Lista.L.length+1;
                                    }
                                }
                                else{
                                    k++;
                                    Pzinho=(Pessoa)Lista.retorna_elemento(k);
                            }
                        }
                        j++;
                        F=(Filme)Lista2[j];
                    }
                    i++;
                    Nome_filme = Listinha[i];
                }
                //após ter excluido a pessoa das listas de pessoas do FILME, exclui a pessoa da lista de pessoas GLOBAL
                if(Artista_Diretor==1) Lista.L = Lista_artistas;
                else Lista.L = Lista_diretores;
                //temporaria
                P =(Pessoa)Lista.retorna_elemento(0);
                while((P!=null)&&(i<Lista.L.length)){
                    P=(Pessoa)Lista.retorna_elemento(i);
                    if(Nome_pessoa.equals(P.getNome())){
                        Lista.excluir_elemento(i);
                        //muda a referencia da lista
                        if(Artista_Diretor==1){
                            Lista_artistas = Lista.L;
                            i=Lista.L.length;
                        }
                        else{
                            Lista_diretores = Lista.L;
                            i=Lista.L.length;
                        }
                }
                else i++;
                }
                Lista_filmes=Lista.L;
                System.out.println("Pessoa excluida com sucesso");
                }
            //caso em que a pessoa não foi encontrada
            }
            System.out.println("Nenhum filme cadastrado");
        }
        else {
            System.out.println("Pessoa não encontrada");
        }
    }    
}
