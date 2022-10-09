package pl.sii.streams.ch6.reduction;

import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Item;

public class AdvancedReductionTest extends Setup {
    // reduce()
    @Test
    public void shouldReduceValues() {
        Double totalPriceOfAllItems = shops.stream()
                .flatMap(shop -> shop.getInventory().getItemList().stream())
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);
        System.out.println(totalPriceOfAllItems);

    }
}
