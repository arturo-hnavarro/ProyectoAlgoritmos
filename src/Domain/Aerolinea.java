package Domain;

import Tda.ListaEnlazada;

/**
 *
 * @author Arturo
 */
public class Aerolinea {
    private static int consecutivo=0;
    private int codigo;
    private String nombre;
    private String sitioWeb;
    private ListaEnlazada telefonos;
    private String correo; //Contáctenos

    public Aerolinea() {
    }

    public Aerolinea(String nombre, String sitioWeb, ListaEnlazada telefonos, String correo) {
        this.codigo = ++consecutivo;
        this.nombre = nombre;
        this.sitioWeb = sitioWeb;
        this.telefonos = telefonos;
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

    public ListaEnlazada getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ListaEnlazada telefonos) {
        this.telefonos = telefonos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
