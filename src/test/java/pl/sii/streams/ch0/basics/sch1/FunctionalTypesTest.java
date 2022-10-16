package pl.sii.streams.ch0.basics.sch1;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;

import java.util.function.*;

public class FunctionalTypesTest extends Setup {
    @Test
    public void testSimpleLambda1() {
        // Simple lambda declaration
        Function<Integer, Integer> func = val1 -> val1 * 2;
        Integer result1 = func.apply(2);
        Assert.assertEquals(result1, 4);

        // W/O sugar
        Integer result2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i * 2;
            }
        }.apply(2);
        Assert.assertEquals(result2, 4);


        // Lambda variations
        // Simple lambda 1
        // Lambda body construction
        Function<String, Integer> sfunc1 = stringInput -> stringInput.length() * 2;
        Function<String, Integer> sfunc2 = stringInput -> {
            int stringLength = stringInput.length();
            int multiplier = 2;
            return stringLength * multiplier;
        }; // braces inside a body

        // Simple lambda 2
        // Lambda input arguments
        Function<String, Integer> singleArg = stringInput -> stringInput.length() * 2;
        BiFunction<String, String, Integer> twoArgs = (inputS1, inputS2) -> inputS1.length() + inputS2.length();
        Supplier<Integer> noArg = () -> 10;
    }

    // Function
    private Function<String, Integer> function1 = new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return s.length();
        }
    };

    private Function<String, Integer> function2 = string -> string.length(); // ------> Syntactic sugar

    private Function<String, Integer> function3 = String::length;            // ------> Syntactic sugar

    // Predicate
    @Test
    public void shouldInvokePredicate() {
        Predicate<String> stringPredicate = s -> s.startsWith("W");
        String s1 = "W-String";
        String s2 = "String";
        Assert.assertTrue(stringPredicate.test(s1));
        Assert.assertFalse(stringPredicate.test(s2));
    }

    // Supplier
    @Test
    public void shouldSupplyValue() {
        Supplier<String> stringSupplier = () -> "SupplyingString";
        Assert.assertEquals(stringSupplier.get(), "SupplyingString");
    }

    // Consumer
    @Test
    public void shouldConsumeValue() {
        Consumer<String> func = System.out::println;
        func.accept("Print a line");
    }

    // Custom lambdas
    @Test
    public void shouldInvokeOurCustomFunction() {
        TriFunction<Integer, Long, Double, String> stringify = (intNum, longNum, doubleNum) ->
                "" + intNum + " " + longNum + " " + doubleNum;
        String result = stringify.apply(10, 100L, 0.0);
        System.out.println(result);
        Assert.assertEquals(result, "10 100 0.0");
    }

    @Test
    public void shouldCrashJvm() {
        QuadFunction<String, String, String, String, String> fourParamFunction =
                (p1, p2, p3, p4) -> p1 + p2 + p3 + p4;
        String result = fourParamFunction.apply("String1", "String2", "String3", "String4");
        Assert.assertEquals(result, "String1String2String3String4");
    }

    // Higher order
    @Test
    public void aMethodShouldAcceptLambda() {
        String result = acceptIncomingFunction(value -> value + "_suffix");
        Assert.assertEquals(result, "Test_suffix");
    }

    private String acceptIncomingFunction(Function<String, String> func) {
        return func.apply("Test");
    }

    @Test
    public void aMethodSHouldReturnLambda() {
        String result = acceptIncomingFunction(gimmeFunc());
        Assert.assertEquals(result, "Test-Test");
    }

    private Function<String, String> gimmeFunc() {
        return val -> val + "-" + val;
    }
}
