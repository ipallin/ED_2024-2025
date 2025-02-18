package integerStackOrQueue;

import java.util.ArrayList;
import java.util.Arrays;

public class IntegerStackOrQueue {
    private Integer soq[];        // ESTRUCTURA DE DATOS DE SOPORTE
    private int toptail;          // ÍNDICE DE LA CIMA DE LA PILA O ÚLTIMO DE LA COLA
    private int mode;             // 0: MODO PILA; 1:MODO COLA


    // CONSTRUCTOR SIN PARÁMETROS (NO SON NECESARIOS)
    // INICIALMENTE SE RESERVA MEMORIA PARA 10 ELEMENTOS, Y SE AMPLIARÁ CUANDO SEA NECESARIO
    public IntegerStackOrQueue(){
        mode = 0;				 // Inicialización en modo pila
        soq = new Integer[10];   // Reserva de espacio inicial
        toptail = -1;            // Índice de la cima de la pila/cola de la cola
    }


    //-------------------------------------------------------------------------------------------//


    // ESTABLECE EL FUNCIONAMIENTO DE LA ESTRUCTURA EN MODO PILA
    public void setStackMode() {
        mode = 0;
    }

    // ESTABLECE EL FUNCIONAMIENTO DE LA ESTRUCTURA EN MODO COLA
    public void setQueueMode() {
        mode = 1;
    }

    // DEVUELVE EL MODO DE FUNCIONAMIENTO ACTUAL DE LA ESTRUCTURA
    public int getMode() {
        return mode;

    }


    //-------------------------------------------------------------------------------------------//


    // AÑADE UN NUEVO ELEMENTO A LA ESTRUCTURA
    // SI NO HAY SITIO LIBRE, SE DUPLICA EL TAMAÑO ACTUAL, Y SE TRASLADAN LOS ELEMENTOS
    // FINALMENTE SE AÑADE EL NUEVO ELEMENTO
    public void insert(Integer v){

        Integer aux[];   // ESTRUCTURA AUXILIAR PARA HACER COPIA INTERMEDIA

        if(toptail == soq.length-1) {  // NO HAY SITIO LIBRE

            aux = new Integer[soq.length*2];   // RESERVAR ESPACIO PARA EL DOBLE DE ELEMENTOS
            for (int i = 0; i<=toptail; i++)    // COPIAR EL CONTENIDO DE LA PILA EN LA PILA AUXILIAR
                aux[i] = soq[i];

            soq = aux;    // SUSTITUIR LA PILA ANTIGUA POR LA PILA AUXILIAR
        }

        // Uso de la clase Arrays
        //soq = Arrays.copyOf(soq, soq.length*2);

        toptail++;	                  // INCREMENTAR LA CIMA/TAIL
        soq[toptail] = v;             // APILAR EL NUEVO ELEMENTO
    }


    //-------------------------------------------------------------------------------------------//


    // EXTRAE UN ELEMENTO A LA ESTRUCTURA
    public Integer get() {

        // SI LA ESTRUCTURA ESTÁ VACÍA DEVUELVE null
        if (toptail == -1)
            return null;

        // LA ESTRUCTURA NO ESTÁ VACÍA. LA EXTRACCIÓN ES DIFERENTE DEPENDIENDO DEL MODO ACTUAL
        if (mode == 0)
            return stackGet();
        else
            return queueGet();
    }


    //-------------------------------------------------------------------------------------------//


    // EXTRAE UN ELEMENTO DELA ESTRUCTURA NO VACÍA Y EN MODO PILA
    public Integer stackGet(){

        Integer elem = soq[toptail];
        toptail--;
        return elem;

        // VERSIÓN CORTA
        // return sql[toptail--];

    }


    //-------------------------------------------------------------------------------------------//


    // EXTRAE UN ELEMENTO DELA ESTRUCTURA NO VACÍA Y EN MODO COLA
    public Integer queueGet(){

        Integer elem = soq[0];   // EL ELEMENTO QUE SE EXTRAE ESTÁ EN LA PRIMERA POSICIÓN

        // DESPLAZAR HACIA LA IZQUIERDA TODOS LOS ELEMENTOS
        for (int i = 0; i<=toptail-1; i++)
            soq[i] = soq[i+1];

        toptail--;
        return elem;
    }


    //-------------------------------------------------------------------------------------------//


    // DEVUELVE EL CONTENIDO DE UNA ESTRUCTURA EN UNA LISTA
    public ArrayList<Integer> list() {

        ArrayList<Integer> list = new ArrayList<>(soq.length);

        if (mode == 0)  // PILA
            for (int i=toptail; i>=0; i--)
                list.add(soq[i]);
        else
            for (int i=0; i<=toptail; i++)
                list.add(soq[i]);

        return list;
    }

}
