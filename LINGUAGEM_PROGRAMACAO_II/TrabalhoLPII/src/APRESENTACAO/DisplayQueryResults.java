package APRESENTACAO;

import DAO.AlunoDao;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DisplayQueryResults extends JFrame {

    AlunoDao alunoDao = new AlunoDao();
    String matricula;
    JTable resultTable;

    public DisplayQueryResults() {
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
    }

    public static void main(String args[]) {
        new DisplayQueryResults();
    }
}
