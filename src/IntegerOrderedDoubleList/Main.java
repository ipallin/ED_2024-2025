package IntegerOrderedDoubleList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Crea nueva lista");
        IntegerOrderedDoubleList lista = new IntegerOrderedDoubleList();

        System.out.println("insertar numeros 1-7");
        lista.insert(1);
        lista.insert(2);
        lista.insert(3);
        lista.insert(4);
        lista.insert(5);
        lista.insert(6);
        lista.insert(7);

        System.out.println(lista.list());
        System.out.println(lista.delete(6));
        System.out.println(lista.list());

    }
}