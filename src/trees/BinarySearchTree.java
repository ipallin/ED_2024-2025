package trees;

import java.util.ArrayList;


public class BinarySearchTree {

    private Node root;

    // CONSTRUCTOR DE ÁRBOL VACÍO
    public  BinarySearchTree() {

        root = null;
    }

    //-----------------------------------------------------------------------------------------//

    // INSERCIÓN DE UN NUEVO VALOR
    public void insert(Integer v) {

        // Se podría comprobar el valor de v, y si es null, no invocar al metodo recursivo de inserción

        root = recursiveInsert(root, v);
    }

    // METODO RECURSIVO DE APOYO
    // LA DEFINICIÓN DEL PROPIO METODO GARANTIZA QUE NO HAYA DUPLICADOS EN EL ABB
    private Node recursiveInsert(Node node, int v) {

        if (node == null)
            node = new Node(v);

        else if (v < node.value)
            node.left = recursiveInsert(node.left, v);
        else if (v > node.value)
            node.right = recursiveInsert(node.right, v);

        return node;

    }

    //-----------------------------------------------------------------------------------------//

    // RECORRIDO EN INORDEN
    public ArrayList<Integer> inorder() {

        ArrayList<Integer> list = new ArrayList<>();

        recursiveInorder(root, list);

        return list;
    }

    private void recursiveInorder(Node node, ArrayList<Integer> list) {

        if (node != null) {
            recursiveInorder(node.left, list);
            list.add(node.value);
            recursiveInorder(node.right, list);
        }
    }

    //-----------------------------------------------------------------------------------------//

    // ALTURA DE UN ARBOL

    public int height() {
        return recursiveHeight(root);
    }

    private int recursiveHeight(Node node){

        if (node == null){
            return -1;
        }

        int rightHeight = recursiveHeight(node.right);
        int leftHeight = recursiveHeight(node.left);

        return 1 + Math.max(rightHeight, leftHeight);

    }

    //-----------------------------------------------------------------------------------------//

    //////////////////////////////////////////////////////////////
// SUMA DE LOS NODOS

    public Integer sum() {

        return recursiveSum(root);
    }

    private Integer recursiveSum(Node node) {

        if (node == null)
            return 0;

        return node.value + recursiveSum(node.left) + recursiveSum(node.right);

    }


    //////////////////////////////////////////////////////////////
//CONTAR NODOS QUE PERTENEZCAN A UN RANGO

    public Integer countInRange(Integer min, Integer max) {

        return recursiveCountInRange(root, min, max);

    }

    private Integer recursiveCountInRange(Node node, Integer min, Integer max) {

        Integer count = 0;

        if (node == null)
            return 0;

        if ((node.value >= min) && (node.value <= max))
            count = 1;

        return count + recursiveCountInRange(node.left, min, max)+ recursiveCountInRange(node.right, min, max);

    }



    //////////////////////////////////////////////////////////////
    //CONTAR NÚMERO DE NODOS

    public Integer numNodes() {

        return recursiveNumNodes(root);
    }

    private Integer recursiveNumNodes(Node node) {

        if (node == null)
            return 0;

        return 1 + recursiveNumNodes(node.left) + recursiveNumNodes(node.right);

    }

    //////////////////////////////////////////////////////////////
// VALOR MEDIO DE LOS NODOS

    public double avg() {

        if (root == null)
            return 0;

        Integer sum = sum();
        Integer numNodes = numNodes();

        return (double) sum / numNodes;

    }


}