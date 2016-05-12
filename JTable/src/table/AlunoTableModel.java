package table;

import entidade.Aluno;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AlunoTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_EDITORA = 1;
    private static final int COL_TITULO = 2;
    private static final int COL_ISBN = 3;

    private List<Aluno> valores;

    public AlunoTableModel(List<Aluno> valores) {
        this.valores = valores;
    }

    public int getRowCount() {
        return valores.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = valores.get(rowIndex);
        if (columnIndex == COL_ID) {
            return aluno.getId();
        } else if (columnIndex == COL_EDITORA) {
            return aluno.getNome();
        } else if (columnIndex == COL_TITULO) {
            return aluno.getIdade();
        } else if (columnIndex == COL_ISBN) {
            return aluno.getMatricula();
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
            case COL_EDITORA:
                coluna = "Nome";
                break;
            case COL_TITULO:
                coluna = "Idade";
                break;
            case COL_ISBN:
                coluna = "Matrícula";
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
        } else if (columnIndex == COL_EDITORA) {
            return String.class;
        } else if (columnIndex == COL_TITULO) {
            return String.class;
        } else if (columnIndex == COL_ISBN) {
            return String.class;
        }
        return null;
    }

    public Aluno get(int row) {
        return valores.get(row);
    }
}
