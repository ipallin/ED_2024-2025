package DoubleList;

import java.util.ArrayList;

public class DoubleList {
    Nodo first;     //Apuntador al primer Nodo de la lista.
    Nodo last;      //Apuntador al ultimo Nodo de la lista.


    //Constructora de la clase IntegerOrderedDoubleList. Crea una lista vacia.
    public DoubleList(){}


    //Metodos de la clase IntegerOrderedDoubleList.
    public void insert(Integer i){

        //Mira si la lista esta vacia. De ser asi crea un Nodo y lo nombra como First y Last.
        if(this.first == null){
            Nodo nuevo = new Nodo(i);   //Se utiliza la constructora de la clase Nodo.
            this.first = nuevo;
            this.last = nuevo;
        }

        //Mira si el valor dado como parametro el menor al valor del primer Nodo de la lista.
        else if(i < this.first.info){
            Nodo nuevo = new Nodo(i);
            //Cambia los apuntadores de el primer Nodo de la lista y del nuevo Nodo creado.
            nuevo.next = this.first;
            this.first.prev = nuevo;
            //Una vez teniendo los apuntadores bien, cambia la referencia del First al nuevo Nodo.
            this.first = nuevo;
        }

        //Si no entra en ningun if, tiene que recorrer la lista hasta encontrar la posición que le corresponda.
        else{
            //Crea un apuntador al primer Nodo y mira siempre a su siguiente.
            Nodo actual = first;

            //Bucle de busqueda (Corta cuando el Nodo siguiente al actual es null o al encontrado su sitio).
            while(actual.next != null && actual.next.info < i){
                actual = actual.next;
            }

            //Dos opciones:
            //1. Tiene que meter el Nodo al final de la lista.
            if(actual == this.last){
                Nodo nuevo = new Nodo(i);
                //Cambia los apuntadores de el ultimo Nodo de la lista y del nuevo Nodo creado.
                nuevo.prev = this.last;
                this.last.next = nuevo;
                //Una vez teniendo los apuntadores bien, cambia la referencia del Last al nuevo Nodo.
                this.last = nuevo;
            }

            //2. El valor del Nodo siguiente es mayor al valor metido como parametro.
            else{
                Nodo nuevo = new Nodo(i);
                //Cambia los apuntadores para insertar el nuevo Nodo (El orden es IMPORTANTE).
                nuevo.next = actual.next;
                actual.next.prev = nuevo;
                nuevo.prev = actual;
                actual.next = nuevo;
            }
        }
    }


    public Boolean delete(Integer i){

        //Mira si la lista esta vacia. De ser asi devuelve false (No tiene nada que borrar).
        if(this.first == null){
            return false;
        }

        //Mira si el Nodo que tiene que borrar es el primero
        else if(i == this.first.info){
            //Mueve la referencia del First al siguiente Nodo.
            this.first = this.first.next;
            //Elimina el apuntador con el Nodo que se quiere borrar (No necesario).
            this.first.prev = null;
            return true;
        }

        //Si no entra en ningun if, tiene que recorrer la lista hasta encontrar el Nodo que se quiera borrar.
        else{

            //Crea un apuntador al primer Nodo y mira siempre a su siguiente.
            Nodo actual = first;

            //Bucle de busqueda (Corta cuando el Nodo siguiente al actual es null o al encontrar el Nodo).
            while(actual.next != null && actual.next.info != i){
                actual = actual.next;
            }

            //Tres opciones:
            //1. No lo ha encontrado (Ha llegado hasta el final).
            if(actual.next == null && actual.info != i){
                return false;
            }

            //2.Lo ha encontrado pero es el ultimo Nodo de la lista.
            else if(actual.next == this.last){
                //Elimina el apuntador con el Nodo que se quiere borrar (NECESARIO).
                this.last.prev = null;
                actual.next = null;

                //Mueve la referencia del First al Nodo anterior (actual).
                this.last = actual;
                return true;
            }

            //3. Lo ha encontrado por el medio de la lista
            else{
                //Cambia los apuntadores para eliminar el Nodo (El orden es IMPORTANTE).
                actual.next = actual.next.next;
                actual.next.prev = actual.next;
                return true;
            }
        }
    }

    public ArrayList<Integer> list(){

        //Mira si la lista esta vacia.
        if(this.first == null){
            //Crea y devuelve un arrayList de Integers vacio.
            return new ArrayList<Integer>();
        }


        else{
            //Crea un ArrayList de Integers
            ArrayList<Integer> lista = new ArrayList<Integer>();

            //Crea un apuntador al primer Nodo.
            Nodo actual = first;

            //Bucle para añadir al ArrayList todos los elementos de la lista.
            while (actual != null){
                //Añade el valor del Nodo a la lista.
                lista.add(actual.info);
                //Mueve el Nodo.
                actual = actual.next;
            }

            return lista;
        }
    }
}
