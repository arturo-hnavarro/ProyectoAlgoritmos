package dominio;


import TDA.lista.ListaEnlazada;
import java.io.Serializable;

/**
 *
 * @author Arturo
 */
public class Agencia implements Serializable {

    private int codigo;
    private String nombre;
    private String ubicacion;
    private ListaEnlazada telefonos;
    private String correo;
    private ListaEnlazada aerolineas;
    private static int consecutivo = 1;

    public Agencia() {
    }

    public Agencia(String nombre, String ubicacion, ListaEnlazada telefonos, String correo, ListaEnlazada aerolineas) {
        this.codigo = consecutivo++;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefonos = telefonos;
        this.correo = correo;
        this.aerolineas = aerolineas;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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

    public ListaEnlazada getAerolineas() {
        return aerolineas;
    }

    public void setAerolineas(ListaEnlazada aerolineas) {
        this.aerolineas = aerolineas;
    }

    public static int getConsecutivo() {
        return consecutivo;
    }

    public static void setConsecutivo(int consecutivo) {
        Agencia.consecutivo = consecutivo;
    }

    @Override
    public String toString() {
        return codigo + "\t" + nombre + "\t"+ ubicacion +"\t" + telefonos + "\t" + correo + "\t" + aerolineas;
    }

}
