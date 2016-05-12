package bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Cometario: Classe que contem os objetos usado no Chat
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 25/04/2016 - Classe: ServidorTCPBasico
 */
public class ChatMessage implements Serializable {

    private String name;                                    // Armazena do nome do cliente
    private String text;                                    // Armazena o texto da mensagem
    private String nameReserved;                            // Armazena nome no cliete que receberar mensagem do tipo reservada
    private Set<String> setOnlines = new HashSet<String>(); // Lista que armazena todos clietnes online
    private Action action;        //

    // Metodo que diz qual assaçao o cliente quer executar
    public enum Action {
        CONNECT, DISCONNECT, SEND_ONE, SEND_ALL, USERS_ONLINE
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNameReserved() {
        return nameReserved;
    }

    public void setNameReserved(String nameReserved) {
        this.nameReserved = nameReserved;
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
