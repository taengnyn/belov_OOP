public class Main {
    public static void main(String[] args) {
        Matrix myMatrix = new Matrix(3, 4);
        myMatrix.setElement(0, 0, 5);
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
        copyMatrix.printMatrix();

        // Створення матриці 3x3
        Matrix matrix = new Matrix(3, 3);
        System.out.println("Empty Matrix:");
        matrix.printMatrix();

        int[][] data = {{1, 2, 3}, {4, -10, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);
        System.out.println("Filled Matrix:");
        matrix.printMatrix();
        matrix.fillMatrix(42);

        System.out.println("Matrix with all values set to 42:");
        matrix.printMatrix();
    }
}






