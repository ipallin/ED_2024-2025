package temas.tema7;

public class Nodo {
    public String valor;
    public int prioridad;


    // Constructor
    public Nodo(String nombre, int valorPrioridad) {
        valor = nombre;
        prioridad = valorPrioridad;
    }

    // Metodo para imprimir el contenido del nodo
    public String toString() {
        return "(" + valor + ", " + prioridad + ")";
    }
}
