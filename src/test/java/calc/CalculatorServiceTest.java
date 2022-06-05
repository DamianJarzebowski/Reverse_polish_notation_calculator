package calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private CalculatorService sut = new CalculatorService();

    @Test
    public void shouldWorkWithEmptyString() {
        Assertions.assertEquals( 0, sut.evaluate(""));
    }

    @Test
    public void shouldParseNumbers() {
        Assertions.assertEquals( 3, sut.evaluate("3"));
    }

    @Test
    public void shouldParseFloatNumbers() {
        Assertions.assertEquals(3.5, sut.evaluate("3.5"));
    }

    @Test
    public void shouldSupportAddition() {
        Assertions.assertEquals(4, sut.evaluate("1 3 +"));
    }

    @Test
    public void shouldSupportMultiplication() {
        Assertions.assertEquals(3, sut.evaluate("1 3 *"));
    }

    @Test
    public void shouldSupportSubtraction() {
        Assertions.assertEquals(-2, sut.evaluate("1 3 -"));
    }

    @Test
    public void shouldSupportDivision() {
        Assertions.assertEquals(2, sut.evaluate("4 2 /"));
    }
}
