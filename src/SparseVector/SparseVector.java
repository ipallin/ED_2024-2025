package SparseVector;

public class SparseVector {
    private Node first;
    private int size;

    public SparseVector(Integer size) {
        this.size = size;
        this.first = null;
    }

    //----------------------------------------------------------------------------------------//

    public boolean setValue(Integer index, Integer value) {
        if (index < 1 || index > size || value == 0) {
            return false;
        }

        Node current = first;
        while (current != null) {
            if (current.index == index) {
                current.value = value; // Actualizar valor existente
                return true;
            }
            current = current.next;
        }

        Node newNode = new Node(index, value);
        newNode.next = first;
        if (first != null) {
            first.prev = newNode;
        }
        first = newNode;
        return true;
    }

    //----------------------------------------------------------------------------------------//


    public boolean resetIndex(Integer index) {
        if (index < 1 || index > size) {
            return false;
        }

        Node current = first;
        while (current != null) {
            if (current.index == index) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    first = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                return true;
            }
            current = current.next;
        }
        return true; // Si no existe, consideramos que ya está "reseteado"
    }


    //----------------------------------------------------------------------------------------//


    public Integer getValue(Integer index) {
        if (index < 1 || index > size) {
            return null;
        }

        Node current = first;
        while (current != null) {
            if (current.index == index) {
                return current.value;
            }
            current = current.next;
        }
        return 0; // Si no está en la lista, su valor es 0
    }

    //----------------------------------------------------------------------------------------//


    public Integer noZeros() {
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //----------------------------------------------------------------------------------------//


    @Override
    public String toString() {
        if (first == null) {
            return "[Zero vector]";
        }

        StringBuilder sb = new StringBuilder();
        Node current = first;
        while (current != null) {
            sb.append("[index=").append(current.index)
                    .append(", value=").append(current.value).append("] ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}