package act2_bst;
import java.util.ArrayList;
public class BinarySearchTree {
    Nodo root;

    //Insertar un elemento: inserta un elemento en el árbol.
    //En la operación de inserción se debe tener en cuenta que los árboles binarios de búsqueda no admiten nodos repetidos.
    public void insert(Integer i){
        if (root == null){
            root = new Nodo(i);
        } else {
            insertRec(root, i);
        }
    }
    private void insertRec(Nodo nodo, Integer i){
        if (nodo.dato == i){
            System.out.println("El elemento ya existe en el árbol");
            //return;
        } else if (i < nodo.dato){
            if (nodo.left == null){
                nodo.left = new Nodo(i);
            } else {
                insertRec(nodo.left, i);
            }
        } else if (i > nodo.dato) {
            if (nodo.right == null){
                nodo.right = new Nodo(i);
            } else {
                insertRec(nodo.right, i);
            }
        }
    }
    //Borrar un elemento: borra un elemento del árbol.
    //Esta operación no tiene efecto si el elemento no existía en el árbol.
    public void delete(Integer i){
        if (root == null){
            System.out.println("El árbol está vacío");
        } else {
            deleteRec(root, i);
        }
    }

    private Nodo deleteRec(Nodo nodo, Integer i){
        if (nodo == null) {
            System.out.println("El elemento no existe en el árbol");
            return null;
        }
        if (i < nodo.dato){
            nodo.left = deleteRec(nodo.left, i);
        } else if (i > nodo.dato){
            nodo.right = deleteRec(nodo.right, i);
        } else {
           if(nodo.left == null && nodo.right == null){
               return null;
           } else if (nodo.left == null){
               return nodo.right;
           } else if (nodo.right == null){
               return nodo.left;
           } else {
              Nodo aux = nodo.right;
                while (aux.left != null){
                    aux = aux.left;
                }
                nodo.dato = aux.dato;
                nodo.right = deleteRec(nodo.right, aux.dato);

           }
        }
        return nodo;
    }

    //Recorrido en inorden: recorre el árbol en inorden y construye una lista con los valores de la secuencia de nodos visitados.
    public ArrayList<Integer> inorder(){
        ArrayList<Integer> lista = new ArrayList<>();
        if (root == null){
            return lista;
        } else {
            inorderRec(root, lista);
            return lista;
        }
    }
    private void inorderRec(Nodo nodo, ArrayList<Integer> lista){
        if (nodo.left != null){
            inorderRec(nodo.left, lista);
        }
        lista.add(nodo.dato);
        if (nodo.right != null){
            inorderRec(nodo.right, lista);
        }
    }

    //Recorrido en preorden: recorre el árbol en preorden y construye una lista con los valores de la secuencia de nodos visitados.
    public ArrayList<Integer> preorder(){
        ArrayList<Integer> lista = new ArrayList<>();
        if (root == null){
            return lista;
        } else {
            preorderRec(root, lista);
            return lista;
        }
    }
    private void preorderRec(Nodo nodo, ArrayList<Integer> lista){
        lista.add(nodo.dato);
        if (nodo.left != null){
            preorderRec(nodo.left, lista);
        }
        if (nodo.right != null){
            preorderRec(nodo.right, lista);
        }
    }

    //Recorrido en postorden: recorre el árbol en postorden y construye una lista con los valores de la secuencia de nodos visitados.
    public ArrayList<Integer> postorder(){
        ArrayList<Integer> lista = new ArrayList<>();
        if (root == null){
            return lista;
        } else {
            postorderRec(root, lista);
            return lista;
        }
    }
    private void postorderRec(Nodo nodo, ArrayList<Integer> lista){
        if (nodo.left != null){
            postorderRec(nodo.left, lista);
        }
        if (nodo.right != null){
            postorderRec(nodo.right, lista);
        }
        lista.add(nodo.dato);
    }



}


