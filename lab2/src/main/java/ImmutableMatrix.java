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

    @Override
    public boolean equals(Object o) {return super.equals(o);}

    @Override
    public int hashCode() {return super.hashCode();}

    public Matrix transpose() {return super.transpose();}

    public Matrix createDiagonalMatrix(double[] vector) {return super.createDiagonalMatrix(vector);}

    public Matrix lowerTriangular() {return super.lowerTriangular();}

    public Matrix upperTriangular() {return super.upperTriangular();}



    public int getRows() {return super.getRows();}

    public int getColumns() {return super.getColumns();}

    public double getElement(int row, int column) {return super.getElement(row, column);}

    public void setElement(int row, int column, double value) {super.setElement(row, column, value);}


    public void printMatrix() {super.printMatrix();
    }

}

