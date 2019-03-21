https://www.vogella.com/tutorials/JUnit/article.html

https://dev.to/ice_lenor/unit-testing-best-practices-27ec

A test fixture is a fixed state in code which is tested used as input for a test. Another way to describe this is a test precondition.

A unit test is a piece of code written by a developer that executes a specific functionality in the code to be tested and asserts a certain behavior or state.

The percentage of code which is tested by unit tests is typically called test coverage.

An integration test aims to test the behavior of a component or the integration between a set of components. The term functional test is sometimes used as synonym for integration test. Integration tests check that the whole system works as intended, therefore they are reducing the need for intensive manual tests.

Performance tests are used to benchmark software components repeatedly. Their purpose is to ensure that the code under test runs fast enough even if it’s under high load.

A test is a behavior test (also called interaction test) if it checks if certain methods were called with the correct input parameters. A behavior test does not validate the result of a method call.

State testing is about validating the result. Behavior testing is about testing the behavior of the application under test.

[tham khao JUnit Expected Exceptions](https://stackjava.com/junit/junit-expected-exceptions-code-vi-du-test-exception-voi-junit.html)

#### mocking

[mockito reference 1](https://www.baeldung.com/mockito-void-methods)

[mockito reference 2](https://www.vogella.com/tutorials/Mockito/article.html#mockitousage)

[mockito reference 3](https://www.javarticles.com/2015/07/mockito-stubbing-with-custom-answers.html)

Sử dụng mocking technical để kiểm tra tính đúng đắn của một function bên trong một interface or class mà chưa triển khai logic code. Đây chính là việc giả lập kết quả trả về của các functions khi chúng chưa được triển khai.

mockito là một framwork hỗ trợ việc mock. sử  dụng `@mock` để định một đối tượng là mock.

– Mockito.when(T methodCall): dùng để giả lập một lời gọi hàm nào đó được sử dụng bên trong method đang được kiểm thử.

– Hàm Mockito.when() thường đi kèm với .thenReturn(), .thenAnswer(), .thenThrow() để chỉ định kết quả trả lại.

```java
//Khi method_A được gọi thì trả về kết quả là “demoValue”: 
Mockito.when(method_A()).thenReturn("demoValue");
 
//Khi method_B được gọi thì sẽ ném ra một Exception với message “demoError”: 
Mockito.when(method_B()).thenThrow(new Exception("demoError"));
 
//Khi method_C được gọi thì sẽ thực hiện xử lý các lệnh định nghĩa 
// bên trong hàm answer() (hàm này giả lập xử lý của method_C) và 
// trả về kết quả:
Mockito.when(method_C()).thenAnswer(new Answer<String>(){
    public String answer(InvocationOnMock invocation){
        String str = “demoNewAnswer”;
            return str;
        }
    });

```

```java
@Test
    public void testgetValue() {
        StockService stockService = mock(StockService.class);
        when(stockService.getValue(anyInt())).thenAnswer(new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocation) {
                return 123;
            }
        });

        assertEquals(stockService.getValue(1), 123);

    }
```

