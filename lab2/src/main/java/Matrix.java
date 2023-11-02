import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private int rows;
    private int columns;
    private final double[][] arr;


    //пуста матриця розміром 0*0
    public Matrix() {
        this(0, 0);
    }

    //заповнення матриці нулями(матриця заданого розміру)
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.arr = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.arr[i][j] = 0;
            }
        }
    }

    //копія іншої матриці
    public Matrix(Matrix otherMatrix) {
        this.rows = otherMatrix.getRows();
        this.columns = otherMatrix.getColumns();
        this.arr = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.arr[i][j] = otherMatrix.getElement(i, j);
            }
        }
    }


    //заповнення матриці значеннями
    public void fillMatrix(double[][] data) {
        if (data.length != rows || data[0].length != columns) {
            throw new IllegalArgumentException("Input data array has incorrect dimensions.");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = data[i][j];
            }
        }
    }

    //заповнення матриці одним і тим самим значенням
    public void fillMatrix(double value) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = value;
            }
        }
    }

    //повертає розмірність матриці
    public int[] getMatrixDimensions() {
        return new int[]{rows, columns};
    }

    //отримання рядка за індексом
    public double[] getRowByIndex(int row) {
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row index.");
        }
        return arr[row];
    }

    //отримання стовпчика за індексом
    public double[] getColumnByIndex(int column) {
        if (column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid column index.");
        }
        double[] result = new double[rows];
        for (int i = 0; i < rows; i++) {
            result[i] = arr[i][column];
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {return false;}
        if (this == obj) {return true;}

        if (!(obj instanceof Matrix)) {return false;}

        Matrix otherMatrix = (Matrix) obj;
        int rows = arr.length;
        int cols = arr[0].length;
        int otherRows = otherMatrix.arr.length;
        int otherCols = otherMatrix.arr[0].length;

        if (rows != otherRows || cols != otherCols) {return false;}

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Math.abs(arr[i][j] - otherMatrix.arr[i][j]) > 1e-9) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public int hashCode() {
        int result = 31 * rows + columns;
        for (int i = 0; i < rows; i++) {
            result = 31 * result + Arrays.hashCode(arr[i]);
        }
        return result;
    }

    public static Matrix addMatrices(Matrix matrix1, Matrix matrix2) {
        int rows1 = matrix1.getRows();
        int columns1 = matrix1.getColumns();

        int rows2 = matrix2.getRows();
        int columns2 = matrix2.getColumns();

        if (rows1 != rows2 || columns1 != columns2) {
            throw new IllegalArgumentException("Matrix dimensions do not match for addition.");
        }

        Matrix resultMatrix = new Matrix(rows1, columns1);
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                double sum = matrix1.getElement(i, j) + matrix2.getElement(i, j);
                resultMatrix.setElement(i, j, sum);
            }
        }
        return resultMatrix;
    }

    public static Matrix scalarMultiply(Matrix matrix, int scalar) {
        Matrix resultMatrix = new Matrix(matrix.getRows(), matrix.getColumns());
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                resultMatrix.setElement(i, j, matrix.getElement(i, j) * scalar);
            }
        }
        return resultMatrix;
    }


    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        int rows1 = matrix1.getRows();
        int columns1 = matrix1.getColumns();
        int columns2 = matrix2.getColumns();

        if (columns1 != matrix2.getRows()) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal"+
                    " \nto the number of rows in the second matrix for multiplication.");
        }

        Matrix resultMatrix = new Matrix(rows1, columns2);
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                double sum = 0;
                for (int k = 0; k < columns1; k++) {
                    sum += matrix1.getElement(i, k) * matrix2.getElement(k, j);
                }
                resultMatrix.setElement(i, j, sum);
            }
        }
        return resultMatrix;
    }

    public Matrix transpose() {
        Matrix resultMatrix = new Matrix(columns, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix.setElement(j, i, getElement(i, j));
            }
        }
        return resultMatrix;
    }

    public Matrix createDiagonalMatrix(double[] vector) {
        int size = vector.length;
        Matrix diagonalMatrix = new Matrix(size, size);

        for (int i = 0; i < size; i++) {
            diagonalMatrix.setElement(i, i, vector[i]);
        }

        return diagonalMatrix;
    }

    public static Matrix createIdentityMatrix(int size) {
        if(size  < 0) {
            throw new IllegalArgumentException("Matrix size cannot be negative.");
        }

        Matrix matrix = new Matrix(size, size);
        for (int i = 0; i < size; i++) {
            matrix.setElement(i, i, 1);
        }

        return matrix;
    }

    public static double[][] getRowMatrix(int n) {
            Random random = new Random();
            double[][] matrix = new double[1][n];
            for (int i = 0; i < n; i++) {
                matrix[0][i] = random.nextInt(100);
            }
            return matrix;
        }

    public static double[][] getColumnMatrix(int m) {
            Random random = new Random();
            double[][] matrix = new double[m][1];
            for (int i = 0; i < m; i++) {
                matrix[i][0] = random.nextInt(100);
            }
            return matrix;
        }


    public Matrix lowerTriangular() {
        int rows = arr.length;
        int cols = arr[0].length;
        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i >= j) {
                    result.arr[i][j] = arr[i][j];
                }
            }
        }

        return result;
    }

    public Matrix upperTriangular() {
        int rows = arr.length;
        int cols = arr[0].length;
        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i <= j) {
                    // Копіюємо елемент в результат
                    result.arr[i][j] = arr[i][j];
                }
            }
        }
        // Повертаємо результат
        return result;
    }


    public int setRows(int rows) {
        return this.rows = rows;
    }

    public int setColumns(int columns) {
        return this.columns = columns;
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    //також для отримання елементу за індексом
    public double getElement(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return arr[row][column];
        } else {
            throw new IllegalArgumentException("Wrong coordinates of element of matrix.");
        }
    }

    public void setElement(int row, int column, double value) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            arr[row][column] = value;
        } else {
            throw new IllegalArgumentException("Wrong coordinates of element of matrix.");
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}


