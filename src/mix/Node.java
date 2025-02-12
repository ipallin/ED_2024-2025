package mix;

public class Node {

    Integer row;
    Integer column;
    Integer value;
    Node next;
    Node prev;


    public Node (Integer row, Integer column, Integer value){

        this.row = row;
        this.column = column;
        this.value = value;
        next = null;
        prev= null;
    }
}
