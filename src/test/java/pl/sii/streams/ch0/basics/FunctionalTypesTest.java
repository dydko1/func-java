package pl.sii.streams.ch0.basics;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalTypesTest extends Setup {
    // Function
    // Predicate
    // Supplier
    private Function<String, Integer> function1 = new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return s.length();
        }
    }; // ------> what exists in the background

    private Function<String, Integer> function2 = string -> string.length(); // ------> Syntactic sugar

    private Function<String, Integer> function3 = String::length;            // ------> Syntactic sugar

    @Test
    public void shouldAcceptLambda() {
        List<String> collect = Stream.of("one", "two").map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "_suffix";
            }
        }).collect(Collectors.toList());
    }

    @Test
    public void shouldInvokeFunction() {
        Function<String, Integer> returnStringLength = String::length;
        String testString = "TestString";
        Integer stringLength = returnStringLength.apply(testString);
        Assert.assertEquals(stringLength, 10);
    }

    @Test
    public void shouldInvokePredicate() {
        Predicate<String> stringPredicate = s -> s.startsWith("W");
        String s1 = "W-String";
        String s2 = "String";
        Assert.assertTrue(stringPredicate.test(s1));
        Assert.assertFalse(stringPredicate.test(s2));
    }

    @Test
    public void shouldSupplyValue() {
        Supplier<String> stringSupplier = () -> "SupplyingString";
        Assert.assertEquals(stringSupplier.get(), "SupplyingString");
    }

    @Test
    public void shouldInvokeOurCustomFunction() {
        TriFunction<String, Integer, Long, Double> stringify = (intNum, longNum, doubleNum) -> "" + intNum + " " + longNum + " " + doubleNum;
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
}
