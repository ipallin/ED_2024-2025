package IntegerMultiSet;

import java.util.ArrayList;

public class IntegerMultiSet {

	private int capacity;				// Capacidad del multiset
	private ArrayList<Integer> lista;	// array base del multiset
	
	public IntegerMultiSet(int capacity) {	// Constructor del multiset
		this.capacity = capacity;
		this.lista = new ArrayList<Integer>();
	}

	//------------------------------------------------------------------------------------------------//


	public boolean insert(Integer value) {
		if (this.size() >= this.capacity) {
			return false; // Capacidad máxima alcanzada, no se puede insertar más de momento
		}
		else {
			this.lista.add(value);
			return true; // Ha sido posible insertar el valor
		}
	}

	//------------------------------------------------------------------------------------------------//


	public boolean delete (Integer value) { // Metodo para eliminar un entero del multiset
		return this.lista.remove(value);
	}

	//------------------------------------------------------------------------------------------------//


	public boolean search (Integer elemento) { // Metodo para buscar si existe un entero en el multiset
		return this.lista.contains(elemento);
	}


	//------------------------------------------------------------------------------------------------//


	public int size() { // Metodo para obtener el tamaño actual del multiset
		return this.lista.size();
	}


	//------------------------------------------------------------------------------------------------//


	public void empty() { // Metodo para vaciar el multiset
		this.lista.clear();
	}

	//------------------------------------------------------------------------------------------------//


	public String toString() { // Metodo para obtener el multiset como cadena de carácteres String
		if (this.size() == 0) { // Comprobación del caso especial del multiset vacío
			return "[Empty multiset]";
		}
		return this.lista.toString().replaceAll(",", " "); // Formateo del array a string característico
	}
}
