/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Control.Contro_Usuario;
import Modelos.Usuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Developer
 */
@Named(value = "registrar")
@RequestScoped
public class MB_Registrar {

   private double Codigo;
   private String Nombre,Email,ImgPerfil,Contraseña,confirmarcontraseña,celular;
   private short Reputacion;
   private Usuario User;
   private boolean acepto;
   private Control.Contro_Usuario Cu;
    
   public MB_Registrar(){
       this.ImgPerfil="resources/img/User.png";
    }

   public void submit() throws Exception{
       System.out.println("hey entre");
       Cu=new Contro_Usuario();
       Cu.crearUsuario(Nombre, Email, ImgPerfil, Contraseña, celular);
   }
   
   
   
   
    public String getCelular() {
        return celular;
    }

    
    
    
//
//    public void submit() throws ClassNotFoundException, SQLException, IOException{
//        String r="";
//        System.out.println(image.getSubmittedFileName());
//        Uploader u=new Uploader(image,UserName);
//        u.upload();
//        Connection con= new Conexion().getCn();
//        Statement st= con.createStatement();
//        ResultSet rs =st.executeQuery("select count(CodUsuario) from Usuarios");
//        rs.next();
//        codUser= rs.getInt(1)+1;
//
//        st.execute("exec insertUser "+codUser+",'"+Nombre+"','"
//                +UserName+"','"+Email+"','"+Celular+"','"+path+"','"+Contraseña+"',"+0+","+null );
//        try {
//            u.upload();
//        } catch (IOException ex) {
//            
//        }
//        
//    }
//    public void updateimg(){
//        if(image!=null){
//            if(image.getContentType().toLowerCase().endsWith(".jpg") || image.getContentType().toLowerCase().endsWith(".png")){
//            
//                Uploader u=new Uploader(image,image.getSubmittedFileName());
//                try {
//                     u.upload();
//                } catch (IOException ex) {
//                }
//                 path=image.getSubmittedFileName();
//                System.out.println(path);
//                }
//            
//            }
//    }
//
//    public String getLoad() {
//        return load;
//    }
//
//    public int getCodUser() {
//        return codUser;
//    }
//
//    public void setCodUser(int codUser) {
//        this.codUser = codUser;
//    }
//
//    public void setLoad(String load) {
//        this.load = load;
//    }
//        
//   public String getimg(FacesContext Fc,UIComponent C,Object Value){
//       if(Value!=null){
//       System.out.println(Value.toString());}
//       return path;
//   }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public double getCodigo() {
        return Codigo;
    }

    public void setCodigo(double Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getImgPerfil() {
        return ImgPerfil;
    }

    public void setImgPerfil(String ImgPerfil) {
        this.ImgPerfil = ImgPerfil;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getConfirmarcontraseña() {
        return confirmarcontraseña;
    }

    public void setConfirmarcontraseña(String confirmarcontraseña) {
        this.confirmarcontraseña = confirmarcontraseña;
    }

    public short getReputacion() {
        return Reputacion;
    }

    public void setReputacion(short Reputacion) {
        this.Reputacion = Reputacion;
    }

    public boolean isAcepto() {
        return acepto;
    }

    public void setAcepto(boolean acepto) {
        this.acepto = acepto;
    }
}
