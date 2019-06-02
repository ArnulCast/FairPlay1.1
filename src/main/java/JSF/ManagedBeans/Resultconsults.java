/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Developer
 */
@Named(value = "resultconsult")
@ViewScoped
public class Resultconsults implements Serializable{

       private ArrayList l;
    private  ArrayList show;
    private ArrayList numbers;
    private String shown;
    private short pos;
    private int limit;
    private  int tope;
    public Resultconsults() {
         l=new ArrayList();
        show=new ArrayList();
        numbers=new ArrayList();
        for (int i=0;i<20;i++){
        l.add("Opcion "+i);}
        if(show.isEmpty()){
            pos=1;
            limit=1;
            tope=6;
            this.drawList();
            this.detNum();
           
        }
        
        
        
    }
    public String btnClick(String b){
        
        if(b.equals("Iniciar Sesion")){
            return "Login.xhtml";
        }else{
            return "Confirm.xhtml";
        } 
    }

    public ArrayList getShow() {
        return show;
    }

    public void setShow(ArrayList show) {
        this.show = show;
    }
        
        private int count=1;
    public void drawList(){
        
            show.clear();
            System.out.println("li "+ limit+" to "+tope);
            while( limit<=tope && l.size()>limit){
            show.add(l.get(limit));
            limit++;
            }
            limit=1;
            
            
    }
    
      public void previus(){
        if(pos>1){
            pos-=1;
            limit=6*pos-5;
            tope=6*pos;
            this.drawList();
        }
        
    }
    public void next(){
        if(pos<can){
            pos+=1;
            limit=6*pos-5;
            tope=6*pos;
            this.drawList();
        }
    }

    public String getShown() {
        return shown;
    }

    public void setShown(String shown) {
        this.shown = shown;
    }
    int can=1;
    private void detNum(){
        can=(int)l.size()/tope;
        if(can>1){
            if(l.size()%tope>0){
                can=can+1;
            }
        for (int i=1;i<=can;i++){
            numbers.add(i);
        }
        shown="";
        }else{
            shown="hide";
            
        }
    }

    public ArrayList getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList numbers) {
        this.numbers = numbers;
    }
    
    
  
    
    /*
    boolean tone,topre;
    public void next(){
        if(topre==true){
            count=count+tope;
        }
        this.drawList();
        tone=true;
        topre=false;
    }
    public void previus(){
        System.out.println("sadf"+count);
        if(count>tope+1){
            if(topre==true){
                count=count-tope;
            }
        count=count-tope;
        this.drawList();}
         tone=false;
         topre=true;
    }*/
    
}
