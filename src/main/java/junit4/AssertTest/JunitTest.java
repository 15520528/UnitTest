package junit4.AssertTest;

import org.junit.Test;

public class JunitTest {
    public static void main(String args[]) {

    }
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        // assert statements
//        assertEquals(1, multiply(10, 0), "10 x 0 must be 0");
//        assertEquals(1, multiply(0, 10), "0 x 10 must be 0");
//        assertEquals(0, multiply(0, 0), "0 x 0 must be 0");
    }
    int multiply(int a, int b){
        return a*b;
    }
}
