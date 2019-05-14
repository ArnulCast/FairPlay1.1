/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Developer
 */
@Entity
@Table(name = "Usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JPA_Usuario.findAll", query = "SELECT j FROM JPA_Usuario j")
    , @NamedQuery(name = "JPA_Usuario.findByCodigo", query = "SELECT j FROM JPA_Usuario j WHERE j.codigo = :codigo")
    , @NamedQuery(name = "JPA_Usuario.findByNombre", query = "SELECT j FROM JPA_Usuario j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "JPA_Usuario.findByEmail", query = "SELECT j FROM JPA_Usuario j WHERE j.email = :email")
    , @NamedQuery(name = "JPA_Usuario.findByImgPerfil", query = "SELECT j FROM JPA_Usuario j WHERE j.imgPerfil = :imgPerfil")
    , @NamedQuery(name = "JPA_Usuario.findByContrase\u00f1a", query = "SELECT j FROM JPA_Usuario j WHERE j.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "JPA_Usuario.findByReputacion", query = "SELECT j FROM JPA_Usuario j WHERE j.reputacion = :reputacion")})
public class JPA_Usuario implements Serializable {

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
    @Size(max = 100)
    @Column(name = "imgPerfil")
    private String imgPerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Contrase\u00f1a")
    private String contraseña;
    @Column(name = "Reputacion")
    private Short reputacion;
    @Basic (optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Celular")
    private String Celular;
    public JPA_Usuario() {
    }

    public JPA_Usuario(Long codigo) {
        this.codigo = codigo;
    }

    public JPA_Usuario(Long codigo, String nombre, String email, String contraseña) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
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

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Short getReputacion() {
        return reputacion;
    }

    public void setReputacion(Short reputacion) {
        this.reputacion = reputacion;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
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
        if (!(object instanceof JPA_Usuario)) {
            return false;
        }
        JPA_Usuario other = (JPA_Usuario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Entidades.JPA_Usuario[ codigo=" + codigo + " ]";
    }
    
}
