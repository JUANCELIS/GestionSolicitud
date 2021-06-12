/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

/**
 *
 * @author juand
 */
public class Usuario {
    
    String primerNombre;
    String segundoNombre;
    String correo;
    String contra1;
    String contra2;
    
    private static Usuario instance;
    
  public Usuario()
  {}

    public Usuario(String primerNombre, String segundoNombre, String correo, String contra1, String contra2) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.correo = correo;
        this.contra1 = contra1;
        this.contra2 = contra2;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
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

    public String getContra2() {
        return contra2;
    }

    public void setContra2(String contra2) {
        this.contra2 = contra2;
    }

    public static Usuario getInstance() {
        return instance;
    }

    public static void setInstance(Usuario instance) {
        Usuario.instance = instance;
    }
  

  
}
