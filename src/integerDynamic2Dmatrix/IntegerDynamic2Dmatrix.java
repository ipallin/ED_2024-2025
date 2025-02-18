package integerDynamic2Dmatrix;

public class IntegerDynamic2Dmatrix {
	
	private MatrixNode first;
	private int numRows;
	private int numColumns;
	
	public IntegerDynamic2Dmatrix() {
		
		first = null;
		numRows = 0;
		numColumns = 0;
	}
	
	public void set(int row, int column, int value) {
		
		MatrixNode aux;
		
		if (row<=numRows) {               // La fila existe
			if (column <= numColumns) {   // La columna existe
			
				aux = positionToNode(row,column);	// Acceder a la posici�n y cambiar el valor		
				
				aux.value = value;       // Establecimiento del valor
			
			} else {  // La fila existe. La columna NO existe. A�adir columnas con valores a 0
				
				addNewColumns(column-numColumns);  // A�adir las columnas que son necesarias => column-numColumns
				
				aux = positionToNode(row,column);
				aux.value = value;
			}
		
		} else {  // La matriz no tienen la fila en la que se realizar� el set
			
			addNewRows(row-numRows);  // A�adir las filas que son necesarias => row-numRows
			
			if (column <= numColumns) {   // La columna existe
				
				aux = positionToNode(row,column);	// Acceder a la posici�n		
				
				aux.value = value;       // Establecimiento del valor
			
			} else {  // La fila existe. La comulna NO existe. A�adir columnas con valores a 0
				
				addNewColumns(column-numColumns);  // A�adir las columnas que son necesarias => column-numColumns
				
				aux = positionToNode(row,column);
				aux.value = value;
			}
		}
	}
	
	
	// A�ade tantas filas nuevas como indique el par�metro
	private void addNewRows(int numNewRows) {
		
		int r;
		MatrixNode aux, prevRow = null;
		
		for (r=1; r<=numNewRows; r++) {
			// Crear la fila (desconectada de la matriz)
			aux = newRow();
			
			// Conectar la nueva fila con la fila anterior
			if (numRows == 0)  {// es la primera fila que se a�ade
				first = aux;
				numColumns = 1;
			}
			else {
				prevRow = positionToNode(numRows,1);
			    prevRow.below = aux;
			}
			numRows++;
		}
	}
	
	// Crear una fila con tantos elementos como indique el n�mero de columnas actual (numColumns)
	// La fina est� desconectada de la matriz
	private MatrixNode newRow() {
		
		int c;
		MatrixNode aux, init, newNode=null;
		
		init = new MatrixNode(0);    // Creaci�n del primer elemento de la fila
		aux = init;
		
		for (c=1; c<numColumns; c++)  {// A�adido de los nuevos elementos
			newNode = new MatrixNode(0);
			aux.right = newNode;
			aux = aux.right;   // es lo mismo que aux = newNode
		}
		
		return init;
	}
	
	// A�ade tantas columnas nuevas como indique el par�metro
	private void addNewColumns(int numNewColumns) {
		
		int r, c;
		
		// A�adir nuevas columnas en todas las filas
		for (r=1; r<=numRows; r++)    // Posicionamiento en la fila
			addNewColumnsInRow(r, numNewColumns);
		
		numColumns += numNewColumns;
		
	}
	
	private void addNewColumnsInRow(int row, int numNewColumns) {
		
		MatrixNode init, aux, newNode = null;
		int i, c, r;  // �ndices para recorridos
		
		init = positionToNode(row,numColumns);   // Posicionamiento en la fila, en su �ltimo elemento
		aux = init;
		
		for (c=1; c<=numNewColumns; c++) {// A�adido de las nuevas columnas
			newNode = new MatrixNode(0);
			aux.right = newNode;	
			aux = newNode;
		}
	}
	
	
	// Devuelve la referencia a la posici�n (row,col) dentro de la matriz
	private MatrixNode positionToNode(int row, int col) {
		
		MatrixNode aux;
		int c, r;  // �ndices para recorridos
		
		aux = first;
		
		for (r=1; r<row; r++)    // Posicionamiento en la fila
			aux = aux.below;
		
		for (c=1; c<col; c++) // Posisionamiento en la �ltima columna actual
			aux = aux.right;
		
		return aux;	
	}
	
	public Integer get(int row, int column) {
		
		return positionToNode(row,column).value;
		
	}
	
	public String toString() {
		
		MatrixNode aux;
		int c, r;  // �ndices para recorridos
		StringBuilder sb;
		
		if (first == null)
			return "Empty matrix";
			
		sb = new StringBuilder();
		
		// Fila con los n�meros de columna
		sb.append("\t");   // Espacio para los n�meros de fila
		for (c=1; c<=numColumns; c++)
			sb.append(c).append("\t");
		sb.append("\n");
		
		// Contenido de la matriz
		for (r=1; r<=numRows; r++) {
			sb.append(r).append("\t");
			for (c=1; c<=numColumns; c++) { 
				aux = positionToNode(r,c);
				sb.append(aux.value).append("\t");
			}
			sb.append("\n");
		}
		
		return sb.toString();		
	}
	

}
