package act2_bst;

public class Main {
    public static void main(String[] args) {
        System.out.println("Se crea un árbol y se insertan los elementos del 1 al 7");
        BinarySearchTree arbol1 = new BinarySearchTree();
        arbol1.insert (4);
        arbol1.insert (2);
        arbol1.insert (1);
        arbol1.insert (6);
        arbol1.insert (3);
        arbol1.insert (5);
        arbol1.insert (7);
        System.out.println( "Se intenta introducir el dato 3, que ya existe en el árbol");
        arbol1.insert (3);
        System.out.println("Se recorre el árbol en inorder, preorder y postorder");
        System.out.println("inorder " + arbol1.inorder());
        System.out.println("preorder " + arbol1.preorder());
        System.out.println("postorder " + arbol1.postorder());
        System.out.println("Se borra el elemento 8");
        arbol1.delete(8);
        System.out.println("Se borra el elemento 3");
        arbol1.delete(3);
        System.out.println("Se recorre el árbol en inorder, preorder y postorder");
        System.out.println("inorder " + arbol1.inorder());
        System.out.println("preorder " + arbol1.preorder());
        System.out.println("postorder " + arbol1.postorder());
    }
}