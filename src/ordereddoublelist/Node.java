package ordereddoublelist;

public class Node {
	Integer value;
	Node anterior;
	Node posterior;
	
	public Node(int v) {
		/*
		 * Constructor del nodo de una lista ordenada doblemente enlazada
		 */
		value = v; // valor entero
		anterior = null;
		posterior = null;
	}
}
	