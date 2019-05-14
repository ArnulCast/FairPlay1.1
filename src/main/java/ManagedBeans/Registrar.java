/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import Control.Uploader;
import Servicios.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
/**
 *
 * @author Developer
 */
@Named(value = "egistrar")
@RequestScoped
public class Registrar {
    private String Nombre,UserName,Email,Celular,Contraseña,fileContent;
    private int codUser;
    private static String path=null;
    private Part image;
    private static String load;
    private Conexion cn;
    public Registrar() throws ClassNotFoundException, SQLException {
        
        if(path==null){
                path="resources/IDataBase/User.png";
                load="hide";}
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public void setPath(String path) {
       this.path = path;
    }

    public void setImage(Part image) {
        this.image = image;
    }
    
    
 
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getPath() {
        return path;
    }

    public Part getImage() {
        return image;
    }
    
    
    public void submit() throws ClassNotFoundException, SQLException, IOException{
        String r="";
        System.out.println(image.getSubmittedFileName());
        Uploader u=new Uploader(image,UserName);
        u.upload();
        Connection con= new Conexion().getCn();
        Statement st= con.createStatement();
        ResultSet rs =st.executeQuery("select count(CodUsuario) from Usuarios");
        rs.next();
        codUser= rs.getInt(1)+1;

        st.execute("exec insertUser "+codUser+",'"+Nombre+"','"
                +UserName+"','"+Email+"','"+Celular+"','"+path+"','"+Contraseña+"',"+0+","+null );
        try {
            u.upload();
        } catch (IOException ex) {
            
        }
        
    }
    public void updateimg(){
        if(image!=null){
            if(image.getContentType().toLowerCase().endsWith(".jpg") || image.getContentType().toLowerCase().endsWith(".png")){
            
                Uploader u=new Uploader(image,image.getSubmittedFileName());
                try {
                     u.upload();
                } catch (IOException ex) {
                }
                 path=image.getSubmittedFileName();
                System.out.println(path);
                }
            
            }
    }

    public String getLoad() {
        return load;
    }

    public int getCodUser() {
        return codUser;
    }

    public void setCodUser(int codUser) {
        this.codUser = codUser;
    }

    public void setLoad(String load) {
        this.load = load;
    }
        
   public String getimg(FacesContext Fc,UIComponent C,Object Value){
       if(Value!=null){
       System.out.println(Value.toString());}
       return path;
   }
}
