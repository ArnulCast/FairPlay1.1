/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Developer
 */
public class Nombre implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException{
        String v=(String) value;
        if(v.length()<=6){
            throw new ValidatorException(new FacesMessage("*Debe ingresar su nombre y apellido"));    
        }
    }
    
}
