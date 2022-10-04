package pl.sii.streams.ch0.basics;

import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Shop;

import java.util.List;
import java.util.stream.Collectors;

public class BasicsTest extends Setup {
    @Test
    public void shouldPass() {
        List<String> l = shops
                .stream() // -----------------------------> generator
                .map(Shop::getName) // -------------------> intermediate operation 1
                //   |_________________________________ method reference
                .filter(name -> name.startsWith("N")) // -> intermediate operation 2
                //              |______________________ lambda function aka anonymous function
                .collect(Collectors.toList());        // -> terminal operation

        // Why use streams?
        // 1. Productivity increase
        // 2. Clarity
        // 3. Expressiveness
    }
}
