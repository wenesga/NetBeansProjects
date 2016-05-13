/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author edson.domenech
 */
public class CadCliente 
{    
    private Integer codCliente;
    private String nmCliente;
    private String nmEndereco;
    private String nmBairro;
    private String nmCidade;
    private String nmUF;
    
    public CadCliente()
    {
        
    }

    public CadCliente(Integer codCliente, String nmCliente, String nmEndereco, String nmBairro, String nmCidade, String nmUF)
    {
        this.codCliente = codCliente;
        this.nmCliente = nmCliente;
        this.nmEndereco = nmEndereco;
        this.nmBairro = nmBairro;
        this.nmCidade = nmCidade;
        this.nmUF = nmUF;
    }
    
    public CadCliente(Integer codCliente, String nmCliente)
    {
        this.codCliente = codCliente;
        this.nmCliente = nmCliente;
    }    
    
    /**
     * @return the codCliente
     */
    public Integer getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * @return the nmCliente
     */
    public String getNmCliente() {
        return nmCliente;
    }

    /**
     * @param nmCliente the nmCliente to set
     */
    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    /**
     * @return the nmEndereco
     */
    public String getNmEndereco() {
        return nmEndereco;
    }

    /**
     * @param nmEndereco the nmEndereco to set
     */
    public void setNmEndereco(String nmEndereco) {
        this.nmEndereco = nmEndereco;
    }

    /**
     * @return the nmBairro
     */
    public String getNmBairro() {
        return nmBairro;
    }

    /**
     * @param nmBairro the nmBairro to set
     */
    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    /**
     * @return the nmCidade
     */
    public String getNmCidade() {
        return nmCidade;
    }

    /**
     * @param nmCidade the nmCidade to set
     */
    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    /**
     * @return the nmUF
     */
    public String getNmUF() {
        return nmUF;
    }

    /**
     * @param nmUF the nmUF to set
     */
    public void setNmUF(String nmUF) {
        this.nmUF = nmUF;
    }
    
    
}
