package IntergerStackOrQueue;

import java.util.ArrayList;

public class IntegerStackOrQueue {
	
	private int mode;
	private Node base; // Primero de la cola, base (último) de la pila
	
	public IntegerStackOrQueue() {
		this.mode = 0;
		this.base = null;
	}

	//------------------------------------------------------------------------------------------------//

	public void setStackMode() {
		this.mode = 0;
	}

	public void setQueueMode() {
		this.mode = 1;
	}

	public int getMode() {
		return this.mode;
	}

	//------------------------------------------------------------------------------------------------//

	public void insert(Integer i) {
		Node newNode = new Node(i);
		if (this.base == null) {
			this.base = newNode;
			return;
		}
		if (this.mode == 0) {
			Node nodePointer = this.base;
			while (nodePointer.next != null) {
				nodePointer = nodePointer.next;
			}
			nodePointer.next = newNode;
		}
		else {
			newNode.next = this.base;
			this.base = newNode;
		}
	}

	//------------------------------------------------------------------------------------------------//


	Integer get() {
		if (this.base == null) {
			return null;
		}
		Integer result;
		if (this.mode == 0) { // Modo cola, sale el primero (FIFO)
			result = this.base.value;
			this.base = this.base.next;
		}
		else { // Mode = 1 Pila, LIFO
			if (this.base.next == null) {
				result = base.value;
				base = null;
			}
			else {
				Node nodePointer = base;
				while (nodePointer.next.next != null) {
					nodePointer = nodePointer.next;
				}
				result = nodePointer.next.value;
				nodePointer.next = null;
			}
		}
		return result;
	}

	//------------------------------------------------------------------------------------------------//


	public ArrayList<Integer> list() {
		ArrayList<Integer> lista = new ArrayList<>(); // ArrayList para almacenar enteros
		/*Integer intPointer;
		do {
			intPointer = this.get();
	        lista.add(intPointer);
		} while (intPointer != null);
		*/
		if (this.base == null) {
			return lista;
		}
		else {
			if (this.mode == 0) { // Modo cola, sale el primero (FIFO)
				Node nodePointer = this.base;
				do {
					lista.add(nodePointer.value);
					nodePointer = nodePointer.next;
				} while (nodePointer.next != null);
				lista.add(nodePointer.value);
			}
			else { // Mode = 1 Pila, LIFO
				if (this.base.next == null) {
					lista.add(base.value);
				}
				else {
					int count = 1;
					Node nodePointer = base;
					while (nodePointer.next.next != null) {
						nodePointer = nodePointer.next;
						count ++;
					}
					while (count >= 0) {
						nodePointer = base;
						for (int i = 0; i < count; i++) {
							nodePointer = nodePointer.next;
				        }
						lista.add(nodePointer.value);
						count --;
					}
				}
			}
		}
		return lista;
	}
}


/*
 * 
 * Modo pila
 * 1->2->3
 * 
 * Transformacion a cola
 * 
 * 
 */
