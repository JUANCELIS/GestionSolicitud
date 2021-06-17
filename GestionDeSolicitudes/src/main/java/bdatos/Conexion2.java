/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juand
 */
public class Conexion2 {

    String usuario = "root";
    String clave = "";
    String url = "jdbc:mysql://localhost:3310/gestionsolicitud";
    Connection con;
    Statement stmt;
    ResultSet rs;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion2.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException ex) {
            System.out.println("error al conectar: ");
            Logger.getLogger(Conexion2.class.getName()).log(Level.SEVERE, null, ex);
        }
//            stmt = con.createStatement();
//            stmt.executeUpdate("INSERT INTO usuario VALUES(null,'2','proyecto','web','gestionsolicitud@gmail.com','12345')");
//            rs = stmt.executeQuery("SELECT * FROM usuario");
//            rs.next();
//            do {
//                System.out.println(rs.getString("id")
//                        + "tipo: " + rs.getString("tipo")
//                        + "nombre: " + rs.getString("nombre")
//                        + "apellido: " + rs.getString("apellido")
//                        + "correo: " + rs.getString("correo")
//                        + "contraseña: " + rs.getString("clave"));
//            } while (rs.next());
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexion2.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return con;
    }
}
