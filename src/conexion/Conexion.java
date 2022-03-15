 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    private static Connection cn =null;
    
    private static void conectar(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";  //@equipo>puerto>Servicio
            cn = DriverManager.getConnection(url,"ot","ot");
            System.out.println("conectando");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }

    public static Connection getConnection() {
        if (cn==null){
            conectar();   
        }
        return cn;
    }
    
    public static void desconectar() {
        if (cn!=null) {
            try {
                if (cn.isClosed()==false) {
                    cn.close();
                }
               } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }    
    
    
}
