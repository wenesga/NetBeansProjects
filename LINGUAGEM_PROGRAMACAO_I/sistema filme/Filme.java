package tp1;
import java.util.Scanner;

public class Filme {
   private String Nome, Descrição, País, Lingua, Produtora;
   private String Avaliação, Duração;
   public Diretor Diretores[];
   public Artista Elenco[];
   Scanner S = new Scanner(System.in);
   Filme[] Lista_filmes;
    
    //Parametros
    Lista Lista = new Lista();
    //
    
    Filme F;
    public void init_lista_filmes(){
        //inicia a lista de filmes
        Lista.init_lista(F);
    }
    
    public String getNome() {
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescrição() {
        return Descrição;
    }
    public void setDescrição(String Descrição) {
        this.Descrição = Descrição;
    }

    public String getPaís() {
        return País;
    }
    public void setPaís(String País) {
        this.País = País;
    }

    public String getLingua() {
        return Lingua;
    }
    public void setLingua(String Lingua) {
        this.Lingua = Lingua;
    }

    public String getProdutora() {
        return Produtora;
    }
    public void setProdutora(String Produtora) {
        this.Produtora = Produtora;
    }

    public String getAvaliação() {
        return Avaliação;
    }
    public void setAvaliação(String Avaliação) {
        this.Avaliação = Avaliação;
    }

    public String getDuração() {
        return Duração;
    }
    public void setDuração(String Duração) {
        this.Duração = Duração;
    }

    public Diretor[] getDiretores() {
        return Diretores;
    }

    public void setDiretores(Diretor[] Diretores) {
        this.Diretores = Diretores;
    }

    public Artista[] getElenco() {
        return Elenco;
    }

    public void setElenco(Artista[] Elenco) {
        this.Elenco = Elenco;
    }
    
    
    //cadastro dos diretores e do elenco
    //recebe a lista das pessoas do filme, a lista das pessoas global, o nome da pessoa e o nome do filme para adicionar à lista de filmes dela
    public void cadastrar_pessoa_filme(Object[] Lista_filme, Object[] Lista_pessoas, String Nome_pessoa, String Nome_filme){
        Lista.L=Lista_filme;
        int i=0;
        //temporaria para comparação
        Pessoa Temp = (Pessoa)Lista.retorna_elemento(0);
        //verifica se a pessoa já está cadastrada na lista do filme
        while((Temp!=null)&&(i<Lista.L.length)){
            //compara os nomes
            if(Nome_pessoa.equals(Temp.getNome())){
                i=Lista.L.length+1;
            }
            else {
                i++;
                
            Temp=(Pessoa)Lista.retorna_elemento(i);
            } 
        }
        if(i!=Lista.L.length+1){
            //se percorreu a lista inteira e a pessoa não foi encontrada na lista de pessoas do FILME, adiciona o filme na lista da PESSOA
            //adiciona o filme à lista de filmes da PESSOA
            String[] Lista_filme_pessoa = Temp.getLista_filmes();
            Temp.cadastrar_filmes_pessoa(Lista_filme_pessoa, Nome_filme);
            Temp.setLista_filmes(Lista_filme_pessoa);
            //adiciona a pessoa temporaria com o filme cadastrado na lista do FILME
            Lista.insere_elemento(Temp);
            //muda a referencia da lista do FILME
            Lista_filme=Lista.L;
            //agora, retira a pessoa sem o filme da lista de pessoas GLOBAL
            //muda a referencia para a lista de pessoas
            Lista.L=Lista_pessoas;
            int j=0;
            Pessoa Temp2 = (Pessoa)Lista.retorna_elemento(0);
            //percorre a lista de pessoas GLOBAL para encontrar a que tem o mesmo nome
            while((Temp2!=null)&&(j<Lista.L.length)){
                //procura a pessoa na lista GLOBAL das pessoas
                if(Nome_pessoa.equals(Temp2.getNome())){
                    //exclui a pessoa da lista
                    Lista.excluir_elemento(j);
                    //insere o primeiro temporario na lista GLOBAL das pessoas
                    Lista.insere_elemento(Temp);
                    //muda a referencia da lista
                    Lista_pessoas = Lista.L;
                    System.out.println("Pessoa cadastrado com sucesso");
                    j=Lista.L.length+1;
                }
                else {
                    j++;
                    Temp2 = (Pessoa)Lista.retorna_elemento(j);
                }
            }
     }
        else System.out.println("Pessoa já inserido");
    }
    
    //cadastra um novo filme, recebe a lista de filmes, a lista de diretores e a lista de artistas para realizar o cadastro
    public void cadastrar_filme(Object[] Lista_filmes, Object[] Lista_diretores, Object[] Lista_artistas){
        Lista.L=Lista_filmes;
        Filme F = (Filme)Lista.retorna_elemento(0);
        Pessoa P = new Pessoa();

        String Nome_filme;
        System.out.println("Digite o nome do filme");
        Nome_filme=S.next();
        int i=0;
        //verifica se já existe algum filme com o mesmo nome
        while((Lista.retorna_elemento(i)!=null)&&(i<Lista.L.length)){
            if(Nome_filme.equals(F.getNome())){
                i=Lista.L.length+1;
            }
            else {
                i++;
                F=(Filme)Lista.retorna_elemento(i);
            }
        }
        if(i==Lista.L.length+1)
            System.out.println("Filme já cadastrado, não é possivel cadastrar");
        else{
            F = new Filme();
            F.setNome(Nome_filme);        

            System.out.println("Digite a descrição do filme:");
            F.setDescrição(S.next());

            System.out.println("Digite o país do filme:");
            F.setPaís(S.next());

            System.out.println("Digite a lingua do filme:");
            F.setLingua(S.next());

            System.out.println("Digite a produtora do filme:");
            F.setProdutora(S.next());

            System.out.println("Digite a duração do filme:");
            F.setDuração(S.next());
            
            //verifica se a avaliação é válida
           /* while((avaliação<1)||(avaliação>10)){
                System.out.println("Número inválido, avaliação deve estar entre 1 e 10");
            }*/
            System.out.println("Digite a avaliação:");
            F.setAvaliação(S.next());
            
            //cadastro diretores e elenco
            String ch = "s";
            String Nome_pessoa;
            //cadastro diretor
            System.out.println("Cadastro dos diretores\n");      
            //temporaria para inserir pessoas nas listas do filme
            System.out.println("Deseja cadastrar um diretor?'s' para sim");
            ch = S.next();
            while("s".equals(ch)){
                System.out.println("Digite o nome do diretor");
                Nome_pessoa = S.next();
                //verifica se o diretor já está inserido
                if(P.procurar_pessoa(Lista_diretores, Nome_pessoa)!=null){
                    //se não estiver cadastrada, adiciona o filme a lista de filmes da PESSOA e a pessoa a lista de pessoas do FILME
                    F.cadastrar_pessoa_filme(F.getDiretores(),Lista_diretores, Nome_pessoa, F.getNome());
                    System.out.println("Deseja cadastrar outro diretor no filme?'s' para sim");
                    ch=S.next();
                }
                else{
                    System.out.println("Diretor não cadastrado no sistema\n");
                    System.out.println("Deseja cadastrar outro diretor?'s' para sim");
                    ch=S.next();
                }
            }
            //cadastro elenco
            System.out.println("Cadastro do elenco\n");
            System.out.println("Deseja cadastrar um artista?'s' para sim");
            ch = S.next();
            while("s".equals(ch)){
                System.out.println("Digite o nome do artista");
                Nome_pessoa = S.next();
                if(P.procurar_pessoa(Lista_diretores, Nome_pessoa)!=null){
                    F.cadastrar_pessoa_filme(F.getElenco(), Lista_artistas, Nome_pessoa, F.getNome());
                    System.out.println("Deseja cadastrar outro artista no filme?'s' para sim");
                    ch=S.next();
                }
                else{
                    System.out.println("Artista não cadastrado no sistema\n");
                    System.out.println("Deseja cadastrar outro Artista?'s' para sim");
                    ch=S.next();
                }
            }
            
            Lista.insere_elemento(F);
            //muda a referencia da lista
            Lista_filmes=Lista.L;
        }
    }
    
    public void listar_filmes(Object[] Lista_filmes){
        System.out.println("Filmes cadastrados:");
        int i=0;
        Lista.L = Lista_filmes;
        //Temporaria
        Filme F = (Filme)Lista.retorna_elemento(0);
        //percorre a lista de filmes exibindo seus nomes
        while((F!=null)&&(i!=Lista.L.length)){
            System.out.println(F.getNome()+"\n");
            i++;
            F=(Filme)Lista.retorna_elemento(i);
        }
    }
    
    public Filme procurar_filme(Object[] Lista_filmes, String Nome_filme){
        int i=0;
        //temporaria
        Lista.L=Lista_filmes;
        Filme F = (Filme)Lista.retorna_elemento(0);
        //percorre a lista de filmes comparando com o nome_filme
        while((F!=null)&&(i<Lista.L.length)){
            if(Nome_filme.equals(F.getNome())){
                i=Lista.L.length+1;
            }
            else {
                i++;
                F=(Filme)Lista.retorna_elemento(i);
            }
        }
        if(i!=Lista.L.length+1){
            System.out.println("Filme encontrado");
            return F;
        }
        else {
            System.out.println("Filme não encontrado!");
            return null;
        }
    }
    
    public void excluir_filme(Object[] Lista_filmes, Object[] Lista_artistas, Object[] Lista_diretores, String Nome_filme){
        //verifica se o filme inserido é válido
        Filme F = procurar_filme(Lista_filmes,Nome_filme);
        if(F!=null){
            //se o filme for encontrado, percorre a lista de artistas e diretores do filme para remover o filme da lista de filmes do mesmo
            //temporarias
            if((F.getDiretores()!=null)&&(F.getElenco()!=null)){
                Diretor[] Diretores = F.getDiretores();
                Diretor D = Diretores[0];

                Artista[] Artistas = F.getElenco();
                Artista A = Artistas[0];
            
            String Temp = new String();
            int i=0,j;
            //percorre a lista de nomes dos artistas do filme
            while((A!=null)&&(i<Artistas.length)){
                String Nome_artista = A.getNome();
                j=0;
                //escolhe a lista global de artistas
                Lista.L= Lista_artistas;
                Artista Azinho = (Artista)Lista.retorna_elemento(0);
                //percorre a lista de artistas global pra comparar os nomes
                //quando achar o artista, exclui o filme de sua lista
                while((Azinho!=null)&&(j<Lista.L.length)){
                    //quando achar o nome do artista, remove o filme de sua lista de filmes
                    if(Nome_artista.equals(Azinho.getNome())){
                        //remove o artista com o nome do filme na lista
                        Lista.excluir_elemento(i);
                        //temporaria para excluir o filme
                        String[] Lista_filmes_temp = Azinho.getLista_filmes();
                        Azinho.excluir_filmes_pessoa(Lista_filmes_temp, Nome_filme);
                        Azinho.setLista_filmes(Lista_filmes_temp);
                        //insere o artista com a lista sem o filme na lista de artistas
                        Lista.insere_elemento(Azinho);
                        //muda a referencia da lista de artistas
                        Lista_artistas = Lista.L;
                    }
                    else{
                        j++;
                        Azinho = (Artista)Lista.retorna_elemento(j);
                    }
                }
                i++;
                A = Artistas[i];
            }
            //percorre a lista de nomes dos diretores do filme
            while((A!=null)&&(i<Artistas.length)){
                String Nome_diretor = A.getNome();
                j=0;
                //escolhe a lista global de artistas
                Lista.L= Lista_diretores;
                Diretor Dzinho = (Diretor)Lista.retorna_elemento(0);
                //percorre a lista de diretores global pra comparar os nomes
                //quando achar o diretor, exclui o filme de sua lista
                while((Dzinho!=null)&&(j<Lista.L.length)){
                    //quando achar o nome do artista, remove o filme de sua lista de filmes
                    if(Nome_diretor.equals(Dzinho.getNome())){
                        //remove o artista com o nome do filme na lista
                        Lista.excluir_elemento(i);
                        //temporaria para excluir o filme
                        String[] Lista_filmes_temp = Dzinho.getLista_filmes();
                        Dzinho.excluir_filmes_pessoa(Lista_filmes_temp, Nome_filme);
                        Dzinho.setLista_filmes(Lista_filmes_temp);
                        //insere o artista com a lista sem o filme na lista de artistas
                        Lista.insere_elemento(Dzinho);
                        //muda a referencia da lista de artistas
                        Lista_artistas = Lista.L;
                    }
                    else{
                        j++;
                        Dzinho = (Diretor)Lista.retorna_elemento(j);
                    }
                }
                i++;
                A = Artistas[i];
            }
            //agora, remove o filme da lista de filmes global
            //muda a referencia da lista
            Lista.L = Lista_filmes;
            F = (Filme)Lista.retorna_elemento(0);
            //percorre a lista de filmes comparando com o nome_filme
            while((F!=null)&&(i<Lista.L.length)){
                if(Nome_filme.equals(F.getNome())){
                    Lista.excluir_elemento(i);
                    i=Lista.L.length;
                    System.out.println("Filme excluido com sucesso");
                    //muda a referencia da lista
                    Lista_filmes = Lista.L;
                    //sai do laço
                    i=Lista.L.length;
                }
                else {
                    i++;
                    F=(Filme)Lista.retorna_elemento(i);
                }
            }
            }
            System.out.println("Nenhum artista nem diretor cadastrado");
        }
        else System.out.println("Filme não encontrado no sistema");
    }
}