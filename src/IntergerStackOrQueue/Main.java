package IntergerStackOrQueue;

public class Main {
	public static void main(String[] args) {
		System.out.println("Inicialización en modo pila vacía");
		IntegerStackOrQueue stackOrQueue = new IntegerStackOrQueue();
		System.out.println("Comprobación del modo:");
		System.out.println(stackOrQueue.getMode());
		System.out.println("Comprobación get null:");
		System.out.println(stackOrQueue.get());
		System.out.println("Inserciones...");
		stackOrQueue.insert(1);
		stackOrQueue.insert(2);
		stackOrQueue.insert(3);
		System.out.println("Listado en modo pila:");
		System.out.println(stackOrQueue.list());
		System.out.println("Cambio a modo cola...");
		stackOrQueue.setQueueMode();
		System.out.println("Comprobación del modo:");
		System.out.println(stackOrQueue.getMode());
		System.out.println("Inserciones...");
		stackOrQueue.insert(4);
		stackOrQueue.insert(5);
		stackOrQueue.insert(6);
		System.out.println("Listado en modo cola:");
		System.out.println(stackOrQueue.list());
		System.out.println("Extracciones en modo cola:");
		System.out.println(stackOrQueue.get());
		System.out.println(stackOrQueue.get());
		System.out.println("Listado en modo cola:");
		System.out.println(stackOrQueue.list());
		System.out.println("Cambio a modo pila...");
		stackOrQueue.setStackMode();
		System.out.println("Extracciones en modo pila:");
		System.out.println(stackOrQueue.get());
		System.out.println(stackOrQueue.get());
		System.out.println("Listado en modo pila:");
		System.out.println(stackOrQueue.list());
	}
}
