/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.CadCliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author edson.domenech
 */
public class CadClienteDAO {
    
    private Connection con;
    
    private void openConnectionOracle() throws Exception
    {
        try
        {
            this.con = ConnectionOracle.openConnection();
        }
        catch(SQLException e)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro SQLException: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message);             
        }                        
    }
    
    public boolean inserir(CadCliente cadCliente) throws SQLException, Exception
    {
        PreparedStatement pst = null;
        
        try
        {
            openConnectionOracle();     
            
            pst = con.prepareStatement("INSERT INTO CADCLIENTE VALUES (?, ?, ?, ?, ?, ?)");            
            
            pst.setInt(1, cadCliente.getCodCliente());
            pst.setString(2, cadCliente.getNmCliente());
            pst.setString(3, cadCliente.getNmEndereco());
            pst.setString(4, cadCliente.getNmBairro());
            pst.setString(5, cadCliente.getNmCidade());
            pst.setString(6, cadCliente.getNmUF());
            
            pst.executeUpdate();            
            
            return true;            
        }
        catch(SQLException e)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro SQLException: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
            return false;
        }                
        finally
        {
            if (pst != null)
            {
                pst.close();
            }
            con.close();
        }
    }    
    
    public boolean alterar(CadCliente cadCliente) throws SQLException, Exception
    {
        PreparedStatement pst = null;
        
        try 
        {
            openConnectionOracle();     
            
            pst = con.prepareStatement("UPDATE CADCLIENTE SET " +                        
                                       "NMCLIENTE = ?, " +
                                       "NMENDERECO = ?, " +
                                       "NMBAIRRO = ?, " +
                                       "NMCIDADE = ?, " +
                                       "NMUF = ? " +                    
                                       "WHERE CODCLIENTE = ? ");
            
            pst.setString(1, cadCliente.getNmCliente());
            pst.setString(2, cadCliente.getNmEndereco());
            pst.setString(3, cadCliente.getNmBairro());
            pst.setString(4, cadCliente.getNmCidade());
            pst.setString(5, cadCliente.getNmUF());
            pst.setInt(6, cadCliente.getCodCliente());
                
            pst.executeUpdate();   

            return true;                            
        } 
        catch(SQLException e)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro SQLException: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
            return false;
        }                
        finally
        {
            if (pst != null)
            {
                pst.close();
            }            
            con.close();
        }
    }    
    
    public boolean remover(CadCliente cadCliente) throws SQLException, Exception   
    {
        PreparedStatement pst = null;
        
        try 
        {
            openConnectionOracle();     
            
            pst = con.prepareStatement("DELETE FROM CADCLIENTE WHERE CODCLIENTE = ?");            
                
            pst.setInt(1, cadCliente.getCodCliente());
                                
            pst.executeUpdate();
            
            return true;
        }
        catch(SQLException e)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro SQLException: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
            return false;
        }                
        finally
        {
            if (pst != null)
            {
                pst.close();
            }            
            con.close();
        }
    }
    
    public List<CadCliente> listar() throws SQLException, Exception   
    {
        List<CadCliente> ListCadCliente = new ArrayList<CadCliente>();
        Statement st = null;                
        
        try 
        {
            openConnectionOracle();     
            
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT CODCLIENTE, NMCLIENTE, NMENDERECO, " + 
                                           "NMBAIRRO, NMCIDADE, NMUF " + 
                                           "FROM CADCLIENTE ORDER BY CODCLIENTE DESC");            
            
            while (rs.next())
            {
                ListCadCliente.add(new CadCliente(rs.getInt("CODCLIENTE"), rs.getString("NMCLIENTE"), 
                                                  rs.getString("NMENDERECO"), rs.getString("NMBAIRRO"), 
                                                  rs.getString("NMCIDADE"), rs.getString("NMUF")));
            }
        
            return  ListCadCliente;                    
        } 
        catch (SQLException e) 
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro SQLException: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
            return null; 
        } 
        finally
        {
            if (st != null)
            {
                st.close();
            }            
            con.close();
        }        
    }
    
    public Integer proxCodCliente() throws SQLException, Exception
    {
        Statement st = null;                
                
        try 
        {
            openConnectionOracle();     
            
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT NVL((MAX(CODCLIENTE) + 1), 1) PROX_CODCLIENTE FROM CADCLIENTE");                        
            
            rs.next();
            
            return rs.getInt("PROX_CODCLIENTE");  
        } 
        catch (SQLException e) 
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro SQLException: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
            return -1; 
        } 
        finally
        {
            if (st != null)
            {
                st.close();
            }            
            con.close();
        }        
    }    
}
