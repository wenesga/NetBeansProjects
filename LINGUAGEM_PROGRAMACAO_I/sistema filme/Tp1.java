package tp1;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Tp1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
            //instancializa os objetos
            Filme F = new Filme();
            Artista Art = new Artista();
            Diretor D = new Diretor();
            Cinéfilo C = new Cinéfilo();
            Administrador Adm = new Administrador();
            Menus menu = new Menus();
            
            Listona LISTA = new Listona();
            LISTA.init_listas();
            
            Object Temp;
            FileInputStream fileIn = new FileInputStream("Dados.ser");  //Arquivo de entrada
            try{ //Tenta executar a leitura de arquivo se não conseguir significa que o arquivo ainda não foi preenchido (primeira execução do programa)
            ObjectInputStream in = new ObjectInputStream(fileIn);        
            LISTA = (Listona)in.readObject();
            in.close();
            fileIn.close(); //Fecha arquivo
            }
            catch (EOFException eofex) {
                //nada a fazer se encontrou fim de arquivo, ou seja, não ha nada gravado
            }
            
            //abre o menu principal
            menu.menu_principal(LISTA.F.Lista.L, LISTA.C.Lista.L, LISTA.Adm.Lista.L, LISTA.D.Lista.L, LISTA.Art.Lista.L, menu);
            
            //Salva os arquivos
            FileOutputStream fileOut = new FileOutputStream("Dados.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(LISTA);
            out.close();
            fileOut.close();
            System.exit(0); //Fecha o programa
    }
}

