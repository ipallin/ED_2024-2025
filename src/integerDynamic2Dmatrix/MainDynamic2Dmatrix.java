package integerDynamic2Dmatrix;

public class MainDynamic2Dmatrix {

	public static void main(String[] args) {

		IntegerDynamic2Dmatrix m = new IntegerDynamic2Dmatrix();
		
		System.out.println(m);
		
		m.set(1, 1, 9);
		System.out.println(m);

		m.set(1, 3, 18);
		System.out.println(m);
		
		m.set(2, 1, 18);
		System.out.println(m);
		
		m.set(3, 1, 27);
		System.out.println(m);
		
		m.set(5, 1, 78);
		System.out.println(m);
		
		m.set(5, 1, 3);
		System.out.println(m);
		
		m.set(6, 6, 61);
		System.out.println(m);
		
		System.out.println(m.get(1,1));  // 9
		System.out.println(m.get(1,3));  // 18
		System.out.println(m.get(2,1));  // 18
		System.out.println(m.get(3,1));  // 27
		System.out.println(m.get(5,1));  // 3
		System.out.println(m.get(6,6));  // 61
	}

}
