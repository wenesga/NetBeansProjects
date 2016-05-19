package Apresentacao;

import Dao.AlunoDAO;
import Entidade.Aluno;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 29/03/2016 - Classe: Tabela
 */
public class Tabela extends JFrame {

    public static void main(String[] args) {
        new Tabela();
    }

    private JLabel lbNome, lbIdade, lbMatricula;
    private JTextField txtNome, txtIdade, txtMatricula;
    private JPanel panelAdd, panelTable, panelButtons;
    private JButton btnNew, btnSave, btnRemove, btnCancel;
    private JTable table;
    private JScrollPane scrollPane;

    private List<Aluno> alunoList;
    private Long idAluno;

    public Tabela() throws HeadlessException {
        super("Alunos");
        setContentPane(new JPanel());
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelAdd = new JPanel(new MigLayout());
        panelAdd.setBorder(BorderFactory.createTitledBorder("Cadastro Alunos"));
        panelAdd.setBounds(5, 0, 480, 100);

        lbNome = new JLabel("Nome:");
        lbMatricula = new JLabel("Matrícula:");
        lbIdade = new JLabel("Idade:");

        txtNome = new JTextField(20);
        //txtIdade = new JTextField(10);
        try {
            javax.swing.text.MaskFormatter idade = new javax.swing.text.MaskFormatter("##");
            txtIdade = new javax.swing.JFormattedTextField(idade);
        } catch (Exception e) {
        }
        //txtMatricula = new JTextField(10);
        try {
            javax.swing.text.MaskFormatter idade = new javax.swing.text.MaskFormatter("******");
            txtMatricula = new javax.swing.JFormattedTextField(idade);
        } catch (Exception e) {
        }

        panelAdd.add(lbNome);
        panelAdd.add(txtNome, "span, growx");

        panelAdd.add(lbMatricula);
        panelAdd.add(txtMatricula, "span, grow");

        panelAdd.add(lbIdade);
        panelAdd.add(txtIdade, "grow");

        panelButtons = new JPanel(new MigLayout());
        panelButtons.setBorder(BorderFactory.createEtchedBorder());
        panelButtons.setBounds(5, 105, 480, 45);

        btnNew = new JButton("Novo");
        btnSave = new JButton("Salvar");
        btnCancel = new JButton("Limpar");
        btnRemove = new JButton("Excluir");
//        btnUpdate = new JButton("Editar");

        panelButtons.add(btnNew, "gapleft 82");
        panelButtons.add(btnCancel);
        panelButtons.add(btnSave, "gap");
//        panelButtons.add(btnUpdate, "gap unrelated");
        panelButtons.add(btnRemove);

        panelTable = new JPanel(new MigLayout());
        panelTable.setBorder(BorderFactory.createTitledBorder("Lista de Alunos"));
        panelTable.setBounds(5, 150, 480, 240);

        table = new JTable();

        scrollPane = new JScrollPane(table);

        panelTable.add(scrollPane);

        carregar();
        bloqueiaCampo(false);

        add(panelAdd);
        add(panelButtons);
        add(panelTable);
        setMinimumSize(new Dimension(500, 420));
        setVisible(true);

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SalvarAluno();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpaCampo();
            }
        });

        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NovoAluno();
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExcluirAluno();
            }
        });

//        btnUpdate.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                AlterarAluno();
//            }
//        });
        this.setLocationRelativeTo(null); // Centralizar janela
    }

    private void ExcluirAluno() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o Aluno para Excluir");
            return;
        }

        Aluno aluno = new TableModel(alunoList).get(rowIndex);

        int confirm = JOptionPane.showConfirmDialog(this, "Deseja excluir o Aluno?", "Excluir Aluno", JOptionPane.YES_NO_OPTION);

        if (confirm != 0) {
            return;
        }

        int result = new AlunoDAO().excluir(aluno.getId());

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Aluno Excluido com sucesso!");
            carregar();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

//    private void AlterarAluno() {
//        int rowIndex = table.getSelectedRow();
//
//        if (rowIndex == -1) {
//            JOptionPane.showMessageDialog(this, "Selecione o Aluno para Editar");
//            return;
//        }
//
//        Aluno aluno = new TableModel(alunoList).get(rowIndex);
//
//        idAluno = aluno.getId();
//
//        txtNome.setText(aluno.getNome());
//        txtIdade.setText(aluno.getIdade() + "");
//        txtMatricula.setText(aluno.getMatricula());
//
//        bloqueiaCampo(true);
//    }
    private void NovoAluno() {
        bloqueiaCampo(true);
    }

    private void SalvarAluno() {
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
            result = new AlunoDAO().salvar(aluno);
        } else {
            aluno.setId(idAluno);
            result = new AlunoDAO().atualizar(aluno);
            idAluno = null;
        }

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Aluno inserido com sucesso!");
            bloqueiaCampo(false);
            limpaCampo();
            carregar();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

    private void limpaCampo() {
        txtNome.setText("");
        txtIdade.setText("");
        txtMatricula.setText("");
        bloqueiaCampo(false);
    }

    private void bloqueiaCampo(boolean b) {
        txtNome.setEnabled(b);
        txtIdade.setEnabled(b);
        txtMatricula.setEnabled(b);
    }

    private void carregar() {
        alunoList = new AlunoDAO().listar();
        if (alunoList != null) {
            table.setModel(new TableModel(alunoList));
        }
    }
}
