package act3_grafo;

import java.util.*;

public class Grafo {
    private LinkedList<NodoGrafo> nodos = new LinkedList<NodoGrafo>();
    public LinkedList<LinkedList<Double>> listaAdyacencia = new LinkedList<LinkedList<Double>>();
    public Grafo(){}

    // insertarNodo: inserta un nodo en el grafo
    public boolean insertarNodo(NodoGrafo nodo){
          if (existeNodo(nodo.getClave())) return false;
          else {
                nodos.add(nodo); // añade el nodo a la lista de nodos
                listaAdyacencia.add(new LinkedList<>()); // añade una nueva LinkedList
                for(LinkedList<Double> l: listaAdyacencia){
                    while (l.size() < nodos.size()) l.add(0.0); // añade tantos 0.0 como nodos haya
                }
                return true;
          }
    }

    // borrarNodo: borra un nodo del grafo
    public boolean borrarNodo(String clave) {
        if (!existeNodo(clave)) {
            return false;
        } else {
            Iterator<NodoGrafo> iterator = nodos.iterator();
            while (iterator.hasNext()) {
                NodoGrafo n = iterator.next();
                if (n.getClave().equals(clave)) {
                    int index = nodos.indexOf(n); // obtiene el índice del nodo
                    iterator.remove(); // borra el nodo de la lista de nodos
                    for (int i = 0; i < nodos.size(); i++) {
                        if (existeArista(clave, nodos.get(i).getClave())) {
                            borrarArista(clave, nodos.get(i).getClave()); // borra las aristas del nodo
                        }
                    }

                    // Remove the row in the adjacency list for the removed node
                    listaAdyacencia.remove(index);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean existeNodo(String clave){
        if(nodos.isEmpty()) return false;
        else{
            for (int i= 0; i < nodos.size(); i++) {
                if (nodos.get(i).getClave().equals(clave)) return true; // si la clave del nodo es igual a la clave pasada por parámetro devuelve true
            }
            return false;
        }
    }

    // numeroNodos: devuelve el número de nodos del grafo
    public int numeroNodos(){
        return nodos.size(); // devuelve el tamaño de la lista de nodos
    }

    // insertarArista: inserta una arista entre dos nodos del grafo
    public boolean insertarArista(String clave1, String clave2, double peso){
        if (!existeNodo(clave1) || !existeNodo(clave2)) {
            return false; // si alguno de los nodos no existe devuelve false
        } else {
            int i = obtenerIndiceNodo(clave1);
            int j = obtenerIndiceNodo(clave2); // obtiene el índice de los nodos

            listaAdyacencia.get(i).set(j, peso);
            listaAdyacencia.get(j).set(i, peso); // añade el peso de la arista en la posición correspondiente de la lista de adyacencia
            return true;
        }
    }

    // borrarArista: borra una arista entre dos nodos del grafo
    public boolean borrarArista(String clave1, String clave2){
        if (existeArista(clave1, clave2)) {
            int i = 0;
            int j = 0;
            for (NodoGrafo n: nodos) {
                if (n.getClave().equals(clave1)) i = nodos.indexOf(n);
                if (n.getClave().equals(clave2)) j = nodos.indexOf(n); // obtiene el índice de los nodos
            }
            listaAdyacencia.get(i).set(j,0.0);
            listaAdyacencia.get(j).set(i,0.0); // añade 0.0 en la posición correspondiente de la lista de adyacencia
            return true;
        }
        else return false;
    }

    // existeArista: devuelve true si existe una arista entre dos nodos del grafo
    public boolean existeArista(String clave1, String clave2){
        if (!existeNodo(clave1) || !existeNodo(clave2)) return false;
        else {
            int i = 0;
            int j = 0;
            for (NodoGrafo n: nodos) {
                if (n.getClave().equals(clave1)) i = nodos.indexOf(n);
                if (n.getClave().equals(clave2)) j = nodos.indexOf(n); // obtiene el índice de los nodos
            }
            if (listaAdyacencia.get(i).get(j) != 0.0) // si la arista existe devuelve true
                return true;
            else
                return false;
        }
    }

    // numeroAristas: devuelve el número de aristas del grafo
    public int numeroAristas(){
        int contador = 0;
        for (LinkedList<Double> l: listaAdyacencia) {
            for (Double d: l) {
                if (d != 0) contador++;
            }
        }
        return contador/2; // devuelve el número de aristas (la mitad ya que son bidireccionales)
    }

    // toString: devuelve un string con la información del grafo
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (NodoGrafo n : nodos) {
            s.append(n.getClave()).append(" : "); // añade la clave del nodo por cada nodo

            for (NodoGrafo adjNode : nodos) {
                int index = nodos.indexOf(adjNode); // obtiene el índice del nodo adyacente
                double weight = listaAdyacencia.get(nodos.indexOf(n)).get(index); // obtiene el peso de la arista entre los nodos

                if (weight != 0.0) {
                    s.append(adjNode.getClave()).append("[").append(weight).append("], "); // añade la clave del nodo adyacente y el peso de la arista
                }
            }
            s.delete(s.length() - 2, s.length()); // borra la última coma y el último espacio
            s.append("\n");
        }
        return s.toString();
    }

    // Dijkstra: devuelve una lista con las distancias mínimas desde el nodo con clave pasada por parámetro hasta el resto de nodos del grafo
    public LinkedList<Double> Dijkstra(String clave) {
        int nodoInicial = obtenerIndiceNodo(clave);
        if (nodoInicial == -1) {
            return null; // si el nodo de inicio no ha sido encontrado
        }
        Queue<Map.Entry<NodoGrafo, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        Map<NodoGrafo, Double> distancias = new HashMap<>();
        Set<NodoGrafo> visitados = new HashSet<>();
        for (NodoGrafo nodo : nodos) {
            distancias.put(nodo, Double.POSITIVE_INFINITY);
        }
        distancias.put(nodos.get(nodoInicial), 0.0);
        queue.add(new AbstractMap.SimpleEntry<>(nodos.get(nodoInicial), 0.0));
        while (!queue.isEmpty()) {
            Map.Entry<NodoGrafo, Double> entry = queue.poll(); // obtiene el nodo con menor distancia
            NodoGrafo nodoActual = entry.getKey(); // obtiene el nodo actual con la clave
            if (visitados.contains(nodoActual)) continue; // si el nodo actual ya ha sido visitado, pasa al siguiente
            visitados.add(nodoActual); // añade el nodo a la lista de nodos visitados
            int indiceActual = nodos.indexOf(nodoActual); // obtiene el índice del nodo actual
            for (int i = 0; i < listaAdyacencia.get(indiceActual).size(); i++) { // recorre los nodos adyacentes
                double peso = listaAdyacencia.get(indiceActual).get(i); // obtiene el peso de la arista entre los nodos
                if (peso != 0) { // si existe una arista entre los nodos
                    NodoGrafo adyacente = nodos.get(i); // obtiene el nodo adyacente
                    if (!visitados.contains(adyacente)) { // si el nodo adyacente no ha sido visitado
                        double nuevaDistancia = distancias.get(nodoActual) + peso; // calcula la distancia
                        if (nuevaDistancia < distancias.get(adyacente)) { // si la distancia es menor que la distancia actual
                            distancias.put(adyacente, nuevaDistancia); // actualiza la distancia
                            queue.add(new AbstractMap.SimpleEntry<>(adyacente, nuevaDistancia)); // añade el nodo a la cola
                        }
                    }
                }
            }
        }

        // convierte las distancias de Map a LinkedList
        LinkedList<Double> resultDistancias = new LinkedList<>();
        for (NodoGrafo nodo : nodos) {
            if (distancias.get(nodo) != Double.POSITIVE_INFINITY) {
                resultDistancias.add(distancias.get(nodo));
            }
        }
        return resultDistancias;
    }

    // Dijkstra: devuelve una lista con los nodos que forman el camino más corto desde el nodo con clave1 hasta el nodo con clave2
    public LinkedList<String> Dijkstra(String clave1, String clave2){
        int nodoInicial = obtenerIndiceNodo(clave1);
        int nodoFinal = obtenerIndiceNodo(clave2);
        if (nodoInicial == -1 || nodoFinal == -1) {
            return null;
        }

        PriorityQueue<Map.Entry<NodoGrafo, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        Map<NodoGrafo, Double> distancias = new HashMap<>();
        Map<NodoGrafo, NodoGrafo> anteriores = new HashMap<>();
        Set<NodoGrafo> visitados = new HashSet<>();
        for (NodoGrafo nodo : nodos) {
            distancias.put(nodo, Double.POSITIVE_INFINITY); // inicializa las distancias a infinito
        }
        distancias.put(nodos.get(nodoInicial), 0.0); // inicializa la distancia del nodo inicial a 0
        queue.add(new AbstractMap.SimpleEntry<>(nodos.get(nodoInicial), 0.0)); // añade el nodo inicial a la cola
        while (!queue.isEmpty()) {
            Map.Entry<NodoGrafo, Double> entry = queue.poll(); // obtiene el nodo con menor distancia
            NodoGrafo nodoActual = entry.getKey(); // obtiene el nodo actual con la clave
            if (visitados.contains(nodoActual)) continue; // si el nodo actual ya ha sido visitado, pasa al siguiente
            visitados.add(nodoActual); // añade el nodo a la lista de nodos visitados
            int indiceActual = nodos.indexOf(nodoActual); // obtiene el índice del nodo actual
            for (int i = 0; i < listaAdyacencia.get(indiceActual).size(); i++) {
                double peso = listaAdyacencia.get(indiceActual).get(i); // obtiene el peso de la arista entre los nodos
                if (peso != 0) {
                    NodoGrafo adyacente = nodos.get(i); // obtiene el nodo adyacente
                    if (!visitados.contains(adyacente)) {
                        double nuevaDistancia = distancias.get(nodoActual) + peso; // calcula la distancia
                        if (nuevaDistancia < distancias.get(adyacente)) {
                            distancias.put(adyacente, nuevaDistancia); // actualiza la distancia
                            anteriores.put(adyacente, nodoActual); // actualiza el nodo anterior
                            queue.add(new AbstractMap.SimpleEntry<>(adyacente, nuevaDistancia)); // añade el nodo a la cola
                        }
                    }
                }
            }
        }

        // convierte las distancias de Map a LinkedList
        LinkedList<String> resultDistancias = new LinkedList<>();
        NodoGrafo nodoActual = nodos.get(nodoFinal); // obtiene el nodo final
        while (nodoActual != null) {
            resultDistancias.addFirst(nodoActual.getClave()); // añade la clave del nodo actual al principio de la lista
            nodoActual = anteriores.get(nodoActual); // obtiene el nodo anterior
        }
        return resultDistancias;
    }

    private int obtenerIndiceNodo(String clave) {
        for (NodoGrafo nodo : nodos) {
            if (nodo.getClave().equals(clave)) {
                return nodos.indexOf(nodo); // devuelve el índice del nodo
            }
        }
        return -1;
    }
}
