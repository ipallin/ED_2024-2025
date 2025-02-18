package SparseVector;

public class SparseVector {
    Integer counter;
    Nodo first;
    Integer value;
    String lista;

    public SparseVector(Integer size) {
    }

    // asigna el valor especificado en el index correspondiente
    public boolean setValue(Integer index, Integer value) {
        if (index < 1) {
            return false;
        } else {
            if (this.first == null) {
                Nodo nuevo = new Nodo(value);
                this.first = nuevo;
                return true;
            } else {
                return true;

            }
        }
    }
    // si el index es menor que 1 devuelve false y si no recorre la estructura hasta encontrar el nodo deseado y sobre este realiza la operacion de borrado
    boolean resetIndex (Integer index){
        if (index < 1) {
            return false;
        } else {
            Nodo actual = first;
            while (actual.next != null && actual.info != index) {
                actual = actual.next;
            }
            actual.prev.next = actual.next;
            actual.next.prev = actual.prev;
            return true;
        }
    }

    // Recorre la lista en busca del con el index especificado y cuando lo encuentra devuelve el valor del mismo
    public Integer getValue (Integer index) {
        Nodo actual = first;
        if (actual.info < 1) {
            return null;
        }
        while (actual.next != null) {
            if (actual.info == index) {
                value = actual.info;
            }
        }
        return value;
    }

    // suma los valores de
    public Integer noZeros () {
        counter = 0;
        Nodo actual = first;
        while (actual.next != null) {
            if (actual.info != 0) {
                counter++;
            }
            actual = actual.next;
        }
        return counter;
    }

    // en un mismo string se concatenan todos los index y value
    public String toString () {
        Nodo actual = first;
        lista = null;
        while (actual.next != null){
            lista = lista +"index:"+ actual.index +"value:"+ actual.info+",";
            actual = actual.next;
        }
        return lista;
    }

}









