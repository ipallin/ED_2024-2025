//Autor: Igor Pallin
//Fecha: 02/12/2024
//Asignatura: Estructura de datos

package integercontainers;

public class Main {
    public static void main(String[] args) {

        IntegerStack pila = new IntegerStack();
        IntegerQueue cola = new IntegerQueue();

        System.out.println("------ Caso de uso: Pila de contenedores en un puerto ------");
        pila.push(904);
        pila.push(666);
        pila.push(385);
        pila.push(33);
        System.out.println("Contenedores actuales en el puerto " + pila.toString());
        System.out.println("Se añade un nuevo contenedor con el identificador 967");
        pila.push(967);
        System.out.println("Contenedores actuales en el puerto " + pila.toString());
        System.out.println("Se retira el primer contenedor de la pila");
        pila.pop();
        System.out.println("Contenedores actuales en el puerto " + pila.toString());
        System.out.println("El identificador del primer contenedor es " + pila.top());
        System.out.println("El tamaño actual de la pila de contenedores es " + pila.size());
        System.out.println("Se busca el contenedor con identificador 33");
        if (pila.search(33))
            System.out.println("El contenedor con identificador 33 SI está en la pila");
        else
            System.out.println("El contenedor con identificador 33 NO está en la pila");
        System.out.println("Se busca el contenedor con identificador 333");
        if (pila.search(333))
            System.out.println("El contenedor con identificador 333 SI está en la pila");
        else
            System.out.println("El contenedor con identificador 333 NO está en la pila");


        System.out.println("\n------ Caso de uso: Cola de pacientes en una consulta ------");
        cola.insert(5624564);
        cola.insert(2454448);
        cola.insert(7848187);
        cola.insert(2346872);
        cola.insert(3746374);
        cola.insert(8923424);
        System.out.println("Pacientes actuales en la consulta " + cola.toString());
        System.out.println("Se añade un nuevo paciente con el DNI 1234567");
        cola.insert(1234567);
        System.out.println("Pacientes actuales en la consulta " + cola.toString());
        System.out.println("Se retira el primer paciente de la cola");
        cola.remove();
        System.out.println("Pacientes actuales en la consulta " + cola.toString());
        System.out.println("El DNI del primer paciente es " + cola.seek());
        System.out.println("El tamaño actual de la cola de pacientes es " + cola.size());
        System.out.println("Se busca el paciente con DNI 7848187");
        if (cola.search(7848187))
            System.out.println("El paciente con SNI 7848187 SI está en la cola");
        else
            System.out.println("El paciente con DNI 7848187 NO está en la cola");
        System.out.println("Se busca el paciente con DNI 7848188");
        if (cola.search(7556745))
            System.out.println("El paciente con DNI 7556745 SI está en la cola");
        else
            System.out.println("El paciente con DNI 7556745 NO está en la cola");
    }
    }
