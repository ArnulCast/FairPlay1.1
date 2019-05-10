/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Developer
 */
@Entity
@Table (name="Usuarios")
public class ME_Usuario implements Serializable {

    private String UserName,Celular,Email,PassWord,ImgPerfil,Roll;
    private short Reputacion;
    private int Codigo;
    private String Reservas;//Lista de reservas 
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ME_Usuario)) {
            return false;
        }
        ME_Usuario other = (ME_Usuario) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.ME_Usuario[ id=" + id + " ]";
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getImgPerfil() {
        return ImgPerfil;
    }

    public void setImgPerfil(String ImgPerfil) {
        this.ImgPerfil = ImgPerfil;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String Roll) {
        this.Roll = Roll;
    }

    public short getReputacion() {
        return Reputacion;
    }

    public void setReputacion(short Reputacion) {
        this.Reputacion = Reputacion;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getReservas() {
        return Reservas;
    }

    public void setReservas(String Reservas) {
        this.Reservas = Reservas;
    }
    
}
