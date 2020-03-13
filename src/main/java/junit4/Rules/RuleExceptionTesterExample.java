package junit4.Rules;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class RuleExceptionTesterExample {
    @Rule
    public ExpectedException exception = ExpectedException.none();
}
