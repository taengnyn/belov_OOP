import java.util.Arrays;

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
        myMatrix.printMatrix();

        Matrix emptyMatrix = new Matrix();
        System.out.println("Empty Matrix:");
        emptyMatrix.printMatrix();

        Matrix matrix3x3 = new Matrix(3, 3);
        System.out.println("3x3 Matrix:");
        matrix3x3.printMatrix();
        Matrix copyMatrix = new Matrix(matrix3x3);

        // Виведення копії матриці 3x3
        System.out.println("Copy of 3x3 Matrix:");
        copyMatrix.printMatrix();*/

        // Створення матриці 3x3
        Matrix matrix1 = new Matrix(1, 1);
        Matrix matrix2 = new Matrix(1, 1);
        /*System.out.println("Empty Matrix:");
        matrix.printMatrix();*/

        //matrix1.fillMatrix(1);
        System.out.println("Filled Matrix 1:");
        matrix1.printMatrix();
        System.out.println("Dimensions Matrix 1:" + Arrays.toString(matrix1.getMatrixDimensions()));

        //matrix1.fillMatrix(1);
        System.out.println("Filled Matrix 2:");
        matrix1.printMatrix();
        System.out.println("Dimensions Matrix 2:" + Arrays.toString(matrix1.getMatrixDimensions()));
    }
}






