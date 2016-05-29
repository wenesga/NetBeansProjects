package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 02/04/2016 - Classe: Categoria
 */
@Entity
public class Comentario extends GenericEntidade {

    @Column(length = 100)
    private String comentario;

    
    
    
    
    
    public String getNome() {
        return comentario;
    }

    public void setNome(String comentario) {
        this.comentario = comentario;
    }
}
