package temas.tema7;

import java.util.ArrayList;


public class ColaDePrioridad {

    private ArrayList<Nodo> cola;

    public ColaDePrioridad(                                                                                                                                                                                                             ) {
        this.cola = new ArrayList<Nodo>();
    }

    // Metodo para insertar un nuevo elemento en la cola de prioridad
    public void insertar(String valor, int prioridad) {

        Nodo nuevoNodo = new Nodo(valor, prioridad);
        cola.add(nuevoNodo);
        upHeap(cola.size() - 1);
    }

    // Metodo para devolver y eliminar el elemento de mayor prioridad
    public Nodo desencolar() {

        if (cola.isEmpty()) {  // Devolver null si la cola está vacía
            return null;
        }
        Nodo raiz = cola.get(0);   // Guardar en "raiz" el nodo raíz
        Nodo ultimo = cola.remove(cola.size() - 1);   // Borrar el último nodo
        if (!cola.isEmpty()) {
            cola.set(0, ultimo);
            downHeap(0);	// Heapify desde la raíz
        }
        return raiz;
    }


    // Metodo para imprimir el contenido de la cola de prioridad
// Sería mejor implementar toString()
    public void imprimirMonticulo() {
        for (int i = 0; i < cola.size(); i++) {
            System.out.print(cola.get(i) + " ");
        }
        System.out.println();
    }

    // Metodo para realizar el "up-heap" (ascenso) del nodo en la posición especificada
    private void upHeap(int posicion) {

        if (posicion > 0) {
            int posicionPadre = (posicion - 1) / 2;
            if (cola.get(posicion).prioridad < cola.get(posicionPadre).prioridad)
            {
                Nodo temp = cola.get(posicion);				// Guardar el hijo en temp
                cola.set(posicion, cola.get(posicionPadre));// Sobreescribir el hijo con el padre
                cola.set(posicionPadre, temp);				// Sobreescribir el padre con temp
                upHeap(posicionPadre);						// Llamada recursiva sobre el padre
            }
        }
    }

    // metodo para realizar el "down-heap" (descenso) del nodo en la posición especificada
    private void downHeap(int posicion) {

        int posicionHijoIzquierdo = 2 * posicion + 1;
        int posicionHijoDerecho = 2 * posicion + 2;

        // Buscar la posición del hijo menor
        if (posicionHijoIzquierdo < cola.size()) {  // Comprobar si existe hijo izquierdo

            int posicionMenorHijo;
            if (posicionHijoDerecho < cola.size() &&   // Comprobar si existe hijo derecho y es menor
                    cola.get(posicionHijoDerecho).prioridad <
                            cola.get(posicionHijoIzquierdo).prioridad) {
                posicionMenorHijo = posicionHijoDerecho;
            } else {
                posicionMenorHijo = posicionHijoIzquierdo;
            }

            // Intercambio padrecon el hijo menor
            if (cola.get(posicion).prioridad > cola.get(posicionMenorHijo).prioridad) {  // Si padre > hijo
                Nodo temp = cola.get(posicion);						// Guardar el padre en temp
                cola.set(posicion, cola.get(posicionMenorHijo));	// Sobreescribir el padre con el hijo menor
                cola.set(posicionMenorHijo, temp);					// Sobreescribir el hijo menor con temp
                downHeap(posicionMenorHijo);						// Llamada recursiva sobre el hijo
            }
        }
    }
}

