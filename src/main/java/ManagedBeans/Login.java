/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Modelos.Usuario;
import Servicios.Conexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author Developer
 */
@Named(value = "login")
@RequestScoped
public class Login implements Serializable{

    /**
     * Creates a new instance of Login
     */
     private Connection con;
    public Login() throws ClassNotFoundException, SQLException {
        con=new Conexion().getCn();
    }
     private int CodUser;
    private String User,Pass;
    private Usuario ObjUser;
    private String u,p=null;
     public void existen(FacesContext Fc,UIComponent C,Object Value)throws ClassNotFoundException, SQLException{
         
         if(C.getId().equals("name")){
             u=(String) Value;
         }else if(C.getId().equals("pass")){
             p=(String) Value;
         }
         if(u!=null && this.p!=null){
            this.consultar(u, p);
            u=null;
            p=null;
            if(ObjUser==null){
            ((UIInput)C).setValid(false);
            FacesMessage Msg= new FacesMessage("Usuario o contraseña incorrecta");
            Fc.addMessage(C.getClientId(Fc), Msg);}
            }
     }
     public void consultar(String user,String pass) throws ClassNotFoundException, SQLException{
         ObjUser=new Usuario();
         try{
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from Usuarios where UserName='"+user+"' and Contraseña='"+pass+"';");
           
         }catch(SQLException e){
            ObjUser=null;
         }
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

    public Usuario getObjUser() {
        return ObjUser;
    }

    public void setObjUser(Usuario ObjUser) {
        this.ObjUser = ObjUser;
    }
     
}
