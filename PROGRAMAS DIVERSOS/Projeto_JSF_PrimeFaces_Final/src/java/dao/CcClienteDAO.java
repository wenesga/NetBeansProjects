package dao;

import entidade.CadCliente;
import entidade.CcCliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author edson.domenech
 */
public class CcClienteDAO 
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
    
    public boolean inserir(CcCliente ccCliente) throws Exception
    {
        PreparedStatement pst = null;
        
        try
        {
            openConnectionOracle();     
            
            pst = con.prepareStatement("INSERT INTO IDS.CCCLIENTE VALUES (?, ?, ?, ?, ?, ?)");            
            
            pst.setInt(1, ccCliente.getCodLcto());
            pst.setInt(2, ccCliente.getCadCliente().getCodCliente());
            pst.setString(3, ccCliente.getDescricao());
            pst.setString(4, ccCliente.getDc());
            pst.setDate(5, new Date(ccCliente.getData().getTime()));
            pst.setDouble(6, ccCliente.getValor());
            
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
    
    public boolean alterar(CcCliente ccCliente) throws Exception
    {
        PreparedStatement pst = null;
        
        try 
        {
            openConnectionOracle();     
            
            pst = con.prepareStatement("UPDATE IDS.CCCLIENTE SET " +                        
                                       "DESCRICAO = ?, " +
                                       "DC = ?, " +
                                       "VALOR = ?, " +
                                       "DATA = ? " + 
                                       "WHERE CODLCTO = ? AND CODCLIENTE = ?");
            
            pst.setString(1, ccCliente.getDescricao());
            pst.setString(2, ccCliente.getDc());
            pst.setDouble(3, ccCliente.getValor());
            pst.setDate(4, new Date(ccCliente.getData().getTime()));
            pst.setInt(5, ccCliente.getCodLcto());
            pst.setInt(6, ccCliente.getCadCliente().getCodCliente());
                
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
    
    public boolean remover(CcCliente ccCliente) throws Exception   
    {
        PreparedStatement pst = null;
        
        try 
        {
            openConnectionOracle();     
            
            pst = con.prepareStatement("DELETE FROM IDS.CCCLIENTE WHERE CODLCTO = ? AND CODCLIENTE = ?");            
                
            pst.setInt(1, ccCliente.getCodLcto());
            pst.setInt(2, ccCliente.getCadCliente().getCodCliente());
                                
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
    
    public List<CcCliente> listar(String CodCliente) throws Exception   
    {
        List<CcCliente> ListCcCliente = new ArrayList<CcCliente>();
        Statement st = null;                
        
        try 
        {
            if (!CodCliente.trim().equals(""))
            {
                openConnectionOracle();     

                st = con.createStatement();

                ResultSet rs = st.executeQuery("SELECT " +
                                               "    CCCLIENTE.CODLCTO, CCCLIENTE.CODCLIENTE, CADCLIENTE.NMCLIENTE, " + 
                                               "    CCCLIENTE.DESCRICAO, CCCLIENTE.DC, CCCLIENTE.DATA, CCCLIENTE.VALOR, " +      
                                               "    (CASE " +  
                                               "        WHEN CCCLIENTE.DC = 'C' THEN " +  
                                               "             CCCLIENTE.VALOR " + 
                                               "        ELSE 0 " + 
                                               "     END) CREDITO, " + 
                                               "    (CASE " +  
                                               "        WHEN CCCLIENTE.DC = 'D' THEN " +  
                                               "             CCCLIENTE.VALOR " + 
                                               "        ELSE 0 " + 
                                               "     END) DEBITO, " +                    
                                               "    TO_NUMBER(SUM((CASE " +  
                                               "                     WHEN CCCLIENTE.DC = 'C' THEN " +  
                                               "                          CCCLIENTE.VALOR " + 
                                               "                     ELSE 0 " +  
                                               "                   END) - " +  
                                               "                  (CASE " +  
                                               "                     WHEN CCCLIENTE.DC = 'D' THEN " +  
                                               "                          CCCLIENTE.VALOR " + 
                                               "                     ELSE 0 " + 
                                               "                   END)) OVER (ORDER BY CCCLIENTE.CODLCTO)) SALDO_DIA " +                                               
                                               "FROM IDS.CCCLIENTE " +  
                                               "INNER JOIN IDS.CADCLIENTE ON CADCLIENTE.CODCLIENTE = CCCLIENTE.CODCLIENTE " +
                                               "WHERE CCCLIENTE.CODCLIENTE = '" + CodCliente + "' " + 
                                               "ORDER BY CCCLIENTE.CODLCTO DESC ");

                while (rs.next())
                {
                    ListCcCliente.add(new CcCliente(rs.getInt("CODLCTO"), 
                                                    new CadCliente(rs.getInt("CODCLIENTE"), rs.getString("NMCLIENTE")),
                                                    rs.getString("DESCRICAO"), rs.getString("DC"), 
                                                    rs.getDate("DATA"), rs.getDouble("VALOR"), 
                                                    rs.getDouble("CREDITO"), rs.getDouble("DEBITO"), 
                                                    rs.getDouble("SALDO_DIA")));
                }
            }
            
            return  ListCcCliente;                    
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
    
    public Integer proxCodLcto() throws Exception
    {
        Statement st = null;                
                
        try 
        {
            openConnectionOracle();     
            
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT NVL((MAX(CODLCTO) + 1), 1) PROX_CODLCTO FROM IDS.CCCLIENTE");                        
            
            rs.next();
            
            return rs.getInt("PROX_CODLCTO");  
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
    
    public List<String> completeCliente(String parcialNome) throws Exception   
    {        
        List<String> ListCliente = new ArrayList<String>();
        Statement st = null;                
        
        try 
        {
            if (!parcialNome.trim().equals(""))
            {
                openConnectionOracle();     

                st = con.createStatement();

                ResultSet rs = st.executeQuery("SELECT NMCLIENTE || ' (' || CODCLIENTE || ')' CLIENTE FROM IDS.CADCLIENTE " +
                                               "WHERE UPPER(NMCLIENTE) LIKE UPPER('%" + parcialNome + "%') " +
                                               "ORDER BY NMCLIENTE ");

                while (rs.next())
                {
                    ListCliente.add(rs.getString("CLIENTE"));
                }
            }
        
            return  ListCliente;                    
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
}
