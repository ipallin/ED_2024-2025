package ordereddoublelist;

import java.util.ArrayList;

import ordereddoublelist.Node;

public class IntegerOrderedDoubleList {
	
	private Node first;
	
	public IntegerOrderedDoubleList() {
		this.first = null;
	}
	
	public void insert(Integer i) {
		Node newNode = new Node(i);
		if (this.first == null) {
			this.first = newNode;
		}
		else {
			Node nodePointer = this.first;
			while (nodePointer != null) {
				if (nodePointer.posterior != null) {
					if (nodePointer.posterior.value < i) {
						// Continuar recorriendo la lista
						nodePointer = nodePointer.posterior;
					}
					else {
						// Insertar
						Node tempNode = nodePointer.posterior;
						newNode.anterior = nodePointer;
						nodePointer.posterior = newNode;
						tempNode.anterior = newNode;
						nodePointer.posterior.posterior = tempNode;
						nodePointer = null; // Para salir del bucle
					}
				}
				else {
					// Insertar a la última posición
					newNode.anterior = nodePointer;
					nodePointer.posterior = newNode;
					nodePointer = null; // Para salir del bucle
				}
			}
		}
	}
	
	boolean delete (Integer i) {
		if (this.first == null) {
			return false;
		}
		else {
			Node nodePointer = this.first;
			while (nodePointer != null) {
				if (nodePointer.value == i) {
					// Borrado exitoso
					nodePointer.anterior.posterior = nodePointer.posterior;
					nodePointer.posterior.anterior = nodePointer.anterior;
					return true;
				}
				else {
					// Continuar
					nodePointer = nodePointer.posterior;
				}
			}
			// Se ha llegado al final del bucle y no se ha encontrado el número a borrar;
			return false;
		}
	}
	
	public ArrayList<Integer> list() {
		ArrayList<Integer> lista = new ArrayList<>();
		if (this.first != null) {
			Node nodePointer = this.first;
			while (nodePointer != null) {
				lista.add(nodePointer.value);
				nodePointer = nodePointer.posterior;
			}
		}
		return lista;
		
	}
}

