package multiset;

public class IntegerMultiSet {
    private Integer[] elements;
    private Integer size;
    private Integer capacity;

    //CONSTRUCTOR
    public IntegerMultiSet(Integer capacity) {
        this.capacity = capacity;
        this.elements = new Integer[capacity];
        this.size = 0;
    }

    //---------------------------------------------------------------------------------------//

    public boolean insert(Integer value) {
        if (size < capacity) {
            elements[size] = value;
            size++;
            return true;
        }
        return false;
    }

    //---------------------------------------------------------------------------------------//

    public boolean delete(Integer value) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                for (int j = i; j < size - 1; j++) { //Desplazar los elementos a la izquierda
                    elements[j] = elements[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    //---------------------------------------------------------------------------------------//

    public boolean search(Integer value){
        for (int i=0; i < size; i++) {
            if (elements[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    //---------------------------------------------------------------------------------------//

    public void empty() {
        size = 0;
    }

    //---------------------------------------------------------------------------------------//

    public String toString() {

        if (size == 0) {
            return "[Empty multiset]";
        }

        StringBuilder sb = new StringBuilder("[ ");

        for (int i = 0; i < size - 1; i++){
            sb.append(elements[i]).append("  ");
        }
        sb.append(elements[size - 1]).append(" ]");
        return sb.toString();
    }
}
