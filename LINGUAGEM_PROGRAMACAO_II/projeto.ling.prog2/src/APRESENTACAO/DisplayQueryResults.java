package APRESENTACAO;
import DAO.AlunoDao;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class DisplayQueryResults extends JFrame {
    
    private AlunoDao alunoDao = new AlunoDao();
    private TableModel tableModel;
    private JTextArea queryArea;

    public DisplayQueryResults() {      
        super("Conslutar Resultado");
        
        JTable resultTable = new JTable(alunoDao.ListaAlunos()); 
        
        add(new JScrollPane(resultTable), BorderLayout.CENTER); 
        setSize(500, 250); 
        setVisible(true); 
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String args[]) {
        new DisplayQueryResults();
    }
}
