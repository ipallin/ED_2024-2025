package temas.tema4;

public class Main {

    public static void main(String[] args) {

        SubClass1 s1 =  new SubClass1();
        SubClass2 s2 =  new SubClass2();

        s1.print();
        s2.print();

    }
}

// En el metodo principal (main) se crean dos objetos, uno de la clase SubClass1 y otro de la clase SubClass2.
// La sentencia s1.print() desemboca en la ejecución del metodo print de la clase SubClass1 ya que en esta clase se sobreescribe el método print de su clase padre (SuperClass).
// La sentencia s2.print() desemboca en la ejecución del metodo print de la clase padre (SuperClass) porque la subclase SubClass2 no lo ha reescrito.

