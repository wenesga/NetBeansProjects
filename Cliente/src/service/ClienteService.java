package service;

import bean.ChatMessage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 25/04/2016 - Classe: ServidorTCPBasico
 */
public class ClienteService {
    
    private Socket socket;
    private ObjectOutputStream output;
    
    public Socket connect() {
        try {
            this.socket = new Socket("localhost", 5555);
            this.output = new ObjectOutputStream(socket.getOutputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return socket;
    }
    
    public void send(ChatMessage message) {
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
