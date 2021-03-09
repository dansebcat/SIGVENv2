/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author danie
 */
public class Conexion {
    Connection con;
    String url="jdbc:mysql://localhost:3306/sigvenv1";
    String user="root";
    String password ="root";
    public Connection Conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            
        }
        return con;
    }
}
