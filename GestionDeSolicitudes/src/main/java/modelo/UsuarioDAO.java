/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bdatos.Conexion;
import bdatos.Conexion2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {

    public void create(Usuario user) {
        Conexion2 mysqlDb = new Conexion2();
        Connection connection = mysqlDb.conectar();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO usuario VALUES (?,?,?,?)");
            statement.setString(1, user.getNombre());
            statement.setString(2, user.getApellido());
            statement.setString(3, user.getCorreo());
            statement.setString(4, user.getContra1());
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> read() throws Exception {
        ArrayList<Usuario> usuarios = new ArrayList();
        Conexion2 mysqlDb = new Conexion2();
        Connection connection = mysqlDb.conectar();
        try {

            String sql = "SELECT * FROM usuario";
            PreparedStatement setencia = connection.prepareStatement(sql);
            ResultSet resultado = setencia.executeQuery(sql);

            while (resultado.next()) {
                System.out.println("entro al while");
                usuarios.add(new Usuario(
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("correo"),
                        resultado.getString("clave")));
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error en read usuarioDao" + connection);

        }
        return usuarios;
    }

    public void update(Usuario user) {

        Conexion2 mysqlDb = new Conexion2();
        Connection connection = mysqlDb.conectar();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE usuario SET name = ?, last_name=?, password = ?WHERE correo_user = ?");
            statement.setString(1, user.getNombre());
            statement.setString(2, user.getApellido());
            statement.setString(3, user.getContra1());
            statement.setString(4, user.getCorreo());
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String correo_user) {
        Conexion mysqlDb = new Conexion();
        Connection connection = mysqlDb.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM usuario WHERE correo_user=?");
            statement.setString(1, correo_user);
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
