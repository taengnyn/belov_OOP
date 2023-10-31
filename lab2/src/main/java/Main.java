import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Matrix myMatrix = new Matrix(3, 4);
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
        Matrix matrix = new Matrix(3, 3);
        /*System.out.println("Empty Matrix:");
        matrix.printMatrix();*/

        int[][] data = {{1, 2, 3}, {4, -10, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);
        System.out.println("Filled Matrix:");
        matrix.printMatrix();
        System.out.println("Dimensions:" + Arrays.toString(matrix.getMatrixDimensions()));

        /*//отримання рядка, стовпчика, елементу за індексом
        int[] row = matrix.getRowByIndex(0);
        int[] column = matrix.getColumnByIndex(1);
        int element = matrix.getElement(1, 2);
        System.out.println("Row: " + Arrays.toString(row));
        System.out.println("Column: " + Arrays.toString(column));
        System.out.println("Element: " + element);

        // Спроба отримати елемент, рядок і стовпець за індексом, якого немає в матриці
        try {
            int element_by_index = matrix.getElement(5, 2);
            System.out.println("Element (5, 2): " + element_by_index);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }*/
    }
}






