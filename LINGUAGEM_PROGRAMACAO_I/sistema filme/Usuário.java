package tp1;
import java.util.Scanner;

public class Usuário {    
    protected Lista Lista = new Lista();    
    protected Scanner S = new Scanner(System.in);
    protected String Nome,Endereço,Email,Login,Senha;
    protected int Telefone;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String Endereço) {
        this.Endereço = Endereço;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int Telefone) {
        this.Telefone = Telefone;
    }
    
    public int procurar_usuário_login_senha(Object[] Lista_cinéfilo, Object[] Lista_administrador, String login, String senha){
        int i=0;
        //temporaria
        Lista.L=Lista_cinéfilo;
        Cinéfilo C = (Cinéfilo)Lista.retorna_elemento(0);
        //percorre a lista de cinéfilos comparando o login e a senha
        while((C!=null)&&(i<Lista.L.length)){
            if((login.equals(C.getLogin()))&&(senha.equals(C.getSenha()))){
                i=Lista.L.length+1;
            }
            else {
                i++;
                C=(Cinéfilo)Lista.retorna_elemento(i);
            }
        }
        if(i==Lista.L.length+1){
            return 1;
        }
        i=0;
        Lista.L=Lista_administrador;
        Administrador A = (Administrador)Lista.retorna_elemento(0);
        //percorre a lista de administrador comparando o login e a senha
        while((A!=null)&&(i<Lista.L.length)){
            if((login.equals(A.getLogin()))&&(senha.equals(A.getSenha()))){
                i=Lista.L.length+1;
            }
            else {
                i++;
                A=(Administrador)Lista.retorna_elemento(i);
            }
        }
        if(i==Lista.L.length+1){
            return 2;
        }

        return 0;
    }
    
    public Usuário procurar_usuário_login(Object[] Lista_cinéfilo, Object[] Lista_administrador, String login){
        int i=0;
        Usuário U = new Usuário();
        //temporaria
        Lista.L=Lista_cinéfilo;
        Cinéfilo C = (Cinéfilo)Lista.retorna_elemento(0);
        while((C!=null)&&(i<Lista.L.length)){
            if(login.equals(C.getLogin())){
                i=Lista.L.length+1;
            }
            else{
                C=(Cinéfilo)Lista.retorna_elemento(i);
                i++;
            }
        }
        if(i==Lista.L.length+1){
            System.out.println("Login já utilizado");
            return U;
        }
        i=0;
        Lista.L=Lista_administrador;
        Administrador A = (Administrador)Lista.retorna_elemento(0);
        while((A!=null)&&(i<Lista.L.length)){
            if(login.equals(A.getLogin())){
                i=Lista.L.length+1;
            }
            else{
                A=(Administrador)Lista.retorna_elemento(i);
                i++;
            }
        }
        if(i==Lista.L.length+1){
            System.out.println("Login já utilizado");
            return U;
        }
        return null;
    }
}
