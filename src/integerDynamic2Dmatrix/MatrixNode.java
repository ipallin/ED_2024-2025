package integerDynamic2Dmatrix;

public class MatrixNode {
	Integer value;
	MatrixNode right;
	MatrixNode below;

	
	
	public MatrixNode(Integer val) {
		
		value = val;
		right = null;
		below = null;
	}
}
