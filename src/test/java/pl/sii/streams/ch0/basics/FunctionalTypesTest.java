package pl.sii.streams.ch0.basics;

import org.testng.annotations.Test;
import pl.sii.streams.Setup;

import java.util.List;
import java.util.function.Function;
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
    };

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
}
