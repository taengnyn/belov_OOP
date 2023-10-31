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
        int value = 42;

        matrix.fillMatrix(value);

        // Перевірка, чи всі елементи матриці заповнені значенням 42
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                assertEquals(value, matrix.getElement(i, j));
            }
        }

        int[][] data = {{1, 2, 3}, {4, 5, 6}};

        // Спроба заповнення матриці з некоректними розмірами введеного масиву
        assertThrows(IllegalArgumentException.class, () -> {
            matrix.fillMatrix(data);
        });
    }

    @Test
    public void getElementWithInvalidRow() {
        Matrix myMatrix = new Matrix(3, 4);
        try {
            int value = myMatrix.getElement(5, 2);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void getElementWithInvalidColumn() {
        Matrix myMatrix = new Matrix(3, 4);
        try {
            int value = myMatrix.getElement(1, 5);
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
        String expectedOutput = "1 2 " + System.lineSeparator() + "3 4 " + System.lineSeparator();
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

    @Test public void matrixCopyConstructor() {
        // Створити матрицю 2x3 з деякими значеннями
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

        // Перевірити, чи не змінюється копія при зміні оригіналу
        original.setElement(0, 0, -1);
        assertNotEquals(original.getElement(0, 0), copy.getElement(0, 0));
    }

    @Test
    public void getElementWithInvalidIndex() {
        Matrix matrix = new Matrix(3, 3);
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);

        // Спроба отримати елемент за недійсним індексом
        assertThrows(IllegalArgumentException.class, () -> {int element = matrix.getElement(5, 2);});
    }

    @Test
    public void getRowWithInvalidIndex() {
        Matrix matrix = new Matrix(3, 3);
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);

        // Спроба отримати рядок за недійсним індексом
        assertThrows(IllegalArgumentException.class, () -> {int[] row = matrix.getRowByIndex(4);});
    }

    @Test
    public void getColumnWithInvalidIndex() {
        Matrix matrix = new Matrix(3, 3);
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);

        // Спроба отримати стовпець за недійсним індексом
        assertThrows(IllegalArgumentException.class, () -> {int[] column = matrix.getColumnByIndex(3);});
    }

    @Test
    public void testGetColumnByValidIndex() {
        Matrix matrix = new Matrix(3, 3);
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.fillMatrix(data);

        int[] expectedColumn = {2, 5, 8};
        int[] actualColumn = matrix.getColumnByIndex(1);

        assertArrayEquals(expectedColumn, actualColumn);

        // Спроба отримати стовпець за некоректним індексом
        assertThrows(IllegalArgumentException.class, () -> {
            int[] column = matrix.getColumnByIndex(5);
        });
    }

    @Test
    public void getMatrixDimensions() {
        Matrix matrix = new Matrix(3, 4);
        int[] expectedDimensions = {3, 4};
        int[] actualDimensions = matrix.getMatrixDimensions();

        assertArrayEquals(expectedDimensions, actualDimensions);
    }


}