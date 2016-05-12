package bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * @Cometario: Classe que contem os objetos usado no Chat
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 25/04/2016 - Classe: ServidorTCPBasico
 */
public class ChatMensagem implements Serializable {
    
    private String nome;                                    // Armazena do nome do cliente
    private String texto;                                   // Armazena o texto da mensagem
    private String nomeReservado;                           // Armazena nome no cliete que receberar mensagem do tipo reservada
    private Set<String> setOnlines = new HashSet<String>(); // Lista que armazena todos clietnes online
    private Action action;        //

    public enum Action {
        CONECTAR, DESCONECTAR, ENVIAR_PARA_UM, ENVIAR_PARA_TODOS, USERS_ONLINE
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNomeReservado() {
        return nomeReservado;
    }

    public void setNomeReservado(String nomeReservado) {
        this.nomeReservado = nomeReservado;
    }

    public Set<String> getSetOnlines() {
        return setOnlines;
    }

    public void setSetOnlines(Set<String> setOnlines) {
        this.setOnlines = setOnlines;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
