//Autor: Igor Pallin
//Fecha: 02/12/2024
//Asignatura: Estructura de datos

package act1_integercontainers;

public class IntegerStack {
    private Nodo primero;
    public IntegerStack(){
        this.primero = null;
    }
    public IntegerStack(Nodo primero) {
        this.primero = primero;
    }

//Apilar un elemento: apila el elemento pasado como parámetro.
    public void push(Integer i) {
        if (primero == null) {
            primero = new Nodo(i);
        }
        else {
            Nodo nuevo = new Nodo(i);
            nuevo.siguiente = primero;
            primero = nuevo;
        }
    }

//Desapilar un elemento: extrae el elemento situado en la cima de la pila y lo devuelve. Si la pila está vacía devuelve null.
    public Integer pop() {
        if (primero == null) {
            return null;
        }
        else {
            Nodo nuevo = primero;
            primero = primero.siguiente;
            return nuevo.dato;
        }
    }

//Obtener el elemento situado en la cima de la pila. Devuelve el elemento situado en la cima, pero sin extraerlo de la estructura. Si la pila está vacía devuelve null.
    public Integer top() {
        if (primero == null) {
            return null;
        }
        else {
            return primero.dato;
        }
    }

//Contar el número de elementos que tiene la pila.
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

//Comprobar si un elemento está en la pila. Devuelve true si el elemento está en la pila, y false en caso contrario.
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

//Mostrar el contenido de la pila. Si la pila está vacía se mostrará el mensaje “Empty stack”.
    public String toString() {
        if (primero == null) {
            return "Empty stack";
        }
        else {
            Nodo actual = primero;
            String pilaString = "[";
            while (actual != null) {
                pilaString += actual.dato + ", ";
                actual = actual.siguiente;
            }
            pilaString += "]";
            return pilaString;
        }
    }

}