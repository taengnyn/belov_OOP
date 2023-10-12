import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    StringCalculator calc = new StringCalculator();

    @Test
    void checkWithRightInput() {
        assertEquals(0, calc.add(""));
        assertEquals(2, calc.add("2"));
        assertEquals(3, calc.add("1\n2"));
        assertEquals(2, calc.add("4,-2"));
        assertEquals(-24, calc.add("1\n-25"));
    }

    @Test
    void addInvalidInput() {
        StringCalculator stringCalc = new StringCalculator();
        try {
            int result = stringCalc.add("1,2,ор");
            fail("Expected IllegalArgumentException, given " + result);
        } catch (IllegalArgumentException e) {
            assertThrows(IllegalArgumentException.class, () -> calc.add("1,2,ор"));
        }
    }

    @Test
    void checkNewline() {

        assertEquals(6, calc.add("1\n2,3"));
        assertThrows(IllegalArgumentException.class, () -> calc.add("\n"));
        assertThrows(IllegalArgumentException.class, () -> calc.add("\n2,3"));
    }

    @Test
    void invalidInputNewline() {
        StringCalculator stringCalc = new StringCalculator();
        try {
            int result = stringCalc.add("1,2\nор");
            int result1 = stringCalc.add("**&^ор");
            fail("Expected IllegalArgumentException, given " + result);
            fail("Expected IllegalArgumentException, given " + result1);
        } catch (IllegalArgumentException e) {
            assertThrows(IllegalArgumentException.class, () -> calc.add("**&^ор"));
        }
    }

    @Test
    void testAddWithWhitespace() {
        assertThrows(IllegalArgumentException.class, () -> calc.add("1,\n"));
        assertThrows(IllegalArgumentException.class, () -> calc.add(" 1 , 2\n3"));
        assertThrows(IllegalArgumentException.class, () -> calc.add("1.786576 , 2\n3 "));
    }

    @Test
    void wrongDelimeter() {
        assertThrows(IllegalArgumentException.class, () -> calc.add("\\12345"));
        assertThrows(IllegalArgumentException.class, () -> calc.add("//<\n1sdcs<2<3"));
    }

    @Test
    void checkDelimeter() {
        assertThrows(IllegalArgumentException.class, () -> calc.add("//<\n1<2<3<"));
        assertEquals(6, calc.add("//;\n1;2;3"));
        assertThrows(IllegalArgumentException.class, () -> calc.add("?\n-1,4?3"));
        assertThrows(IllegalArgumentException.class, () -> calc.add("//??\n-1,4??3"));
        assertEquals(6, calc.add("//*\n-1,4*3"));
        assertEquals(6, calc.add("//?\n-1,4?3"));
        assertEquals(6, calc.add("//;\n1;2;3"));
    }
}