package temas.tema8;

import java.util.LinkedList;

public class TablaHashAbierta {

    private int tamVector;					// Tamaño del vector de soporte
    private LinkedList<Elemento> vector[]; 	// Vector de soporte. Cada elemento del vector
    // es una lista de los elementos que colisionan

    private double FC; 	// Factor de carga actual de la tabla (para redisperisón)


    @SuppressWarnings("unchecked")
    public TablaHashAbierta(int tamVector) {

        this.tamVector = tamVector;
        this.vector = new LinkedList[this.tamVector];

        for (int i = 0; i < this.tamVector; i++) {
            vector[i] = new LinkedList<Elemento>();
        }
        this.FC = 0;
    }

    // Función HASH que devuelve el índice de entrada en un vector de tamaño N
    private int hash(String clave, int tam) {

        int hash = clave.hashCode();
        return Math.abs(hash) % tam;


//		int hash = 0;
//		char c;
//		int indice;
//
//		for(int i = 0; i < clave.length(); i++) {
//			c = clave.charAt(i);
//			hash += (int) c;
//		}
//		indice = hash % tam;
//		return indice;
    }


    // Iserción de un nuevo elemento en la tabla
    // Sólo se inserta si la clave no existe en la tabla
    // Otra alternativa es actualizar el valor de la clave si ya existe
    public void insertar(String clave, int valor) {

        if (buscar(clave) != null)  // La clave existe
            return;

        int indice = hash(clave, tamVector);  // Cálculo del índice de inserción en el vector

        Elemento nuevoElemento = new Elemento(clave,valor);    // Crear el nuevo elemento
        vector[indice].add(nuevoElemento);                     // Insertar en nuevo elemento en la lista. El método "add" de LinkedList añade al final de la lista

        calcularFC();

        if (FC > 1) {
            redispersion();     // LLamada al método de resispersión
            System.out.println("Redispersion necesaria, FC = " + FC);
        }
        else
            System.out.println("La redispersion no es necesaria, FC = " + FC);
    }



    // Cálculo del factor de carga
    private void calcularFC() {

        int s = 0;    // número de elementos almacenados en la tabla

        // calcular el número de elementos de la tabla
        for(int i = 0; i < tamVector; i++)
            s += vector[i].size();

        // actualizar el factor de carga
        FC = (double)s/tamVector;
    }



    // Método que valida si un número es primo
    // Devuelve true si lo es y false en caso contrario
    public boolean primo(int n) {

        if (n % 2 == 0)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {

            if(n % i == 0)
                return false;
        }
        return true;
    }

    // Devuelve el primo más próximo al valor pasado por parámetro
    public int siguientePrimo(int n) {

        int siguiente = n;

        while (! primo(siguiente))
            siguiente++;

        return siguiente;
    }


    // Realización de redispersión si es necesario (factor de carga > 1)
    @SuppressWarnings("unchecked")
    private void redispersion() {

        String clave;
        Integer valor, indice, nuevoTamVector;
        LinkedList<Elemento> lista;

        // inicializar el nuevo vector de soporte
        nuevoTamVector = siguientePrimo(2*tamVector);

        LinkedList<Elemento> nuevoVector[] = new LinkedList[nuevoTamVector];

        for (int i = 0; i < nuevoTamVector; i++)
            nuevoVector[i] = new LinkedList<Elemento>();


        for(int i = 0; i < tamVector; i++) {   // Recorrido del vector actual

            lista = vector[i];

            for (Elemento elem: lista) {

                clave = elem.getClave();
                valor = elem.getValor();

                indice = hash(clave, nuevoTamVector);    // Cálculo del índice en el nuevo vector
                nuevoVector[indice].add(elem);           // Inserción del elemento en la lista
            }

        }
        // actualización de los atributos
        vector = nuevoVector;
        tamVector = nuevoTamVector;
    }



    // Búsqueda de una clave
    // Si existe, devuelve la información asociada a la clave
    // Si no existe, devuelve null

    public Integer buscar(String clave) {

        String claveActual;
        int indice = hash(clave, tamVector);    // índice de la lista en la que estaría el elemento

        for(Elemento elem: vector[indice]) {   // Recorrido de la lista

            claveActual = elem.getClave();

            if(claveActual.equals(clave)) {
                return elem.getValor();
            }
        }

//      // Guardar la lista en la variable "Lista"
//		LinkedList<Elemento> lista;
//		lista = vector[indice];
//		for(Elemento elem: lista {   // Recorrido de la lista
//
//			claveActual = elem.getClave();
//
//			if(claveActual.equals(clave)) {
//				return elem.getValor();
//			}
//		}
        return null;
    }


    // Representación de la tabla en formato String
    public String toString() {

        StringBuilder sb = new StringBuilder();
        LinkedList<Elemento> lista;


        for(int i = 0; i < this.tamVector; i++) {
            sb.append("[" + i + "] -->");

            lista = vector[i];
            for(Elemento elem: lista) {
                sb.append(elem);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}