/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juand
 */
public class Consultas extends Conexion2 {

    public boolean registrar(int id, int tipousuario, String nombre, String apellido, String correo, String clave, String tipodocumento) {

        PreparedStatement pst = null;

        try {

            String consulta = "INSERT INTO usuario (id, tipousuario, nombre, apellido, correo, clave, tipodocumento) VALUES ('?', '2', '?', '?', '?', '?', '?');";

            pst = conectar().prepareStatement(consulta);

            pst.setInt(1, id);
            pst.setInt(2, tipousuario);
            pst.setString(3, nombre);
            pst.setString(4, apellido);
            pst.setString(5, correo);           
            pst.setString(6, clave);
            pst.setString(7, tipodocumento);

            if (pst.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("error al guardar " + ex);
           
        }
        {
            try {

                if (conectar() != null) {
                    conectar().close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (SQLException e) {
                System.out.println("error " + e);

            }
            return false;
        }
    }

    public static void main(String[] args) {

        Consultas con = new Consultas();
        System.out.println(con.registrar(1, 2, "rayo", "maquuin", "rayo@gmail.com", "12344", "cc"));

    }
}
