/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.http.Part;

/**
 *
 * @author Developer
 */
public class Uploader {
   
    String ruta;
    private Part image;
    private String Name;

    public Uploader(Part img,String name){
        image=(Part)img;
        Name=name;
        ruta="I:\\Users\\Developer\\Documents\\TuCanchaYaIRL\\TuCancha\\web\\resources\\IDataBase";
    }
  public void upload() throws IOException{
      String path="";
      try{
        InputStream in=image.getInputStream();
        path=Name;
        Files.copy(in,new File(ruta,Name).toPath());
      }catch (Exception e){
          
      }
  }
  
}
