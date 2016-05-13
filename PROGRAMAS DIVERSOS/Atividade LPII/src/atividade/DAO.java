package atividade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAO 
{
    private final String URL = "jdbc:mysql://localhost:3306/dbwork";
    private final String USUARIO = "root";
    private final String SENHA = "070900";
    protected Connection conexao;
    protected PreparedStatement instrucao;
    protected ResultSet resultado;
    
    public DAO()
    {
        try
        {
            conexao = DriverManager.getConnection( URL, USUARIO, SENHA );
        }
        catch(SQLException sql)
        {
            JOptionPane.showMessageDialog(null,"Não foi possível efetuar a conexão! ");
        }
    }  
} 