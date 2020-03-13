package junit4.Annotation;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static java.lang.Thread.sleep;

public class AnnotationClass {
    //execute before class
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
    }
    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }
    @Before
    public void runBeforeTestMethod() {
        System.out.println("@Before - runBeforeTestMethod");
    }
    @After
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
    }
    @Test
    public void test_method_1() {
        System.out.println("@Test - test_method_1");
    }
    @Test
    @Ignore("This test case will be ignored")
    public void test_method_2() {
        System.out.println("@Test - test_method_2");
    }

    @Test(timeout = 1000)
    public void testTimeout2() throws InterruptedException {
        sleep(500);
    }

    @Test
    public void testMathUtils1() throws Exception {
        MathUtils.divide(1, 0);
    }

    @Test
    public void shouldTestExceptionMessage() throws  Exception {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("divides by zero");
        MathUtils.divide(1,1);
        MathUtils.divide(1,1);
        MathUtils.divide(1,1);
    }
}

class MathUtils {
    public static int divide(int input1, int input2 ) throws Exception {
        if (input2 == 0) {
            throw new ArithmeticException("divide by zero");
        }
        return input1/input2;
    }
}
