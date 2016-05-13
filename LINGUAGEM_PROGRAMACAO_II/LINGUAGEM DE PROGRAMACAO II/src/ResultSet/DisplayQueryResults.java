package ResultSet;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

/**
 * @Cometario: Exibe o conteúdo da tabela Authors no banco de dados de livros
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 21/03/2016 - Classe: DisplayQueryResults
 */
public class DisplayQueryResults extends JFrame {
    // URL de banco de dados, nome de usuário e senha

    static final String DATABASE_URL = "jdbc:mysql://localhost/alunoteste";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    // a consulta padrão recupera todos os dados da tabela Authors
    static final String DEFAULT_QUERY = "SELECT * FROM aluno";

    private ResultSetTableModel tableModel;
    private JTextArea queryArea;

    // cria o ResultSetTableModel e GUI
    public DisplayQueryResults() {
        super("Exibindo resultados da consulta");

        // cria o ResultSetTableModel e exibe a tabela de banco de dados
        try {
            // cria o TableModel para resultados da consulta SELECT * FROM authors
            tableModel = new ResultSetTableModel(DATABASE_URL,
                    USERNAME, PASSWORD, DEFAULT_QUERY);

            // configura JTextArea em que o usuário digita consultas
            queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
            queryArea.setWrapStyleWord(true);
            queryArea.setLineWrap(true);

            JScrollPane scrollPane = new JScrollPane(queryArea,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            // configura o JButton para enviar consulta
            JButton submitButton = new JButton("submeter consulta");

            // cria o Box para gerenciar o posicionamento da queryArea e do
            // submitButton na GUI
            Box boxNorth = Box.createHorizontalBox();
            boxNorth.add(scrollPane);
            boxNorth.add(submitButton);

            // cria JTable com base no tableModel         
            JTable resultTable = new JTable(tableModel);

            JLabel filterLabel = new JLabel("Filtro:");
            final JTextField filterText = new JTextField();
            JButton filterButton = new JButton("Aplicar filtro");
            Box boxSouth = Box.createHorizontalBox();

            boxSouth.add(filterLabel);
            boxSouth.add(filterText);
            boxSouth.add(filterButton);

            // posiciona os componentes GUI no painel de conteúdo
            add(boxNorth, BorderLayout.NORTH);
            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxSouth, BorderLayout.SOUTH);

            // cria evento ouvinte para submitButton
            submitButton.addActionListener(
                    new ActionListener() {
                // passa consulta para modelo de tabela
                public void actionPerformed(ActionEvent event) {
                    // realiza uma nova consulta
                    try {
                        tableModel.setQuery(queryArea.getText());
                    } catch (SQLException sqlException) {
                        JOptionPane.showMessageDialog(null,
                                sqlException.getMessage(), "erro de banco de dados",
                                JOptionPane.ERROR_MESSAGE);

                        // tenta recuperar a partir da consulta de usuário inválida
                        // executando consulta padrão
                        try {
                            tableModel.setQuery(DEFAULT_QUERY);
                            queryArea.setText(DEFAULT_QUERY);
                        } catch (SQLException sqlException2) {
                            JOptionPane.showMessageDialog(null,
                                    sqlException2.getMessage(), "erro de banco de dados",
                                    JOptionPane.ERROR_MESSAGE);

                            // assegura que a conexão de banco de dados está fechada
                            tableModel.disconnectFromDatabase();

                            System.exit(1); // termina o aplicativo
                        }
                    }
                }
            }
            );

            final TableRowSorter< TableModel> sorter
                    = new TableRowSorter< TableModel>(tableModel);
            resultTable.setRowSorter(sorter);

            setSize(500, 250); // configura o tamanho da janela
            setVisible(true); // exibe a janela

            // cria o ouvinte para filterButton
            filterButton.addActionListener(
                    new ActionListener() {
                // passa o texto do filtro para o ouvinte
                public void actionPerformed(ActionEvent e) {
                    String text = filterText.getText();

                    if (text.length() == 0) {
                        sorter.setRowFilter(null);
                    } else {
                        try {
                            sorter.setRowFilter(
                                    RowFilter.regexFilter(text));
                        } catch (PatternSyntaxException pse) {
                            JOptionPane.showMessageDialog(null,
                                    "padrão de Bad regex", "Bad regex pattern",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                    "erro de banco de dados", JOptionPane.ERROR_MESSAGE);

            // assegura que a conexão de banco de dados está fechada
            tableModel.disconnectFromDatabase();

            System.exit(1); // termina o aplicativo
        }

        // dispõe da janela quando o usuário fecha o aplicativo (isso sobrescreve
        // o padrão de HIDE_ON_CLOSE)
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // assegura que a conexão de banco de dados é fechada quando usuário fecha o aplicativo
        addWindowListener(
                new WindowAdapter() {
            // desconecta­se do banco de dados e sai quando a janela for fechada
            public void windowClosed(WindowEvent event) {
                tableModel.disconnectFromDatabase();
                System.exit(0);
            }
        });
    }

    // executa o aplicativo
    public static void main(String args[]) {
        new DisplayQueryResults();
    }
}
