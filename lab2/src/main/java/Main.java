import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Identity matrix:");
        Matrix.createIdentityMatrix(4).printMatrix();*/

        double[][] rowMatrix = Matrix.getRowMatrix(5);
        System.out.println("Row Matrix:");
        System.out.println(Arrays.deepToString(rowMatrix));


        double[][] columnMatrix = Matrix.getColumnMatrix(3);
        System.out.println("Column Matrix:");
        for (double[] matrix : columnMatrix) {
            System.out.println(Arrays.toString(matrix));
        }

    }


}






