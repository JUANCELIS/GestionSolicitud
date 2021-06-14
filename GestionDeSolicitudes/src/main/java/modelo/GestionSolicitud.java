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
public class GestionSolicitud {

    private int id_solicitud;
    private String estadoSolicitud;
    private String respuestaSolicitud;
    private String nombreAdministrador;

    public GestionSolicitud() {
    }

    public GestionSolicitud(int id_solicitud, String estadoSolicitud, String respuestaSolicitud, String nombreAdministrador) {
        this.id_solicitud = id_solicitud;
        this.estadoSolicitud = estadoSolicitud;
        this.respuestaSolicitud = respuestaSolicitud;
        this.nombreAdministrador = nombreAdministrador;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getRespuestaSolicitud() {
        return respuestaSolicitud;
    }

    public void setRespuestaSolicitud(String respuestaSolicitud) {
        this.respuestaSolicitud = respuestaSolicitud;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id_solicitud;
        hash = 13 * hash + Objects.hashCode(this.estadoSolicitud);
        hash = 13 * hash + Objects.hashCode(this.respuestaSolicitud);
        hash = 13 * hash + Objects.hashCode(this.nombreAdministrador);
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
        final GestionSolicitud other = (GestionSolicitud) obj;
        if (this.id_solicitud != other.id_solicitud) {
            return false;
        }
        if (!Objects.equals(this.estadoSolicitud, other.estadoSolicitud)) {
            return false;
        }
        if (!Objects.equals(this.respuestaSolicitud, other.respuestaSolicitud)) {
            return false;
        }
        if (!Objects.equals(this.nombreAdministrador, other.nombreAdministrador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GestionSolicitud{" + "id_solicitud=" + id_solicitud + ", estadoSolicitud=" + estadoSolicitud + ", respuestaSolicitud=" + respuestaSolicitud + ", nombreAdministrador=" + nombreAdministrador + '}';
    }

}
