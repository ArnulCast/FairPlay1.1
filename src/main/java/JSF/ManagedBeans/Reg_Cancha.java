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
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Developer
 */
@Named(value = "reg_Cancha")
@RequestScoped
public class Reg_Cancha {
    String img,name;
    int capacidad,tipo,puntos;
    float valor;
    private Connection con;
    public Reg_Cancha() {
        img="";
        name="";
        img="resources/img/User.png";
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    public void sumit(int codUsre) throws ClassNotFoundException, SQLException{
        con=new Conexion().getCn();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select CodEstablecimiento from Establecimiento where CodUsuario="+codUsre);
        rs.next();
        int codE=rs.getInt(1);
        rs=st.executeQuery("select count(*) from Cancha");
        rs.next();
        int codC=rs.getInt(1)+1;
        st.execute("insertCancha "+codC+","+codE+",'"+name+"','"+img+"',"+tipo+","+valor+","+capacidad+","+puntos);
    }
}
