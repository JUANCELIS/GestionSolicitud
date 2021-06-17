/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author juand
 */
public class Usuario {
    
    int id;
    int tipousuario;
    String nombre;
    String apellido;
    String correo;
    String contra1;
    String tipodocumento;

    
        public Usuario(int id, int tipousuario, String nombre, String apellido, String correo, String contra1, String tipodocumento) {
        this.id = id;
        this.tipousuario = tipousuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contra1 = contra1; 
        this.tipodocumento = tipodocumento;
    }
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", tipousuario=" + tipousuario + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contra1=" + contra1 +  ", tipodocumento=" + tipodocumento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + this.tipousuario;
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.apellido);
        hash = 13 * hash + Objects.hashCode(this.correo);
        hash = 13 * hash + Objects.hashCode(this.contra1);
        
        hash = 13 * hash + Objects.hashCode(this.tipodocumento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.tipousuario != other.tipousuario) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contra1, other.contra1)) {
            return false;
        }
     
        if (!Objects.equals(this.tipodocumento, other.tipodocumento)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra1() {
        return contra1;
    }

    public void setContra1(String contra1) {
        this.contra1 = contra1;
    }



    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }


  
}
