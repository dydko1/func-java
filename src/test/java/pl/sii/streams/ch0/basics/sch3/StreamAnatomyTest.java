package pl.sii.streams.ch0.basics.sch3;

import org.testng.annotations.Test;
import pl.sii.utils.Shop;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAnatomyTest {
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
    }
}
