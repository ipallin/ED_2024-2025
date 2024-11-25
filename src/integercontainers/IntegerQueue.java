//Autor: Igor Pallin
//Fecha: 02/12/2024
//Asignatura: Estructura de datos

package integercontainers;

public class IntegerQueue {
    private Nodo primero;
    public IntegerQueue(){
        this.primero = null;
    }
    public IntegerQueue(Nodo primero) {
        this.primero = primero;
    }

//Insertar un elemento: inserta el elemento pasado como parámetro.
    public void insert(Integer i) {
        if (primero == null) {
            primero = new Nodo(i);
        }
        else {
            Nodo actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = new Nodo(i);
        }
    }

//Sacar un elemento: extrae el elemento situado en la cabecera de la cola. Si la cola está vacía devuelve null.
    public Integer remove() {
        if (primero == null) {
            return null;
        }
        else {
            Nodo actual = primero;
            primero = primero.siguiente;
            return actual.dato;
        }
    }

//Obtener el elemento situado en la cabecera de la cola. Devuelve el elemento situado en la cabecera, pero sin extraerlo de la estructura. Si la cola está vacía devuelve null.
    public Integer seek() {
        if (primero == null) {
            return null;
        }
        else {
            return primero.dato;
        }
    }
//Contar el número de elementos que tiene la cola.
    public Integer size() {
        if (primero == null) {
            return 0;
        }
        else {
            Nodo actual = primero;
            int contador = 0;
            while (actual != null) {
                contador++;
                actual = actual.siguiente;
            }
            return contador;
        }
    }

//Comprobar si un elemento está en la cola. Devuelve true si el elemento está en la cola, y false en caso contrario.
    public boolean search(Integer i) {
        if (primero == null) {
            return false;
        }
        else {
            Nodo actual = primero;
            while (actual != null) {
                if (actual.dato == i) {
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }
    }

//Mostrar el contenido de la cola. Si la cola está vacía se mostrará el mensaje “Empty stack”.
    public String toString() {
        if (primero == null) {
            return "Empty queue";
        }
        else {
            Nodo actual = primero;
            String colaString = "[";
            while (actual != null) {
                colaString += actual.dato + ", ";
                actual = actual.siguiente;
            }
            colaString += "]";
            return colaString;
        }
    }

}
