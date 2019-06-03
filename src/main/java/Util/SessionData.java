/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import JPA.Control.UsuarioJpaController;
import JPA.Entidades.Usuario;

/**
 *
 * @author Developer
 */
public class SessionData {
     private UsuarioJpaController Cu;
    private boolean loged=false;
    private Usuario User;
    
    public SessionData(){
       
    }
    public static SessionData crearSessionData(){
        return new SessionData();
    }
    
    public boolean initSesion(String TryEmail,String TryPass){
        Cu=new  UsuarioJpaController();
        this.resetUser();
        User=Cu.FindByString(TryEmail,TryPass);
        if(User!=null){
            this.loged=true;
            return true;
        }
        this.resetUser();
        return false;
    }
    public void outSesion(){
        this.resetUser();
        loged=false;
    }
    public void resetUser(){
        User=new Usuario();
        User.setCodigo((long) 0);
        User.setCelular("");
        User.setContrasena("");
        User.setEmail("");
        User.setEstablecimientoList(null);
        User.setImgPerfil("");
        User.setNombre("");
        User.setReputacion((short)0);
    }
    

    public String text(){
        return "";
    }
   
  
     public Long getCodigo() {
        return User.getCodigo();
    }

    public void setCodigo(Long codigo) {
        User.setCodigo(codigo);
    }

    public String getNombre() {
        return User.getNombre();
    }

    public void setNombre(String nombre) {
        User.setNombre(nombre);
    }

    public String getEmail() {
        return User.getEmail();
    }

    public void setEmail(String email) {
        User.setEmail(email);
    }

    public String getCelular() {
       return User.getCelular();
    }

    public void setCelular(String celular) {
        User.setCelular(celular);
    }

    public String getImgPerfil() {
        return User.getImgPerfil();

    }

    public void setImgPerfil(String imgPerfil) {
        User.setImgPerfil(imgPerfil);
    }

    public Short getReputacion() {
        return User.getReputacion();
    }

    public boolean getLoged() {
        return loged;
    }

    public void setLoged(boolean loged) {
        this.loged = loged;
    }

}
