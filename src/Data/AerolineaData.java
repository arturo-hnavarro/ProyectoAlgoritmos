package Data;

import Domain.Aerolinea;
import Tda.Listas.ListaEnlazada;
import Tda.Listas.ListaException;

/**
 *
 * @author Arturo
 */
public class AerolineaData {

    ListaEnlazada aerolineas;

    public AerolineaData() {
        this.aerolineas = new ListaEnlazada();
    }

    public void agregarAerolinea(Aerolinea aerolinea) throws ListaException {

        if (existe(aerolinea.getCodigo(), aerolinea.getNombre())) {
            aerolineas.insertar(aerolinea); //TODO insertar ordenado
        }

    }//agregarAerolinea

    public boolean existe(int codigo, String nombre) throws ListaException {
        if (aerolineas.isEmpty()) {
            return false;
        }
        int n = aerolineas.getSize();
        for (int i = 1; i <= n; i++) {
            Aerolinea aerolinea = (Aerolinea) aerolineas.getNodo(i).elemento;
            if (aerolinea.getCodigo() == codigo && aerolinea.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void eliminarAerolinea(Aerolinea aerolinea) throws ListaException {
        if (aerolineas.isEmpty()) {
            return;
        }
        int n = aerolineas.getSize();
        for (int i = 1; i <= n; i++) {
            Aerolinea aerolineaActual = (Aerolinea) aerolineas.getNodo(i).elemento;
            if (aerolinea.getCodigo() == aerolineaActual.getCodigo()
                    && aerolinea.getNombre().equalsIgnoreCase(aerolineaActual.getNombre())) {
                aerolineas.suprimir(aerolinea);
            }
        }
    }

    public void modificarAerolinea(Aerolinea aerolineaModificada, int codigo, String nombre) throws ListaException {
        if (aerolineas.isEmpty()) return;
        int n = aerolineas.getSize();
        for (int i = 1; i <= n; i++) {
            Aerolinea aerolineaActual = (Aerolinea) aerolineas.getNodo(i).elemento;
            if (aerolineaActual.getCodigo() == codigo &&
                aerolineaActual.getNombre().equalsIgnoreCase(nombre)) {
                //Elimino la aerolínea de la lista
                aerolineas.suprimir(aerolineaActual);
                aerolineaActual.setNombre(aerolineaModificada.getNombre());
                aerolineaActual.setSitioWeb(aerolineaModificada.getSitioWeb());
//                aerolineaActual.setTelefonos(aerolineaModificada.getTelefonos());
                aerolineaActual.setCorreo(aerolineaModificada.getCorreo());
                aerolineas.insertar(aerolineaActual);
                return;
            }
        }
    }
    
    public ListaEnlazada obtenerTodasLasAerolineas(){
        return aerolineas;
    }
}