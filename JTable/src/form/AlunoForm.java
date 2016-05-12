package form;

import controller.AlunoControle;
import entidade.Aluno;
import table.AlunoCellRenderer;
import table.AlunoTableModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AlunoForm extends JFrame {

    private JLabel lbNome, lbIdade, lbMatricula;
    private JTextField txtNome, txtIdade, txtMatricula;
    private JPanel panelAdd, panelTable, panelButtons;
    private JButton btnNew, btnSave, btnUpdate, btnRemove, btnCancel;
    private JTable table;
    private JScrollPane scrollPane;

    private JLabel nAlunos;

    private List<Aluno> alunoList;
    private Long idAluno;

    public AlunoForm() throws HeadlessException {
        super("Cadastro de Alunos");
        setContentPane(new JPanel());
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelAdd = new JPanel(new MigLayout());
        panelAdd.setBorder(BorderFactory.createTitledBorder("Adicionar Alunos"));
        panelAdd.setBounds(5, 0, 480, 100);

        lbNome = new JLabel("Nome:");
        lbIdade = new JLabel("Idade:");
        lbMatricula = new JLabel("Matrícula:");

        txtNome = new JTextField(50);
        txtIdade = new JTextField(50);
        txtMatricula = new JTextField(15);

        panelAdd.add(lbNome);
        panelAdd.add(txtNome, "span, growx");

        panelAdd.add(lbIdade);
        panelAdd.add(txtIdade, "span, growx");

        panelAdd.add(lbMatricula);
        panelAdd.add(txtMatricula, "growx");

        nAlunos = new JLabel("0");
        panelAdd.add(nAlunos, "wrap para");

        panelButtons = new JPanel(new MigLayout());
        panelButtons.setBorder(BorderFactory.createEtchedBorder());
        panelButtons.setBounds(5, 105, 480, 45);
        
        btnNew = new JButton("Novo");
        btnSave = new JButton("Salvar");
        btnCancel = new JButton("Cancelar");
        btnRemove = new JButton("Excluir");
        btnUpdate = new JButton("Editar");

        panelButtons.add(btnNew, "gapleft 37"); // Centraliza os bontões
        panelButtons.add(btnCancel);
        panelButtons.add(btnSave, "gap unrelated");
        panelButtons.add(btnUpdate, "gap unrelated");
        panelButtons.add(btnRemove);

        panelTable = new JPanel(new MigLayout());
        panelTable.setBorder(BorderFactory.createTitledBorder("Lista de Alunos"));
        panelTable.setBounds(5, 150, 480, 240);

        table = new JTable();

        scrollPane = new JScrollPane(table);

        panelTable.add(scrollPane);

        refreshTable();
        bloqueiaCampo(false); //Bloqueia os campos

        add(panelAdd);
        add(panelButtons);
        add(panelTable);
        setMinimumSize(new Dimension(500,420));
        setVisible(true);
        
        

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSaveAluno();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpaCampo();
            }
        });

        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNovoAluno();
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRemoverAluno();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAlterarAluno();
            }
        });
        this.setLocationRelativeTo(null); // Centraliza janela
    }

    private void onRemoverAluno() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o aluno a ser removido!");
            return;
        }

        Aluno aluno = new AlunoTableModel(alunoList).get(rowIndex);

        int confirm = JOptionPane.showConfirmDialog(this, "Confirmar exclusão?", "Excluir Aluno", JOptionPane.YES_NO_OPTION);

        if (confirm != 0) {
            return;
        }

        int result = new AlunoControle().excluirAluno(aluno.getId());

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Valor removido com sucesso!");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

    private void onAlterarAluno() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o aluno a ser alterado!");
            return;
        }

        Aluno aluno = new AlunoTableModel(alunoList).get(rowIndex);

        idAluno = aluno.getId();

        txtNome.setText(aluno.getNome());
        txtIdade.setText(aluno.getIdade() + "");
        txtMatricula.setText(aluno.getMatricula());

        bloqueiaCampo(true); //Libera os campos
    }

    private void onNovoAluno() {
        bloqueiaCampo(true); //Libera os campos
    }

    private void onSaveAluno() {
        Aluno aluno = new Aluno();

        if (txtNome.getText().length() > 0 && txtIdade.getText().length() > 0 && txtMatricula.getText().length() > 0) {
            aluno.setNome(txtNome.getText());
            aluno.setIdade(Integer.parseInt(txtIdade.getText()));
            aluno.setMatricula(txtMatricula.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
            return;
        }

        int result = 0;
        if (idAluno == null) {
            result = new AlunoControle().addAluno(aluno);
        } else {
            aluno.setId(idAluno);
            result = new AlunoControle().alterarAluno(aluno);
            idAluno = null;
        }

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Valor inserido com sucesso!");
            bloqueiaCampo(false); //Bloqueia os campos
            limpaCampo();
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

    private void limpaCampo() {
        txtNome.setText("");
        txtIdade.setText("");
        txtMatricula.setText("");
        bloqueiaCampo(false); //Bloqueia os campos
    }

    private void bloqueiaCampo(boolean b) {
        txtNome.setEnabled(b);
        txtIdade.setEnabled(b);
        txtMatricula.setEnabled(b);
    }

    private void refreshTable() {
        alunoList = new AlunoControle().findAlunos();
        nAlunos.setText(String.valueOf(alunoList.size()));
        if (alunoList != null) {
            table.setModel(new AlunoTableModel(alunoList));
            table.setDefaultRenderer(Object.class, new AlunoCellRenderer());
        }
    }
}
