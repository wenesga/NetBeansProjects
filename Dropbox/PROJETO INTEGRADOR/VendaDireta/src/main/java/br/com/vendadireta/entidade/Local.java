package br.com.vendadireta.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Cometario:  
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date   01/05/2016 - Classe: Local
 */
@Entity
public class Local extends GenericEntidade{

    @Column(length = 100, nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private double latitude;
    
    @Column(nullable = false)
    private double longitude;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    } 
}
