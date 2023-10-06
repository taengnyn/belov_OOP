import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    StringCalculator calc = new StringCalculator();

    @Test
    void isEmptyString() {
        assertEquals(0, calc.add(""));
    }

    @Test
    void isEqualsToTwo() {
        assertEquals(2, calc.add("2"));
    }

    @Test
    void isEqualsToThree() {
        assertEquals(3, calc.add("1,2"));
    }

    @Test
    void addInvalidInput() {
        StringCalculator stringCalc = new StringCalculator();
        try {
            int result = stringCalc.add("1,2,ор");
            fail("Expected IllegalArgumentException, given " + result);
        } catch (IllegalArgumentException e) {
            // Очікуємо IllegalArgumentException
        }
    }

}