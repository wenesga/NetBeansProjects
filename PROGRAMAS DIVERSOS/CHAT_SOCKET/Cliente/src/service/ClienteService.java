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

// CRIAR PONTO DE ACESSO
// netsh wlan set hostednetwor mode=allow ssid=aquino key=12345678
// netsh wlan start hostednetwork

public class ClienteService {
    
    private Socket socket;
    private ObjectOutputStream output;
    
    // Metodo para conectar no servidor
    public Socket connect() {
        try {
            this.socket = new Socket("169.254.119.238", 5555);
            this.output = new ObjectOutputStream(socket.getOutputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return socket;
    }
    
    // Metodo para enviar mensagem
    public void send(ChatMessage message) {
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
