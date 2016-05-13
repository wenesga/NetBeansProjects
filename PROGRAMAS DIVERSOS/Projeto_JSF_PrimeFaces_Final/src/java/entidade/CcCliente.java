package entidade;

import java.util.Date;

/**
 *
 * @author edson.domenech
 */
public class CcCliente 
{
    private Integer codLcto;
    private CadCliente cadCliente;
    private String descricao;
    private String dc;
    private Date data;
    private double valor;
    
    private double credito;
    private double debito;
    private double saldo_dia;
    
    public CcCliente()
    {

    }

    public CcCliente(Integer codLcto, CadCliente cadCliente, String descricao, 
                     String dc, Date data, double valor,
                     double credito, double debito, double saldo_dia)
    {
        this.codLcto = codLcto;
        this.cadCliente = cadCliente;
        this.descricao = descricao;
        this.dc = dc;
        this.data = data;
        this.valor = valor;        
        
        this.credito = credito;
        this.debito = debito;
        this.saldo_dia = saldo_dia;        
    }
    
    /**
     * @return the codLcto
     */
    public Integer getCodLcto() {
        return codLcto;
    }

    /**
     * @param codLcto the codLcto to set
     */
    public void setCodLcto(Integer codLcto) {
        this.codLcto = codLcto;
    }

    /**
     * @return the codCliente
     */
    public CadCliente getCadCliente() {
        return cadCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCadCliente(CadCliente cadCliente) {
        this.cadCliente = cadCliente;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the dc
     */
    public String getDc() {
        return dc;
    }

    /**
     * @param dc the dc to set
     */
    public void setDc(String dc) {
        this.dc = dc;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public double getSaldo_dia() {
        return saldo_dia;
    }

    public void setSaldo_dia(double saldo_dia) {
        this.saldo_dia = saldo_dia;
    }
}
