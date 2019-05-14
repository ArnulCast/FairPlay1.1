/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import JPA.Control.JPA_UsuarioJpaController;
import JPA.Entidades.JPA_Usuario;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Developer
 */
public class Contro_Usuario {
    private JPA_Usuario Ue;
   
    private EntityManagerFactory emf;
    private JPA_UsuarioJpaController em;
    public void crearUsuario(String Nombre, String Email,String ImgPerfil,String Contraseña,String Celular) throws Exception{
        Ue=new JPA_Usuario();
        Ue.setCodigo((long)(1));
        Ue.setNombre(Nombre);
        Ue.setEmail(Email);
        Ue.setImgPerfil("resources/img/User.png");
        Ue.setCelular(Celular);
        Ue.setContraseña(Contraseña);
        emf=javax.persistence.Persistence.createEntityManagerFactory("FairPlay");
        em= new JPA_UsuarioJpaController((UserTransaction) emf.createEntityManager().getTransaction(), emf);
    }
    
    
}
