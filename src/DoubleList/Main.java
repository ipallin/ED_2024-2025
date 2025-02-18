package DoubleList;

public class Main {
    public static void main(String[] args) {

        //Crea una lista vacia
        DoubleList lista = new DoubleList();

        System.out.println("Insertar en la lista el valor 3");
                lista.insert(3);
                System.out.println(lista.list());

        System.out.println("Insertar en la lista el valor 1");
                lista.insert(1);
                System.out.println(lista.list());

        System.out.println("Insertar en la lista el valor 7");
                lista.insert(7);
                System.out.println(lista.list());

        System.out.println("Insertar en la lista el valor 5");
                lista.insert(5);
                System.out.println(lista.list());

        System.out.println("Insertar en la lista el valor 2");
                lista.insert(2);
                System.out.println(lista.list());

        System.out.println("Insertar en la lista el valor 6");
                lista.insert(6);
                System.out.println(lista.list());

        System.out.println("Insertar en la lista el valor 4");
                lista.insert(4);
                System.out.println(lista.list());



        System.out.println("Borrar de la lista el valor 1");
                lista.delete(1);
                System.out.println(lista.list());

        System.out.println("Borrar de la lista el valor 7");
                lista.delete(7);
                System.out.println(lista.list());

        System.out.println("Borrar de la lista el valor 3");
                lista.delete(3);
                System.out.println(lista.list());

        System.out.println("Borrar de la lista el valor 3 de nuevo");
        lista.delete(3);
        System.out.println(lista.list());
    }
}