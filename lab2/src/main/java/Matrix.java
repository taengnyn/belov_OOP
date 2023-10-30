public class Matrix {
    private final int rows;
    private final int columns;
    private final int[][] arr; // Двовимірний масив для збереження даних матриці

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.arr = new int[rows][columns];
    }

    //public void setRows(int i) { this.rows = i;}

    public int getRows() {
        return rows;
    }

    //public void setColumns(int i) { this.columns = i;}
    public int getColumns() {
        return columns;
    }

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

