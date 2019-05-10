/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Developer
 */
public class Conexion {
    private static Connection cn=null;
    public Conexion() throws ClassNotFoundException, SQLException{
        this.conectar();                    
    }
    public void conectar() throws ClassNotFoundException,SQLException{
         if(cn==null){
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://DEVELOPER-PC:1433;databaseName=PROAULA;user=Cliente;password=1234");
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
}
