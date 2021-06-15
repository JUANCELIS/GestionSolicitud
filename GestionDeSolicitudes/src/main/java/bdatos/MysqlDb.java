/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author juand
 */
public class MysqlDb {
 
     public Connection getConnection() {
           try {
               
               String connectionString = "jdbc:mysql://localhost:3310/gestionsolicitud?user=root";
               Connection connection = DriverManager.getConnection(connectionString);
               System.out.println("Se Establecio conexión");
               return connection;
           } catch (Exception e) {
               e.getMessage();
               System.out.println("no funciona establecer conexion");
               return null;
           }
       }
}
