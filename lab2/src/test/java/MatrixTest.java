import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    public void matrixInitialization() {
        Matrix myMatrix = new Matrix(3, 4);
        assertNotNull(myMatrix);
    }

    @Test
    public void setAndGetElement() {
        Matrix myMatrix = new Matrix(3, 4);
        myMatrix.setElement(1, 2, 8);
        assertEquals(8, myMatrix.getElement(1, 2));
    }

    @Test
    public void matrixDimensions() {
        Matrix myMatrix = new Matrix(3, 4);
        assertEquals(3, myMatrix.getRows());
        assertEquals(4, myMatrix.getColumns());
    }

    @Test
    public void setElementWithInvalidRow() {
        Matrix myMatrix = new Matrix(3, 4);
        try {
            myMatrix.setElement(-5, 2, 8);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void setElementWithInvalidColumn() {
        Matrix myMatrix = new Matrix(3, 4);
        try {
            myMatrix.setElement(1, 8, 8);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void fillMatrixWithPositiveValue() {
        Matrix matrix = new Matrix(3, 3);
        double value = 42.1;

        matrix.fillMatrix(value);

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                assertEquals(value, matrix.getElement(i, j));
            }
        }

        double[][] data = {{1, 2, 3}, {4, 5, 6}};

        assertThrows(IllegalArgumentException.class, () -> {
            matrix.fillMatrix(data);
        });
    }

    @Test
    public void getElementWithInvalidRow() {
        Matrix myMatrix = new Matrix(3, 4);
        try {
            double value = myMatrix.getElement(5, 2);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void getElementWithInvalidColumn() {
        Matrix myMatrix = new Matrix(3, 4);
        try {
            double value = myMatrix.getElement(1, 5);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void printMatrix() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Matrix myMatrix = new Matrix(2, 2);
        myMatrix.setElement(0, 0, 1);
        myMatrix.setElement(0, 1, 2);
        myMatrix.setElement(1, 0, 3);
        myMatrix.setElement(1, 1, 4);

        myMatrix.printMatrix();
        System.setOut(originalOut);

        String consoleOutput = outputStream.toString();
        String expectedOutput = "1.0 2.0 " + System.lineSeparator() + "3.0 4.0 " + System.lineSeparator();
        assertEquals(expectedOutput, consoleOutput);
    }

    @Test
    public void emptyMatrixConstructor() {
        Matrix emptyMatrix = new Matrix();
        assertEquals(0, emptyMatrix.getRows());
        assertEquals(0, emptyMatrix.getColumns());
    }

    @Test
    public void matrixConstructorWithSize() {
        Matrix matrix = new Matrix(3, 4);
        assertEquals(3, matrix.getRows());
        assertEquals(4, matrix.getColumns());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(0, matrix.getElement(i, j));
            }
        }
    }

    @Test
    public void matrixCopyConstructor() {
        Matrix original = new Matrix(2, 3);
        original.setElement(0, 0, 1);
        original.setElement(0, 1, 2);
        original.setElement(0, 2, 3);
        original.setElement(1, 0, 4);
        original.setElement(1, 1, 5);
        original.setElement(1, 2, 6);

        Matrix copy = new Matrix(original);

        assertEquals(original.getRows(), copy.getRows());
        assertEquals(original.getColumns(), copy.getColumns());
        for (int i = 0; i < original.getRows(); i++) {
            for (int j = 0; j < original.getColumns(); j++) {
                assertEquals(original.getElement(i, j), copy.getElement(i, j));
            }
        }

        original.setElement(0, 0, -1);
        assertNotEquals(original.getElement(0, 0), copy.getElement(0, 0));
    }

    @Test
    public void getElementWithInvalidIndex() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);

        assertThrows(IllegalArgumentException.class, () -> {
            double element = matrix.getElement(5, 2);
        });
    }

    @Test
    public void getRowWithInvalidIndex() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);

        assertThrows(IllegalArgumentException.class, () -> {
            double[] row = matrix.getRowByIndex(4);
        });
    }

    @Test
    public void getColumnWithInvalidIndex() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);

        assertThrows(IllegalArgumentException.class, () -> {
            double[] column = matrix.getColumnByIndex(3);
        });
    }

    @Test
    public void testGetColumnByValidIndex() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);

        double[] expectedColumn = {2, 5, 8};
        double[] actualColumn = matrix.getColumnByIndex(1);

        assertArrayEquals(expectedColumn, actualColumn);

        assertThrows(IllegalArgumentException.class, () -> {
            double[] column = matrix.getColumnByIndex(5);
        });
    }

    @Test
    public void getMatrixDimensions() {
        Matrix matrix = new Matrix(3, 4);
        int[] expectedDimensions = {3, 4};
        int[] actualDimensions = matrix.getMatrixDimensions();

        assertArrayEquals(expectedDimensions, actualDimensions);
    }

    @Test
    public void testAddMatrices() {
        Matrix matrix1 = new Matrix(3, 3);
        double[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix1.fillMatrix(data1);

        Matrix matrix2 = new Matrix(3, 3);
        double[][] data2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        matrix2.fillMatrix(data2);

        double[][] expectedMatrix = {{10, 10, 10}, {10, 10, 10}, {10, 10, 10}};
        Matrix resultMatrix = Matrix.addMatrices(matrix1, matrix2);

        int[] actualDimensions = resultMatrix.getMatrixDimensions();
        assertEquals(3, actualDimensions[0]);
        assertEquals(3, actualDimensions[1]);

        double[][] actualData = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                actualData[i][j] = resultMatrix.getElement(i, j);
            }
        }
        assertArrayEquals(expectedMatrix, actualData);

        Matrix matrix3 = new Matrix(3, 2);
        double[][] data3 = {{9, 8}, {6, 5}, {3, 2}};
        matrix3.fillMatrix(data3);
        try {
            Matrix resultMatrix1 = Matrix.addMatrices(matrix1, matrix3);
        } catch (IllegalArgumentException e) {
            assertEquals("Matrix dimensions do not match for addition.", e.getMessage());
        }
    }

    @Test
    public void testScalarMultiply() {
        Matrix matrix = new Matrix(2, 3);
        double[][] data = {{9, 8, 7}, {3, 2, 1}};
        matrix.fillMatrix(data);

        Matrix resultMatrix = Matrix.scalarMultiply(matrix, 2);
        int[] actualDimensions = resultMatrix.getMatrixDimensions();
        assertEquals(2, actualDimensions[0]);
        assertEquals(3, actualDimensions[1]);

        double[][] actualData = new double[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                actualData[i][j] = resultMatrix.getElement(i, j);
            }
        }
        double[][] expectedData = {{18, 16, 14}, {6, 4, 2}};
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void testMatrixMultiplication() {
        Matrix matrix1 = new Matrix(2, 3);
        double[][] data1 = {{1, 2, 3}, {4, 5, 6}};
        matrix1.fillMatrix(data1);

        Matrix matrix2 = new Matrix(3, 2);
        double[][] data2 = {{7, 8}, {9, 10}, {11, 12}};
        matrix2.fillMatrix(data2);

        Matrix resultMatrix = Matrix.multiply(matrix1, matrix2);
        int[] actualDimensions = resultMatrix.getMatrixDimensions();
        assertEquals(2, actualDimensions[0]);
        assertEquals(2, actualDimensions[1]);

        double[][] expectedData = {{58, 64}, {139, 154}};
        double[][] actualData = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                actualData[i][j] = resultMatrix.getElement(i, j);
            }
        }
        assertArrayEquals(expectedData, actualData);


        Matrix matrix3 = new Matrix(2, 2);
        double[][] data3 = {{7, 8}, {9, 10}};
        matrix3.fillMatrix(data3);

        try {
            Matrix resultMatrix1 = Matrix.multiply(matrix1, matrix3);
        } catch (IllegalArgumentException e) {
            assertEquals("Number of columns in the first matrix must be equal" +
                    " \nto the number of rows in the second matrix for multiplication.", e.getMessage());
        }
    }

    @Test
    public void testTranspose(){
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);

        double[][] expectedMatrix = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};

        Matrix result = matrix.transpose();
        double[][] actualData = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                actualData[i][j] = result.getElement(i, j);
            }
        }
        assertArrayEquals(expectedMatrix, actualData);
    }
}