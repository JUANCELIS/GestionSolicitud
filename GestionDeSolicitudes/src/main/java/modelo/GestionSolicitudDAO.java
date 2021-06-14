/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bdatos.MysqlDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class GestionSolicitudDAO {

    public void create(GestionSolicitud solicitud) {
        MysqlDb mysqlDb = new MysqlDb();
        Connection connection = mysqlDb.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO gestionsolicitud VALUES (?,?,?)");
            statement.setString(1, solicitud.getEstadoSolicitud());
            statement.setString(2, solicitud.getRespuestaSolicitud());
            statement.setString(3, solicitud.getNombreAdministrador());
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<GestionSolicitud> read() {
        ArrayList<GestionSolicitud> solicitudes = new ArrayList();
        MysqlDb mysqlDb = new MysqlDb();
        Connection connection = mysqlDb.getConnection();
        try {
            String sql = "SELECT * FROM gestionsolicitud";
            Statement setencia = connection.prepareStatement(sql);
            ResultSet resultado = setencia.executeQuery(sql);
            while (resultado.next()) {
                solicitudes.add(new GestionSolicitud(
                        resultado.getInt("idsolicitud"),
                        resultado.getString("estadosolicitud"),
                        resultado.getString("respuestasolicitud"),
                        resultado.getString("administrador")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return solicitudes;
    }

    public void update(GestionSolicitud solicitud) {

        MysqlDb mysqlDb = new MysqlDb();
        Connection connection = mysqlDb.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE gestionsolicitud SET estadosolicitud = ?, respuestasolicitud = ?, administrador = ? WHERE idsolicitud = ?");
            statement.setString(1, solicitud.getEstadoSolicitud());
            statement.setString(2, solicitud.getRespuestaSolicitud());
            statement.setString(3, solicitud.getNombreAdministrador());
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        MysqlDb mysqlDb = new MysqlDb();
        Connection connection = mysqlDb.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM gestionsolicitud WHERE idsolicitud=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
