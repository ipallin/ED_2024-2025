package IntegerOrderedDoubleList;

import java.util.ArrayList;

public class IntegerOrderedDoubleList {
    // atributos
    private Nodo first;
    private Nodo last;

    // constructores
    public IntegerOrderedDoubleList() {
    }

    //------------------------------------------------------------------------------------------------//


    // métodos
    public void insert(Integer i){
        if (this.first==null) {
            Nodo actual = new Nodo(i); // nuevo nodo es mismo + first + last
            this.first = actual;
            this.last = actual;
        } else {
            if (this.first.info > i){
                Nodo actual = new Nodo(i);
                this.first.prev = actual; // se añade el nuevo al principio
                actual.next = this.first; // first es next del nuevo
                this.first = actual; // nuevo es first
            } else {
                Nodo actual = this.first;
                while (actual.next != null && actual.next.info < i){
                    actual = actual.next; // recorre la lista
                }
                if (actual == this.last){ // si es el último en la lista
                    Nodo nuevo = new Nodo(i);
                    this.last.next = nuevo;
                    nuevo.prev = this.last;
                    this.last = nuevo;
                } else { // si está en medio de la lista
                    Nodo nuevo = new Nodo (i);
                    actual.next.prev = nuevo;
                    nuevo.next = actual.next;
                    actual.next = nuevo;
                    nuevo.prev = actual;
                }
            }
        }
    }

    //------------------------------------------------------------------------------------------------//



    Boolean delete (Integer i){
        if (this.first == null){
            return false;
        } else {
            Nodo actual = this.first;
            while (actual.info != null){
                if (actual.info == i){
                    actual.prev.next = actual.next;
                    actual.next.prev = actual.prev;
                    return true;
                } else {
                    actual = actual.next;
                }
            }
        }return false;
    }

    //------------------------------------------------------------------------------------------------//


    public ArrayList<Integer> list(){
        ArrayList<Integer> lista = new ArrayList<Integer>(); // inicializa lista vacía
        Nodo actual = this.first;
        while (actual != null){
            lista.add(actual.info);
            actual = actual.next;
        }
        return lista;
    }

}
