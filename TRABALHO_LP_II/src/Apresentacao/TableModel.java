package Apresentacao;

import Entidade.Aluno;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_IDADE = 2;
    private static final int COL_MATRICULA = 3;

    private List<Aluno> valores;

    public TableModel(List<Aluno> valores) {
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
        } else if (columnIndex == COL_NOME) {
            return aluno.getNome();
        } else if (columnIndex == COL_IDADE) {
            return aluno.getIdade();
        } else if (columnIndex == COL_MATRICULA) {
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
            case COL_NOME:
                coluna = "Nome";
                break;
            case COL_IDADE:
                coluna = "Idade";
                break;
            case COL_MATRICULA:
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
        } else if (columnIndex == COL_NOME) {
            return String.class;
        } else if (columnIndex == COL_IDADE) {
            return String.class;
        } else if (columnIndex == COL_MATRICULA) {
            return String.class;
        }
        return null;
    }

    public Aluno get(int row) {
        return valores.get(row);
    }
}
