package act3_grafo;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        // LECTURA DE LOS DATOS DE LAS GASOLINERAS Y CONSTRUCCIÓN DE LOS NODOS DEL GRAFO
        String directorioProyecto = System.getProperty("user.dir").concat("/src/grafo");
        String nombreFicheroGasolineras = "gasolineras.csv";
        String separador = System.getProperty("file.separator");
        String pathFicheroGasolineras = directorioProyecto + separador + nombreFicheroGasolineras;

        String[] datosGasolinera = new String[5];
        Gasolinera gasolinera;

        try (FileReader fr = new FileReader(pathFicheroGasolineras)) {
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                datosGasolinera = linea.split(";");
                gasolinera = new Gasolinera(datosGasolinera[2], datosGasolinera[1], datosGasolinera[2], datosGasolinera[3], datosGasolinera[4]);
                grafo.insertarNodo(gasolinera);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // LECTURA DE LAS DISTANCIAS ENTRE GASOLINERAS Y CONSTRUCCIÓN DE LAS ARISTAS DEL GRAFO
        String nombreFicheroDistanciasGasolineras = "distancias-gasolineras.csv";
        String pathFicheroDistanciasGasolineras = directorioProyecto + separador + nombreFicheroDistanciasGasolineras;
        String[] datosDistanciaGasolineras;

        try (FileReader fr = new FileReader(pathFicheroDistanciasGasolineras)) {
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                datosDistanciaGasolineras = linea.split(";");
                grafo.insertarArista(datosDistanciaGasolineras[0], datosDistanciaGasolineras[1], Double.parseDouble(datosDistanciaGasolineras[2]) );
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // PRUEBAS DE LAS FUNCIONALIDAD DEL GRAFO
        System.out.println("Se comprueban las funcionalidades del grafo:");
        System.out.println("------- NODOS -------");
        System.out.println("Número de nodos: " + grafo.numeroNodos());
        System.out.println("Se insertan tres nuevos nodos en el grafo con claves 0001, 0002 y 0003 ");
        grafo.insertarNodo(new Gasolinera("0001", "GASOLINERA DE PRUEBA", "CALLE DE PRUEBA", "MUNICIPIO DE PRUEBA", "LOCALIDAD DE PRUEBA"));
        grafo.insertarNodo(new Gasolinera("0002", "GASOLINERA DE PRUEBA", "CALLE DE PRUEBA", "MUNICIPIO DE PRUEBA", "LOCALIDAD DE PRUEBA"));
        grafo.insertarNodo(new Gasolinera("0003", "GASOLINERA DE PRUEBA", "CALLE DE PRUEBA", "MUNICIPIO DE PRUEBA", "LOCALIDAD DE PRUEBA"));
        System.out.println("Se comprueba que existe el nodo 'CORVERA DE ASTURIAS-203':"+ grafo.existeNodo("CORVERA DE ASTURIAS-203"));
        System.out.println("Número de nodos: " + grafo.numeroNodos());
        System.out.println("Se borra el nodo con clave '0001' || " + grafo.borrarNodo("0001"));
        System.out.println("Número de nodos: " + grafo.numeroNodos());
        System.out.println("------- ARISTAS -------");
        System.out.println("Número de aristas: " + grafo.numeroAristas());
        grafo.insertarNodo(new Gasolinera("0001", "GASOLINERA DE PRUEBA", "CALLE DE PRUEBA", "MUNICIPIO DE PRUEBA", "LOCALIDAD DE PRUEBA"));
        System.out.println("Se insertan tres nuevas aristas en el grafo entre 0001, 0002 y 0003 ");
        grafo.insertarArista("0001", "0002", 1.0);
        grafo.insertarArista("0001", "0003", 2.0);
        grafo.insertarArista("0002", "0003", 3.0);
        System.out.println("Se comprueba que existe la arista '0001,0002' " + grafo.existeArista("0001", "0002"));
        System.out.println("Número de aristas: " + grafo.numeroAristas());
        System.out.println("Se borra la arista entre 0001 y 0002 || " + grafo.borrarArista("0001", "0002"));
        System.out.println("Número de aristas: " + grafo.numeroAristas());
        System.out.println("Se borra el nodo con clave '0002' || " + grafo.borrarNodo("0002"));
        System.out.println("Número de aristas: " + grafo.numeroAristas());
        System.out.println("------- ALGORITMOS -------");
        System.out.println("Algoritmo de Dijkstra desde 'CORVERA DE ASTURIAS-203': " + grafo.Dijkstra("CORVERA DE ASTURIAS-203"));
        System.out.println("Algoritmo de Dijkstra entre 'GIJÓN-81' y 'AVILÉS-15': " + grafo.Dijkstra("GIJ�N-81","AVIL�S-15"));
    }
}