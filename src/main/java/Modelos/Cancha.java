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
public class Cancha {
 private int Cod,CodE,tipo,Capacida,Puntuacion;
 private float precioHOra;
 private String img,name,Stipo;
    
    public String getStipo() {
        return Stipo;
    }

    public void setStipo(String Stipo) {
        this.Stipo = Stipo;
    }

    public int getCod() {
        return Cod;
    }

    public void setCod(int Cod) {
        this.Cod = Cod;
    }

    public int getCodE() {
        return CodE;
    }

    public void setCodE(int CodE) {
        this.CodE = CodE;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCapacida() {
        return Capacida;
    }

    public void setCapacida(int Capacida) {
        this.Capacida = Capacida;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(int Puntuacion) {
        this.Puntuacion = Puntuacion;
    }

    public float getPrecioHOra() {
        return precioHOra;
    }

    public void setPrecioHOra(float precioHOra) {
        this.precioHOra = precioHOra;
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
 
}
