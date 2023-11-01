import java.util.Arrays;

public final class ImmutableMatrix extends Matrix{

    public ImmutableMatrix() {super();}

    public ImmutableMatrix(int rows, int columns) {super(rows, columns);}

    public ImmutableMatrix(Matrix otherMatrix) {super(otherMatrix);}

    public void fillMatrix(int[][] data) {
        throw new IllegalArgumentException("Input data array has incorrect dimensions.");
        }

    public void fillMatrix(int value) {super.fillMatrix(value);}


    public int[] getMatrixDimensions() {return super.getMatrixDimensions();}

    public int[] getRowByIndex(int index) {return super.getRowByIndex(index);}

    public int[] getColumnByIndex(int index) {return super.getColumnByIndex(index);}


    public int getRows() {return super.getRows();}

    public int getColumns() {return super.getColumns();}

    public int getElement(int row, int column) {return super.getElement(row, column);}

    public void setElement(int row, int column, int value) {super.setElement(row, column, value);}


    public void printMatrix() {super.printMatrix();
    }

}

