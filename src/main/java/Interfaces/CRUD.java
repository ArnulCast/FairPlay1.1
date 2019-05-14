/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.ArrayList;

/**
 *
 * @author Developer
 */
public interface CRUD <T> {
    public  void Registra(String n,String p);
    public boolean Consultar(String n,String p);
    public void Eliminar();
    
    
}
