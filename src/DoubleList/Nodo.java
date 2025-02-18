package DoubleList;

public class Nodo {

    Integer info;   //Información o valor que contiene el Nodo
    Nodo next;      //Apuntador al siguiente Nodo
    Nodo prev;      //Apuntador al Nodo previo.


    //Constructora de la clase Nodo. Crea un nuevo Nodo con el valor que se le ha pasado como parametro (Sin apuntadores).
    public Nodo (Integer info){
        this.info = info;
        this.next = null;
        this.prev = null;
    }
}
