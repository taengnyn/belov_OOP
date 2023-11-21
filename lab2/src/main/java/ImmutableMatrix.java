import java.util.Arrays;

public final class ImmutableMatrix extends Matrix {

    public ImmutableMatrix() {
        super();
    }

    public ImmutableMatrix(int rows, int columns) {
        super(rows, columns);
    }

    public ImmutableMatrix(Matrix otherMatrix) {
        super(otherMatrix);
    }


    @Override
    public void fillMatrix(double[][] data) {
        throw new UnsupportedOperationException("ImmutableMatrix cannot be modified.");
    }

    @Override
    public void fillMatrix(double value) {
        throw new UnsupportedOperationException("ImmutableMatrix cannot be modified.");
    }

    @Override
    public void setElement(int row, int column, double value) {
        throw new UnsupportedOperationException("ImmutableMatrix cannot be modified.");
    }


    @Override
    public Matrix transpose() {
        return super.transpose();
    }

    @Override
    public Matrix createDiagonalMatrix(double[] vector) {
        return super.createDiagonalMatrix(vector);
    }

    @Override
    public Matrix lowerTriangular() {
        return super.lowerTriangular();
    }

    @Override
    public Matrix upperTriangular() {
        return super.upperTriangular();
    }

    @Override
    public Matrix inverse() {
        return super.inverse();
    }

    @Override
    public void printMatrix() {
        super.printMatrix();
    }
}

