public class Matrix {
    private final int rows;
    private final int columns;
    private final int[][] arr;


    //пуста матриця розміром 0*0
    public Matrix() {
        this(0, 0);
    }

    //заповнення матриці нулями(матриця заданого розміру)
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.arr = new int[rows][columns];
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
        this.arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.arr[i][j] = otherMatrix.getElement(i, j);
            }
        }
    }

    //заповнення матриці значеннями
    public void fillMatrix(int[][] data) {
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
    public void fillMatrix(int value) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = value;
            }
        }
    }

    //отримання рядка за індексом
    public int[] getRowByIndex(int row) {
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row index.");
        }
        return arr[row];
    }

    //отримання стовпчика за індексом
    public int[] getColumnByIndex(int column) {
        if (column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid column index.");
        }
        int[] result = new int[rows];
        for (int i = 0; i < rows; i++) {
            result[i] = arr[i][column];
        }
        return result;
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    //також для отримання елементу за індексом
    public int getElement(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return arr[row][column];
        } else {
            throw new IllegalArgumentException("Wrong coordinates of element of matrix.");
        }
    }

    public void setElement(int row, int column, int value) {
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


