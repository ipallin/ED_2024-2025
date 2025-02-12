package mix;

public class Main {
    public static void main(String[] args) {

        SparseArray array = new SparseArray(5,5);

        array.setValue(1,1,5);
        array.setValue(2,2,10);

        System.out.println(array.getValue(1,1));
        System.out.println(array.toString());


    }
}
