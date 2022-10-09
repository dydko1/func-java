package pl.sii.streams.ch0.basics;

import org.testng.annotations.Test;
import pl.sii.utils.Shop;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. Narrow down the topic of the talk
 *   - focus on three elements, Functional Interfaces, Stream API, productivity features brought by both
 * 2. Explain what is functional and what are functional languages
 * 3. Expand on features make the language function
 * 4. Show java on a spectrum
 *   FP <---------------------------------------> OOP
 *   Haskel             Scala      Java post8     Java-pre8
 *   F#
 *   Clojure
 * 5. Explain lambda based on functional interfaces
 * 6. Explain 4 basic interfaces Function Predicate Supplier Consumer
 * Java 8 additions to language
 * 1. Lambda expressions
 * 2. Method references inside lambda expressions
 */
public class BasicsTest {
    @Test
    public void shouldPass() {
        LinkedList<Shop> aCollection = new LinkedList<>();
        aCollection.add(Shop.nullShop());
        aCollection.add(Shop.nullShop());

        List<String> l = aCollection
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
