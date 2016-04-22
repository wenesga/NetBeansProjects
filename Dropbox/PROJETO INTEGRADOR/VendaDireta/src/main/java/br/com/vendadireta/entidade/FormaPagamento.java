package br.com.vendadireta.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 02/04/2016 - Classe: Marca
 */
@Entity
public class FormaPagamento extends GenericEntidade {

    @Column(nullable = false, name = "Entrada")
    private Byte entrada;

    @Column(nullable = false, name = "Parcelas")
    private Byte parcela;

    @Column(length = 20, nullable = false, name = "Tipo_Pagamento")
    private String tipo;

    public Byte getEntrada() {
        return entrada;
    }

    public void setEntrada(Byte entrada) {
        this.entrada = entrada;
    }

    public Byte getParcela() {
        return parcela;
    }

    public void setParcela(Byte parcela) {
        this.parcela = parcela;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
