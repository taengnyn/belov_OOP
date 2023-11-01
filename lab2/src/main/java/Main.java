public class Main {
    public static void main(String[] args) {
        //Matrix myMatrix = new Matrix(1, 4);
        /*myMatrix.setElement(0, 0, 5);
        myMatrix.setElement(1, 2, 8);
        myMatrix.setElement(2, 3, 3);

        int value = myMatrix.getElement(0, 0);
        System.out.println("This value is: " + value);

        int numRows = myMatrix.getRows();
        int numColumns = myMatrix.getColumns();
        System.out.println("Number of rows: " + numRows);
        System.out.println("Number of columns: " + numColumns);
        System.out.println("----Matrix----");
        System.out.println("Matrix:");
        myMatrix.printMatrix();*/

        double[][] data1 = {{1, 2, 3}, {4, 5, 8}, {7, 8, 9}};
        double[][] data2 = {{9, 8, 7}, {6, 5, 4}, {3, -1, 1}};

        Matrix matrix1 = new Matrix(3, 3);
        Matrix matrix2 = new Matrix(3, 3);
        matrix1.fillMatrix(data1);
        matrix2.fillMatrix(data2);

        System.out.println("Matrix 1:");
        matrix1.printMatrix();
        System.out.println("Matrix 2:");
        matrix2.printMatrix();

        /*System.out.println("Matrix 1 + Matrix 2:");
        Matrix.addMatrices(matrix1, matrix2).printMatrix();

        System.out.println("Matrix 1 * 4:");
        Matrix.scalarMultiply(matrix1, 4).printMatrix();*/
        double[] vector = {1, 2, 3};

        System.out.println("Matrix 1 transpose:");
        matrix1.createDiagonalMatrix(vector).printMatrix();
    }
}






