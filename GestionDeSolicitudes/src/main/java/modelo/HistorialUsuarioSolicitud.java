/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author juand
 */
public class HistorialUsuarioSolicitud {
    private int id_solicitud;
    private Date fecha;
    private String asunto;
    private String mensaje;

    public HistorialUsuarioSolicitud(int id_solicitud, Date fecha, String asunto, String mensaje) {
        this.id_solicitud = id_solicitud;
        this.fecha = fecha;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }
    
    public HistorialUsuarioSolicitud()
    {}

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id_solicitud;
        hash = 29 * hash + Objects.hashCode(this.fecha);
        hash = 29 * hash + Objects.hashCode(this.asunto);
        hash = 29 * hash + Objects.hashCode(this.mensaje);
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
        final HistorialUsuarioSolicitud other = (HistorialUsuarioSolicitud) obj;
        if (this.id_solicitud != other.id_solicitud) {
            return false;
        }
        if (!Objects.equals(this.asunto, other.asunto)) {
            return false;
        }
        if (!Objects.equals(this.mensaje, other.mensaje)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HistorialUsuarioSolicitud{" + "id_solicitud=" + id_solicitud + ", fecha=" + fecha + ", asunto=" + asunto + ", mensaje=" + mensaje + '}';
    }
    
    
}