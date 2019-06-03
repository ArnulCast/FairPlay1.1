/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF.ManagedBeans;

import JPA.Control.EstablecimientoJpaController;
import JPA.Control.ServiciosJpaController;
import JPA.Control.UbicacionJpaController;
import JPA.Control.UsuarioJpaController;
import JPA.Entidades.Establecimiento;
import JPA.Entidades.Servicios;
import JPA.Entidades.Ubicacion;
import JPA.Entidades.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Developer
 */
@Named(value = "reg_Est")
@RequestScoped
public class Reg_Est {
    
    private Integer codigo;
    private String nombre;
    private String telefono;
    private String descripcion;
    private long codAdmin;
    private UsuarioJpaController Cu;

    private Boolean wifi;
    private Boolean parking;
    private Boolean alquiler;
    private Boolean venta;
    private String obsequios;
    private String diaS1,diaS2;
    private String horario1,horario2;
    private float latitud,longitud;
    
    /** Entidades*/
    private Establecimiento estb;
    private Servicios servicio;
    private Ubicacion ubicacion;
    
    //Controladores
    private ServiciosJpaController Sc;
    private EstablecimientoJpaController Ec;
    private UbicacionJpaController ubc;
    
    public void submit(long CodUser) throws ClassNotFoundException, SQLException, Exception{
        this.crearEstb(CodUser);
        this.CrearUbicacion();
        this.crearServicio();

    }
    private Servicios crearServicio() throws Exception{
        servicio=new Servicios(this.codigo,this.wifi,this.parking,this.alquiler,this.venta,this.obsequios);
        Sc= new ServiciosJpaController();
        try {
            Sc.create(servicio);
            return servicio;
        } catch (Exception ex) {
            throw ex;
        } 
        
    }
    private Ubicacion CrearUbicacion() throws Exception{
        ///agregar condicion por que null es permitido
        ubicacion=new Ubicacion(this.codigo,latitud,longitud);
        ubc=new UbicacionJpaController();
        try {
            ubc.create(ubicacion);
            return ubicacion;
        } catch (Exception ex) {
            throw ex;
            
        }
        
    }
    private void crearEstb(long idUser){
        Ec=new EstablecimientoJpaController();
        this.codigo=Ec.getEstablecimientoCount()+1;
        Cu=new UsuarioJpaController();
        estb =new Establecimiento(this.codigo,idUser,this.nombre,this.telefono,this.diaS1+this.diaS2,this.horario1+this.horario2,this.descripcion);
        try {
            Ec.create(estb);
        } catch (Exception ex) {
            Logger.getLogger(Reg_Est.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    
    
    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setCodAdmin(int codAdmin) {
        this.codAdmin = codAdmin;
    }

    public long getCodAdmin() {
        return codAdmin;
    }

    public void setCodAdmin(long codAdmin) {
        this.codAdmin = codAdmin;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Boolean getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Boolean alquiler) {
        this.alquiler = alquiler;
    }

    public Boolean getVenta() {
        return venta;
    }

    public void setVenta(Boolean venta) {
        this.venta = venta;
    }

    public String getObsequios() {
        return obsequios;
    }

    public void setObsequios(String obsequios) {
        this.obsequios = obsequios;
    }

    public String getDiaS1() {
        return diaS1;
    }

    public void setDiaS1(String diaS1) {
        this.diaS1 = diaS1;
    }

    public String getDiaS2() {
        return diaS2;
    }

    public void setDiaS2(String diaS2) {
        this.diaS2 = diaS2;
    }

    public String getHorario1() {
        return horario1;
    }

    public void setHorario1(String horario) {
        this.horario1 = horario;
    }
    
     public String getHorario2() {
        return horario2;
    }

    public void setHorario2(String horario) {
        this.horario2 = horario;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }
}
