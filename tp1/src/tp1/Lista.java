package tp1;

public class Lista {
    
    public Object L[];    
    int n=0;
  
    public void init_lista(Object N){
        //inicia a lista        
        L = new  Object [10];
    }
    
    public Object retorna_elemento(int i)
    {
        //retorna elemento i da lista
            if (L[i]==null)
                return null;
            else return L[i];
        
            
    }
            
    public void insere_elemento(Object N){      
       int i;
       //verifica se há espaço vazio na lista
       for(i=0;i<L.length;i++)
       {
           if(L[i]==null){
               //se houver espaço vazio,insere o elemento no mesmo
               L[i]=N;
               i=L.length+1;
           }
       }
       if( i==L.length ) {
            //se não houver espaço vazio,cria outro vetor igual ao primeiro com espaços a mais
            int m;
            m=L.length+10;
            Object Nova_lista[];
            Nova_lista = new Object[m];
            for(i=0;i<L.length;i++)
            {
                //copia os elementos
                Nova_lista[i]=L[i];
            }
            //insere o elemento no novo espaço criado
            Nova_lista[m]=N;
            //muda a referencia da lista
            L = Nova_lista;
            //
        }
    }
    
    public void excluir_elemento(int i)
    {
        //move os elementos da direita para a esquerda
        while((i<L.length)&&(L[i+1]!=null)){
            L[i]=L[i+1];
            i++;
        }
        //torna o ultimo elemento alterado null
        L[i]=null;
    }

    public Object[] getLista() {
        //retorna a lista inteira
        return L;
    }

    public void setLista(Object[] L) {
        this.L = L;
    }
    
}
