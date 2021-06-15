/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import bdatos.MysqlDb;
import java.util.ArrayList;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author juand
 */
public class DemoDb {
    public static void main(String[] args) {
        
        testUsuario();
    
    }
     public static void testUsuario(){
        UsuarioDAO user = new UsuarioDAO();
        ArrayList<Usuario> users = new ArrayList();
        users = user.read();
        for(Usuario aux:users){
            System.out.println(aux.toString());
        }
    }
}
