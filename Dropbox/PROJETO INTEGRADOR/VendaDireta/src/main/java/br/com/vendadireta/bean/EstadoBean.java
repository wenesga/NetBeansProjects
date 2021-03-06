package br.com.vendadireta.bean;

import br.com.vendadireta.dao.EstadoDAO;
import br.com.vendadireta.entidade.Estado;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 13/04/2016 - Classe: EstadoBean
 */
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

    private Estado estado;
    private List<Estado> estados;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    @PostConstruct
    public void listar() {
        try {
            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar os Estado");
            erro.printStackTrace();
        }
    }

    public void novo() {
        estado = new Estado();
    }

    public void salvar() {
        try {
            EstadoDAO estadoDAO = new EstadoDAO();
            estadoDAO.merge(estado);
            estado = new Estado();
            estados = estadoDAO.listar();

            Messages.addGlobalInfo("Estado salvo com sucesso!");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Estado");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
            EstadoDAO estadoDAO = new EstadoDAO();
            estadoDAO.excluir(estado);
            estados = estadoDAO.listar();

            Messages.addGlobalInfo("Estado removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar remover o Estado");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
    }
}
