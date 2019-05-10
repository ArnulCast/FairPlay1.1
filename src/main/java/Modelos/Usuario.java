/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Developer
 */
public class Usuario {
    private String User,Pass,Email,Nombre,Telefono;
    private String image;
    private int CodUser,Points;
    private boolean hasEst;

    public int getPoints() {
        return Points;
    }

    public boolean isHasEst() {
        return hasEst;
    }

    public void setHasEst(boolean hasEst) {
        this.hasEst = hasEst;
    }

    
    
    public void setPoints(int Points) {
        this.Points = Points;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCodUser() {
        return CodUser;
    }

    public void setCodUser(int CodUser) {
        this.CodUser = CodUser;
    }

    @Override
    public String toString() {
        return "Usuario{" + "User=" + User + ", Pass=" + Pass + ", Email=" + Email + ", Nombre=" + Nombre + ", Telefono=" + Telefono + ", image=" + image + ", CodUser=" + CodUser + ", Points=" + Points + '}';
    }
    
}
