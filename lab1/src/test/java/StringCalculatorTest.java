import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    StringCalculator calc = new StringCalculator();

    @Test
    void isEmptyString() {
        assertEquals(0, calc.add(""));
    }

    @Test
    void onlyNewline() {
        assertThrows(IllegalArgumentException.class, () -> calc.add("\n"));
    }

    @Test
    void isEqualsToTwo() {
        assertEquals(2, calc.add("2"));
    }

    @Test
    void isEqualsToThree() {
        assertEquals(3, calc.add("1\n2"));
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
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    void newlineFirstly() {
        StringCalculator calc = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.add("\n2,3"));
    }

    @Test
    void newlineWithoutNums() {
        StringCalculator calc = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.add("1,\n"));
    }

    @Test
    void invalidInputNewline() {
        StringCalculator stringCalc = new StringCalculator();
        try {
            int result = stringCalc.add("1,2\nор");
            int result1 = stringCalc.add("**&^ор");
            fail("Expected IllegalArgumentException, given " + result);
        } catch (IllegalArgumentException e) {
            assertThrows(IllegalArgumentException.class, () -> calc.add("**&^ор"));


        }
    }
    @Test
    void testAddWithWhitespace() {
        StringCalculator calc = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.add(" 1 , 2\n3 "));
        assertThrows(IllegalArgumentException.class, () -> calc.add("1.786576 , 2\n3 "));
    }
}