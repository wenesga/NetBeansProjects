package Entidade;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 * @author WENES
 */
public class Tabela extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;

    public Tabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList dados) {
        linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] nomes) {
        colunas = nomes;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Object[] linha = (Object[]) getLinhas().get(numLin);
        return linha[numCol];
    }
    
    @Override  
    public boolean isCellEditable(int row, int column) {  
    return true;  
    } 
}
