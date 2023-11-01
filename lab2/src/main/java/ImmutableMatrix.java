import java.util.Arrays;

public final class ImmutableMatrix extends Matrix{

    public ImmutableMatrix() {super();}

    public ImmutableMatrix(int rows, int columns) {super(rows, columns);}

    public ImmutableMatrix(Matrix otherMatrix) {super(otherMatrix);}

    public void fillMatrix(double[][] data) {
        throw new IllegalArgumentException("Input data array has incorrect dimensions.");
        }

    public void fillMatrix(double value) {super.fillMatrix(value);}


    public int[] getMatrixDimensions() {return super.getMatrixDimensions();}

    public double[] getRowByIndex(int index) {return super.getRowByIndex(index);}

    public double[] getColumnByIndex(int index) {return super.getColumnByIndex(index);}

    public Matrix transpose() {return super.transpose();}

    public int getRows() {return super.getRows();}

    public int getColumns() {return super.getColumns();}

    public double getElement(int row, int column) {return super.getElement(row, column);}

    public void setElement(int row, int column, double value) {super.setElement(row, column, value);}


    public void printMatrix() {super.printMatrix();
    }

}

