package Apresentacao;

import Entidade.Produto;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 29/03/2016 - Classe: TableModel
 */
public class TableModel extends AbstractTableModel {

    private static final int COL_NOME = 0;
    private static final int COL_ESTOQUE_MINIMO = 1;
    private static final int COL_DESCRICAO = 2;
    private static final int COL_ID = 3;
    private List<Produto> valores;

    public TableModel(List<Produto> valores) {
        this.valores = valores;
    }

    public int getRowCount() {
        return valores.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto aluno = valores.get(rowIndex);
        if (columnIndex == COL_ID) {
            return aluno.getId();
        } else if (columnIndex == COL_NOME) {
            return aluno.getNome();
        } else if (columnIndex == COL_ESTOQUE_MINIMO) {
            return aluno.getEstoqueMinimo();
        } else if (columnIndex == COL_DESCRICAO) {
            return aluno.getDecricacao();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case COL_ID:
                coluna = "Código";
                break;
            case COL_NOME:
                coluna = "Nome";
                break;
            case COL_ESTOQUE_MINIMO:
                coluna = "Estoque Minimo";
                break;
            case COL_DESCRICAO:
                coluna = "Decrição";
                break;
            default:
                throw new IllegalArgumentException("Coluna inválida!");
        }
        return coluna;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Long.class;
        } else if (columnIndex == COL_NOME) {
            return String.class;
        } else if (columnIndex == COL_ESTOQUE_MINIMO) {
            return String.class;
        } else if (columnIndex == COL_DESCRICAO) {
            return String.class;
        }
        return null;
    }

    public Produto get(int row) {
        return valores.get(row);
    }
}
