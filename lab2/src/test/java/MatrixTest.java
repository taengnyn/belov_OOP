import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    public void testMatrixInitialization() {
        Matrix myMatrix = new Matrix(3, 4);
        assertNotNull(myMatrix);
    }

    @Test
    public void testSetAndGetElement() {
        Matrix myMatrix = new Matrix(3, 4);
        myMatrix.setElement(1, 2, 8);
        assertEquals(8, myMatrix.getElement(1, 2));
    }

    @Test
    public void testMatrixDimensions() {
        Matrix myMatrix = new Matrix(3, 4);
        assertEquals(3, myMatrix.getRows());
        assertEquals(4, myMatrix.getColumns());
    }

    @Test
    public void testSetElementWithInvalidRow() {
        Matrix myMatrix = new Matrix(3, 4);
        try {
            myMatrix.setElement(-5, 2, 8);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    @Test
    public void testSetElementWithInvalidColumn() {
        Matrix myMatrix = new Matrix(3, 4);
        try {
            myMatrix.setElement(1, 8, 8);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void testGetElementWithInvalidRow() {
        Matrix myMatrix = new Matrix(3, 4);
        try {
            int value = myMatrix.getElement(5, 2);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void testGetElementWithInvalidColumn() {
        Matrix myMatrix = new Matrix(3, 4);
        try {
            int value = myMatrix.getElement(1, 5);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void testPrintMatrix() {
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
}