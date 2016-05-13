package mb;

import dao.CcClienteDAO;
import entidade.CadCliente;
import entidade.CcCliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author edson.domenech
 */
@ManagedBean
@SessionScoped
public class CcClienteMB 
{
    private CcCliente ccCliente;
    private CcClienteDAO ccClienteDAO;    
    private List<CcCliente> listCcCliente;
    private boolean addNewReg;
    private boolean showMsgErros;   
    private String clienteSel;
    private String nmClienteSel;
    
    private final String autoCompleteError = "Registro não localizado...";
    
    public CcClienteMB() throws Exception
    {
        this.clienteSel = "";
        this.nmClienteSel = "";
        this.showMsgErros = false;    
        this.ccClienteDAO = new CcClienteDAO();  
        atualizaList();
    }
    
    public List<String> completeCliente(String parcialNome) throws Exception
    {
        List<String> listCcCli = this.ccClienteDAO.completeCliente(parcialNome);
        
        if (listCcCli == null || listCcCli.isEmpty())
        {
            listCcCli = new ArrayList<String>();
            listCcCli.add(autoCompleteError);
        }
        
        return listCcCli;
    }

    public String getClienteSel() 
    {    
        return clienteSel;
    }

    public void setClienteSel(String clienteSel) 
    {
        this.clienteSel = clienteSel;
    }

    public String getNmClienteSel() 
    {
        return nmClienteSel;
    }

    public void setNmClienteSel(String nmClienteSel) throws Exception 
    {
        if (nmClienteSel == null)
        {
            clienteSel = "";
            atualizaList();
        }
        
        this.nmClienteSel = nmClienteSel;        
    }
    
    public void handleClienteSel(SelectEvent event) throws Exception 
    {       
        if (!event.getObject().toString().equals(autoCompleteError))
        {
            Integer iniCod = event.getObject().toString().lastIndexOf("(") + 1;
            Integer fimCod = event.getObject().toString().lastIndexOf(")");                
            String str = event.getObject().toString();

            setClienteSel(str.substring(iniCod, fimCod));
            setNmClienteSel(str.substring(0, iniCod-1).trim());

            atualizaList();
        }   

        //limpar o autocomplete com recurso de jQuery dentro da ManagedBean 
        RequestContext rc = RequestContext.getCurrentInstance();
        rc.execute("jQuery('#frmTblccCliente\\\\:tblccCliente\\\\:acCliente_input').val('');");        
    }      
    
    public List<CcCliente> getListar()
    {
        return listCcCliente;
    }
    
    public boolean disableBtnNovo()
    {
        if (nmClienteSel == null || nmClienteSel.trim().equals(""))
        {
            return true;
        }
        else
        {
            return false;
        }        
    }

    public int totalCcCliente()
    {
        return listCcCliente.size();
    }
    
    private void atualizaList() throws Exception
    {
        this.showMsgErros = false;
        
        listCcCliente = this.ccClienteDAO.listar(getClienteSel());           
        
        if (listCcCliente == null)
        {
            this.showMsgErros = true;
        }
    }
    
    public String colorSaldo(CcCliente c)
    {
        if (c.getSaldo_dia() < 0)
        {
            return "color: #8B0000;";
        }
        else
        {
            return "";
        }
    }    
    
    public void salvar(ActionEvent Evento) throws Exception
    {
        try
        {   
            if (addNewReg)
            {
                this.ccCliente.setCodLcto(this.ccClienteDAO.proxCodLcto());
                this.ccCliente.setCadCliente(new CadCliente(Integer.parseInt(getClienteSel()), getNmClienteSel()));
                
                if (!this.ccClienteDAO.inserir(this.ccCliente))
                {
                    this.showMsgErros = true;
                }
            }
            else
            {
                if (!this.ccClienteDAO.alterar(this.ccCliente))
                {
                    this.showMsgErros = true;
                }
            }        
        }
        finally
        {
            if (!this.showMsgErros)
            {
                atualizaList();
            }
        }
    }    
    
    public void remover(ActionEvent Evento) throws Exception
    {
        try
        {
            if (!this.ccClienteDAO.remover(this.ccCliente))
            {
                this.showMsgErros = true;
            }
        }
        finally
        {
            if (!this.showMsgErros)
            {
                atualizaList();
            }
        }
    }

    public CcCliente getCcCliente() 
    {
        return ccCliente;
    }

    public void setCcCliente(CcCliente ccCliente) 
    {
        refresh();
        
        this.showMsgErros = false;
        
        if (ccCliente == null)
        {
            this.ccCliente = new CcCliente();                        
            this.ccCliente.setDc("C");
            this.ccCliente.setData(new Date());
        }
        else
        {        
            this.ccCliente = ccCliente;
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