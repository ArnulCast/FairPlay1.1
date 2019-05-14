/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Developer
 */
@Named(value = "index")
@RequestScoped
public class Index {

    private String Usuario;
    private String Visitante;
    private boolean User;
    /**
     * Creates a new instance of Index
     */
    public Index() {
        Visitante="";
        Usuario="hide";
        User=false;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getVisitante() {
        return Visitante;
    }

    public boolean isUser() {
        return User;
    }

    public void setUser(boolean User) {
        this.User = User;
    }
 
}
