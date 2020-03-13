package junit4.Exception;

import org.junit.Test;

import java.util.ArrayList;

public class ExpectException {

    @Test(expected= IndexOutOfBoundsException.class)
    public void testWithEmpty() {
        new ArrayList<Object>().get(0);
    }

}
