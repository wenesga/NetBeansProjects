package tp1;

public class Diretor extends Pessoa{
    Diretor D;
    public void init_lista_diretor(){
        //inicia a lista de diretores
        Lista.init_lista(D);
    }
    //cadastra diretor
    public void cadastrar_diretor(Object[] Lista1)
    {
        Lista.L=Lista1;
        Diretor D = new Diretor();
        
        System.out.println("Digite o nome do diretor:");
        D.setNome(S.next());
        
        System.out.println("Digite a data de nascimento:");
        Data Data = new Data();
        Data.setData(Data);
        D.setNascimento(Data);

        System.out.println("Digite a cidade:");
        D.setCidade(S.next());
        
        System.out.println("Digite a nacionalidade:");
        D.setNacionalidade(S.next());

        System.out.println("Digite a biografia:");
        D.setBiografia(S.next());
        
        Lista.insere_elemento(D);
        //muda a referencia da lista
        Lista1=Lista.L;
    }
}
