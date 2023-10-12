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
<<<<<<< HEAD
    }

    @Test
    void newlineFirstly() {
=======
        assertThrows(IllegalArgumentException.class, () -> calc.add("\n"));
>>>>>>> 611f2c5 (Task4 of TDD Kata corrected)
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
<<<<<<< HEAD
        assertThrows(IllegalArgumentException.class, () -> calc.add("1, \n"));
        assertThrows(IllegalArgumentException.class, () -> calc.add(" 1 , 2\n3 "));
=======
        assertThrows(IllegalArgumentException.class, () -> calc.add("1,\n"));
        assertThrows(IllegalArgumentException.class, () -> calc.add(" 1 , 2\n3"));
>>>>>>> 611f2c5 (Task4 of TDD Kata corrected)
        assertThrows(IllegalArgumentException.class, () -> calc.add("1.786576 , 2\n3 "));
    }

    @Test
    void wrongDelimeter(){
        assertThrows(IllegalArgumentException.class,() -> calc.add("\\12345"));
        assertThrows(IllegalArgumentException.class,() -> calc.add("//<\n1sdcs<2<3"));
    }

    @Test
    void checkDelimeter(){
<<<<<<< HEAD
        assertEquals(6, calc.add("//[<]\n1<2<3"));
        assertEquals(6, calc.add("//[;]\n1;2;3"));
    }

    @Test
    void wrongNegative(){
        assertThrows(IllegalArgumentException.class,() -> calc.add("1,-2,-3"));
        assertThrows(IllegalArgumentException.class,() -> calc.add("//;\n76;-223"));
        assertThrows(IllegalArgumentException.class,() -> calc.add("//*\n832*-27*82"));
    }

    @Test
    void lessThanThousand() {
        assertEquals(1999, calc.add("1000,999,1001"));
        assertEquals(121, calc.add("100,8172,21"));
        assertThrows(IllegalArgumentException.class,() -> calc.add("8owe3,2937,126"));
    }

    @Test
    void custDelimeters() {
        assertEquals(1999, calc.add("//[(*&^&^%&^)]\n1000(*&^&^%&^)999(*&^&^%&^)(*&^&^%&^)1001"));
        assertEquals(121, calc.add("//[*]\n100*8172**21"));
        assertThrows(IllegalArgumentException.class,() -> calc.add("8owe3,2937,126"));
    }

    @Test
    void multipDelimeters() {
        assertEquals(6, calc.add("//[%][*]\n1%2*3"));
        assertEquals(337, calc.add("//[*%&^%^&][*/*/][???]\n100*%&^%^&8172*/*/21???216"));
        assertEquals(137, calc.add("//[&&&][+++][yu]\n8&&&3+++2937yu126"));
    }

    @Test
    void longMultipDelimeters() {
        assertEquals(6, calc.add("//[%%%%%%%%][**//**//**]\n1%%%%%%%%2**//**//**3"));
        assertEquals(337, calc.add("//[*%&^%^&][*/*/][???]\n100*%&^%^&8172*/*/21???216"));
        assertEquals(137, calc.add("//[&&&][+++][yuuytyghvhjj]\n8&&&3+++2937yuuytyghvhjj126"));
        assertEquals(6, calc.add("//[*]\n1*2**3"));
=======
        assertThrows(IllegalArgumentException.class,() -> calc.add("//<\n1<2<3<"));
        assertEquals(6, calc.add("//;\n1;2;3"));
        assertThrows(IllegalArgumentException.class,() -> calc.add("?\n-1,4?3"));
        assertThrows(IllegalArgumentException.class,() -> calc.add("//??\n-1,4??3"));
        assertEquals(6, calc.add("//*\n-1,4*3"));
        assertEquals(6, calc.add("//?\n-1,4?3"));
        assertEquals(6, calc.add("//;\n1;2;3"));
>>>>>>> 611f2c5 (Task4 of TDD Kata corrected)
    }

}