package temas.tema3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Comparative {
    public static void main(String[] args) {
        String filePath = "resources/students_1000.txt"; // Path del fichero de datos

        // Crear una ArrayList y una LinkedList para almacenar los datos de los estudiantes
        ArrayList<Student> arrayList = new ArrayList<>();
        LinkedList<Student> linkedList = new LinkedList<>();

        // Leer datos de estudiantes desde el archivo y almacenarlos en ambas listas

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Los datos están separados por comas
                String firstName = data[0];
                String lastName = data[1];
                int age = Integer.parseInt(data[2]);
                double grade = Double.parseDouble(data[3]);
                arrayList.add(new Student(firstName, lastName, age, grade));
                linkedList.add(new Student(firstName, lastName, age, grade));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }


        // Elementos necesarios para simular los accesos aleatorios

        int accessCount = 1000000;       // Cantidad de accesos
        Random random = new Random();    // Generador de números aleatorios


        // Realizar accesos aleatorios y medir el tiempo en ArrayList

        long startTime = System.nanoTime();        // almacenar referencia de tiempo antes del bucle for
        for (int i = 0; i < accessCount; i++) {
            int index = random.nextInt(arrayList.size());   // generar el índice aleatorio para el acceso
            Student student = arrayList.get(index);			// acceder al elemento
        }
        long endTime = System.nanoTime();  		// almacenar referencia de tiempo antes del bucle for

        System.out.println("Tiempo de acceso en ArrayList: " + (endTime - startTime) / 1000000 + " ms");

        // Realizar accesos aleatorios y medir el tiempo en LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < accessCount; i++) {
            int index = random.nextInt(linkedList.size());
            Student student = linkedList.get(index);
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo de acceso en LinkedList: " + (endTime - startTime) / 1000000 + " ms");
    }

}
