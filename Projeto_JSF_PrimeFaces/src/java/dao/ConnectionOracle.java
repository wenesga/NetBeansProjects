/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author edson.domenech
 */
public class ConnectionOracle {
    
    public static Connection openConnection() throws Exception 
    {
        Connection dbconn = null;
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Properties db_credentials = new Properties(); 
            db_credentials.put("user", "ids"); 
            db_credentials.put("password", "xxxxxxxxxxxxx"); 
            
            dbconn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.249:1521:ids", db_credentials);                        
        } 
        finally 
        {
            return dbconn;
        }
    }  
    
}