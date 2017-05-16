package Data;

import Domain.Aerolinea;
import Tda.ListaEnlazada;

/**
 *
 * @author Arturo
 */
public class AerolineaData {
    
    ListaEnlazada aerolineas;

    public AerolineaData() {
        this.aerolineas = new ListaEnlazada();
    }
    
    public void agregarAerolinea(Aerolinea aerolinea ){
        aerolineas.insertarOrdenado(aerolinea);
    }//agregarAerolinea
    
    
    
}
