// Figura 28.25: ResultSetTableModel.java - WENES GOMES AQUINO - ARRAIAS - TOCANTINS.
package ResultSet;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 * @Cometario: Um TableModel que fornece dados ResultSet a uma JTable.
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 21/03/2016 - Classe: ResultSetTableModel
 */
/*
 Linhas e colunas do ResultSet são contadas a partir de 1 e linhas e
 colunas JTable são contadas a partir de 0. Ao processar
 linhas ou colunas de ResultSet para utilização em uma JTable, é
 necessário adicionar 1 ao número de linha ou coluna para manipular
 a coluna apropriada de ResultSet (isto é, coluna 0 de JTable é a
 coluna de ResultSet 1 e a linha de JTable 0 é a linha de ResultSet 1).
 */

public class ResultSetTableModel extends AbstractTableModel {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;

    // monitora o status da conexão de banco de dados
    private boolean connectedToDatabase = false;

    // construtor inicializa resultSet e obtém seu objeto de metadados;
    // determina o número de linhas
    public ResultSetTableModel(String url, String username, String password, String query) throws SQLException {
        // conecta­se ao banco de dados
        connection = DriverManager.getConnection(url, username, password);

        // cria Statement para consultar o banco de dados
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        // atualiza status de conexão de banco de dados
        connectedToDatabase = true;

        // configura consulta e a executa
        setQuery(query);
    }

    // obtém a classe que representa o tipo de coluna
    public Class getColumnClass(int column) throws IllegalStateException {
        // assegura que o banco de dados conexão está disponível          
        if (!connectedToDatabase) {
            throw new IllegalStateException("Não conectado ao banco de dados");
        }

        // determina a classe Java de coluna
        try {
            String className = metaData.getColumnClassName(column + 1);

            // retorna objeto Class que representa className
            return Class.forName(className);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return Object.class; // se ocorrerem os problemas acima, assume tipo Object
    }

    // obtém o número de colunas em ResultSet
    public int getColumnCount() throws IllegalStateException {
        // assegura que o banco de dados conexão está disponível
        if (!connectedToDatabase) {
            throw new IllegalStateException("Não conectado ao banco de dados");
        }

        // determina número de colunas
        try {
            return metaData.getColumnCount();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0; // se ocorrerem os problemas acima, retorna 0 para o número de colunas
    }

    // obtém o nome de uma coluna particular em ResultSet
    public String getColumnName(int column) throws IllegalStateException {
        // assegura que o banco de dados conexão está disponível
        if (!connectedToDatabase) {
            throw new IllegalStateException("Não conectado ao banco de dados");
        }

        // determina o nome de coluna
        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return ""; // se ocorrerem problemas, retorna string vazia para nome de coluna
    }

    // retorna o número de linhas em ResultSet
    public int getRowCount() throws IllegalStateException {
        // assegura que o banco de dados conexão está disponível
        if (!connectedToDatabase) {
            throw new IllegalStateException("Não conectado ao banco de dados");
        }
        return numberOfRows;
    } // fim do método getRowCount

    // obtém o valor na linha e na coluna especificadas
    public Object getValueAt(int row, int column)
            throws IllegalStateException {
        // assegura que o banco de dados conexão está disponível
        if (!connectedToDatabase) {
            throw new IllegalStateException("Não conectado ao banco de dados");
        }

        // obtém o valor na linha e na coluna especificadas do ResultSet
        try {
            resultSet.absolute(row + 1);
            return resultSet.getObject(column + 1);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return ""; // se ocorrerem problemas, retorna objeto string vazio
    }

    // configura a nova string de consulta de banco de dados
    public void setQuery(String query) throws SQLException, IllegalStateException {
        // assegura que o banco de dados conexão está disponível
        if (!connectedToDatabase) {
            throw new IllegalStateException("Não conectado ao banco de dados");
        }

        // especifica a consulta e a executa
        resultSet = statement.executeQuery(query);

        // obtém os metadados para o ResultSet
        metaData = resultSet.getMetaData();

        // determina o número de linhas em ResultSet
        resultSet.last(); // move para a última linha
        numberOfRows = resultSet.getRow(); // obtém o número de linha

        // notifica a JTable de que modelo foi alterado
        fireTableStructureChanged();
        // fecha Statement e Connection
    }

    public void disconnectFromDatabase() {
        if (connectedToDatabase) {
            // fecha Statement e Connection                        
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } finally // atualiza status de conexão de banco de dados
            {
                connectedToDatabase = false;
            }
        }
    }
}
