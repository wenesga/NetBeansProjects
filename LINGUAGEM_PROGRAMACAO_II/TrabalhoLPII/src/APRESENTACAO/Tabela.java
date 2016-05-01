package APRESENTACAO;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import DAO.AlunoDao;
import DAO.Conexao;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class Tabela extends JFrame {

    AlunoDao alunoDao = new AlunoDao();
    Conexao c = new Conexao();
    
    String matricula;
    JTable resultTable;

    public Tabela() {
        super("Conslutar Resultado");
        resultTable = new JTable(alunoDao.ListaAlunos());
        resultTable.setRowSelectionAllowed(true);

        resultTable.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                JTable jt = (JTable) evt.getSource();

                int linha = jt.getSelectedRow();
                int coluna = jt.getSelectedColumn();
                if ((linha != -1)) {
                    Object matriculaLinha = jt.getValueAt(linha, 0);
                    matricula = matriculaLinha.toString();
                }
            }
        });

        JPanel jp = new JPanel(new GridLayout(1, 2));
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setSize(50, 30);

        JButton btnSalvar = new JButton("salvar");
        btnSalvar.setSize(50, 30);

        jp.add(btnExcluir, BorderLayout.EAST);
        jp.add(btnSalvar, BorderLayout.WEST);

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = alunoDao.ExcluirAluno(matricula);

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Elemento excluido com sucesso");
                    resultTable.setModel(alunoDao.ListaAlunos());
                }
            }
        });


        add(new JScrollPane(resultTable), BorderLayout.CENTER);
        add(jp, BorderLayout.SOUTH);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);
        setSize(500, 250);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent event) {
                System.exit(0);
            }
        });
        this.setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        new Tabela();
        
    }
}
