/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Developer
 */
public class Establecimiento {
       int Cod,CodU;
    String Nombre,Direccion,cel,decripcion;
    ArrayList<Integer> Canchas;
    public int getCod() {
        return Cod;
    }

    public void setCod(int Cod) {
        this.Cod = Cod;
    }

    public int getCodU() {
        return CodU;
    }

    public void setCodU(int CodU) {
        this.CodU = CodU;
    }

    public ArrayList<Integer> getCanchas() {
        return Canchas;
    }

    public void setCanchas(ArrayList<Integer> Canchas) {
        this.Canchas = Canchas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
    
}
