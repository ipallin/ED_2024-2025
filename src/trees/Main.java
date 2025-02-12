package trees;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        System.out.println(bst.height());

        bst.insert(1);
        System.out.println(bst.height());

        for (int i=1; i<10; i++)
            bst.insert(i);

        System.out.println(bst.inorder());
        System.out.println(bst.height());


    }

}