package TDA.lista;

import java.io.Serializable;

public class ListaException extends Exception implements Serializable{
    //Constructor
    public ListaException(String err){
        super(err);
    }//Constructor
}