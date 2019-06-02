/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF.ManagedBeans;

import Servicios.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Developer
 */
@Named(value = "reg_Est")
@RequestScoped
public class Reg_Est {
    
    private String Nombre,Telefono,Direccion,desc,Stipo;
    private Date HDOI,HDOF,HDFI,HDFF;
    private String De="",A="";
    int user,cal,cod;
    private Connection con;

    public String getDe() {
        return De;
    }

    public void setDe(String De) {
        this.De = De;
    }

    public String getA() {
        return A;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setA(String A) {
        this.A = A;
    }

    public Date getHDOI() {
        return HDOI;
    }

    public void setHDOI(Date HDOI) {
        this.HDOI = HDOI;
    }

    public Date getHDOF() {
        return HDOF;
    }

    public void setHDOF(Date HDOF) {
        this.HDOF = HDOF;
    }

    public Date getHDFI() {
        return HDFI;
    }

    public void setHDFI(Date HDFI) {
        this.HDFI = HDFI;
    }

    public Date getHDFF() {
        return HDFF;
    }

    public void setHDFF(Date HDFF) {
        this.HDFF = HDFF;
    }

    
    
    public Reg_Est() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }



    public void submit(int CodUser) throws ClassNotFoundException, SQLException{
        con=new Conexion().getCn();
        Statement st=con.createStatement();
        
        ResultSet rs=st.executeQuery("select count(*) from HoraDiasOrdinarios");
        rs.next();
        int codHDO =rs.getInt(1)+1;
        st.execute("exec insertHDO "+codHDO+","+"'"+c(HDOI)+"'"+","+"'"+c(HDOF)+"'"+","+De+","+A);
        
        rs=st.executeQuery("select count(*) from HorarioDiasFestivos");
        rs.next();
        int codHDF =rs.getInt(1)+1;
        st.execute("exec insertHDF "+codHDF+","+"'"+c(HDFI)+"'"+","+"'"+c(HDFF)+"'");
        
        rs=st.executeQuery("select count(*) from Calendario");
        rs.next();
        cal=rs.getInt(1)+1;
        st.execute("exec insertCal "+cal+","+codHDO+","+codHDF);
        
        rs=st.executeQuery("select count(*) from Establecimiento");
        rs.next();
        cod= rs.getInt(1)+1;
        st.execute("exec insertEstable "+cod+",'"+Nombre+"','"+Direccion+"',"+CodUser+",'"+Telefono+"',"+cal+",'"+desc+"'");
        st.execute("exec updateRol "+CodUser);
    }
   private Time c(Date d){
       
       return new Time(d.getTime());
   }
}
