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
public class HistorialUsuarioSolicitudDAO {

    public void create(HistorialUsuarioSolicitud solicitud) {
        MysqlDb mysqlDb = new MysqlDb();
        Connection connection = mysqlDb.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO hisotialusuario VALUES (?,?,?,?)");
            statement.setInt(1, solicitud.getId_solicitud());
            statement.setDate(2, solicitud.getFecha());
            statement.setString(3, solicitud.getAsunto());
            statement.setString(4, solicitud.getMensaje());
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HistorialUsuarioSolicitud> read() {
        ArrayList<HistorialUsuarioSolicitud> solicitudes = new ArrayList();
        MysqlDb mysqlDb = new MysqlDb();
        Connection connection = mysqlDb.getConnection();
        try {
            String sql = "SELECT * FROM historialinventario";
            Statement setencia = connection.prepareStatement(sql);
            ResultSet resultado = setencia.executeQuery(sql);
            while (resultado.next()) {
                solicitudes.add(new HistorialUsuarioSolicitud(resultado.getInt("idsolicitud"),
                        resultado.getDate("fecha"),
                        resultado.getString("asunto"),
                        resultado.getString("mensaje")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return solicitudes;
    }
     public ArrayList<HistorialUsuarioSolicitud> read(int id) {
        ArrayList<HistorialUsuarioSolicitud> solicitudes = new ArrayList();
        MysqlDb mysqlDb = new MysqlDb();
        Connection connection = mysqlDb.getConnection();
        try {
            String sql = "SELECT * FROM historialinventario WHERE idoslicitud = "+id;
            Statement setencia = connection.prepareStatement(sql);
            ResultSet resultado = setencia.executeQuery(sql);
            while (resultado.next()) {
                solicitudes.add(new HistorialUsuarioSolicitud(resultado.getInt("idsolicitud"),
                        resultado.getDate("fecha"),
                        resultado.getString("asunto"),
                        resultado.getString("mensaje")));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return solicitudes;
    }
    public void update(HistorialUsuarioSolicitud solicitud) {

        MysqlDb mysqlDb = new MysqlDb();
        Connection connection = mysqlDb.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE usuario SET fecha = ?, asunto=?, mensaje = ? WHERE idsolicitud = ?");
            statement.setDate(1, solicitud.getFecha());
            statement.setString(2, solicitud.getAsunto());
            statement.setString(3, solicitud.getMensaje());
            statement.setInt(4, solicitud.getId_solicitud());
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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM hisorialusuario WHERE idsolicitud=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
