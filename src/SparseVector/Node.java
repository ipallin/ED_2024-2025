package SparseVector;

class Node {
    int index;
    int value;
    Node next;
    Node prev;

    Node(int index, int value) {
        this.index = index;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
