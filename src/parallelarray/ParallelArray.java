package parallelarray;

public class ParallelArray {

    private String[] names;
    private String[] addresses;
    private Integer[] ages;
    private int numRecords;

    // Inicialización con tamaño fijo
    public ParallelArray() {
        names = new String[10];
        addresses = new String[10];
        ages = new Integer[10];
        numRecords = 0;
    }

    //-----------------------------------------------------------//
    // Aumento de las capacidades de los arrays de soporte
    private void upCapacity() {

        int newCapacity = names.length*2;

        String[] newNames = new String[newCapacity];
        String[] newAddresses = new String[newCapacity];
        Integer[] newAges = new Integer[newCapacity];

        for (int i=0; i<numRecords; i++) {
            newNames[i] = names[i];
            newAddresses[i] = addresses[i];
            newAges[i] = ages[i];
        }

        names = newNames;
        addresses = newAddresses;
        ages = newAges;
    }

    //-----------------------------------------------------------//

    // Insertar un nuevo registro
    public void insert(String name, String address, Integer age) {

        if (numRecords == names.length) {
            upCapacity();
        }

        names[numRecords] = name;
        addresses[numRecords] = address;
        ages[numRecords] = age;
        numRecords++;
    }

    //-----------------------------------------------------------//

    private void deleteRecord(int index) {

        // Intercambiar el registros que se quiere borrar con el último
        // Borrar el último registro => numRegistros--

        names[index] = names[numRecords - 1];
        addresses[index] = addresses[numRecords - 1];
        ages[index] = ages[numRecords - 1];
        numRecords--;

    }

    //-----------------------------------------------------------//

    public boolean delete(String name, String address, Integer age) {

        boolean found = false;

        for (int i=0; i<numRecords; i++) {
            if (names[i].equals(name) && addresses[i].equals(address) && ages[i].equals(age)) {
                deleteRecord(i);
                found = true;
            }
        }
        return found;
    }

    //-----------------------------------------------------------//


    // Obtener el tamaño
    public int size() {
        return numRecords;
    }

    // Vaciar el array paralelo
    public void empty() {

        numRecords = 0;
    }

    //-----------------------------------------------------------//


    // Representación en String del contenido
    @Override
    public String toString() {
        if (numRecords == 0)
            return "[Empty parallel array]";

        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < numRecords; i++) {
            sb.append(" [str1=").append(names[i])
                    .append(", str2=").append(addresses[i])
                    .append(", i=").append(ages[i]).append("] ");
        }
        sb.append("]");
        return sb.toString();
    }
}

