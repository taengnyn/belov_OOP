import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 3);
        double[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix1.fillMatrix(data1);

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

        }


}






