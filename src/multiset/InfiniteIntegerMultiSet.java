package multiset;

public class InfiniteIntegerMultiSet {
    private Integer[] elements;
    private Integer size;

    //CONSTRUCTOR
    public InfiniteIntegerMultiSet() {
        this.elements = new Integer[10];
        this.size = 0;
    }

    //---------------------------------------------------------------------------------------//

    public boolean insert(Integer value) {

        if (size < elements.length) {
            elements[size++] = value;
            return true;
        } else {
            Integer[] copy = new Integer[elements.length*2];
            for (int i=0; i<elements.length; i++){
                copy[i] = elements[i];
            }
            elements = copy;
            return true;
        }
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
