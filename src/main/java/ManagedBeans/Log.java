/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Modelos.Usuario;
import Servicios.Conexion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Developer
 */
@Named(value = "log")
@SessionScoped
public class Log implements Serializable {
    private boolean loged,hasESt;
    private String Usuario;
    private String Visitante;
    private String User,Pass,Email,Nombre,Telefono;
    private String image;
    private int CodUser;
    private String admin,notAdmin;
    private String btn;
   public void submit(Usuario us) throws ClassNotFoundException, SQLException{
         User=us.getUser();
         Email=us.getEmail();
         CodUser =us.getCodUser();
         image=us.getImage();
         System.out.println(image);
        loged=true;
        us=null;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getNotAdmin() {
        return notAdmin;
    }

    public void setNotAdmin(String notAdmin) {
        this.notAdmin = notAdmin;
    }
  
    public String getUsuario() {
        return Usuario;
    }
    public String getImage() {
        return image;
    }

    public String getVisitante() {
        return Visitante;
    }
    public void close(){
        loged=false;
        this.clean();
    }
    public Log(){
        loged=false;
        Visitante="";
        Usuario="hide";
        User="";
        image="resources/img/icon.jpg";
    }

    public void onLoad() throws ClassNotFoundException, SQLException{
        if(this.loged==false){
                this.Visitante="";
                this.Usuario="hide";
                btn="Iniciar Sesion";
            }else{
                this.Visitante="hide";
                this.Usuario="";
                btn="Reservar";
        }
        String r=""; 
        if(loged==true){
        Connection con=new Conexion().getCn();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select Roll from Usuarios where CodUsuario="+CodUser);
        rs.next();
        r=rs.getString(1);
    }
    if (r!=null){
             admin="";
             notAdmin="hide";
         }else{
             admin="hide";
             notAdmin="";
         }
    }

    public String getBtn() {
        return btn;
    }

    public void setBtn(String btn) {
        this.btn = btn;
    }
    
    public boolean isLoged() {
        return loged;
    }
    
    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }  
    
    public void clean(){
        User="";
         Email="";
         Nombre="";
         CodUser =0;
         hasESt=false;
         image="resources/img/icon.jpg";
    }

    public int getCodUser() {
        return CodUser;
    }
    
    
}
