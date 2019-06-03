/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Developer
 */
@Entity
public class ListCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Codigo")
    private long CodAdmin;
    

    public long getCodAdmin() {
        return CodAdmin;
    }

    public void setCodAdmin(long CodAdmin) {
        this.CodAdmin = CodAdmin;
    }


 

 

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListCode)) {
            return false;
        }
        ListCode other = (ListCode) object;
        
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Entidades.ListCode[ id="  + " ]";
    }
    
}
