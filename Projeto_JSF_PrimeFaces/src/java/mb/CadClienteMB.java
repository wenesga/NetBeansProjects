/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.CadClienteDAO;
import entidade.CadCliente;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author edson.domenech
 */
@ManagedBean
@SessionScoped
public class CadClienteMB {

    private CadCliente cadCliente;
    private CadClienteDAO cadClienteDAO;    
    private List<CadCliente> listCadCliente;
    private boolean addNewReg;
    private boolean showMsgErros;    
    
    public CadClienteMB() throws Exception
    {        
        this.showMsgErros = false;    
        this.cadClienteDAO = new CadClienteDAO();                
        atualizaList();
    }
    
    public List<CadCliente> listar() throws SQLException
    {
        return listCadCliente;
    }
    
    public int totalCliente() throws SQLException
    {
        return listCadCliente.size();
    }
    
    private void atualizaList() throws SQLException, Exception
    {
        listCadCliente = this.cadClienteDAO.listar();        
    }
    
    public void salvar(ActionEvent Evento) throws SQLException, Exception
    {
        try
        {   
            if (addNewReg)
            {
                this.cadCliente.setCodCliente(this.cadClienteDAO.proxCodCliente());
                
                if (!this.cadClienteDAO.inserir(this.cadCliente))
                {
                    this.showMsgErros = true;
                }
            }
            else
            {
                if (!this.cadClienteDAO.alterar(this.cadCliente))
                {
                    this.showMsgErros = true;
                }
            }        
        }
        finally
        {
            atualizaList();
        }
    }    

    public void remover(ActionEvent Evento) throws SQLException, Exception
    {
        try
        {
            if (!this.cadClienteDAO.remover(this.cadCliente))
            {
                this.showMsgErros = true;
            }
        }
        finally
        {
            atualizaList();
        }
    }   
    
    public CadCliente getCadCliente() 
    {
        return cadCliente;
    }

    public void setCadCliente(CadCliente cadCliente) 
    {
        refresh();
        
        this.showMsgErros = false;
        
        if (cadCliente == null)
        {
            this.cadCliente = new CadCliente();                        
            this.cadCliente.setNmUF("SC");            
        }
        else
        {        
            this.cadCliente = cadCliente;
        }   
    }

    public boolean isShowMsgErros() 
    {
        return showMsgErros;
    }

    public void setShowMsgErros(boolean showMsgErros) 
    {
        this.showMsgErros = showMsgErros;
    }

    public boolean isAddNewReg() 
    {
        return addNewReg;
    }

    public void setAddNewReg(boolean addNewReg) 
    {
        this.addNewReg = addNewReg;          
    }
    
    public void refresh() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse(); //Optional
    }
}
