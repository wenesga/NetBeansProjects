package Apresentacao;

import Dao.AlunoDAO;
import Entidade.Produto;
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

    private JLabel lbNome, lbEstoqueMinimo, lbDecricao;
    private JTextField txtNome, txtEstoqueMinimo, txtDecricao;
    private JPanel panelAdd, panelTable, panelButtons;
    private JButton btnNew, btnSave, btnRemove, btnCancel, btnUpdate;
    private JTable table;
    private JScrollPane scrollPane;

    private List<Produto> produtoLista;
    private Long idProduto;

    public Tabela() throws HeadlessException {
        super("Protudos");
        setContentPane(new JPanel());
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelAdd = new JPanel(new MigLayout());
        panelAdd.setBorder(BorderFactory.createTitledBorder("Cadastro Produtos"));
        panelAdd.setBounds(5, 0, 480, 100);

        lbNome = new JLabel("Nome:");
        lbDecricao = new JLabel("Descrição:");
        lbEstoqueMinimo = new JLabel("Estoque Minimo:");

        txtNome = new JTextField(20);
        
        txtEstoqueMinimo = new JTextField(10);
        txtEstoqueMinimo.addKeyListener(new java.awt.event.KeyAdapter() {                      // cria um listener ouvinte de digitação do fieldNumero
            public void keyReleased(java.awt.event.KeyEvent evt) {                            // cria um ouvinte para cada tecla pressionada
                txtEstoqueMinimo.setText(txtEstoqueMinimo.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""
            }
        });


        txtDecricao = new JTextField(10);

        panelAdd.add(lbNome);
        panelAdd.add(txtNome, "span, growx");

        panelAdd.add(lbDecricao);
        panelAdd.add(txtDecricao, "span, grow");

        panelAdd.add(lbEstoqueMinimo);
        panelAdd.add(txtEstoqueMinimo, "grow");

        panelButtons = new JPanel(new MigLayout());
        panelButtons.setBorder(BorderFactory.createEtchedBorder());
        panelButtons.setBounds(5, 105, 480, 45);

        btnNew = new JButton("Novo");
        btnSave = new JButton("Salvar");
        btnCancel = new JButton("Limpar");
        btnRemove = new JButton("Excluir");
        btnUpdate = new JButton("Editar");

        panelButtons.add(btnNew, "gapleft 55");
        panelButtons.add(btnCancel);
        panelButtons.add(btnSave, "gap");
        panelButtons.add(btnUpdate, "gap unrelated");
        panelButtons.add(btnRemove);

        panelTable = new JPanel(new MigLayout());
        panelTable.setBorder(BorderFactory.createTitledBorder("Lista de Produtos"));
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

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AlterarAluno();
            }
        });
        this.setLocationRelativeTo(null); // Centralizar janela
    }

    private void ExcluirAluno() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o produto para Excluir");
            return;
        }

        Produto aluno = new TableModel(produtoLista).get(rowIndex);

        int confirm = JOptionPane.showConfirmDialog(this, "Deseja excluir o produto?", "Excluir produto", JOptionPane.YES_NO_OPTION);

        if (confirm != 0) {
            return;
        }

        int result = new AlunoDAO().excluir(aluno.getId());

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Produto Excluido com sucesso!");
            carregar();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

    private void AlterarAluno() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o Aluno para Editar");
            return;
        }

        Produto produto = new TableModel(produtoLista).get(rowIndex);

        idProduto = produto.getId();

        txtNome.setText(produto.getNome());
        txtEstoqueMinimo.setText(produto.getEstoqueMinimo() + "");
        txtDecricao.setText(produto.getDecricacao());

        bloqueiaCampo(true);
    }

    private void NovoAluno() {
        bloqueiaCampo(true);
    }

    private void SalvarAluno() {
        Produto aluno = new Produto();

        if (txtNome.getText().length() > 0 && txtEstoqueMinimo.getText().length() > 0 && txtDecricao.getText().length() > 0) {
            aluno.setNome(txtNome.getText());
            aluno.setEstoqueMinimo(Integer.parseInt(txtEstoqueMinimo.getText()));
            aluno.setDecricacao(txtDecricao.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
            return;
        }

        int result = 0;
        if (idProduto == null) {
            result = new AlunoDAO().salvar(aluno);
        } else {
            aluno.setId(idProduto);
            result = new AlunoDAO().atualizar(aluno);
            idProduto = null;
        }

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Produto inserido com sucesso!");
            bloqueiaCampo(false);
            limpaCampo();
            carregar();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

    private void limpaCampo() {
        txtNome.setText("");
        txtEstoqueMinimo.setText("");
        txtDecricao.setText("");
        bloqueiaCampo(false);
    }

    private void bloqueiaCampo(boolean b) {
        txtNome.setEnabled(b);
        txtEstoqueMinimo.setEnabled(b);
        txtDecricao.setEnabled(b);
    }

    private void carregar() {
        produtoLista = new AlunoDAO().listar();
        if (produtoLista != null) {
            table.setModel(new TableModel(produtoLista));
        }
    }
}
