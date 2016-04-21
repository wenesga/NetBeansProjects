/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.CadCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author edson.domenech
 */
public class CadClienteDAO 
{
    private Connection con;
    
    private void openConnectionOracle() throws Exception
    {
        try
        {
            this.con = ConnectionOracle.openConnection();
        }
        catch(Exception e)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Exception: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message);             
        }                        
    }
    
    public boolean inserir(CadCliente cadCliente) throws Exception
    {
        PreparedStatement pst = null;
        
        try
        {
            openConnectionOracle();     
            
            pst = con.prepareStatement("INSERT INTO IDS.CADCLIENTE VALUES (?, ?, ?, ?, ?, ?)");            
            
            pst.setInt(1, cadCliente.getCodCliente());
            pst.setString(2, cadCliente.getNmCliente());
            pst.setString(3, cadCliente.getNmEndereco());
            pst.setString(4, cadCliente.getNmBairro());
            pst.setString(5, cadCliente.getNmCidade());
            pst.setString(6, cadCliente.getNmUF());
            
            pst.executeUpdate();            
            
            return true;            
        }
        catch(Exception e)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Exception: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
            return false;
        }                
        finally
        {
            if (pst != null)
            {
                pst.close();
            }

            if (con != null)
            {
                con.close();
            }            
        }
    }    
    
    public boolean alterar(CadCliente cadCliente) throws Exception
    {
        PreparedStatement pst = null;
        
        try 
        {
            openConnectionOracle();     
            
            pst = con.prepareStatement("UPDATE IDS.CADCLIENTE SET " +                        
                                       "NMCLIENTE = ?, " +
                                       "NMENDERECO = ?, " +
                                       "NMBAIRRO = ?, " +
                                       "NMCIDADE = ?, " +
                                       "NMUF = ? " +                    
                                       "WHERE CODCLIENTE = ?");
            
            pst.setString(1, cadCliente.getNmCliente());
            pst.setString(2, cadCliente.getNmEndereco());
            pst.setString(3, cadCliente.getNmBairro());
            pst.setString(4, cadCliente.getNmCidade());
            pst.setString(5, cadCliente.getNmUF());
            pst.setInt(6, cadCliente.getCodCliente());
                
            pst.executeUpdate();   

            return true;                            
        } 
        catch(Exception e)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Exception: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
            return false;
        }                
        finally
        {
            if (pst != null)
            {
                pst.close();
            }            

            if (con != null)
            {
                con.close();
            }            
        }
    }    
    
    public boolean remover(CadCliente cadCliente) throws Exception   
    {
        PreparedStatement pst = null;
        
        try 
        {
            openConnectionOracle();     
            
            pst = con.prepareStatement("DELETE FROM IDS.CADCLIENTE WHERE CODCLIENTE = ?");            
                
            pst.setInt(1, cadCliente.getCodCliente());
                                
            pst.executeUpdate();
            
            return true;
        }
        catch(Exception e)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Exception: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
            return false;
        }                        
        finally
        {
            if (pst != null)
            {
                pst.close();
            }            

            if (con != null)
            {
                con.close();
            }            
        }
    }
    
    public List<CadCliente> listar() throws Exception   
    {
        List<CadCliente> ListCadCliente = new ArrayList<CadCliente>();
        Statement st = null;                
        
        try 
        {
            openConnectionOracle();     
            
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT CODCLIENTE, NMCLIENTE, NMENDERECO, " + 
                                           "NMBAIRRO, NMCIDADE, NMUF " + 
                                           "FROM IDS.CADCLIENTE ORDER BY CODCLIENTE DESC");            
            
            while (rs.next())
            {
                ListCadCliente.add(new CadCliente(rs.getInt("CODCLIENTE"), rs.getString("NMCLIENTE"), 
                                                  rs.getString("NMENDERECO"), rs.getString("NMBAIRRO"), 
                                                  rs.getString("NMCIDADE"), rs.getString("NMUF")));
            }
        
            return  ListCadCliente;                    
        } 
        catch (Exception e) 
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Exception: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
            return null; 
        } 
        finally
        {
            if (st != null)
            {
                st.close();
            }            

            if (con != null)
            {
                con.close();
            }            
        }        
    }
    
    public Integer proxCodCliente() throws Exception
    {
        Statement st = null;                
                
        try 
        {
            openConnectionOracle();     
            
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT NVL((MAX(CODCLIENTE) + 1), 1) PROX_CODCLIENTE FROM IDS.CADCLIENTE");                        
            
            rs.next();
            
            return rs.getInt("PROX_CODCLIENTE");  
        } 
        catch (Exception e) 
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Exception: " + e.getMessage(), "");  
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
            return -1; 
        } 
        finally
        {
            if (st != null)
            {
                st.close();
            }            

            if (con != null)
            {
                con.close();
            }            
        }        
    }    
}
