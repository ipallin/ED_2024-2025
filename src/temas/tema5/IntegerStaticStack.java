package temas.tema5;

public class IntegerStaticStack {

    private int size;            // Tamaño máximo de la pila
    private Integer stack[];    // Estructura de datos auxiliar
    private int top;            // Posición de la cima


    public IntegerStaticStack(int s){
        size = s;
        stack = new Integer[size];
        top = -1;
    }

    // push
    // Añade un elemento a la pila. Devuelve true si la operación ha terminado con éxito, y false en caso contrario
    public boolean push(Integer i){
        boolean success = false;

        if(top < size - 1){
            top++;
            stack[top] = i;
            success = true;
        }
        return success;
    }


    // pop
    // extrae el elemento de la cima de la pila si no está vacía,
    // en caso contrario, devuelve null
    public Integer pop(){

        if(top < 0)
            return null;

        Integer i = stack[top];
        top--;
        return i;
        //return stack[top--];	--> VERSIÓN CORTA

    }


    // peek
    // consulta (sin extraer) el elemento de la cima de la pila
    public Integer peek() {
        if(top < 0)
            return null;

        return stack[top];
    }

    // empty
    // devuelve true si la pila está vacía, y false en caso contrario
    public boolean empty() {
        return top == -1;
    }


    // reset
    // vacía la pila

    public void reset() {
        top = -1;
    }


}



