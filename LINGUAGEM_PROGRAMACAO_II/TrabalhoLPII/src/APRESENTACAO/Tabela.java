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
import DAO.AlunoDAO;
import DAO.Conexao;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tabela extends JFrame {

    public static void main(String args[]) {
        new Tabela(); //Chamando construtor no metodo main
    }

    AlunoDAO alunoDao = new AlunoDAO();
    Conexao conn = new Conexao();
    String matricula;
    JTable resultTable;

    public Tabela() {  //Construtoru

        super("Tabela de Alunos"); // Tituto da janela

        resultTable = new JTable(alunoDao.ListaAlunos());
        resultTable.setRowSelectionAllowed(true);
        resultTable.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                JTable jt = (JTable) evt.getSource();

                int linha = jt.getSelectedRow();

                if ((linha != -1)) {
                    Object matriculaLinha = jt.getValueAt(linha, 2);
                    matricula = matriculaLinha.toString();
                }
            }
        });

        JPanel jp = new JPanel(new GridLayout(4, 2));

        jp.add(new JLabel("Nome:"));
        jp.add(new JTextField());

        jp.add(new JLabel("Idade:"));
        jp.add(new JTextField());

        jp.add(new JLabel("Matricula:"));
        jp.add(new JTextField());
        
        JButton btnSalvar = new JButton("salvar");
        btnSalvar.setSize(1, 1);
        jp.add(btnSalvar, BorderLayout.WEST);
        
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setSize(50, 30);
        jp.add(btnExcluir, BorderLayout.EAST);

        

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

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        add(new JScrollPane(resultTable), BorderLayout.CENTER);
        add(jp, BorderLayout.SOUTH);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);
        setSize(500, 400); //Define do tamanho da janela
        setVisible(true); //Define se a janela é visivel
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Operação pandrão de fechamento

        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent event) {
                System.exit(0);
            }
        });
        this.setLocationRelativeTo(null); //Centralizar jenela
    }
}
