package dao;

import java.sql.*;

public class Conexao {

    private static final String URL_MYSQL = "jdbc:mysql://localhost/alunos";
    private static final String DRIVER_CLASS_MYSQL = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados");
        try {
            Class.forName(DRIVER_CLASS_MYSQL);
            return DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() {
        Connection connection = getConnection();
        PreparedStatement stmt = null;
        String sql = "CREATE TABLE IF NOT EXISTS `alunos` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `nome` varchar(50) NOT NULL,\n"
                + "  `idade` int(3) NOT NULL,\n"
                + "  `matricula` varchar(50) NOT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ");";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.execute();
            System.out.println("Tabela Criada com Sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }
}
