package ordereddoublelist;

public class Main {
	public static void main(String[] args) {
		IntegerOrderedDoubleList lista = new IntegerOrderedDoubleList();
		System.out.println("Comprobación borrado sin elementos:");
		System.out.println(lista.delete(1));
		System.out.println("Comprobación insert:");
		lista.insert(1);
		lista.insert(9);
		lista.insert(4);
		lista.insert(90);
		lista.insert(4);
		lista.insert(5);
		System.out.println(lista.list());
		System.out.println("Comprobación borrado número inexistente:");
		System.out.println(lista.delete(2));
		System.out.println("Comprobación borrado número repetido (4):");
		System.out.println(lista.delete(4));
		System.out.println(lista.list());
		System.out.println("Comprobación borrado números no repetidos (4 y 5):");
		System.out.println(lista.delete(4));
		System.out.println(lista.delete(5));
		System.out.println(lista.list());
	}
}
