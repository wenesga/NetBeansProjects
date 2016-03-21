package ConsultandoConectando;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @Cometario: Consultando e conectando-se a um banco de dados
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 21/03/2016 - Classe: DisplayAuthors
 */
public class PrimeiraConexao {

    // URL do banco de dados
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/alunoteste";
    static String sql = "select * from aluno";

    // carrega o aplicativo
    public static void main(String args[]) {
        Connection connection = null; // gerencia a conexão
        Statement statement   = null;   // instrução de consulta
        ResultSet resultSet   = null;   // gerencia resultados

        // conecta­se ao banco de dados books e o consulta
        try {
            // estabelece uma conexão com o banco de dados
            connection = DriverManager.getConnection(
                    DATABASE_URL, "root", "");

            // cria Statement para consultar banco de dados
            statement = connection.createStatement();

            // consulta o banco de dados
            resultSet = statement.executeQuery(sql);

            // processa os resultados da consulta
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Tebela: " +metaData.getTableName(1));

            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-11s\t", metaData.getColumnName(i));
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-11s\t", resultSet.getObject(i));
                }
                System.out.println();
            } // fim do while
        } // fim do try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // fim do catch                                                   
        finally // assegura que o resultSet, a instrução e a conexão estão fechados
        {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } // fim do try                                                         
            catch (Exception exception) {
                exception.printStackTrace();
            } // fim do catch                                                       
        } // fim de finally                                                         
    }
}
