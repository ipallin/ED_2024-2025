package mix;

public class SparseArray {

    private Node first;
    private Integer rows;       //Numero filas
    private Integer columns;    //Numero columnas

    //Inicializar (filas,columnas)
    //CONSTUCTOR SparseArray
    public SparseArray(Integer rows, Integer columns) {
        this.first = null;
        this.rows = rows;
        this.columns = columns;
    }

    //------------------------------------------------------------------------------//

    public boolean setValue(Integer row, Integer column, Integer value){
        //Comprobar que no está vacía y el valor está dentro del array
        if ((row<1) || (column<1) || (row>rows) || (column>columns) || (value.equals(0))){
            return false;
        }

        Node aux = first;
        while (aux != null){

            if ((aux.row.equals(row)) && (aux.column.equals(column))){

                aux.value = value;
                return true;
            }
            aux = aux.next;
        }

        Node newNode = new Node(row, column, value);
        newNode.next = first;

        if (first!=null){   // Si está vacia
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        } else {            // No está vacia
            first = newNode;
        }
        return true;
    }

//------------------------------------------------------------------------------//

    boolean resetPosition (Integer row, Integer column) {
    if (row <1 || row > rows || column < 1 || column > columns) {
        return false;
    }

    Node aux = first;

    while(aux != null){
        if(aux.row.equals(row) && aux.column.equals(column)) {

            if (aux == first) {
                first = aux.next;
                if (first != null) {
                    first.prev = null;
                }
            }
            else {
               aux.prev.next = aux.next;
                if (aux.next != null){
                    aux.next.prev = aux.prev;
                }
            }
               return true;
            }
            aux = aux.next;
        }
    return true;
    }

    //------------------------------------------------------------------------------//

    public Integer getValue (Integer row, Integer column){
        if (row <1 || row > rows || column < 1 || column > columns) {
            return null;
        }

        Node aux = first;

        while (aux != null){
            if (aux.row.equals(row) && aux.column.equals(column)){
                return aux.value;
            }
            aux = aux.next;
        }
        return 0;
    }

    //------------------------------------------------------------------------------//

    public Integer noZeros() {
        int contadorZeros = 0;

        Node aux = first;

        while(aux!=null){
            contadorZeros++;
            aux = aux.next;
        }
        return contadorZeros;
    }

    //------------------------------------------------------------------------------//

    @Override
    public String toString(){

        Node aux;

        if (first == null) return "[Zero array]";

        StringBuilder sb = new StringBuilder();

        aux = first;

        while (aux != null){
            sb.append(aux).append(" ");
            aux = aux.next;
        }
        return sb.toString();
    }
}
