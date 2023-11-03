import java.util.Arrays;

public class Main {
    /*public static void main(String[] args) {
        Matrix matrix = new Matrix(2, 2);
        double[][] data = {{2, 1}, {7, 4}};


        Matrix matrix2 = new Matrix(3, 3);
        double[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix2.fillMatrix(data2);

        Matrix matrix3 = new Matrix(3, 3);
        double[][] data3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 10}};
        matrix3.fillMatrix(data3);

        System.out.println("matrix1 equals matrix2: " + matrix1.equals(matrix2)); // Очікується true
        System.out.println("matrix1 equals matrix3: " + matrix1.equals(matrix3)); // Очікується false


        System.out.println("matrix1 hashCode: " + matrix1.hashCode());
        System.out.println("matrix2 hashCode: " + matrix3.hashCode());


        matrix.fillMatrix(data);

        System.out.println("Original Matrix:");
        matrix.printMatrix();
        try {
            Matrix inverseMatrix = matrix.inverse();
            if (inverseMatrix != null) {
                System.out.println("\nInverse Matrix:");
                inverseMatrix.printMatrix();
            } else {
                System.out.println("\nMatrix is singular, and its inverse does not exist.");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }}*/

    public static void main(String[] args) {
        GenericMatrix.Matrix<GenericMatrix.MatrixElement<Integer>> matrix = new GenericMatrix.Matrix<>(3, 3);
        Integer[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix.setElement(i, j, new GenericMatrix.MyMatrixElement<Integer>(data[i][j]));
            }
        }

        System.out.println(matrix.toString());
    }

}






