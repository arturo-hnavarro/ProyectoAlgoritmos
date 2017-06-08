/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;


public class Aerolinea implements Serializable{
    private int  codigo;
    private String nombre;
    private String sitioWeb;
    private String telefono;
    private String correo;

    public Aerolinea() {
    }
    
    public Aerolinea(int codigo, String nombre, String sitioWeb, String telefono, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sitioWeb = sitioWeb;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return codigo + "\t" + nombre + "\t"  + sitioWeb + "\t"  + telefono + "\t"  + correo;
    }
    
   
}   

