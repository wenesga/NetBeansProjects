package APRESENTACAO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ENTIDADE.Aluno;

public class TableModelAluno extends AbstractTableModel {

    private ArrayList<Aluno> alunos;
    private final String[] colunas = {"Nome", "Idade", "Matricula"};

    public TableModelAluno() {
        this.alunos = new ArrayList<>();
    }

    /**
     * Retorna uma linha completa da tabela
     *
     * @param rowIndex
     * @return Aluno
     */
    public Aluno getAluno(int rowIndex) {
        return this.alunos.get(rowIndex);
    }

    /**
     * Adiciona um aluno a tabela (cria uma linha)
     *
     * @param aluno
     */
    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
        fireTableDataChanged();
    }

    /**
     * Remove um aluno da tabela (remove uma linha)
     *
     * @param rowIndex
     */
    public void removeAluno(int rowIndex) {
        this.alunos.remove(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Retorna a quantidade de linhas da tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {

        return this.alunos.size();
    }

    /**
     * Retorna o numero de colunas da tabela
     *
     * @return int
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Retorna o valor especifico de uma celula
     *
     * @param rowIndex
     * @param columnIndex
     * @return Object
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        //switch na coluna
        switch (columnIndex) {

            //coluna do nome do aluno
            case 0:
                return this.alunos.get(rowIndex).getNome();

            //coluna da idade do aluno
            case 1:
                return this.alunos.get(rowIndex).getIdade();

            //coluna da maatricula do aluno
            case 2:
                return this.alunos.get(rowIndex).getMatricula();

            default:
                return this.alunos.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
