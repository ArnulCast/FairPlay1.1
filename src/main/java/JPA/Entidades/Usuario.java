/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.Entidades;

import JPA.Entidades.Establecimiento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Developer
 */
@Entity
@Table(name = "Usuario")
//@XmlRootElement
//@NamedQueries({
////    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
//    @NamedQuery(name = "Usuario.findByCodigo", query = "SELECT u FROM Usuario u WHERE u.codigo = :codigo")
//    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
//    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
//    , @NamedQuery(name = "Usuario.findByCelular", query = "SELECT u FROM Usuario u WHERE u.celular = :celular")
//    , @NamedQuery(name = "Usuario.findByImgPerfil", query = "SELECT u FROM Usuario u WHERE u.imgPerfil = :imgPerfil")
//    , @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a")
//    , @NamedQuery(name = "Usuario.findByReputacion", query = "SELECT u FROM Usuario u WHERE u.reputacion = :reputacion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Codigo")
    private Long codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Celular")
    private String celular;
    @Size(max = 100)
    @Column(name = "imgPerfil")
    private String imgPerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Contrase\u00f1a")
    private String contrasena;
    @Column(name = "Reputacion")
    private Short reputacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAdmin")
    private List<Establecimiento> establecimientoList;

    public Usuario() {
    }

    public Usuario(Long codigo) {
        this.codigo = codigo;
    }

   public Usuario(Long codigo, String nombre, String email, String celular, String contraseña) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
        this.celular = celular;
        this.contrasena = contraseña;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Short getReputacion() {
        return reputacion;
    }

    public void setReputacion(Short reputacion) {
        this.reputacion = reputacion;
    }

    @XmlTransient
    public List<Establecimiento> getEstablecimientoList() {
        return establecimientoList;
    }

    public void setEstablecimientoList(List<Establecimiento> establecimientoList) {
        this.establecimientoList = establecimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Control.Usuario[ codigo=" + codigo + " ]";
    }
    
}
