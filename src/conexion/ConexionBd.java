/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author BRAYAN
 */
public class ConexionBd {
    
    //PATRON SINGLETON PARA CONEXION UNICA A LA BASE DE DATOS
    
    public static Connection connection;
    
    public static Connection getConnection(){
    
        try {
            if (connection == null){
                Runtime.getRuntime().addShutdownHook(new getClose());
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://45.79.204.125:3306/control_gastos","dosys","Dosys123.!");
            }
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Conexión a la base de datos fallida",e);
        }
    }
    
    static class getClose extends Thread{
        @Override
        public void run(){
            try {
                Connection con= ConexionBd.getConnection();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            
        }


    }
    
}
