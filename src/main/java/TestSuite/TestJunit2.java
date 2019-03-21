package TestSuite;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestJunit2 {
    String str1 = new String ("abc");
    String str2 = new String ("abc");
    String str3 = new String("abc");
    String[] expectedArray = {"one", "two", "three"};
    String[] resultArray =  {"one", "two", "three"};
    String str4 = str3;
    @Test
    public void testAssertions() {
        assertEquals("must be equal", str1, str2);
        assertEquals("two object string mush be equal", str3, str2);
        assertTrue(str4 == str3);
        assertNotSame(str3, str2, "2 objects must be equal");
        assertArrayEquals(expectedArray, resultArray);
    }
}
