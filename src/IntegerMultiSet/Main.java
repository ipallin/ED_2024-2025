package IntegerMultiSet;

public class Main {
	public static void main(String[] args) { // Testing
		IntegerMultiSet multiSet = new IntegerMultiSet(4);
		System.out.println("Test de multiset de 4 elementos");
		System.out.print("Test de contenido: ");
		System.out.println(multiSet.toString());
		System.out.print("Test de borrado no exitoso: ");
		System.out.println(multiSet.delete(10));
		System.out.print("Test de inserción exitosa: ");
		System.out.println(multiSet.insert(10));
		multiSet.insert(10);
		multiSet.insert(10);
		multiSet.insert(5);
		System.out.print("Test de contenido: ");
		System.out.println(multiSet.toString());
		System.out.print("Test de inserción no exitosa: ");
		System.out.println(multiSet.insert(10));
		System.out.print("Test de búsqueda no exitosa: ");
		System.out.println(multiSet.search(11));
		System.out.print("Test de búsqueda exitosa: ");
		System.out.println(multiSet.search(10));
		System.out.print("Test de tamaño: ");
		System.out.println(multiSet.size());
		System.out.print("Test de borrado exitoso: ");
		System.out.println(multiSet.delete(10));
		System.out.print("Test de tamaño: ");
		System.out.println(multiSet.size());
		System.out.print("Test de contenido: ");
		System.out.println(multiSet.toString());
		System.out.print("Test de vaciado (la prueba es la muestra de contenido): ");
		multiSet.empty();
		System.out.println(multiSet.toString());
	}
}
