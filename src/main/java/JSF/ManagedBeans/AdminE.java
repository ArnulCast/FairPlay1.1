/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF.ManagedBeans;

import Modelos.Cancha;
import Servicios.Conexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Developer
 */
@Named(value = "adminE")
@ViewScoped
public class AdminE  implements Serializable{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int cod;
      String vista[]=new String[4];
    private  ArrayList<Cancha> show;
    private String Stipo,Ename;
    public AdminE() throws ClassNotFoundException, SQLException {
        con=new Conexion().getCn();
        st=con.createStatement();
        Estadisticas();
    }

    
    public String getEname() {
        return Ename;
    }
    
    public void setEname(String Ename) {
        this.Ename = Ename;
    }

    public String getStipo() {
        return Stipo;
    }

    public void setStipo(String Stipo) {
        this.Stipo = Stipo;
    }

    public ArrayList<Cancha> getShow() {
        return show;
    }

    public void setShow(ArrayList<Cancha> show) {
        this.show = show;
    }

    
    public void Estadisticas(){
        vista[0] = "hide";
        vista[1] = "hide";
        vista[2] = "hide";
        vista[3] = "hide";
    }
    public void Canchas() throws ClassNotFoundException, SQLException{
        vista[0] = "hide";
        vista[1] = "hide";
        vista[2] = "";
        vista[3] = "hide";
        this.ListCanchas();
    }
    public void Reservas(){
        vista[0] = "hide";
        vista[1] = "";
        vista[2] = "hide";
        vista[3] = "hide";
    }
    public void MiLocal(){
        vista[0] = "hide";
        vista[1] = "hide";
        vista[2] = "hide";
        vista[3] = "";
    }
    




    public String[] getVista() {
        return vista;
    }

    public void setVista(String[] vista) {
        this.vista = vista;
    }
    public void ListCanchas() throws ClassNotFoundException, SQLException{
        rs=st.executeQuery("exec cCanchaDesUsuario @Codu="+cod);
        Cancha Ca;
        show=new ArrayList();
        while(rs.next()){
            Ca=new Cancha();
            Ca.setCod(rs.getInt(1));
            Ca.setName(rs.getString(2));
            Ca.setImg(rs.getString(3));
            Ca.setTipo(rs.getInt(4));
            Ca.setStipo(evalue(Ca.getTipo()));
            Ca.setPrecioHOra(rs.getFloat(5));
            Ca.setCapacida(rs.getInt(6));
            Ca.setPuntuacion(rs.getInt(7));
            show.add(Ca);
        }
        
    }
    public String evalue(int Dato){
        switch (Dato){
            case 1:
                return "Futbol 11";
            case 2:
                return "Futbol 9";
            case 3:
                return "Futbol 7";
            case 4: 
                return "Futbol 5";
        }
        return null;
    }

 public void setCode(int codigo) throws SQLException{
     cod=codigo;
     rs=st.executeQuery("exec nameEst @Codu="+cod);
     rs.next();
     Ename=rs.getString(1);
 }   
}
