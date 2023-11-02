import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Identity matrix:");
        Matrix.createIdentityMatrix(4).printMatrix();*/

        /*double[][] rowMatrix = Matrix.getRowMatrix(5);
        System.out.println("Row Matrix:");
        System.out.println(Arrays.deepToString(rowMatrix));


        double[][] columnMatrix = Matrix.getColumnMatrix(3);
        System.out.println("Column Matrix:");
        for (double[] matrix : columnMatrix) {
            System.out.println(Arrays.toString(matrix));*/

        Matrix matrix = new Matrix(4, 3);
        double[][] data = {{11, -37, 18}, {47, 20, 1}, {47, 21, 19.3}, {56.3, 5, -10}};

        matrix.fillMatrix(data);
        System.out.println("Matrix:");
        matrix.printMatrix();

        Matrix upperTriangularMatrix = matrix.upperTriangular();

        // Виводимо результат
        System.out.println("Original Matrix:");
        matrix.printMatrix();

        System.out.println("Upper Triangular Matrix:");
        upperTriangularMatrix.printMatrix();


        }


}






