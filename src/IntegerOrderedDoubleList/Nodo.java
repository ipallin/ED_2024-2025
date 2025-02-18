package IntegerOrderedDoubleList;

public class Nodo {
    Integer info; // Establecer tipo de valor
    Nodo next;
    Nodo prev;

    public Nodo(Integer info){
        this.info=info;
        this.next=null;
        this.prev=null;
    }
}
