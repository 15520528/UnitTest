package Mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Iterator;
import java.util.Properties;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class MockitoTest {
    StockService stockService;

    @Before
    public void setUp(){

        this.stockService = mock(StockService.class);
    }

    // demonstrates the return of multiple values
    @Test
    public void testMoreThanOneReturnValue() {

        Iterator<String> i = mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result = i.next() + " " + i.next();
        //assert
        assertEquals("Mockito rocks", result);

    }

    // this test demonstrates how to return values based on the input
    @Test
    public void testReturnValueDependentOnMethodParameter(){

        Comparable<String> c= mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1, c.compareTo("Mockito"));

    }

    @Test
    public void testGetValue() {

        when(stockService.getValue(anyInt())).thenAnswer(new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocation) {
                return 123;
            }
        });

        assertEquals(stockService.getValue(1), 123);

    }

    // demonstrates how to return values independent of the input value
    @Test
    public void testReturnValueInDependentOnMethodParameter()  {

        Comparable<Integer> c= mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        //assert
        assertEquals(-1, c.compareTo(9));

    }

    // demonstrates return a value based on the type of the provide parameter
    @Test
    public void testWithAnyClass(){

        when(stockService.connectToDB(isA(String.class))).thenReturn(true);

        assertEquals(stockService.connectToDB("MySql"), true);

    }

    @Test(expected = Exception.class)
    public void testWithThrow(){

        Properties properties = mock(Properties.class);
        when(properties.get("Anddroid")).thenThrow(new IllegalArgumentException());

        try {
                properties.get("Anddroid1");
//                fail("Anddroid is misspelled");
        }
        catch (IllegalArgumentException ex){

        }

    }

    @Test
    public void whenAddCalledVerfied() {

        doNothing().when(stockService).add(isA(Integer.class), isA(String.class));
        stockService.add(1, "");

        verify(stockService, times(1)).add(1, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithDoThrow(){

        doThrow(new IllegalArgumentException()).when(stockService).add(isA(Integer.class), isA(String.class));

        stockService.add(0, null);

    }

    //to verify that the specified conditions are met
    @Test
    public void testVerify(){

        when(stockService.getUniqueId()).thenReturn(1997);

        stockService.getValue(12);
        stockService.getUniqueId();
        stockService.getUniqueId();

        // now check if method testing was called with the parameter 12
//        verify(stockService).getValue(ArgumentMatchers.eq(anyInt()));

        // was the method called twice?
        verify(stockService, times(2)).getUniqueId();
        verify(stockService, atLeast(2)).getUniqueId();

        verifyNoMoreInteractions(stockService);
    }

}
