package SparseVector;

public class Nodo {
    Integer info;   //Información o valor que contiene el Nodo
    Nodo next;      //Apuntador al siguiente Nodo
    Nodo prev;      //Apuntador al Nodo previo
    Nodo  index;

    public Nodo (Integer info) {
        //this.index = index;
        this.info = info;
        this.next = null;
        this.prev = null;
    }
}
